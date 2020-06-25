/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docente.implementation;
import java.util.List;
import com.docente.model.Student;
/**
 *
 * @author DonTulio
 */
public interface ImplementationStudent {
    public int add(List<Student> students,int sectionId);
    public int update(List<Student> students);
    public List<Student> getElements(int sectionId);
}
