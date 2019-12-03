/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise5;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class Excercise5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /*
        
        // a little chaos
        Random randomizer = new Random();

        System.out.println("Random can make integers: " + randomizer.nextInt());
        System.out.println("Or a double: " + randomizer.nextDouble());
        System.out.println("Or even a boolean: " + randomizer.nextBoolean());

        int num = randomizer.nextInt(100);

        System.out.println("You can store a randomized result: " + num);
        System.out.println("And use it over and over again: " + num + ", " + num);

        System.out.println("Or just keep generating new values");
        System.out.println("Here's a bunch of numbers from 0 - 100: ");

        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        //this is make it so that it randomizes a number from 50 to 99
        //the nextint in random goes from 0 (inclusive)
        //and then goes to the argument exclusive so for 0 - 100 nextInt(101)
        //so this will go from 50 to 99 to becuase we are adding the number after the
        //number has been generated
        System.out.println(randomizer.nextInt(50) + 50);   
     
        //opinonator
        Random randomizer = new Random();
        System.out.println("I can't decide what animal I like the best.");
        System.out.println("I know! Random can decide FOR ME!");

        //we have to randomize to 6 to include 5
        int x = randomizer.nextInt(6);

        System.out.println("The number we chose was: " + x);

        switch (x) {
            case 0:
                System.out.println("Llamas are the best!");
                break;
            case 1:
                System.out.println("Dodos are the best!");
                break;
            case 2:
                System.out.println("Woolly Mammoths are DEFINITELY the best!");
                break;
            case 3:
                System.out.println("Sharks are the greatest, they have their own week!");
                break;
            case 4:
                System.out.println("Cockatoos are just so awesomme!");
                break;
            case 5:
                System.out.println("Have you ever met a Mole-Rat? They're GREAT!");
                break;
            default:
                break;
        }

        System.out.println("Thanks Random, maybe YOU'RE the best!");
        
         
        
        //fortune cookie
        Random randomizer = new Random();
        
        String[] array = {"Those aren’t the droids you’re looking for.",
            "Never go in against a Sicilian when death is on the line!",
            "Goonies never say die.",
            "With great power there must also come — great responsibility.",
            "Never argue with the data.",
            "Try not. Do, or do not. There is no try.",
            "You are a leaf on the wind, watch how you soar.",
            "Do absolutely nothing, and it will be everything that you thought it could be.",
            "Kneel before Zod.",
            "Make it so."};
        
        //we have to randomize to array length
        int i = randomizer.nextInt(array.length);
        System.out.println("Your Geek Fortune: " + array[i]);
        
       //Random().nextInt(int bound) = Random integer from 0 (inclusive) to bound (exclusive)
	
	//1. nextInt(range) = nextInt(max - min)
	new Random().nextInt(5);  // [0...4] [min = 0, max = 4]
	new Random().nextInt(6);  // [0...5]
	new Random().nextInt(7);  // [0...6]
	new Random().nextInt(8);  // [0...7]
	new Random().nextInt(9);  // [0...8]
	new Random().nextInt(10); // [0...9]			
	new Random().nextInt(11); // [0...10]
	
	//2. To include the last value (max value) = (range + 1)
	new Random().nextInt(5 + 1)  // [0...5] [min = 0, max = 5]
	new Random().nextInt(6 + 1)  // [0...6]
	new Random().nextInt(7 + 1)  // [0...7]
	new Random().nextInt(8 + 1)  // [0...8]
	new Random().nextInt(9 + 1)  // [0...9]
	new Random().nextInt(10 + 1) // [0...10]			
	new Random().nextInt(11 + 1) // [0...11]
	
	//3. To define a start value (min value) in a range,
	//   For example, the range should start from 10 = (range + 1) + min
	new Random().nextInt(5 + 1)  + 10 // [0...5]  + 10 = [10...15]
	new Random().nextInt(6 + 1)  + 10 // [0...6]  + 10 = [10...16]
	new Random().nextInt(7 + 1)  + 10 // [0...7]  + 10 = [10...17]
	new Random().nextInt(8 + 1)  + 10 // [0...8]  + 10 = [10...18]
	new Random().nextInt(9 + 1)  + 10 // [0...9]  + 10 = [10...19]
	new Random().nextInt(10 + 1) + 10 // [0...10] + 10 = [10...20]
	new Random().nextInt(11 + 1) + 10 // [0...11] + 10 = [10...21]
	
	// Range = (max - min)
	// So, the final formula is ((max - min) + 1) + min
	
	//4. Test [10...30]
	// min = 10 , max = 30, range = (max - min)
	new Random().nextInt((max - min) + 1) + min
	new Random().nextInt((30 - 10) + 1) + 10
	new Random().nextInt((20) + 1) + 10
	new Random().nextInt(21) + 10    //[0...20] + 10 = [10...30]
	
	//5. Test [15...99]
	// min = 15 , max = 99, range = (max - min)
	new Random().nextInt((max - min) + 1) + min
	new Random().nextInt((99 - 15) + 1) + 15
	new Random().nextInt((84) + 1) + 15
	new Random().nextInt(85) + 15    //[0...84] + 15 = [15...99]
	
	//Done, understand?
         
        //high roller
        Random diceRoller = new Random();

        //we cant use diceRoller.nextInt(7) that will give us 0 - 6
        //the addition is the starting point 
        //if we did nextInt(7) + 1 that would give us (0-6) + 1 which would be 1 -7
        //random.nextInt(x) + y = Range: y ... ((x+y) - 1)?
        int rollResult = diceRoller.nextInt(6) + 1;

        //high roller v2
        int min = 1;
        int max;

        max = promptNumber("How many sides on the dice?: ");
        
        int rollResultM = getRandomNumberInRange(min, max);
        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResultM);

        if (rollResultM == min) {
            System.out.println("You rolled a critical failure!");
        } else if (rollResultM == max) {
            System.out.println("You rolled a critical! Nice Job!");
        }
        
   
        //coin flipper
        Random rCoin = new Random();
        boolean coinSide = rCoin.nextBoolean();

        display("Ready, Set, Flip....!!");
        if (coinSide) {
            display("You got Heads!");
        } else {
            display("You got Tails!");
        }

        */
        
        //Guess Me More
        display("I've chosen a number between -100 and 100. Betcha can't guess it!");
        int chosenNumber = getRandomNumberInRange(-100,100);
        System.out.println(chosenNumber);
        
        int guess = promptNumber("Your Guess: ");
        
        if (guess < chosenNumber)
            display("\nHa, nice try - too low! Try again!");
        else if(guess > chosenNumber)
            display("\nHa, nice try - too high! Try again!");
        else
            display("\nWow, nice guess! That was it!");

    }

    public static int getRandomNumberInRange(int min, int max) {

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
}
