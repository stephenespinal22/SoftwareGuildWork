/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster.controller;

import classroster.DAO.ClassRosterDAO;
import classroster.DAO.ClassRosterDAOFileImpl;
import classroster.DTO.Student;
import classroster.servicelayer.ClassRosterDataValidationException;
import classroster.servicelayer.ClassRosterDuplicateIdException;
import classroster.servicelayer.ClassRosterPersistenceException;
import classroster.servicelayer.ClassRosterService;
import classroster.view.ClassRosterView;
import classroster.view.UserIO;
import classroster.view.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author stephenespinal
 */
public class ClassRosterController {

    public ClassRosterController(ClassRosterService service, ClassRosterView view) {
        this.service = service;
        this.view = view;
    }

    private ClassRosterView view;
// Replace the field declaration for the ClassRosterDao:
//private ClassRosterDAO dao;
// with a declaration for the ClassRosterServiceLayer:
    private ClassRosterService service;

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
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
        } catch (ClassRosterPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void createStudent() throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        boolean hasErrors = false;
        do {
            Student currentStudent = view.getNewStudentInfo();
            try {
                service.createStudent(currentStudent);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (ClassRosterDuplicateIdException | ClassRosterDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    private void listStudents() throws ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        List<Student> studentList = service.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void viewStudent() throws ClassRosterPersistenceException {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = service.getStudent(studentId);
        view.displayStudent(student);
    }

    private void removeStudent() throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        service.removeStudent(studentId);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
