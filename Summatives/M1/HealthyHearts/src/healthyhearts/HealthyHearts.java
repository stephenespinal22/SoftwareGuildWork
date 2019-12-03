/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthyhearts;

import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class HealthyHearts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //healthy hearts
        int age = promptNumber("What is your age? ");
        int maxHR = 220 - age;
        //we use Math.round to round the number and truncate the un-needed extra sig figs
        System.out.println("Your maximum heart rate should be " + maxHR + " beats per minute"
                + "\nYour target HR Zone is " + (Math.round(maxHR * .5))
                + " - " + (Math.round(maxHR * .85)) + " beats per minute");

    }
    //display a message and return an integer parsed from a string input

    public static int promptNumber(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(sc.nextLine());
    }
}
