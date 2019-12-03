/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classroster.dao;

import com.mycompany.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author stephenespinal
 */
public interface ClassRosterDAO {
    
    //Create
    Student create(Student student);
    
    List<Student> readAll();
  
    Student readById(String string);
    
    void update(String studentid, Student student);
    
    void delete(String studentId);
}
