/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.guessnumber.daos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sg.com.guessnumber.dtos.Round;

/**
 *
 * @author stephenespinal
 */
//@Repository
//@Profile("test")
public class GuessNumberRoundMockDao implements GuessNumberRoundDao {

    private static List<Round> roundList;

    public GuessNumberRoundMockDao() {
        if (roundList == null) {
            ArrayList<Round> list = new ArrayList<Round>();
            Round round = new Round();
            round.setRoundId(1);
            round.setGameId(1);
            round.setTimeStamp(LocalDateTime.now().toString());
            round.setRoundName("1");
            round.setGuess("1234");
            round.setResult("e:4:p:0");
            list.add(round);
            roundList = list;
        }
    }

    @Override
    public Round createRound(Round round) {
        int nextId = 0;
        nextId = roundList.stream().mapToInt(v -> v.getRoundId()).max().orElse(0);
        //default to zero if nothing in dvdList
        nextId++;
        round.setRoundId(nextId);
        roundList.add(round);
        return round;
    }

    @Override
    public List<Round> readRoundsByGameId(int gameId) {
        //list verison of getting all rounds by gameid
        ArrayList<Round> listToReturn = new ArrayList<Round>();
        for (Round round : roundList)
        {
            if(round.getGameId() == gameId)
            {
                listToReturn.add(round);
            }
        }
        return listToReturn;
    }

}
