/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise8;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class Excercise8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /*
        //method to the madness
        eatMe();
        drinkMe();

        System.out.println("\n ― Lewis Carroll, Alice in Wonderland");

       
        
        //return to sender
        char aMystery = mystery();
        String totallyUnexpected = unexpected();
        double aSurprise = surprise();
        boolean itsClassified = classified();
        int aSecret = secret();

        System.out.println("The methods have returned! Their results...\n");
        System.out.println("Mysterious: " + aMystery);
        System.out.println("    Secret: " + aSecret);
        System.out.println("Surprising: " + aSurprise);
        System.out.println("Classified: " + itsClassified);
        System.out.println("Unexpected: " + totallyUnexpected);

       
        //match work
        System.out.println(" The word Cart should come before Horse alphabetically : " + comesBefore("Cart","Horse"));
        System.out.println(" Half of 42 = " + halfOf(42));
        System.out.println(" (short) Pi = " + pi());
        System.out.println(" The first letter of the word Llama is: " + firstLetter("llama"));
        System.out.println(" 1337 x 1337 = " + times1337(1337));

         */
        //barely controlled chaos
        String color = getRandomColor(); // call color method here 
        String animal = getRandomAnimal(); // call animal method again here 
        String colorAgain = getRandomColor(); // call color method again here 
        int weight = getRandomNumber(5, 200); // call number method, 
        // with a range between 5 - 200 
        int distance = getRandomNumber(10, 20); // call number method, 
        // with a range between 10 - 20 
        int number = getRandomNumber(10000, 20000); // call number method, 
        // with a range between 10000 - 20000 
        int time = getRandomNumber(2, 6); // call number method, 
        // with a range between 2 - 6            

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
                + weight + "lb " + " miniature " + animal
                + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
                + number + " " + colorAgain + " poppies for nearly "
                + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
                + "let me tell you!");

    }

    //barely controlled chaos
    static String getRandomColor() {
        int randomColor = getRandomNumber(0, 4);
        switch (randomColor) {
            case 0:
                return "red";
            case 1:
                return "blue";
            case 2:
                return "green";
            case 3:
                return "yellow";
            case 4:
                return "black";
        }
        return "blue";
    }

    static String getRandomAnimal() {
        int randomAnimal = getRandomNumber(0, 4);
        switch (randomAnimal) {
            case 0:
                return "bird";
            case 1:
                return "spider";
            case 2:
                return "cow";
            case 3:
                return "horse";
            case 4:
                return "rhino";
        }
        return "bird";
    }

    //method to the madness
    static void eatMe() {
        System.out.println(" 'But I don’t want to go among mad people,' Alice remarked.");
        System.out.println(" 'Oh, you can’t help that,' said the Cat.");
        System.out.print(" 'We’re all mad here. I’m mad. You’re mad.'");
    }

    static void drinkMe() {
        System.out.println(" 'How do you know I’m mad?' said Alice.");
        System.out.println(" 'You must be,' said the Cat, 'or you wouldn’t have come here.' ");

    }

    //return to sender
    public static int secret() {
        return 42;
    }

    public static double surprise() {
        return 3.14;
    }

    public static char mystery() {
        return 'X';
    }

    public static boolean classified() {
        return true;
    }

    public static String unexpected() {
        return "Spanish Inquisition";
    }

    //match work
    public static double pi() {
        return 3.14;
    }

    public static int times1337(int x) {
        return x * 1337;
    }

    public static double halfOf(double y) {
        return y / 2;
    }

    public static String firstLetter(String word) {
        return word.substring(0, 1);
    }

    public static boolean comesBefore(String a, String b) {
        return a.compareToIgnoreCase(b) < 0;
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

}
