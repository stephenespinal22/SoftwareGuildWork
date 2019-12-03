/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.masteryoop.daos;

/**
 *
 * @author stephenespinal
 */
public class FlooringPersistanceException extends Exception {

    public FlooringPersistanceException(String message) {
        super(message);
    }

    public FlooringPersistanceException(String message,
            Throwable cause) {
        super(message, cause);
    }
}

