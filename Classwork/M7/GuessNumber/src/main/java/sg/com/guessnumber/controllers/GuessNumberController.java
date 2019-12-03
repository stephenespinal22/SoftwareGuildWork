/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.guessnumber.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sg.com.guessnumber.dtos.Game;
import sg.com.guessnumber.dtos.Round;
import sg.com.guessnumber.services.GuessNumberService;

/**
 *
 * @author stephenespinal
 */
@RestController
@RequestMapping("/game")
public class GuessNumberController {

    private GuessNumberService service;

    @Autowired
    public GuessNumberController(GuessNumberService service) {
        this.service = service;
    }

    @RequestMapping(value = "/begin", method = POST)
    @ResponseStatus(HttpStatus.CREATED) //201 created a resource
    public Game createGame(@RequestBody Game game) {
        return service.createGame(game);
    }

    @RequestMapping(value = "guess", method = POST)
    @ResponseStatus(HttpStatus.CREATED) //201 created a resource
    public ResponseEntity<Round> createGuess(@RequestBody Round round) {
        Round roundtoReturn = service.createRound(round);

        if (roundtoReturn == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(roundtoReturn, HttpStatus.OK);
    }

    @RequestMapping(value = "/game", method = GET)
    public List<Game> readGames() {
        return service.readGames();
    }

    @RequestMapping(value = "/game/{id}", method = GET)
    public ResponseEntity<Game> readGameById(@PathVariable int id) {

        Game game = service.readGameById(id);

        if (game == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(game, HttpStatus.OK);

    }

    @RequestMapping(value = "/rounds/{id}", method = GET)
    public List<Round> readRoundsByGameId(@PathVariable int id) {
        return service.readRoundsByGameId(id);
    }

}
