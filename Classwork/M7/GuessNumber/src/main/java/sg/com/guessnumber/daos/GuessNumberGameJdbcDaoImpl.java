/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.guessnumber.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sg.com.guessnumber.dtos.Game;

@Repository
@Profile("prod")
public class GuessNumberGameJdbcDaoImpl implements GuessNumberGameDao {

    private final JdbcTemplate jdbcTemplate;

    private final String insertGame = "insert into Game (answer) values (?);"; //create
    private final String selectAllGames = "select gameId, answer,isFinished from Game;"; //read all
    private final String selectGameById = "select gameId,answer, isFinished from Game where gameId = ?;"; //readbyId
    private final String updateGame = "update Game set isFinished = ? where gameId = ?;";
    //for testing
    private final String deleteAllRounds = "delete from Round";
    private final String deleteAllGames = "delete from Game";

    @Autowired
    public GuessNumberGameJdbcDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Game createGame(Game game) {
        jdbcTemplate.update(insertGame, game.getAnswer());
        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        game.setGameId(newId);
        return game;
    }

    @Override
    public List<Game> readAllGames() {
        return jdbcTemplate.query(selectAllGames, new GameJDBCMapper());
    }

    @Override
    public Game readGameById(int id) {
        return jdbcTemplate.queryForObject(selectGameById, new GameJDBCMapper(), id);
    }

    @Override
    public void updateGame(Game game) {
        jdbcTemplate.update(updateGame, game.getIsFinished(), game.getGameId());
    }

    //for testing
    @Override
    @Transactional
    public void deleteAllGames() {
        jdbcTemplate.update(deleteAllRounds);
        jdbcTemplate.update(deleteAllGames);
    }

    private class GameJDBCMapper implements org.springframework.jdbc.core.RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int i) throws SQLException {
            Game game = new Game();
            game.setGameId(rs.getInt("gameId"));
            game.setAnswer(rs.getString("answer"));
            game.setIsFinished(rs.getBoolean("isFinished"));
            return game;
        }

    }
}
