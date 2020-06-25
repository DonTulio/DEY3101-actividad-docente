/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docente.view.component;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;


/**
 *
 * @author DonTulio
 */
public class ComponentJTextField extends JTextField{
    private String placeHolder;
    
    public ComponentJTextField(String newPlaceHolder) {
        setPlaceHolder(newPlaceHolder);
        initPlaceHolder();
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(getText().equals(getPlaceHolder())){
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(getText().isEmpty()){
                    setText(getPlaceHolder());
                    setForeground(Color.GRAY);
                }
            }
        });
    }
    
    private void setPlaceHolder(String placeHolder){
        this.placeHolder = placeHolder;
    }
    
    private String getPlaceHolder(){
        return this.placeHolder;
    }
    
    private void initPlaceHolder(){
        this.setText(this.getPlaceHolder());
        this.setForeground(Color.GRAY);
    }
    
    
    
}
