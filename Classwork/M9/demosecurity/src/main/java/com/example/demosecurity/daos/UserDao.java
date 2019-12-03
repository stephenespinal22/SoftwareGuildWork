/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demosecurity.daos;

import com.example.demosecurity.dtos.User;
import java.util.List;

/**
 *
 * @author stephenespinal
 */

public interface UserDao {
    User getUserById(int id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int id);
    User createUser(User user);
}
