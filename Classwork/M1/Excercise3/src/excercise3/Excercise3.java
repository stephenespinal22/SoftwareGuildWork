/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise3;

import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class Excercise3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*

        String yourName;
        String yourQuest;
        double velocityOfSwallow;

        System.out.print("What is your name?? ");
        yourName = inputReader.nextLine();

        System.out.print("What is your quest?! ");
        yourQuest = inputReader.nextLine();

        System.out.print("What is the airspeed velocity of an unladen"
                + " swallow?!?! ");
        velocityOfSwallow = inputReader.nextDouble();

        System.out.println("How do you know " + velocityOfSwallow + " is correct," + yourName + ",");
        System.out.println("when you didn't even know if the swallow was African or European!");
        System.out.println("Maybe skip answering things about birds and instead go " + yourQuest + "\n");

        int meaningOfLifeAndEverything = 42;
        double pi = 3.14159;
        String cheese, color;

        System.out.println("Give me pi to at least 5 decimals: ");
        pi = inputReader.nextDouble();

        System.out.println("What is the meaning of life, the universe & everything? ");
        meaningOfLifeAndEverything = inputReader.nextInt();

        System.out.println("What is your favorite kind of cheese? ");
        cheese = inputReader.nextLine();

        System.out.println("Do you like the color red or blue more? ");
        color = inputReader.nextLine();

        System.out.println("Ooh, " + color + " " + cheese + " sounds delicious!");
        System.out.println("The circumference of life is " + (2 * pi * meaningOfLifeAndEverything) + "\n");

        //bigger Better Adder
        int number1, number2, sum;
        System.out.print("what's your first Number: ");
        number1 = inputReader.nextInt();

        System.out.print("what's your second Number: ");
        number2 = inputReader.nextInt();

        sum = number1 + number2;

        System.out.println("\nthe sum is: " + sum + "\n");

        //Passing the turing test
        String name1, favColor, fruit;
        int favNumber;

        System.out.print("Hello there!\nWhat's your name?");
        name1 = inputReader.nextLine();

        System.out.print("\nHi, " + name1 + "!  What's your favorite color?");
        favColor = inputReader.nextLine();

        System.out.print("\nHuh, " + favColor + "? Mine's Electric Lime.\n\nI really like limes. They're my favorite fruit, too.\n"
                + "What's YOUR favorite fruit,");
        fruit = inputReader.nextLine();

        System.out.print("Really? " + fruit + "? That's wild!\n"
                + "Speaking of favorites, what's your favorite number?");
        favNumber = inputReader.nextInt();

        System.out.println(favNumber + " is a cool number. Mine's -7.\n"
                + "Did you know " + favNumber + "* -7 is "+ (favNumber*-7) + "? That's a cool number too!");
        
        System.out.println("Well, thanks for talking to me, " + name1 + "!");
        
        
        //all the trivia
        String answer1 = prompt("1,024 Gigabytes is equal to one what? ");
        String answer2 = prompt("In our solar system which is the only planet that rotates clockwise? ");
        String answer3 = prompt("The largest volcano ever discovered in our solar system is located on which planet? ");
        String answer4 = prompt("What is the most abundant element in the earth's atmosphere? ");

        display("Wow, 1,024 Gigabytes is a " + answer3 + "!\n"
                + "I didn't know that the largest ever volcano was discovered on " + answer1 + "!\n"
                + "That's amazing that " + answer2 + " is the most abundant element in the atmosphere...\n"
                + answer4 + " is the only planet that rotates clockwise, neat!");

        

        //do it better
        int howManyMiles = promptNumber("How many miles can you run? ");
        display("I can run " + (howManyMiles * 2 + 1));
        int howManyHotdogs = promptNumber("How many hotdogs can you eat? ");
        display("I can eat " + (howManyHotdogs * 2 + 1));
        int howManyLanguages = promptNumber("How many languages do you speak? ");
        display("I can speak " + (howManyLanguages * 2 + 1));

         
        
        //healthy hearts
        int age = promptNumber("What is your age? ");
        int maxHR = 220 - age;
        display("Your maximum heart rate should be "+ maxHR + " beats per minute"+
                "\nYour target HR Zone is " + (Math.round(maxHR * .5)) +
                " - " + (Math.round(maxHR *.85)) + " beats per minute");
         */

        //mini mad libs
        String noun1 = prompt("I need a noun: ");
        String adj1 = prompt("Now an adj: ");
        String noun2 = prompt("Another noun: ");
        int num = promptNumber("A number: ");
        String adj2 = prompt("Another adj: ");
        String pNoun1 = prompt("I need a plural noun: ");
        String pNoun2 = prompt("Another one: ");
        String pNoun3 = prompt("One more: ");
        String verb1 = prompt("I need a verb (present tense): ");
        String verb2= prompt("Same verb (past tense): ");

        System.out.println("*** NOW LETS GET MAD (libs) ***");
        display(noun1 +": the "+adj1+" frontier. These are the voyages of the starship " + noun2 
                + "\nIts "+num+"-year mission: to explore strange "+adj2+" "+ pNoun1+", to seek out " + adj2 + " "
                + pNoun2 +" and\n"+ adj2 + " " + pNoun3 + ", to boldly " + verb1 + " where no one has "+verb2+" before.");
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
