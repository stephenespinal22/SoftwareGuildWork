/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.dto.DVD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stephenespinal
 */
public interface DVDLibraryDAO {

    /**
     * Adds the given DVD to the library and associates it with the given title. If there is already a DVD associated with the given title it will return that
     * DVD object, otherwise it will return null.
     *
     * @param title with which DVD is to be associated
     * @param dvdMovie DVD to be added to the library
     * @return the DVD object previously associated with the given title if it exists, null otherwise
     */
    DVD addDVD(String title, DVD dvd) throws IOException;

    /**
     * Returns a String array containing the titles of all DVD's in the library.
     *
     * @return String array containing the titles of all the DVDs in the library
     */
    List<DVD> getAllDVDs() throws IOException;

    /**
     * Returns the DVD object associated with the given title. Returns null if no such DVD exists
     *
     * @param title of the DVD to retrieve
     * @return the DVD object associated with the given title, null if no such DVD exists
     */
    DVD getDVD(String title) throws IOException;

    /**
     * Removes from the library the DVD associated with the given title. Returns the DVD object that is being removed or null if there is no DVD associated with
     * the given title
     *
     * @param title of DVD to be removed
     * @return DVD object that was removed or null if no DVD was associated with the given title
     */
    DVD removeDVD(String title) throws IOException;

    /**
     * Edits from the library the DVD associated with the given title. Returns the DVD object that is being Edited or null if there is no DVD associated with
     * the given title
     *
     * @param title of DVD to be edited
     * @return DVD object that was edited or null if no DVD was associated with the given title
     */
     DVD editDVD(String title, ArrayList<String> newInfo) throws IOException;
}
