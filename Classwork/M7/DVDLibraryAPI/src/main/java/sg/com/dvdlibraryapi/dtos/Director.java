/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibraryapi.dtos;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author stephenespinal
 */
public class Director {
    
    private int directorId;
    private String directorName;
    private List<DVD> dvds;

    public List<DVD> getDvds() {
        return dvds;
    }

    public void setDvds(List<DVD> dvds) {
        this.dvds = dvds;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.directorId;
        hash = 67 * hash + Objects.hashCode(this.directorName);
        hash = 67 * hash + Objects.hashCode(this.dvds);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Director other = (Director) obj;
        if (this.directorId != other.directorId) {
            return false;
        }
        if (!Objects.equals(this.directorName, other.directorName)) {
            return false;
        }
        if (!Objects.equals(this.dvds, other.dvds)) {
            return false;
        }
        return true;
    }


    
    
}
