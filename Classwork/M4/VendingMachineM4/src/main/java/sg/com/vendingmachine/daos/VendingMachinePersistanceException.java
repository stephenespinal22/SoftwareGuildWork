/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingmachine.daos;

/**
 *
 * @author stephenespinal
 */
public class VendingMachinePersistanceException extends Exception  {
    
        public VendingMachinePersistanceException(String message) {
        super(message);
    }

    public VendingMachinePersistanceException(String message,
            Throwable cause) {
        super(message, cause);
    }

}
