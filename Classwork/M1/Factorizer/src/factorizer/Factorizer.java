/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorizer;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class Factorizer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int numOfFactors = 0;
        int calcPerfectNum = 0;

        int numToFactor = promptNumber("What number would you like to factor? ");
        System.out.println("The factors of " + numToFactor + " are: ");

        for (int i = 1; i < numToFactor; i++) {
            if (numToFactor % i == 0) {
                numOfFactors++;
                calcPerfectNum += i;
                System.out.println(i);
            }
        }

        //print out the number as a factor
        System.out.println(numToFactor);
        //how many factors add 1 to include the number itself
        System.out.println(numToFactor + " has " + (numOfFactors + 1) + " factors");

        //check if the number is perfect by adding up all the factors besides itself
        if (calcPerfectNum == numToFactor) {
            System.out.println(numToFactor + " is a perfect number.");
        } else {
            System.out.println(numToFactor + " is not a perfect number.");
        }
        if (numOfFactors == 1) {
            System.out.println(numToFactor + " is a prime number.");
        } else {
            System.out.println(numToFactor + " is not a prime number.");
        }

    }

    public static int promptNumber(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(sc.nextLine());
    }
}
