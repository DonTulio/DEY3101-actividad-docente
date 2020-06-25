/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docente.model;

/**
 *
 * @author DonTulio
 */
public class Student {
    private int id;
    private int rut;
    private char dv;
    private float mark;
    private float oldMark;
    
    public Student(Integer rut, char dv,float mark) {
        this.setDv(dv);
        this.setRut(rut);
        this.setMark(mark);
        this.setOldMark(1.0f);
    }

    public Student(int id, Integer rut, char dv,float mark,float oldMark) {
        this.setId(id);
        this.setRut(rut);
        this.setDv(dv);
        this.setMark(mark);
        this.setOldMark(oldMark);
    }
    
    
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }
    
    public Integer getRut() {
        return rut;
    }

    private void setRut(Integer rut) {
        this.rut = rut;
    }

    public char getDv() {
        return dv;
    }

    private void setDv(char dv) {
        this.dv = dv;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public float getOldMark() {
        return oldMark;
    }

    public void setOldMark(float oldMark) {
        this.oldMark = oldMark;
    }
    
    public String getFullRut(){
        return String.format("%s-%s",String.valueOf(this.getRut()),
                this.getDv());
    }
    
    public String[] getDataForTable(){
        String [] data = {
            String.valueOf(this.getRut()),
            String.valueOf(this.getDv()),
            String.valueOf(this.getMark())
        };
        return data;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", rut=" + rut + ", dv=" + dv + ", mark=" + mark + '}';
    }
    
}
