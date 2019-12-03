/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.guessnumber.services;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sg.com.guessnumber.TestApplicationConfiguration;
import sg.com.guessnumber.daos.GuessNumberGameDao;
import sg.com.guessnumber.dtos.Game;
import sg.com.guessnumber.dtos.Round;

/**
 *
 * @author stephenespinal
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class GuessNumberServiceTest {

    @Autowired
    GuessNumberService service;

    public GuessNumberServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createGame method, of class GuessNumberService.
     */
    @Test
    public void testCreateGame() {

        service.deleteAllGames();

        Game game = new Game();

        Game gameFromService = service.createGame(game);

        assertEquals(gameFromService.getAnswer(), "It's a secret to everyone!");
        assertTrue(!gameFromService.getIsFinished());

    }

    /**
     * Test of readGames method, of class GuessNumberService.
     */
    @Test
    public void testReadGames() {
        service.deleteAllGames();

        ArrayList<Game> list = new ArrayList<Game>();

        Game game = new Game();

        game = service.createGame(game);
        list.add(game);

        List<Game> gamesFromService = service.readGames();

        assertEquals(list, gamesFromService);

    }

    /**
     * Test of readGameById method, of class GuessNumberService.
     */
    @Test
    public void testReadGameById() {
        service.deleteAllGames();

        Game game = new Game();
        game = service.createGame(game);
        int gameId = game.getGameId();

        Game gameFromService = service.readGameById(gameId);

        assertEquals(game, gameFromService);

    }

    /**
     * Test of createRound method, of class GuessNumberService.
     */
    @Test
    public void testCreateRound() {
        service.deleteAllGames();

        Game game = new Game();
        game = service.createGame(game);
        int gameId = game.getGameId();
        game.setIsFinished(true);
        service.updateGame(game);

        //get the game back and find out the answer
        Game gameFromService = service.readGameById(gameId);
        String answer = gameFromService.getAnswer();

        //set it back to false
        game.setIsFinished(false);
        service.updateGame(game);

        //create the round
        Round round = new Round();
        round.setGuess(answer);
        round.setGameId(gameId);

        service.createRound(round);

        //re get game to check if its true
        gameFromService = service.readGameById(gameId);

        assertTrue(gameFromService.getIsFinished());

    }

    /**
     * Test of readRoundsByGameId method, of class GuessNumberService.
     */
    @Test
    public void testReadRoundsByGameId() {
        service.deleteAllGames();

        Game game = new Game();
        game = service.createGame(game);
        int gameId = game.getGameId();

        //create the round
        ArrayList<Round> list = new ArrayList<Round>();

        Round round = new Round();
        round.setGuess("1234");
        round.setGameId(gameId);
        
        list.add(round);

        service.createRound(round);
        
        List<Round> roundsFromService = service.readRoundsByGameId(gameId);
        
        assertEquals(list,roundsFromService);

    }
}
