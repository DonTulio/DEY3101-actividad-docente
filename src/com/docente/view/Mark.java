/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docente.view;

import com.docente.controller.ControllerSection;
import com.docente.controller.ControllerStudent;
import com.docente.helper.Helper;
import com.docente.implementation.ImplementationSection;
import com.docente.implementation.ImplementationStudent;
import com.docente.model.Section;
import com.docente.model.Student;
import javax.swing.JFrame;
import com.docente.view.component.ComponentTableStudent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author DonTulio
 */
public class Mark extends javax.swing.JFrame {

    /**
     * Creates new form Mark
     */
    private Section section;
    private ImplementationStudent impltStudent;
    private ImplementationSection impltSection;
    public Mark(Section section) {
        initComponents();
        this.setSection(section);
        this.setImpltStudent(ControllerStudent.newInstance());
        this.setImpltSection(ControllerSection.newInstance());
        initConfig();
    }

    private Section getSection() {
        return section;
    }

    private void setSection(Section section) {
        this.section = section;
    }

    private ImplementationStudent getImpltStudent() {
        return impltStudent;
    }

    private void setImpltStudent(ImplementationStudent impltStudent) {
        this.impltStudent = impltStudent;
    }

    private ImplementationSection getImpltSection() {
        return impltSection;
    }

    private void setImpltSection(ImplementationSection impltSection) {
        this.impltSection = impltSection;
    }
    
    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPBase = new javax.swing.JPanel();
        jScroll = new javax.swing.JScrollPane();
        JTableStundet = new javax.swing.JTable();
        jLabelSection = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 600));
        setMinimumSize(new java.awt.Dimension(400, 600));
        setSize(new java.awt.Dimension(400, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPBase.setBackground(new java.awt.Color(255, 255, 255));

        jScroll.setBackground(new java.awt.Color(255, 255, 255));

        JTableStundet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        JTableStundet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTableStundet.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        JTableStundet.setGridColor(new java.awt.Color(255, 255, 255));
        jScroll.setViewportView(JTableStundet);

        jLabelSection.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabelSection.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSection.setText("Section");
        jLabelSection.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 153, 255)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 255, 51));
        jButton2.setText("Save");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 255, 102)));
        jButton2.setMaximumSize(new java.awt.Dimension(41, 27));
        jButton2.setMinimumSize(new java.awt.Dimension(41, 27));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBaseLayout = new javax.swing.GroupLayout(jPBase);
        jPBase.setLayout(jPBaseLayout);
        jPBaseLayout.setHorizontalGroup(
            jPBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addGroup(jPBaseLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPBaseLayout.setVerticalGroup(
            jPBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSection, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addGap(44, 44, 44)
                .addGroup(jPBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
  
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.getImpltStudent().update(this.getSection().getStudents());
        JOptionPane.showMessageDialog(null, "Data saved!!");
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.getSection().setStatus((byte)1);
        this.getImpltSection().save(this.getSection());
        this.getImpltStudent().update(this.getSection().getStudents());
        JOptionPane.showMessageDialog(null, "Data Saved!");
    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void fillTable(){
        ComponentTableStudent model = null;
        String[] columns = {
            "RUT",
            "Old Mark",
            "New Mark"
        };
        if(this.getSection().getStudents().size() == 0){
             List<Student> newStudents = Helper.generateStudent();
             this.getSection().setStudents(newStudents);
             this.getImpltStudent().add(newStudents, this.getSection().getSectionId());
             // Reload id mark from DB
             this.getSection().setStudents(
                     this.getImpltStudent().getElements(
                             this.getSection().getSectionId())
             );
             model = new ComponentTableStudent(this.getSection().getStudents(),columns);
        }
        else{
            model = new ComponentTableStudent(this.getSection().getStudents(),columns);
        }
        JTableStundet.setModel(model);
    }
    
    private void initConfig(){
        this.jLabelSection.setText(this.getSection().getSectionName());
         fillTable();
        this.setSize(400, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
       
        this.setVisible(true);
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableStundet;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabelSection;
    private javax.swing.JPanel jPBase;
    private javax.swing.JScrollPane jScroll;
    // End of variables declaration//GEN-END:variables
}
