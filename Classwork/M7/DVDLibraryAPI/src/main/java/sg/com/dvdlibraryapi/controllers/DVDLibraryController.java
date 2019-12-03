/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibraryapi.controllers;

import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sg.com.dvdlibraryapi.dtos.DVD;
import sg.com.dvdlibraryapi.services.DVDLibraryService;
import sg.com.dvdlibraryapi.views.DVDLibraryView;

/**
 *
 * @author stephenespinal
 */
@RestController
@RequestMapping("/api")

public class DVDLibraryController {

    private DVDLibraryView view;
    private DVDLibraryService service;

    @Autowired

    public DVDLibraryController(DVDLibraryView view, DVDLibraryService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {

    }

    @RequestMapping(value = "/dvds", method = POST)
    @ResponseStatus(HttpStatus.CREATED) //201 created a resource
    public DVD createDvd(@RequestBody DVD dvd) {
        return service.createDVD(dvd);
    }

    //'value = "/dvds", method = GET' the path "/dvds" cannot have another method using this request mapping and same get method
    //use another path 
    @RequestMapping(value = "/dvds", method = GET)
    public List<DVD> readDvds() {
        return service.readDVDs();
    }

    //read by id
    //putting in a variable
    //localhost:8080/dvds/{variable}
    @RequestMapping(value = "/dvds/{id}", method = GET)
    public ResponseEntity<DVD> readDvdById(@PathVariable int id) {

        DVD dvd = service.readDVDById(id);

        if (dvd == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity(dvd, HttpStatus.OK);

    }

    @RequestMapping(value = "/dvds/{id}", method = PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDvd(@PathVariable int id, @RequestBody DVD dvd) {
        service.updateDVDById(dvd);
    }

     @RequestMapping(value = "/dvds/{id}", method = DELETE)
     @ResponseStatus(HttpStatus.NO_CONTENT) // 204 public void deleteDvd(@PathVariable int id){ service.deleteDvd(id); }
    public void deleteDvd(@PathVariable int id) {
       service.deleteDVD(id);
    
    }

}
