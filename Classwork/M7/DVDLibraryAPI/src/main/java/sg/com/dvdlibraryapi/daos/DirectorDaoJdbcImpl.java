/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibraryapi.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sg.com.dvdlibraryapi.dtos.DVD;
import sg.com.dvdlibraryapi.dtos.Director;

@Repository
public class DirectorDaoJdbcImpl implements DirectorDao {

    private final JdbcTemplate jdbcTemplate;

    private final String createDirector = "insert into directors(DirectorName) values (?);";
    private final String selectAllDirectors = "select DirectorId,DirectorName from directors;";
    private final String selectDirectorById = "select DirectorId,DirectorName from directors where DirectorId = ?;";
    private final String updateDirector = "update directors set DirectorName = ? where DirectorId = ?;";
    private final String deleteDirector = "delete from directors where DirectorId = ?;";
    private final String deleteDvdByDirectorId = "delete from dvds where DirectorId = ?;";

    @Autowired
    public DirectorDaoJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Director createDirector(Director director) {
        jdbcTemplate.update(createDirector, director.getDirectorName());
        int directorId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        director.setDirectorId(directorId);
        return director;
    }

    @Override
    public List<Director> readAllDirectors() {
        return jdbcTemplate.query(selectAllDirectors, new DirectorJDBCMapper());
    }

    @Override
    public Director readDirectorByID(int id) {
        return jdbcTemplate.queryForObject(selectDirectorById,new DirectorJDBCMapper(),id);
    }

    @Override
    public void updateDirector(int id, Director director) {
        jdbcTemplate.update(updateDirector, director.getDirectorName(), director.getDirectorId());
    }

    @Transactional //all or nothing anytime more then one jdbc update to rollback
    @Override
    public void deleteDirector(int id) {
        //clearing out fk assciations before deleting the parent row
        //this should be a single transaction: will fail if both dont work
        jdbcTemplate.update(deleteDvdByDirectorId, id);
        jdbcTemplate.update(deleteDirector, id);
    }

    private class DirectorJDBCMapper implements org.springframework.jdbc.core.RowMapper<Director> {

        @Override
        public Director mapRow(ResultSet rs, int i) throws SQLException {
            Director director = new Director();
            director.setDirectorId(rs.getInt("DirectorId"));
            director.setDirectorName(rs.getString("DirectorName"));
            return director;
        }
    }
}
