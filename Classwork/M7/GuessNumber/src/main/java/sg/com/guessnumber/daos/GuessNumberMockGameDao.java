/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.guessnumber.daos;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import sg.com.guessnumber.dtos.Game;

/**
 *
 * @author stephenespinal
 */
//@Repository
//@Profile("test")
public class GuessNumberMockGameDao implements GuessNumberGameDao {

    private static List<Game> gameList;

    public GuessNumberMockGameDao() {
        if (gameList == null) {
            ArrayList<Game> list = new ArrayList<Game>();
            Game game = new Game();
            game.setGameId(1);
            game.setAnswer("1234");
            game.setIsFinished(false);
            list.add(game);
            gameList = list;
        }
    }

    @Override
    public Game createGame(Game game) {
        int nextId = 0;
        nextId = gameList.stream().mapToInt(v -> v.getGameId()).max().orElse(0);
        //default to zero if nothing in dvdList
        nextId++;
        game.setGameId(nextId);
        gameList.add(game);
        return game;
    }

    @Override
    public List<Game> readAllGames() {
        return gameList;
    }

    @Override
    public Game readGameById(int id) {
        return this.gameList.stream()
                .filter(d -> d.getGameId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateGame(Game game) {
        Game foundGame = readGameById(game.getGameId());
        if (foundGame != null) {
            foundGame.setGameId(game.getGameId());
            foundGame.setAnswer(game.getAnswer());
            foundGame.setIsFinished(game.getIsFinished());

        }
    }

    @Override
    public void deleteAllGames() {

    }

}
