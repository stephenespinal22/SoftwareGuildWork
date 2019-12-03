/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibraryapi.views;

import java.util.List;
import org.springframework.stereotype.Component;
import sg.com.dvdlibraryapi.dtos.DVD;

/**
 *
 * @author stephenespinal
 */

@Component

public class DVDLibraryView {

    public DVD promptDvd() {
        return new DVD();
    }

    public void displayDvds(List<DVD> dvds) {
    }

    public void displayDvd(DVD dvd) {
    }

    public DVD promptEditDvd(DVD dvd) {
        return dvd;
    }

    public int promptDvdId(String message) {
        return 0;
    }

    public int promptMenu() {
        return 1;
    }

}
