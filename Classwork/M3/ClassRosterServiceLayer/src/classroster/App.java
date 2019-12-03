/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster;

import classroster.DAO.ClassRosterAuditDao;
import classroster.DAO.ClassRosterAuditDaoFileImpl;
import classroster.DAO.ClassRosterDAO;
import classroster.DAO.ClassRosterDAOFileImpl;
import classroster.controller.ClassRosterController;
import classroster.servicelayer.ClassRosterService;
import classroster.servicelayer.ClassRosterServiceImpl;
import classroster.view.ClassRosterView;
import classroster.view.UserIO;
import classroster.view.UserIOConsoleImpl;

/**
 *
 * @author stephenespinal
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instantiate the UserIO implementation
        UserIO myIo = new UserIOConsoleImpl();
        // Instantiate the View and wire the UserIO implementation into it
        ClassRosterView myView = new ClassRosterView(myIo);
        // Instantiate the DAO
        ClassRosterDAO myDao = new ClassRosterDAOFileImpl();
        // Instantiate the Audit DAO
        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
        // Instantiate the Service Layer and wire the DAO and Audit DAO into it
        ClassRosterService myService = new ClassRosterServiceImpl(myDao, myAuditDao);
        // Instantiate the Controller and wire the Service Layer into it
        ClassRosterController controller = new ClassRosterController(myService, myView);
        // Kick off the Controller
        controller.run();
    }
}
