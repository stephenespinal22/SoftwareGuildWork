/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.controller;

import dvdlibrary.view.DVDLibraryView;
import dvdlibrary.dao.DVDLibraryDAO;
import dvdlibrary.dto.DVD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stephenespinal
 */
public class DVDLibraryController {

    //declare fields that will be instantiated in the APP class then
    //passed to the constructor of this class to these fields
    private DVDLibraryDAO dao;
    private DVDLibraryView view;

    /**
     * Constructor for Dependency Injection we will not create these objects in this class
     */
    public DVDLibraryController(DVDLibraryDAO dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    /**
     * Runs the main logic of the program uses a switch statement with menu choices to create a main menu which allows the user to perform actions
     */
    public void run() {

        //dao read from file
        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            while (keepGoing) {

                menuSelection = view.getMenuChoice();
                switch (menuSelection) {
                    case 1:
                        createDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        listDVDs();
                        break;
                    case 5:
                        listDVDInfo();
                        break;
                    case 6:
                        //method for dao to store to file
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }//end of switch
                newLine();
            }//end of while
            exitMessage();
        } catch (IOException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }//end of run

    /**
     * Controller add/create DVD
     *
     * calls some view methods to retrieve information from the user to create a new DVD then we call the DAO method to add the DVD to the map
     *
     */
    private void createDVD() throws IOException {

        newLine();

        view.displayCreateDVDBanner();

        DVD dvd = view.getNewDVDInfo();

        dao.addDVD(dvd.getTitle(), dvd);

        view.displayCreateSuccessBanner();

    }

    /**
     * Controller remove DVD
     *
     * calls some view methods to retrieve the title the user wants to search for then from the DAO calls the remove DVD method to remove it from the map
     *
     */
    private void removeDVD() throws IOException{

        newLine();

        view.displayRemoveDVDBanner();

        String title = view.getTitleChoice();

        DVD removedDVD = dao.removeDVD(title);

        view.displayRemoveDVDResponse(removedDVD);
    }

    /**
     * Controller edit DVD
     *
     * Asks user to DVD title to edit then asks the user for the new Info for the chosen DVD and stores it in a list then we send the list to the DAO to edit
     * the DVD info next we return the DVD and display the correct response
     *
     */
    private void editDVD() throws IOException{

        newLine();

        view.displayEditDVDBanner();

        String title = view.getTitleChoice();

        ArrayList<String> newInfo = view.getDVDInfoToEdit();

        DVD editedDVD = dao.editDVD(title, newInfo);

        view.displayEditResponse(editedDVD);
    }

    /**
     * Controller list all DVDs
     *
     * creates a list of DVDs from the DAO map and then calls a method from the view to display all DVDs in that list
     *
     */
    private void listDVDs() throws IOException{

        newLine();

        view.displayAllBanner();

        List<DVD> dvdList = dao.getAllDVDs();

        view.displayDVDList(dvdList);
    }

    /**
     * Controller list DVD info
     *
     * displays all info on a DVD
     *
     */
    private void listDVDInfo() throws IOException{

        newLine();

        view.displayDVDBanner();

        String title = view.getTitleChoice();

        DVD dvdForDisplay = dao.getDVD(title);

        view.displayDVD(dvdForDisplay);
    }

    /**
     * Calls view.unknownCommand() to create a message to the user when an input was unknown
     */
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    /**
     * Calls view.displayExitBanner() to display an exit message when the user is done using the program
     */
    private void exitMessage() {
        view.displayExitBanner();
    }

    /**
     * Calls view.newLine() to create a new line for display purposes
     */
    private void newLine() {
        view.newLine();
    }

}
