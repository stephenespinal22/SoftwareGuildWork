/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster;

import classroster.DAO.ClassRosterDAO;
import classroster.DAO.ClassRosterDAOFileImpl;
import classroster.controller.ClassRosterController;
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
        // TODO code application logic here
        UserIO io = new UserIOConsoleImpl();

        ClassRosterDAO dao = new ClassRosterDAOFileImpl();
        ClassRosterView view = new ClassRosterView(io);

        ClassRosterController controller = new ClassRosterController(dao, view);

        controller.run();
    }

}
