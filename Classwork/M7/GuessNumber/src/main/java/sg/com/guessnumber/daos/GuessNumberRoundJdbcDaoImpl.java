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
import sg.com.guessnumber.dtos.Round;

@Repository
@Profile("prod")

public class GuessNumberRoundJdbcDaoImpl implements GuessNumberRoundDao {

    private final JdbcTemplate jdbcTemplate;

    private final String insertRound = "insert into Round (gameId, guess,roundName,`timeStamp`,result) values (?,?,?,?,?);";
    private final String selectAllRounds = "select `timeStamp`,roundId,roundName, gameId, guess, result from Round where gameId = ? order by `timeStamp`;";

    @Autowired
    public GuessNumberRoundJdbcDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Round createRound(Round round) {
        jdbcTemplate.update(insertRound, round.getGameId(), round.getGuess(),round.getRoundName(),round.getTimeStamp(),round.getResult());
        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        round.setRoundId(newId);
        return round;
    }

    @Override
    public List<Round> readRoundsByGameId(int gameId) {
        return jdbcTemplate.query(selectAllRounds, new RoundJDBCMapper(),gameId);
    }

    private class RoundJDBCMapper implements org.springframework.jdbc.core.RowMapper<Round> {

        @Override
        public Round mapRow(ResultSet rs, int i) throws SQLException {
            Round round = new Round();
            round.setRoundId(rs.getInt("roundId"));
            round.setRoundName(rs.getString("roundName"));
            round.setTimeStamp(rs.getString("timeStamp"));
            round.setGuess(rs.getString("guess"));
            round.setResult(rs.getString("result"));
            round.setGameId(rs.getInt("gameId"));

            return round;
        }

    }
}
