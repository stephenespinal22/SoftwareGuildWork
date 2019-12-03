/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classroster.dao;

import com.mycompany.classroster.dto.Student;
import java.util.ArrayList;
import java.util.List;

public class ClassRosterDAOImpl implements ClassRosterDAO {

    protected List<Student> students = new ArrayList<>();

    @Override
    public Student create(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public List<Student> readAll() {
        return students;
    }

    @Override
    public Student readById(String studentid) {
        for (Student currentStudent : students) {
            if (currentStudent.getStudentid().equals(studentid)) {
                return currentStudent;
            }
        }
        return null;
    }

    @Override
    public void update(String studentid, Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentid().equals(studentid)) {
                students.set(i, student);
            }
        }
    }

    @Override
    public void delete(String studentid) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentid().equals(studentid)) {
                students.remove(i);
            }
        }
    }

}
