/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryapi.daos;

/**
 *
 * @author Randall
 */
public interface DVDActorDAO {
    void addActorToDvd(int dvdId, int actorId);
    void removeActorFromDvd(int dvdId, int actorId);
    void removeAllDvdsFromActor(int actorId);
    void removeAllActorsFromDVD(int dvdId);
}
