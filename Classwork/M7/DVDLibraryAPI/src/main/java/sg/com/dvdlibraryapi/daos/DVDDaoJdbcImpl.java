/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibraryapi.daos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import sg.com.dvdlibraryapi.dtos.DVD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sg.com.dvdlibraryapi.dtos.Director;


// in case of public key issues in application properties
//spring.datasource.url=jdbc:mysql://localhost:3306/dvdLibrary?serverTimezone=America/Chicago&user=root&password=rootroot&useSSL=FALSE
//check for my sql connection strings in google and 
@Repository

public class DVDDaoJdbcImpl implements DVDDao {

    private final JdbcTemplate jdbcTemplate;

    private final String insertDvd = "insert into dvds (Title,`Description`,DirectorId) values (?,?,?);";  // Create
    
    private final String selectAllDvd = "select DvdId, title, `description`, dvds.DirectorId, DirectorName from dvds "
            + "INNER JOIN directors ON dvds.DirectorId = directors.DirectorId ";           // Read All
    
    private final String selectDvd = selectAllDvd + "WHERE dvdId = ?;"; //- Read By Id
    
    private final String selectDvdByDirectorId = selectAllDvd + "WHERE directorId = ?;";
    
    private final String updateDvd = "update dvds set title = ?, description = ?, directorId = ? where DvdId = ?;";//Update
    
    private final String deleteDvd = "delete from dvds where DvdId = ?;";//Delete

    @Autowired
    public DVDDaoJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public DVD createDVD(DVD dvd) {
        jdbcTemplate.update(insertDvd, dvd.getTitle(), dvd.getDescription(), dvd.getDirector().getDirectorId());
        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        dvd.setId(newId);
        return dvd;
    }

    @Override
    public List<DVD> readDVDs() {
        return this.jdbcTemplate.query(selectAllDvd, new DvdJDBCMapper());
    }

    @Override
    public DVD readDVDById(int id) {
        return this.jdbcTemplate.queryForObject(selectDvd, new DvdJDBCMapper(), id);
    }

    @Override
    public void updateDVDById(DVD dvd) {
        jdbcTemplate.update(updateDvd, dvd.getTitle(), dvd.getDescription(), dvd.getDirector().getDirectorId(), dvd.getId());
    }

    @Override
    public void deleteDVD(int id) {
        jdbcTemplate.update(deleteDvd, id);
    }

    @Override
    public List<DVD> readDVDsByDirectorId(int directorId) {
        return this.jdbcTemplate.query(selectDvdByDirectorId, new DvdJDBCMapper(), directorId );
    }
    
    private class DvdJDBCMapper implements org.springframework.jdbc.core.RowMapper<DVD> {

        @Override
        public DVD mapRow(ResultSet rs, int i) throws SQLException {
            DVD dvd = new DVD();
            // id, title, `description
            dvd.setId(rs.getInt("DvdId"));
            dvd.setTitle(rs.getString("title"));
            dvd.setDescription(rs.getString("description"));
  
            
            Director director = new Director();
            director.setDirectorId(rs.getInt("DirectorId"));
            director.setDirectorName(rs.getString("DirectorName"));
            
            dvd.setDirector(director);
            
            return dvd;
        }

    }
}
