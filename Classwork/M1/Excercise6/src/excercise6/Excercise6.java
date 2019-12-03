/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise6;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class Excercise6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /*
        //wait a while
        
        int timeNow = 5;
        int bedTime = 10;

        while (timeNow < bedTime) {
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a liiiiittle longer....");
            timeNow++; // Time passes
        }

        System.out.println("Oh. It's " + timeNow + " o'clock.");
        System.out.println("Guess I should go to bed ...");
        
        
        //stay positive
        int startingNum = promptNumber("What number should I count down from? ");
        System.out.println("\nHere goes!\n");
        
        while (startingNum >= 0)
        {
            System.out.print(startingNum + " ");
            
            if(startingNum % 10 == 0)
            {
                System.out.println("\n");
            }
            startingNum--;
        }
        
        System.out.println("\nWhew, better stop there...!");
        
        

        //Roller Coaster
        
        Scanner userInput = new Scanner(System.in);

        System.out.println("We're going to go on a roller coaster...");
        System.out.println("Let me know when you want to get off...!");

        String keepRiding = "y";
        int loopsLooped = 0;
        while (keepRiding.equals("y")) {
            System.out.println("WHEEEEEEEEEEEEEeEeEEEEeEeeee.....!!!");
            System.out.print("Want to keep going? (y/n) :");
            keepRiding = userInput.nextLine();
            loopsLooped++;
        }

        System.out.println("Wow, that was FUN!");
        System.out.println("We looped that loop " + loopsLooped + " times!!");
        
        
        
        //Do or do not
        
        Scanner input = new Scanner(System.in);
        System.out.print("Should I do it? (y/n) ");
        boolean doIt;

        if (input.next().equals("y")) {
            doIt = true; // DO IT!
        } else {
            doIt = false; // DONT YOU DARE!
        }

        boolean iDidIt = false;

        do {
            iDidIt = true;
            break;
        } while (doIt);

        if (doIt && iDidIt) {
            System.out.println("I did it!");
        } else if (!doIt && iDidIt) {
            System.out.println("I know you said not to ... but I totally did anyways.");
        } else {
            System.out.println("Don't look at me, I didn't do anything!");
        }
        
        
        //Loves Me
        int petals = 34;
        
        while (petals > 0)
        {
            if(petals % 2 == 0)
            {
                System.out.println("It loves me NOT");
            }else
            {
                System.out.println("It Loves me!");
            }
            petals--;
        }
        System.out.println("I knew it, It loves me!");
        
        //Maybe it loves me
        int petals = getRandomNumberInRange(13, 89);
        //int petals = 34;
        System.out.println(petals);
        boolean sheLovesMe = true;
        while (petals > 0) {
            if (sheLovesMe) {

                System.out.println("It loves me NOT");

                sheLovesMe = false;
            } else {

                System.out.println("It Loves me!");
                
                sheLovesMe = true;
            }
            petals--;
        }
        if (sheLovesMe) {
            System.out.println("I knew it, It loves me!");
        } else {
            System.out.println("Awww, bummer");
        }
         
        
        //guess me finally
        int chosenNumber = getRandomNumberInRange(-100, 100);
        System.out.println(chosenNumber);

        display("I've chosen a number between -100 and 100. Betcha can't guess it!");

        int guess = promptNumber("Your guess: ");

        if (guess == chosenNumber) 
        {
            System.out.println("\nWow, nice guess! That was it!");
        } 
        else 
        {
            while (guess != chosenNumber) 
            {
                if (guess < chosenNumber) 
                    System.out.println("\nHa, nice try - too low! Try again!");
                else if (guess > chosenNumber) 
                    System.out.println("\nHa, nice try - too high! Try again!");
                
                guess = promptNumber("Your guess: ");
            }
            System.out.println("\nFinally! It's about time you got it!");
        }

    
        
        //Beware the kraken
        System.out.println("Alrighty, get those flippers and wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLASH*");

        int depthDivedInFt = 0;

        // Turns out the ocean is only so deep, 36200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.
        while(depthDivedInFt < 36200){
            System.out.println("So far, we've swam " + depthDivedInFt + " feet");
            
            //added this question to stop
            if(prompt("should we stop? (y/n) ").equals("y"))
                break;

            if(depthDivedInFt >= 20000){
                System.out.println("Uhhh, I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            }

            // I can swim, really fast! 1000ft at a time!
            depthDivedInFt += 1000;
            
            //adding seeing fish
            int randomFish = getRandomNumberInRange(0,2);
            switch(randomFish){
                case 0:
                    System.out.println("There's some tuna");
                    break;
                case 1:
                    System.out.println("There's some swordfish");
                    break;
                case 2:
                    System.out.println("There's some whale sharks");
                default:
                    break;
            }
            
        }
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");

        */
        
        //lazy teenager
        
        int chanceOfCleaning = 0;
        int timesTold = 0;      
        
        while (true)
        {
            timesTold++;
            chanceOfCleaning += 5;
            System.out.println("Clean your room!! (x" + timesTold + ") Chance of cleaning: " + chanceOfCleaning);
            
            if(timesTold == 15)
            {
                System.out.println("Clean your room!! That's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
                break;
            }
            
            int chance = getRandomNumberInRange(1,100);
            if( chance < chanceOfCleaning)
            {
                System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
                break;
            }
            
        }
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
