/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryapi.daos;

import com.mycompany.dvdlibraryapi.dtos.Actor;
import com.mycompany.dvdlibraryapi.dtos.DVD;
import com.mycompany.dvdlibraryapi.dtos.Director;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ActorDAOImpl implements ActorDAO {

    JdbcTemplate jdbc;

    private final String insertActor = "insert into actors (name) values (?);";                    //Create
    private final String selectAllActors = "select actors.id, name from actors";
    private final String selectActor = selectAllActors + " Where actors.id = ?";                                                   //Read By Id
    private final String selectActorsByDvdId = selectAllActors + " Inner dvds_actors on dvds_actors.actorId = actors.id Where dvds_actors.dvdId = ?";                                //Read All By DirectorId
    private final String updateActor = "update actors set name = ? where id = ?;";                //Update
    private final String deleteActor = "delete from actors where id = ?;";

    // CRUD INSERT, SELECT, UPDATE, DELETE
    @Autowired
    public ActorDAOImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Actor createActor(Actor actor) {
        this.jdbc.update(insertActor, actor.getName());
        actor.setId(this.jdbc.queryForObject("Select Last_Insert_ID()", Integer.class));
        return actor;
    }

    @Override
    public List<Actor> readActors() {
        return this.jdbc.query(this.selectActor, new ActorJDBCMapper());
    }

    @Override
    public List<Actor> readActorsByDvd(int dvdId) {
        return this.jdbc.query(this.selectActorsByDvdId, new ActorJDBCMapper(), dvdId);
    }

    @Override
    public Actor readById(int id) {
        return this.jdbc.queryForObject(this.selectActor, new ActorJDBCMapper(), id);
    }

    @Override
    public void updateActor(Actor actor) {
        this.jdbc.update(updateActor, actor.getName());
    }

    @Override
    public void deleteActor(int id) {
        this.jdbc.update(deleteActor, id);
    }

    private class ActorJDBCMapper implements org.springframework.jdbc.core.RowMapper<Actor> {

        @Override
        public Actor mapRow(ResultSet rs, int i) throws SQLException {
            Actor actor = new Actor();

            actor.setId(rs.getInt("id"));
            actor.setName(rs.getString("name"));

            return actor;

        }

    }
}
