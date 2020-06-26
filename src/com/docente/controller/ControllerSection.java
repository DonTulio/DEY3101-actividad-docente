/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docente.controller;
import com.docente.implementation.ImplementationConnectionDB;
import com.docente.model.Section;
import com.docente.connection.ConnectionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLFeatureNotSupportedException;
import java.util.List;
import com.docente.implementation.ImplementationSection;
import com.docente.model.Student;
import java.util.ArrayList;
/**
 *
 * @author DonTulio
 */
public class ControllerSection implements ImplementationSection{
    private ImplementationConnectionDB imptDB;
    
    
    private static ControllerSection ctrlSection;
    
    private ControllerSection(){
        this.imptDB = ConnectionDB.newInstance();
    }
    
    public static ControllerSection newInstance(){
        if(ctrlSection == null){
            ctrlSection = new ControllerSection();
        }
        return ctrlSection;
    }
    
    
    private Connection openConnection() throws ClassNotFoundException, Exception{
        return this.imptDB.openConnection();
    }
    
    public int add(Section elemento) {
        int temp = 0;
        Connection con = null;
        try {
            con = this.openConnection();
            PreparedStatement pstm = con
                    .prepareStatement("INSERT INTO section (nameSection) values(?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, elemento.getSectionName());
            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            if(rs.first())
                   temp = rs.getInt(1);
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

    
    public int update(Section elemento) {
       int temp = 0;
       Connection con = null;
        try {
            con = this.openConnection();
            PreparedStatement pstm = con
                    .prepareStatement("UPDATE section SET sectionName = ?  WHERE sectionId = ?");
            pstm.setString(1, elemento.getSectionName());
            pstm.setInt(2, elemento.getSectionId());
            temp = pstm.executeUpdate();
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

    
    public int save(Section elemento) {
        int temp = 0;
        Connection con = null;
        try {
            con = this.openConnection();
            PreparedStatement pstm = con
                    .prepareStatement("UPDATE section SET status = 1  WHERE idSection = ?");
            pstm.setInt(1, elemento.getSectionId());
            temp = pstm.executeUpdate();
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

    
    public List<Section> getElements() {
        List<Section> sections = new ArrayList<Section>();
        Connection con = null;
        try {
            con = this.openConnection();
            
            PreparedStatement pstm = con
                    .prepareStatement("SELECT idSection,nameSection,status FROM section");
            
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                List<Student> studentTemp = ControllerStudent.newInstance().getElements(rs.getInt(1));
                Section section = new Section(rs.getInt(1),
                            rs.getString(2),
                            studentTemp,
                            rs.getByte(3));
                sections.add(section);
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
        return sections;
    }
    
    public List<Section> findElements(Section findSection){
        List<Section> sections = new ArrayList<Section>();
        Connection con = null;
        try {
            con = this.openConnection();
            PreparedStatement pstm = con
                    .prepareStatement("SELECT idSection,nameSection,status FROM "
                            + "section WHERE UPPER(nameSection) = ?");
            pstm.setString(1, findSection.getSectionName().toUpperCase());
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                List<Student> studentTemp = ControllerStudent.newInstance().getElements(rs.getInt(1));
                Section section = new Section(rs.getInt(1),
                            rs.getString(2),
                            studentTemp,
                            rs.getByte(3));
                sections.add(section);
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
        return sections;
    }
}
