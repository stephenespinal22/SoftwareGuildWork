/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryapi.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DVDActorDAOJDBCImpl implements DVDActorDAO {

    private final String addActorToDvd = "insert into dvds_actors (dvdId, actorId) values(?,?);";
    private final String removeActorfromDvd = "delete from dvds_actors where dvdid = ? and actorid= ?;";
    private final String removeAllDvdsFromActor = "delete from dvds_actors where actorId = ?;";
    private final String removeAllActorsFromDVD = "delete from dvds_actors where dvdId = ?;";

    JdbcTemplate jdbc;

    // CRUD INSERT, SELECT, UPDATE, DELETE
    @Autowired
    public DVDActorDAOJDBCImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void addActorToDvd(int dvdId, int actorId) {
        this.jdbc.update(addActorToDvd, dvdId, actorId);
    }

    @Override
    public void removeActorFromDvd(int dvdId, int actorId) {
        this.jdbc.update(removeActorfromDvd, dvdId, actorId);
    }

    @Override
    public void removeAllDvdsFromActor(int actorId) {
        this.jdbc.update(removeAllDvdsFromActor, actorId);
    }

    @Override
    public void removeAllActorsFromDVD(int dvdId) {
        this.jdbc.update(removeAllActorsFromDVD, dvdId);
    }
}
