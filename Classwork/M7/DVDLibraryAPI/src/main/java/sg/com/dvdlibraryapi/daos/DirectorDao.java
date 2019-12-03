/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibraryapi.daos;

import java.util.List;
import sg.com.dvdlibraryapi.dtos.Director;

/**
 *
 * @author stephenespinal
 */
public interface DirectorDao {
    
    Director createDirector(Director director);
    
    List<Director> readAllDirectors();
    
    Director readDirectorByID(int id);
    
    void updateDirector(int id,Director director);
    
    void deleteDirector(int id);
}
