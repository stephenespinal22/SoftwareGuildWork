/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryapi.daos;

import com.mycompany.dvdlibraryapi.dtos.DVD;
import com.mycompany.dvdlibraryapi.dtos.Director;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DVDDAOJdbcImpl implements DVDDAO {

    private final JdbcTemplate jdbcTemplate;

    private final String insertDvd = "insert into dvds (title,`description`, directorId) values (?,?,?);";                    //Create
    private final String selectAllDvd = "select dvds.id, title, `description`,directorId, directors.`name` as 'directorName'"
            + " from dvds "
            + "inner join directors on dvds.directorid = directors.id ";                        //Read All
    private final String selectDvd = selectAllDvd + " Where dvds.id = ?";                                                   //Read By Id
    private final String selectDvdsByDirector = selectAllDvd + " Where dvds.directorId = ?";                                //Read All By DirectorId
    private final String updateDvd = "update dvds set title = ?, description = ?, directorId where id = ?;";                //Update
    private final String deleteDvd = "delete from dvds where id = ?;";                                                      //Delete

    @Autowired
    public DVDDAOJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public DVD createDvd(DVD dvd) {
        jdbcTemplate.update(insertDvd, dvd.getTitle(), dvd.getDescription(), dvd.getDirectorId());
        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        dvd.setID(newId);
        return dvd;
    }

    @Override
    public List<DVD> readDvds() {
        return this.jdbcTemplate.query(selectAllDvd, new DvdJDBCMapper());
    }

    @Override
    public List<DVD> readDvdsByDirector(int directorId) {
        return this.jdbcTemplate.query(selectDvdsByDirector, new DvdJDBCMapper(), directorId);
    }

    @Override
    public DVD readById(int id) {
        return this.jdbcTemplate.queryForObject(selectDvd, new DvdJDBCMapper(), id);
    }

    @Override
    public void updateDvd(DVD dvd) {
        jdbcTemplate.update(updateDvd, dvd.getTitle(), dvd.getDescription(), dvd.getID());
    }

    @Override
    public void deleteDvd(int id) {
        jdbcTemplate.update(deleteDvd, id);
    }

    private class DvdJDBCMapper implements org.springframework.jdbc.core.RowMapper<DVD> {

        @Override
        public DVD mapRow(ResultSet rs, int i) throws SQLException {
            DVD dvd = new DVD();
            Director director = new Director();

            // id, title, `description
            dvd.setID(rs.getInt("Id"));
            dvd.setDirectorId(rs.getInt("directorId"));
            dvd.setTitle(rs.getString("title"));
            dvd.setDescription(rs.getString("description"));
            director.setId(rs.getInt("directorId"));
            director.setName(rs.getString("directorName"));

            dvd.setDirector(director);
            return dvd;
        }

    }
}
