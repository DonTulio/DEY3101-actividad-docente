/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docente.view.component;

import com.docente.model.Student;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DonTulio
 */
public class ComponentTableStudent extends AbstractTableModel {
    private List<Student> students;
    private String[] columns;
    
    public ComponentTableStudent(List<Student> students, String[] colTitle) {
        this.setColumns(colTitle);
        this.setStudents(students);
    }
    
    public List<Student> getStudents() {
        return students;
    }

    private void setStudents(List<Student> students) {
        this.students = students;
    }

    public String[] getColumns() {
        return columns;
    }

    private void setColumns(String[] columns) {
        this.columns = columns;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        boolean re = false;
        if(columnIndex == 2){
            re = !re;
        }
        return re;
    }
    
    
    @Override
    public int getRowCount() {
        return this.getStudents().size();
    }

    @Override
    public String getColumnName(int column) {
        return this.getColumns()[column];
    }
    
    @Override
    public int getColumnCount() {
        return this.getColumns().length;
    }

    public Student getSelectedItem(int indexRow){
        return this.getStudents().get(indexRow);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object obj = null;
        if(columnIndex == 0)
            obj = this.getStudents().get(rowIndex).getFullRut();
        else if(columnIndex == 1)
            obj = this.getStudents().get(rowIndex).getMark();
        else if(columnIndex == 2)
            obj = this.getStudents().get(rowIndex).getOldMark();
        return obj;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       Student sts = this.getStudents().get(rowIndex);
        System.out.println("Cambio el valor "+aValue);
        float newMark = 0.0f;
        try {
            newMark = Float.parseFloat(String.valueOf(aValue));
            if(newMark <= 7.0 && newMark >= 1.0){
                sts.setMark(newMark);
                sts.setOldMark(newMark);
            }
        } catch (NumberFormatException e) {
            sts.setOldMark(1.0f);
        }
        fireTableCellUpdated(rowIndex, columnIndex);
        fireTableCellUpdated(rowIndex, columnIndex-1);
    }
    


}

           
    