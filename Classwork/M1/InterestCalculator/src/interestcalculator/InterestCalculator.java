/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interestcalculator;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class InterestCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        double currentBalance = promptDouble("What is the initial principal? ($): ");
        double annualInterestRate = promptDouble("What is the Annual Interest Rate? (%): ");
        int numberOfYears = promptNumber("How many years is the money to stay in the fund? ");
        double quarterlyInterestRate = annualInterestRate / 4;

        for (int year = 0; year < numberOfYears; year++) {
            
            System.out.println("--------------------------\nYear " + (year +1));
            System.out.println("The Principal at the begining of the year is: $" + currentBalance);
            double oldBalance = currentBalance;
            for (int i = 0; i < 4; i++) {
                currentBalance = currentBalance * (1 + (quarterlyInterestRate / 100));
            }
            System.out.println("The total amount of interest earned for the year is: $" + (currentBalance - oldBalance));
            System.out.println("The principal at the end of this year is: $" + currentBalance);
        }


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
