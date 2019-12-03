/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userioexample;

/**
 *
 * @author stephenespinal
 */
public class UserIOExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       UserIO io = new UserIO();
       
       io.readDouble("Enter a number between 0 and 10", 0, 10);
    }
    
}
