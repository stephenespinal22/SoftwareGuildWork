/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.guessnumber.daos;

import java.util.List;
import sg.com.guessnumber.dtos.Game;

/**
 *
 * @author stephenespinal
 */
public interface GuessNumberGameDao {

    Game createGame(Game game);

    List<Game> readAllGames();

    Game readGameById(int id);

    void updateGame(Game game);

    void deleteAllGames();

}
