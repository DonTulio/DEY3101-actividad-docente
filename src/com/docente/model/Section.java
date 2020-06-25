/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docente.model;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author DonTulio
 */
public class Section {
    private Integer sectionId;
    private String sectionName;
    private List<Student> students;
    private byte status;
    
    public Section(Integer sectionId, String sectionName,byte status) throws Exception {
        this.setSectionId(sectionId);
        this.setSectionName(sectionName);
        this.setStudents(new ArrayList<Student>());
        this.setStatus(status);
    }
    
    public Section(String sectionName) throws Exception {
        this.setSectionId(sectionId);
        this.setSectionName(sectionName);
        this.setStudents(new ArrayList<Student>());
    }
    
    public Section(Integer sectionId, String sectionName,List<Student> marks,byte status) throws Exception {
        this.setSectionId(sectionId);
        this.setSectionName(sectionName);
        this.setStudents(marks);
        this.setStatus(status);
    }

    public Integer getSectionId() {
        return sectionId;
    }

    private void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    private void setSectionName(String sectionName) throws Exception {
        if(sectionName.trim().equals("Write Section-Write Code")){
            throw new Exception("name is empty");
        }
        this.sectionName = sectionName;
    }

    public void setStudents(List<Student> marks){
        this.students = marks;
    }
    
    public List<Student> getStudents(){
        return this.students;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
    
    
    public String[] getDataForTable(){
        String[] data = {
            this.separateSectionCode()[0],
            this.separateSectionCode()[1],
            String.valueOf(this.getStudents().size()),
            this.getStatus()==1?"Saved":"Recovery"
        };
        return data;
    }
    
    private String[] separateSectionCode(){
        return this.getSectionName().split("-");
    }
    
}
