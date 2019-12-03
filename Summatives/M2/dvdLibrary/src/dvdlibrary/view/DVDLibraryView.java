/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.view;

import dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stephenespinal
 */
public class DVDLibraryView {

    private UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    //main menu
    public int getMenuChoice() {
        io.print("Main Menu");
        io.print("1. Add DVD to the Library");
        io.print("2. Remove DVD from the Library");
        io.print("3. Edit Information for an existing DVD from the Library");
        io.print("4. List All DVD's in the Library");
        io.print("5. Display Info for DVD");
        io.print("6. Exit");

        return io.readInt("Please Enter a number to select from the"
                + " above choices: ", 1, 6);
    }

    //add dvd methods
    public DVD getNewDVDInfo() {

        //get information about the DVD to create a new DVD object
        String title = io.readString("Please enter DVD Title: ");
        String releaseDate = io.readString("Please enter DVD Release Date: ");
        String mpaa = io.readString("Please enter DVD MPAA Rating: ");
        String director = io.readString("Please enter the Director's Name: ");
        String studio = io.readString("Please enter the Studio's Name: ");
        String note = io.readString("Please enter a note about the DVD, e.g. Good Family Movie: ");

        //create new DVD and set the fields to what the user enters
        DVD currentDVD = new DVD(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMpaaRating(mpaa);
        currentDVD.setDirectorsName(director);
        currentDVD.setStudio(studio);
        currentDVD.setNote(note);

        //return the dvd that was made back to the controller so it can send it to the DAO
        return currentDVD;
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("DVD successfully created.  Please hit enter to continue");
    }

    //remove dvd methods
    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveDVDResponse(DVD removedDVD) {
        //check if returned dvd was null or not so we can have the view display the correct response
        if (removedDVD != null) {
            io.readString("DVD successfully removed. Please hit enter to continue.");
        } else {
            io.print("No such DVD. Remove Failed");
            io.readString("Please hit enter to continue.");
        }
    }

    //editDVD methods
    public ArrayList<String> getDVDInfoToEdit() {
        ArrayList<String> newInfo = new ArrayList<>();
        io.print("Enter the new Info for this DVD...");
        newInfo.add(io.readString("Please enter DVD Release Date: "));
        newInfo.add(io.readString("Please enter DVD MPAA Rating: "));
        newInfo.add(io.readString("Please enter the Director's Name: "));
        newInfo.add(io.readString("Please enter the Studio's Name: "));
        newInfo.add(io.readString("Please enter a note about the DVD, e.g. Good Family Movie: "));

        return newInfo;
    }

    public void displayEditDVDBanner() {
        io.print("=== Edit DVD ===");
    }

    public void displayEditResponse(DVD editedDVD) {
        //check if returned dvd was null or not so we can have the view display the correct response
        if (editedDVD != null) {
            io.readString("DVD successfully edited. Please hit enter to continue.");
        } else {
            io.print("No such DVD. Edit Failed");
            io.readString("Please hit enter to continue.");
        }
    }

    //search by title method
    public String getTitleChoice() {
        return io.readString("Please enter the Title of the DVD: ");
    }

    //display dvd object methods
    public void displayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDVDBanner() {
        io.print("=== Display DVD ===");
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            io.print(currentDVD.getTitle());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print("--------------------------------------");
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirectorsName());
            io.print(dvd.getStudio());
            io.print(dvd.getNote());
            io.print("--------------------------------------");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    //misc view methods
    public void displayExitBanner() {
        io.print("Thank You. Good Bye!!!");
    }

    public void newLine() {
        io.print("");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
