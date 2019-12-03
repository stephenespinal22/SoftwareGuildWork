/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.guessnumber.services;

import java.util.List;
import sg.com.guessnumber.dtos.Game;
import sg.com.guessnumber.dtos.Round;

/**
 *
 * @author stephenespinal
 */
public interface GuessNumberService {

    Game createGame(Game game);

    List<Game> readGames();

    Game readGameById(int id);

    Round createRound(Round round);

    List<Round> readRoundsByGameId(int gameId);
    
    void deleteAllGames();
  
    void updateGame(Game game);
}
