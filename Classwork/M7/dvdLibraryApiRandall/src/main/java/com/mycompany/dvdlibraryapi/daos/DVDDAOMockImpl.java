/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryapi.daos;

import com.mycompany.dvdlibraryapi.dtos.DVD;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;


public class DVDDAOMockImpl implements DVDDAO {

    private static List<DVD> dvdList;

    public DVDDAOMockImpl() {
        if (dvdList == null) {
            ArrayList<DVD> list = new ArrayList<DVD>();
            DVD dvd = new DVD();
            dvd.setID(0);            
            dvd.setDirectorId(0);

            dvd.setTitle("World/Cosmo");
            dvd.setDescription("Hello");
            list.add(dvd);
            dvdList = list;
        }
    }

    @Override
    public DVD createDvd(DVD d) {
        int nextId = 0;
        nextId = dvdList.stream().mapToInt(v -> v.getID()).max().orElse(0);
        nextId++;
        d.setID(nextId);
        dvdList.add(d);

        return d;
    }

    @Override
    public List<DVD> readDvds() {

        return dvdList;
    }

    @Override
    public DVD readById(int id) {
        return this.dvdList.stream()
                .filter(d -> d.getID() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateDvd(DVD d) {
        DVD foundDvd = readById(d.getID());
        if (foundDvd != null) {
            foundDvd.setTitle(d.getTitle());
            foundDvd.setDescription(d.getDescription());
        }
    }

    @Override
    public void deleteDvd(int id) {
        dvdList.removeIf(dvd -> dvd.getID() == id);
    }

    @Override
    public List<DVD> readDvdsByDirector(int directorid) {
        return dvdList.stream().filter(dvd -> dvd.getDirectorId()== directorid).collect(Collectors.toList());
    }

}
