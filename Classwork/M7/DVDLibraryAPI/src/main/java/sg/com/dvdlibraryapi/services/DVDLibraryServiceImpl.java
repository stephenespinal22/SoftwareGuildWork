/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibraryapi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sg.com.dvdlibraryapi.daos.DVDDao;
import sg.com.dvdlibraryapi.daos.DirectorDao;
import sg.com.dvdlibraryapi.dtos.DVD;
import sg.com.dvdlibraryapi.dtos.Director;

@Service

public class DVDLibraryServiceImpl implements DVDLibraryService {

    private DVDDao dvdDao;
    private DirectorDao directorDao;

    @Autowired
    public DVDLibraryServiceImpl(DVDDao dvdDao, DirectorDao directorDao) {
        this.dvdDao = dvdDao;
        this.directorDao = directorDao;
    }

    @Transactional
    //if create dvd fails, it will roll back the director that was created
    @Override
    public DVD createDVD(DVD dvd) {

        if (dvd.getDirector() == null) //unchecked exception we dont declare throws on this method
        //we probably shouldnt do this, alert people this method will throw an exception
        {
            throw new RuntimeException("Director is required");
        }

        //check for director existance
        //!!!!!!!!!!!!!!ASSUMPTION: When director Id is 0, create a director name with director name provided
        if (dvd.getDirector().getDirectorId() == 0) {
            Director director = dvd.getDirector();
            director = directorDao.createDirector(director);
            //this is the same reference inside the dvd object
            //anything we modify will effect the director inside "dvd"
        }

        return dvdDao.createDVD(dvd);
    }

    @Override
    public List<DVD> readDVDs() {
        return dvdDao.readDVDs();
    }

    @Override
    public DVD readDVDById(int id) {
        return dvdDao.readDVDById(id);
    }

    /*
    
    //many to many relationship
    
    dvd has many actors
    actor has many movie
    
    //bridge table - relationship between tables
    //any additional columns are about the relationship
    actor_movie
        movie
        actorId
        characterName
    
    Actor_Movie
    1. neo
    2.cop
    
    
    DvdService
    +getDvd(int dvdId);
        // GetDvd 
            // if != null -> getActorsByDvdId(dvdId)
    +getActor(int actorId)
        // getActorById(actorID) 
            // if != null -> dvdDao.getDvdsByActorId(actorId);
    ActorDao
    +getActorsByDvdId(int dvdId);
    public class Dvd{
    
    private int directorId; 
    private Director director;
    private List<Actor> actors;
    }
    public class Director{
    private int  id;
    private String Name;
    private List<Dvd> dvds;
    }
    public class Actor{
    private List<Dvd> dvds;   
    }
     */

    @Override
    public Director readDirectorById(int directorId) {
        Director director = directorDao.readDirectorByID(directorId);

        if (director != null) {
            director.setDvds(dvdDao.readDVDsByDirectorId(directorId));
        }
        return director;
    }

    @Override
    public void updateDVDById(DVD dvd) {
        Director director = directorDao.readDirectorByID(dvd.getDirector().getDirectorId());
        if (director == null) {
            throw new RuntimeException("Director was not found");
        }
        dvdDao.updateDVDById(dvd);

    }

    @Override
    public void deleteDVD(int id) {
        dvdDao.deleteDVD(id);
    }

}
