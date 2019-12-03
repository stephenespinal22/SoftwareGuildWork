/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Random;

/**
 *
 * @author stephenespinal
 */
public class PrintAllRandomNumbersInRange {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[] array = new int[5];
        int possiblePosition = -1;

        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }

        for (int i = 0; i < array.length; i++) {

            do {
                possiblePosition = getRandomNumber(0, array.length-1);
            } while (checkIfInArray(array,possiblePosition));
            array[i] = possiblePosition;
        }

        for (int i : array) {
            System.out.println(i);
        }
    }

    public static boolean checkIfInArray(int[] array, int intToCheck) {
        for (int i = 0; i < array.length; i++) {
            if (intToCheck == array[i]) {
                return true;
            }
        }
        return false;
    }

    //get a random number in the range passed by the arguments
    public static int getRandomNumber(int min, int max) {
        //we want to return 0 here because if we pass 0,0
        //we want it to go to zero, sum is already 100
        if (min >= max) {
            return -1;
        }

        Random r = new Random();
        //next int returns a number within 0 to specified number (non-inclusive)
        //we only want numbers between max and min
        //so EX.. 50 to 100 we only want 50 numbers so 100 -50
        //we add 1 because next int is not including the number specified to
        //finally we add min to the end because we want the number generated
        //to start at that minimum value EX.. (0 to 50) + 50 = 50 .. 100 
        return r.nextInt((max - min) + 1) + min;
    }

}
