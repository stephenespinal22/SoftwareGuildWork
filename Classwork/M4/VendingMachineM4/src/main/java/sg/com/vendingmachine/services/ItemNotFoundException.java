/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingmachine.services;

/**
 *
 * @author stephenespinal
 */
public class ItemNotFoundException extends Exception  {
    
        public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message,
            Throwable cause) {
        super(message, cause);
    }

}
