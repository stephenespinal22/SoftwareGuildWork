/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster.DAO;

import classroster.DTO.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassRosterDAOFileImpl implements ClassRosterDAO {

    private Map<String, Student> studentMap = new HashMap<>();

    @Override
    public Student addStudent(String studentId, Student student) {
        studentMap.put(studentId, student);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<Student>(studentMap.values());
    }

    @Override
    public Student getStudent(String studentId) {
        return studentMap.get(studentId);

    }

    @Override
    public Student removeStudent(String studentId) {
        Student removedStudent = studentMap.remove(studentId);
        return removedStudent;
    }

}
