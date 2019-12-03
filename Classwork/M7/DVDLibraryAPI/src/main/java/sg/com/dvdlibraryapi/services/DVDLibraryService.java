/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibraryapi.services;

import java.util.List;
import sg.com.dvdlibraryapi.dtos.DVD;
import sg.com.dvdlibraryapi.dtos.Director;

/**
 *
 * @author stephenespinal
 */
public interface DVDLibraryService {

    DVD createDVD(DVD dvd);

    List<DVD> readDVDs();

    DVD readDVDById(int id);
    
    Director readDirectorById(int directorId);

    void updateDVDById(DVD dvd);

    void deleteDVD(int id);
}
