/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryapi.daos;

import com.mycompany.dvdlibraryapi.dtos.Actor;
import java.util.List;

/**
 *
 * @author Randall
 */
public interface ActorDAO {

    Actor createActor(Actor d);

    //ReadALL
    List<Actor> readActors();

    //ReadALL
    List<Actor> readActorsByDvd(int dvdId);

    //READByID
    Actor readById(int id);

    //UPDATE
    void updateActor(Actor d);

    //DELETE
    void deleteActor(int d);
}
