/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryapi.daos;

import com.mycompany.dvdlibraryapi.dtos.DVD;
import java.util.List;

/**
 *
 * @author triplexlj
 */
public interface DVDDAO {
    //CREATE
    DVD createDvd(DVD d);
    //ReadALL
    List<DVD> readDvds();
    
    //ReadALL
    List<DVD> readDvdsByDirector(int directorid);
            
    //READByID
    DVD readById(int id);
    //UPDATE
    void updateDvd(DVD d);
    //DELETE
    void deleteDvd(int d);
}
