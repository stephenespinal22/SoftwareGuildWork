/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.guessnumber.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sg.com.guessnumber.daos.GuessNumberGameDao;
import sg.com.guessnumber.daos.GuessNumberRoundDao;
import sg.com.guessnumber.dtos.Game;
import sg.com.guessnumber.dtos.Round;

@Service
public class GuessNumberServiceImpl implements GuessNumberService {

    private GuessNumberGameDao gameDao;
    private GuessNumberRoundDao roundDao;

    @Autowired
    public GuessNumberServiceImpl(GuessNumberGameDao gameDao, GuessNumberRoundDao roundDao) {
        this.gameDao = gameDao;
        this.roundDao = roundDao;
    }

    @Override
    @Transactional
    public Game createGame(Game game) {
        game.setAnswer(generateAnswer());
        game = gameDao.createGame(game);

        //create a a game with a hidden answer to send back to controller
        Game gameToReturn = new Game();
        gameToReturn.setGameId(game.getGameId());
        gameToReturn.setIsFinished(Boolean.FALSE);
        hideAnswer(gameToReturn);

        return gameToReturn;
    }

    @Override
    public List<Game> readGames() {

        List<Game> gameList = gameDao.readAllGames();

        //go through list and set answer to a hidden value
        for (Game gameToCheck : gameList) {
            hideAnswer(gameToCheck);
        }

        return gameList;
    }

    @Override
    public Game readGameById(int id) {
        Game gameToReturn;

        //need to catch this exception and return null which we check for
        //in the controller to send a 404 not found
        try {
            gameToReturn = gameDao.readGameById(id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        hideAnswer(gameToReturn);

        return gameToReturn;
    }

    private void hideAnswer(Game gameToReturn) {
        if (gameToReturn.getIsFinished() == false) {
            gameToReturn.setAnswer("It's a secret to everyone!");
        }
    }

    @Override
    public List<Round> readRoundsByGameId(int gameId) {
        return roundDao.readRoundsByGameId(gameId);
    }

    @Override
    @Transactional
    public Round createRound(Round round) {

        //check if game exists
        //get game to work with round
        Game thisRoundsGame;
        try {
            thisRoundsGame = gameDao.readGameById(round.getGameId());
            //setRounds to all rounds
            thisRoundsGame.setRounds(roundDao.readRoundsByGameId(round.getGameId()));
        } catch (EmptyResultDataAccessException e) {
            return null; //send null will be checked in controller
        }

        //check if game is done already
        if (thisRoundsGame.getIsFinished()) {
            //would like to throw exception here
            return null;
        }
        //set time stamp
        String dateTimeNow = LocalDateTime.now().toString();
        round.setTimeStamp(dateTimeNow);

        //setRoundName
        round.setRoundName((thisRoundsGame.getRounds().size() + 1) + "");

        //check if correct
        String thisGamesAnswer = thisRoundsGame.getAnswer();
        String thisGamesGuess = round.getGuess();

        //check for win
        if (thisGamesAnswer.equalsIgnoreCase(thisGamesGuess)) {
            thisRoundsGame.setIsFinished(true);
            gameDao.updateGame(thisRoundsGame);
            round.setResult("e:4:p:0");
        } else {  //generate result string
            round.setResult(generateResult(thisGamesAnswer, thisGamesGuess));
        }

        return roundDao.createRound(round);
    }

    private String generateResult(String answer, String guess) {
        String result;
        int countExact = 0;
        int countNumInString = 0;

        //get exact
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess.charAt(i)) {
                countExact++;
            }
        }

        //get partial
        for (int i = 0; i < guess.length(); i++) {
            for (int j = 0; j < answer.length(); j++) {
                if (guess.charAt(i) == answer.charAt(j)) {
                    countNumInString++;
                }
            }
        }
        result = "e:" + countExact + ":p:" + (countNumInString - countExact);

        return result;
    }

    private String generateAnswer() {

        //set up for method
        String answer = "";
        ArrayList<Integer> intArray = new ArrayList<>();
        int randomNum = -1;

        //insert 4 random numbers in an array only if they already havent been picked
        while (intArray.size() < 4) {

            randomNum = getRandomNumber(0, 9);
            if (!intArray.contains(randomNum)) {
                intArray.add(randomNum);
            }
        }

        //take array and make a string out of it
        for (int i = 0; i < intArray.size(); i++) {
            answer = answer + intArray.get(i);
        }

        return answer;
    }

    //get a random number in the range passed by the arguments inclusive
    private int getRandomNumber(int min, int max) {
        if (min >= max) {
            return -1;
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @Override
    public void deleteAllGames() {
        gameDao.deleteAllGames();
    }
    
   @Override
    public void updateGame(Game game) {
        gameDao.updateGame(game);
    }
}
