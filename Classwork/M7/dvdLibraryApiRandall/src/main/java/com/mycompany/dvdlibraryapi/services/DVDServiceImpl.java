/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryapi.services;

import com.mycompany.dvdlibraryapi.daos.ActorDAO;
import com.mycompany.dvdlibraryapi.daos.DVDActorDAO;
import com.mycompany.dvdlibraryapi.daos.DVDDAO;
import com.mycompany.dvdlibraryapi.dtos.Actor;
import com.mycompany.dvdlibraryapi.dtos.DVD;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//service layer basically is our pass thru
@Service
public class DVDServiceImpl implements DVDService {

    private DVDDAO dao;
    private DVDActorDAO dvdActorDAO;
    private ActorDAO actorDAO;
    @Autowired
    public DVDServiceImpl(DVDDAO dao, DVDActorDAO dvdActorDAO, ActorDAO actorDAO) {
        this.dao = dao;
        this.dvdActorDAO = dvdActorDAO;
        this.actorDAO = actorDAO;
    }

   
    
    @Override
    @Transactional
    public DVD createDvd(DVD d) {
        DVD dvd = dao.createDvd(d);
        
        /* check for director */
            
        
        for (Actor actor : d.getActors()) {
            int actorId = actor.getId();
            if(actorDAO.readById(actorId) != null){
               this.dvdActorDAO.addActorToDvd(d.getID(), actorId);
            }else{
                /* decide if we should throw an error! */ 
            }
        }
        return dvd;
    }


    @Override
    public List<DVD> readDvds() {
        return dao.readDvds();
    }

    @Override
    public List<DVD> readDvdsByDirector(int directorId) {
        return dao.readDvdsByDirector(directorId);
    }

    @Override
    public DVD readById(int id) {
        return dao.readById(id);
    }

    @Override
    @Transactional
    public void updateDvd(DVD dvd) {
        dao.updateDvd(dvd);
        //List<Actor> actors = this.actorDAO.readActorsByDvd(dvd.getID());
        this.dvdActorDAO.removeAllActorsFromDVD(dvd.getID());
         for (Actor actor : dvd.getActors()) {
            int actorId = actor.getId();
            if(actorDAO.readById(actorId) != null){
               this.dvdActorDAO.addActorToDvd(dvd.getID(), actorId);
            }else{
                /* decide if we should throw an error! */ 
            }
        }
    }

    @Override
    @Transactional
    public void deleteDvd(int id) {
        dvdActorDAO.removeAllActorsFromDVD(id);
        dao.deleteDvd(id);
    }

}
