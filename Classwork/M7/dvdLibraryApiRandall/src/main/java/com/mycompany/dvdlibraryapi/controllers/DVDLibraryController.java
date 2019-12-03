/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryapi.controllers;

import com.mycompany.dvdlibraryapi.daos.DVDDAO;
import com.mycompany.dvdlibraryapi.dtos.DVD;
import com.mycompany.dvdlibraryapi.services.DVDService;
import com.mycompany.dvdlibraryapi.views.DVDLibraryView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author triplexlj
 */
//very sensitive make sure controller package is named controller or controllers, thats it
@RestController//Telling SPRING this class-pay attention to incoming request-META data for Spring boot app to know about controller-its picky to know where you put your controller in
@RequestMapping("/api")
public class DVDLibraryController {

    private DVDLibraryView view;
    private DVDService service;

    @Autowired//Dependecy Injection

    public DVDLibraryController(DVDLibraryView view, DVDService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {

    }

    @RequestMapping(value = "/dvds", method = POST)//your getting data with POST//your giving data with GET
    @ResponseStatus(HttpStatus.CREATED)//201 created a resource and since its in the 200's everything is okay
    //CREATE
    public DVD createDvd(@RequestBody DVD d) {//@requestBody we have data coming in from http request is a post and the info is going to be in the body and we are directing that body to this variable
        return service.createDvd(d);
    }

    //HTTP VERBS
    //Get
    //Post
    //Put
    //Delete
    @RequestMapping(value = "/dvds", method = GET)//you are telling spring after the domain anything after the domain has to match a particular value to go to a method inside of your controller
    public List<DVD> readDvds(@RequestParam(value = "directorId", required = false) Integer directorId) {
        if (directorId == null) {
            return service.readDvds();

        }
        return service.readDvdsByDirector(directorId);
    }

    //READByID
    // localhost:8080/dvds/1
    @RequestMapping(value = "/dvds/{id}", method = GET)
    public ResponseEntity<DVD> readById(@PathVariable int id) {

        DVD dvd = service.readById(id);

        if (dvd == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity(dvd, HttpStatus.OK);
    }

    //UPDATE
    @RequestMapping(value = "/dvds/{id}", method = PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void updateDvd(@PathVariable int id, @RequestBody DVD d) {
        service.updateDvd(d);
    }

    //DELETE
    @RequestMapping(value = "/dvds/{id}", method = DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void deleteDvd(@PathVariable int id) {
        service.deleteDvd(id);
    }

}
