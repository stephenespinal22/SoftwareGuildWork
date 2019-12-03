/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster.controller;

import classroster.DAO.ClassRosterDAO;
import classroster.DAO.ClassRosterDAOFileImpl;
import classroster.DTO.Student;
import classroster.view.ClassRosterView;
import classroster.view.UserIO;
import classroster.view.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author stephenespinal
 */
public class ClassRosterController {

    public ClassRosterController(ClassRosterDAO dao,ClassRosterView view)
    {
        this.dao = dao;
        this.view = view;
    }
    
    private ClassRosterDAO dao;
    private ClassRosterView view;

    public void run() {

        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

           menuSelection = view.getMenuChoice();
            switch (menuSelection) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    }

    private void createStudent() {

        view.displayCreateStudentBanner();

        Student student = view.getNewStudentInfo();

        dao.addStudent(student.getStudentId(), student);

        view.displayCreateSuccessBanner();
        
    }

    private void listStudents() {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void viewStudent() {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }

    private void removeStudent() {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        dao.removeStudent(studentId);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
