/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doggenetics;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class DogGenetics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*create variables
        call get random percentages method to fill array (of 
        your choice of size) of percentages that add up the number of your choosing
         */
        int[] percentages = getRandomPercentages(5, 100);

        //create array of dogbreeds should be same amount as array created above
        String[] dogBreeds = {"St. Benard", "Chihuahua",
            "Dramatic RedNosed Asian Pug", "Common Cur", "King Doberman"};

        //ask user for dogname for display
        String dogName = prompt("What is your dog's name? ");

        //display fake results
        System.out.println("Well then, I have this highly reliable "
                + "report on " + dogName + "'s prestigious "
                + "background right here.\n");

        System.out.println(dogName + " is:\n");

        displayPercentageOfDog(percentages, dogBreeds);

        System.out.println("\nWow, that's QUITE the dog!");

    }

    // method creates an array of specified amount and returns the array
    //full of random percentages that add up to 100
    public static int[] getRandomPercentages(int arrSize, int upTo) {

        //create array with amount passed by argument
        int[] percentages = new int[arrSize];

        // we need a sum to keep track of already generated numbers
        int sum = 0;

        //go through loop and generate number between 1 and (100 - sum)
        //we want 100 - sum  
        //the first time sum will be 0
        //this gives us a number between 1 and 100
        //next time we go through the loop, sum will be updated to add the generated number
        //and the pool of eligible numbers will be reduced by the numbers already generated
        //we do this until the very last number which we take care of after the loop
        for (int i = 0; i < percentages.length - 1; i++) {
            percentages[i] = getRandomNumber(0, upTo - sum);
            sum += percentages[i];
        }

        //last index in the array is random based on the other numbers
        //we do this to ensure that the numbers add up to 100
        percentages[percentages.length - 1] = upTo - sum;
        sum += percentages[percentages.length - 1];

        //return the array full
        return percentages;

        //OLD CODE/TEST CODE
        //sum = 0;
//        int percentage1 = getRandomNumber(0, 100);
//        sum += percentage1;
//        int percentage2 = getRandomNumber(0,100 - sum);
//                sum += percentage2;
//
//        int percentage3 = getRandomNumber(0,100 - sum);
//                sum += percentage3;
//
//        int percentage4 = getRandomNumber(0,100 - sum);
//                sum += percentage4;
//
//        int percentage5 = 100 - sum;
//
//        System.out.println(percentage1);
//        System.out.println(percentage2);
//        System.out.println(percentage3);
//        System.out.println(percentage4);
//        System.out.println(percentage5);
//        
//        sum = percentage1 + percentage2 + percentage3 + percentage4 + percentage5;
//        
//        System.out.println("sum: " + sum);
    }

    //just a excercise method to see if I could randomize the breeds
    //no duplicate numbers
    public static int[] getArrayOfRandomIndexesOfAnotherArray(int arraySize) {
        //create array to return
        int[] array = new int[arraySize];

        //initilize to -1 (empty)
        int possiblePosition = -1;

        //make array empty
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }

        //fill array with random numbers from 0 to array's size - 1 (indexes)
        for (int i = 0; i < array.length; i++) {

            //repeatly generate number until you get one thats not in the array
            do {
                possiblePosition = getRandomNumber(0, array.length - 1);
            } while (checkIfInArray(array, possiblePosition));
            //once we find one, add it to the array
            array[i] = possiblePosition;
        }

        return array;
    }
    
    //needed this method to check if int is in an array for above method
    public static boolean checkIfInArray(int[] array, int intToCheck) {
        for (int i = 0; i < array.length; i++) {
            if (intToCheck == array[i]) {
                return true;
            }
        }
        return false;
    }

    //display formatted table of random percentage and dog
    //accepts the percentage array and the dog array
    public static void displayPercentageOfDog(int[] percentages, String[] dogs) {
        
        //generate array of random numbers from 0 to array size -1 (all indexes no duplication)
        //example.. if dog array is 5, then this array could contain {1,4,2,3,0}
        int [] arrayOfDogIndexes = getArrayOfRandomIndexesOfAnotherArray(dogs.length);

        for (int i = 0; i < percentages.length; i++) {
            //print out the percentages and then print a random position in the dogs
            //array by iterativley going through the "dog index" array, returning that random
            //number that corresponds to an index for the dogs array
            System.out.println(percentages[i] + "% " + dogs[ arrayOfDogIndexes[i] ]);
        }
    }

    //get a random number in the range passed by the arguments
    public static int getRandomNumber(int min, int max) {
        //we want to return 0 here because if we pass 0,0
        //we want it to go to zero, sum is already 100
        if (min >= max) {
            return 0;
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

    //display a message and return a string of input
    public static String prompt(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }

    //display a message and return an integer parsed from a string input
    public static int promptNumber(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(sc.nextLine());
    }

}
