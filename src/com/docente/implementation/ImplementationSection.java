/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docente.implementation;
import java.util.List;
import com.docente.model.Section;
/**
 *
 * @author DonTulio
 */
public interface ImplementationSection {
    public int add(Section section);
    public int update(Section section);
    public int save(Section section);
    public List<Section> getElements();
    public List<Section> findElements(Section findSection);
}
