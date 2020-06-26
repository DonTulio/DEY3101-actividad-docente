/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docente.helper;
import com.docente.model.Student;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
/**
 *
 * @author DonTulio
 */
public class Helper {
    private static final Integer MIN =  10_123_456;
    // 15_000_000 + 10_123_456
    private static final Integer MAX = 25_123_456;
    
    public static Integer separateNumberRut(String rut){
        return Integer.parseInt(rut.substring(0, rut.length()-1));
    }
    
    public static char separateDVRut(String rut){
        return rut.substring(rut.length()-1, rut.length()).charAt(0);
    }
    
    public static int generateRut(){
        return new Random().nextInt(MAX-MIN) + MIN;
    }
    
    public static char generateDV(int rut){
        int acum = 0;
        int factor = 2;
        char dv = '0';
        for(int pivote = getLengthRut(rut)-1;pivote > 0;pivote --){
            acum += (getValueForPosition(rut, pivote) * factor);
            factor ++;
            if(factor>7){
                factor = 2;
            }
        }
        acum = 11 - acum%11;
        if(acum == 10){
            dv = 'K';
        }
        else if(acum == 11){
            dv = '0';
        }else{
            dv = String.valueOf(acum).charAt(0);
        }
        return dv;
    }
    
    public static int getLengthRut(int rut){
        return String.valueOf(rut).length();
    }
    
    private static int getValueForPosition(int rut, int position){
         String nRut = String.valueOf(rut);
         return Integer.parseInt(String.valueOf(nRut.charAt(position)));
    }
    
    public static List<Student> generateStudent(){
        List<Student> students = new ArrayList<Student>();
        
        int random = new Random().nextInt(25-15)+15;
        
        for(int pivote = 0; pivote<=random; pivote++){
            
            int rut = generateRut();
            while(isExistRutInList(rut,students)==true){
                rut = generateRut();
            }
            
            Student student = new Student(
                                rut,
                                generateDV(rut), 
                                0);
            students.add(student);
            System.out.println(student.toString());
        }
        return students;
    }
    
    private static boolean isExistRutInList(int rut,List<Student> students){
        boolean exit = false;
        for(Student std : students){
            if(std.getRut() == rut){
                exit = !exit;
                break;
            }
        }
        
        return exit;
    }
}
