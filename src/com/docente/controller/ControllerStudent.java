/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docente.controller;
import com.docente.connection.ConnectionDB;
import com.docente.helper.Helper;
import com.docente.implementation.ImplementationConnectionDB;
import com.docente.model.Student;
import java.util.List;
import java.util.ArrayList;
import com.docente.implementation.ImplementationStudent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DonTulio
 */
public class ControllerStudent implements ImplementationStudent{
    private ImplementationConnectionDB imptDB;
    
    private static ControllerStudent ctrlStudent;
    
    private ControllerStudent(){
        this.imptDB = ConnectionDB.newInstance();
    }
    
    public static ControllerStudent newInstance(){
        if(ctrlStudent == null){
            ctrlStudent = new ControllerStudent();
        }
        return ctrlStudent;
    }
    
    private Connection openConnection() throws ClassNotFoundException, Exception{
        return this.imptDB.openConnection();
    }
    
    public int add(List<Student> students,int sectionId) {
        int temp = 0;
        Connection con = null;
        try {
            con = this.openConnection();
            PreparedStatement pstm = con
                    .prepareStatement("INSERT INTO mark (idSection,rutStudent,mark) values(?,?,?)");
            
            for(Student student: students){
                pstm.setInt(1, sectionId);
                pstm.setString(2, String.format("%s%s",student.getRut(),student.getDv()));
                pstm.setFloat(3, student.getMark());
                temp += pstm.executeUpdate();
            }
            
        } catch (SQLException e) {
            System.out.println(
                        String
                                .format("SQL Exception : %s - %s",
                                        e.getErrorCode(),
                                        e.getMessage())
            );
        }
        catch(ClassCastException e){
            System.out.println(
                        String
                                .format("SQL Exception : %s - %s",
                                        e.getLocalizedMessage(),
                                        e.getMessage())
            );
        }
        catch(Exception e){
            System.out.println(
                            String
                                    .format("SQL Exception : %s - %s",
                                            e.getLocalizedMessage(),
                                            e.getMessage())
                );
        }
        finally{
            this.imptDB.closeConnection(con);
        }
        return temp;
    }

    
    public int update(List<Student> students) {
        int temp = 0;
        Connection con = null;
        try {
            con = this.openConnection();
            for(Student student:students){
                PreparedStatement pstm = con
                    .prepareStatement("UPDATE mark SET mark=? WHERE idMark=?");
                pstm.setFloat(1, student.getMark());
                pstm.setInt(2,student.getId());
                temp = pstm.executeUpdate();
            }
            
        } catch (SQLException e) {
            System.out.println(
                        String
                                .format("SQL Exception : %s - %s",
                                        e.getErrorCode(),
                                        e.getMessage())
            );
        }
        catch(ClassCastException e){
            System.out.println(
                        String
                                .format("SQL Exception : %s - %s",
                                        e.getLocalizedMessage(),
                                        e.getMessage())
            );
        }
        catch(Exception e){
            System.out.println(
                            String
                                    .format("SQL Exception : %s - %s",
                                            e.getLocalizedMessage(),
                                            e.getMessage())
                );
        }
        finally{
            this.imptDB.closeConnection(con);
        }
        return temp;
    }

    
    public List<Student> getElements(int sectionId) {
        List<Student> students = new ArrayList<Student>();
        Connection con = null;
        try {
            con = this.openConnection();
            PreparedStatement pstm = con
                    .prepareStatement("SELECT idMark,rutStudent,mark,newMark FROM mark WHERE idSection=?");
            pstm.setInt(1, sectionId);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Student student = new Student(rs.getInt(1),
                                Helper.separateNumberRut(rs.getString(2)),
                                Helper.separateDVRut(rs.getString(2)),
                                rs.getFloat(3),
                                rs.getFloat(4));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println(
                        String
                                .format("SQL Exception : %s - %s",
                                        e.getErrorCode(),
                                        e.getMessage())
            );
        }
        catch(ClassCastException e){
            System.out.println(
                        String
                                .format("SQL Exception : %s - %s",
                                        e.getLocalizedMessage(),
                                        e.getMessage())
            );
        }
        catch(Exception e){
            System.out.println(
                            String
                                    .format("SQL Exception : %s - %s",
                                            e.getLocalizedMessage(),
                                            e.getMessage())
                );
        }
        finally{
            this.imptDB.closeConnection(con);
        }
        return students;
    }    
}
