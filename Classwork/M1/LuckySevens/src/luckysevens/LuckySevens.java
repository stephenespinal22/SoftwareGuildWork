/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckysevens;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class LuckySevens {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int money = promptNumber("How many dollars do you have? ");
        int die1, die2;
        int howManyRolls = 0;
        int rollsToStopAt = 0;
        int mostAmountOfMoney = 0;

        while (money > 0) {
            die1 = getRandomNumber(1, 6);
            die2 = getRandomNumber(1, 6);
            howManyRolls++;
            
            if ( (die1 + die2) == 7)
                money += 4;
            else
                money--;
            
            if ( mostAmountOfMoney < money)
            {
                mostAmountOfMoney = money;
                rollsToStopAt = howManyRolls;
            }
        }
        
        System.out.println("You are broke after " + howManyRolls + " rolls.\n"
                + "You should have quit after " + rollsToStopAt + " rolls when you "
                        + "had $" + mostAmountOfMoney);
        

    }

    public static int getRandomNumber(int min, int max) {

        if (min >= max) {
            return -1;
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void display(String message) {
        System.out.println(message);
    }

    public static String prompt(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }

    public static int promptNumber(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(sc.nextLine());
    }

    public static double promptDouble(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return Double.parseDouble(sc.nextLine());
    }

}
