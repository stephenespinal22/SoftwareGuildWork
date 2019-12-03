/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibraryapi.daos;

import java.util.List;
import sg.com.dvdlibraryapi.dtos.DVD;

/**
 *
 * @author stephenespinal
 */
public interface DVDDao {
    
    DVD createDVD(DVD dvd);
    
    List <DVD> readDVDs();
    
    DVD readDVDById(int id);
    
    //one to many reads
    List<DVD> readDVDsByDirectorId(int directorId);
    
    
    void updateDVDById(DVD dvd);
    
    void deleteDVD(int id);
    
}
