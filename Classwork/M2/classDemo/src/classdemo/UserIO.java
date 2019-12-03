/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classdemo;

import java.util.Scanner;

/**
 *
 * @author acetip
 * 
 * 5/10
 */
public class UserIO {
    
    public void display(String message)
    {
        System.out.println(message);
    }
    
    public String prompt(String message)
    {
        display(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
        
    }
    
    public boolean promptQuestion(String message){
        String answer = prompt(message);
        return "y".equalsIgnoreCase(answer);
        
    }
    
    public int promptInt(String message) {
        Scanner sc = new Scanner(System.in);
        display(message);
        return sc.nextInt();
    }
    
    public String promptQuestion(String message,String[] options)
    {
        String answer = prompt(message);
        //check if item is in array
        
        //i stands for index
        for (int i = 0; i < options.length; i++) {
            if (options[i].equalsIgnoreCase(answer))
                return options[i];
        }
        display("invalid choice");
        return null;
        
    }
}
