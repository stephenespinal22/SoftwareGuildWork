/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary;

import dvdlibrary.controller.DVDLibraryController;
import dvdlibrary.dao.DVDLibraryDAO;
import dvdlibrary.dao.DVDLibraryDAOImpl;
import dvdlibrary.view.DVDLibraryView;
import dvdlibrary.view.UserIO;
import dvdlibrary.view.UserIOConsoleImpl;

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

        DVDLibraryDAO dao = new DVDLibraryDAOImpl();
        DVDLibraryView view = new DVDLibraryView(io);

        DVDLibraryController controller = new DVDLibraryController(dao, view);

        controller.run();
    }

}
