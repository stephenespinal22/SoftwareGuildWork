/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibraryapi.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Repository;
import sg.com.dvdlibraryapi.dtos.DVD;


public class DvdDaoMockImpl implements DVDDao {

    private static List<DVD> dvdList;

    public DvdDaoMockImpl() {
        if (dvdList == null) {
            ArrayList<DVD> list = new ArrayList<DVD>();
            DVD dvd = new DVD();
            dvd.setId(1);
            dvd.setTitle("Back To The Future");
            dvd.setDescription("10/10");
            list.add(dvd);
            dvdList = list;
        }
    }

    @Override
    public DVD createDVD(DVD dvd) {
        int nextId = 0;
        nextId = dvdList.stream().mapToInt(v -> v.getId()).max().orElse(0);
        //default to zero if nothing in dvdList
        nextId++;
        dvd.setId(nextId);
        dvdList.add(dvd);
        return dvd;
    }

    @Override
    public List<DVD> readDVDs() {
        return dvdList;
    }

    @Override
    public DVD readDVDById(int id) {

        return this.dvdList.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateDVDById(DVD dvd) {
        DVD foundDvd = readDVDById(dvd.getId());
        if (foundDvd != null) {
            foundDvd.setTitle(dvd.getTitle());
            foundDvd.setDescription(dvd.getDescription());
        }
    }

    @Override
    public void deleteDVD(int id) {
        dvdList.removeIf(dvd -> dvd.getId() == id);
    }

    @Override
    public List<DVD> readDVDsByDirectorId(int directorId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
