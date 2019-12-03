/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class DVDLibraryDAOImpl implements DVDLibraryDAO {

    private Map<String, DVD> dvdMap = new HashMap<>();
    public static final String DVDLIBRARY_FILE = "DVDLibrary.txt";
    public static final String DELIMITER = "::";

    @Override
    public DVD addDVD(String title, DVD dvd) throws IOException {
        readLibrary();
        dvdMap.put(title, dvd);
        writeLibrary();
        return dvd;
    }

    @Override
    public List<DVD> getAllDVDs() throws IOException {
        readLibrary();
        return new ArrayList<DVD>(dvdMap.values());
    }

    @Override
    public DVD getDVD(String title) throws IOException {
        readLibrary();
        return dvdMap.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws IOException {
        readLibrary();
        DVD removedDVD = dvdMap.remove(title);
        writeLibrary();
        return removedDVD;
    }

    @Override
    public DVD editDVD(String title, ArrayList<String> newInfo) throws IOException {
        readLibrary();
        DVD dvdToEdit = dvdMap.get(title);
        if (dvdToEdit != null) {
            dvdToEdit.setReleaseDate(newInfo.get(0));
            dvdToEdit.setMpaaRating(newInfo.get(1));
            dvdToEdit.setDirectorsName(newInfo.get(2));
            dvdToEdit.setStudio(newInfo.get(3));
            dvdToEdit.setNote(newInfo.get(4));
            dvdMap.replace(title, dvdToEdit);
            writeLibrary();
            return dvdToEdit;
        } else {
            return null;
        }
    }

    /**
     * Reads all DVDs from a file and puts them in the map (memory)
     *
     * @throws IOException if an error occurs reading from the file
     */
    private void readLibrary() throws IOException {

        Scanner scanner = null;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(new FileReader(DVDLIBRARY_FILE)));
        } catch (IOException e) {
            System.out.println("Could not load file.");
        }
        // currentLine holds the most recent line read from the file
        String currentLine;

        String[] currentTokens;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // DVD object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);

            //create the DVD to add to the map
            DVD currentDVD = new DVD(currentTokens[0]);
            // Set the remaining vlaues on currentDVD manually
            currentDVD.setReleaseDate(currentTokens[1]);
            currentDVD.setMpaaRating(currentTokens[2]);
            currentDVD.setDirectorsName(currentTokens[3]);
            currentDVD.setStudio(currentTokens[4]);
            currentDVD.setNote(currentTokens[5]);

            // Put currentDVD into the map using title as the key
            dvdMap.put(currentDVD.getTitle(), currentDVD);
        }
        // close scanner
        scanner.close();
    }

    /**
     * Writes all DVDs in the Library out to a DVDLIBRARY_FILE.
     *
     * @throws IOException if an error occurs writing to the file
     */
    private void writeLibrary() throws IOException {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(DVDLIBRARY_FILE));
        } catch (IOException e) {
            System.out.println("Could not write file");
        }

        Collection <DVD> dvdList = this.dvdMap.values();
        for (DVD currentDVD : dvdList) {
            // write the DVD object to the file
            out.println(currentDVD.getTitle() + DELIMITER
                    + currentDVD.getReleaseDate() + DELIMITER
                    + currentDVD.getMpaaRating() + DELIMITER
                    + currentDVD.getDirectorsName() + DELIMITER
                    + currentDVD.getStudio() + DELIMITER
                    + currentDVD.getNote());
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

}
