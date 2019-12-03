/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classroster.dao;

import com.mycompany.classroster.dto.Student;
import java.util.ArrayList;

/**
 *
 * @author stephenespinal
 */
public class ClassRosterDAOFileImpl extends ClassRosterDAOImpl {
    
    private String fileName;
    
    public ClassRosterDAOFileImpl(String fileName){
        this.fileName = fileName;
        
    }
    
    @Override
    public Student create(Student student){
        loadFile();
        student = super.create(student);
        
        saveFile();
        return student;
        
    }

    private void loadFile() {

    }

    private void saveFile() {
        
    }
    
}
