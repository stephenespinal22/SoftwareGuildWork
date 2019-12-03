/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classroster.dao;

import com.mycompany.classroster.dto.Student;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stephenespinal
 */
public class ClassRosterDAOFileTest {
    
 ClassRosterDAO target = new ClassRosterDAOImpl();

    public ClassRosterDAOFileTest() {
    }

    @Before
    public void setup() {
        target = new ClassRosterDAOImpl();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void myFirstTest() {
        //AAA

        //Arrange
        String expected = "bob";

        //Act
        String actual = "bob";

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    public void shouldCreateStudent() {

        //Arrange 
        Student student = new Student();
        student.setStudentid("001");
        student.setStudentName("John Smith");
        student.setCourse("Java");
        target.create(student);

        //Act
        Student actual = target.create(student);

        //Assert
        assertEquals(student, actual);

    }

    @Test
    public void shouldReadAll() {

        //Arrange 
        Student student = new Student();
        student.setStudentid("001");
        student.setStudentName("John Smith");
        student.setCourse("Java");
        target.create(student);
        //Act
        List<Student> students = target.readAll();

        //Assert
        assertEquals(1, students.size());
        assertEquals(student, students.get(0));

    }

    @Test
    public void shouldReturnFoundStudent() {

        //arrange
        Student expected = new Student();
        expected.setStudentid("000");
        expected.setStudentName("John Smith");
        expected.setCourse("Java");

        createStudent(10);
        //act
        Student student = target.readById("000");
        //assert
        assertEquals(expected, student);

    }

    @Test
    public void shouldReturnNull() {

        //arrange
        //act
        Student student = target.readById("000");
        //assert
        assertNull(student);

    }

    @Test
    public void shouldReturnUpdatedStudent() {

        //arrange
        createStudent(1);
        Student student = target.readById("000");
        //act
        student.setStudentName("Sally Smith");
        target.update(student.getStudentid(), student);
        Student actual = target.readById("000");
        //assert
        assertEquals(student, actual);

    }
    
        @Test
    public void shouldReturnNullStudentAfterDelete() {

        //arrange
        createStudent(1);
        
        //act
        target.delete("000");
        Student actual = target.readById("000");
        
        //assert
        assertNull(actual);
        assertEquals(0, target.readAll().size());

    }

    private void createStudent(int n) {
        for (int i = 0; i < n; i++) {
            Student student = new Student();
            student.setStudentid("00" + i);
            student.setStudentName("John Smith");
            student.setCourse("Java");
            target.create(student);
        }
    }
}
