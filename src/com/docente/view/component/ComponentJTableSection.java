/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docente.view.component;

import com.docente.model.Section;
import javax.swing.table.DefaultTableModel;
import com.docente.model.Section;
import com.docente.model.Student;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author DonTulio
 */
public class ComponentJTableSection extends DefaultTableModel {
    
    private List<Section> sections;
    
    public ComponentJTableSection(List<Section> sections){
        this.setSections(sections);
        this.fillTable();
    }

    private List<Section> getSections() {
        return sections;
    }

    private void setSections(List<Section> sections) {
        this.sections = sections;
    }
    
    private void fillTable(){
        addColumn("Section code");
        addColumn("Section name");
        addColumn("alumns size");
        addColumn("Status");
        for(Section student : this.getSections()){
            addRow(student.getDataForTable());
        }
    }

    public int getCount(){
        int acum = 0;
        for(Section section: this.sections){
            if(section.getStatus()==0){
                acum ++;
            }
        }
        return acum;
    }
    @Override
    public boolean isCellEditable(int row, int column) {
        super.isCellEditable(row, column);
        return false;
        //To change body of generated methods, choose Tools | Templates.
    }
    
    public Section getSectionFromPosition(int row){
        return sections.get(row);
    }
    
    
}
