/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise7;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class Excercise7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /*
        //for and twenty blackbirds
        int birdsInPie = 0;
        for (int i = 1; i < 25; i++) {
            System.out.println("Blackbird #" + i + " goes into the pie!");
            birdsInPie++;
        }

        System.out.println("There are " + birdsInPie + " birds in there!");
        System.out.println("Quite the pie full!");
        
        
        
        //spring foward, fall back
        //start range is 0 end is 9 -- 10 times
        //add one to start and end and will print same range as below
        System.out.println("It's Spring...!");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + ", ");
        }
        
        //start at 10 end at 1 -- 10 times
        System.out.println("\nOh no, it's fall...");
        for (int i = 10; i > 0; i--) {
            System.out.print(i + ", ");
        }

        
        
        //for times
        int whatTimesTable = promptNumber("Which times table shall I recite? ");
        
        for (int i = 1; i<= 15; i++)
        {
            System.out.println(i + " * " + whatTimesTable + " is: " + (i * whatTimesTable));
        }
        
         
        //for times for
        int whatTimesTable = promptNumber("Which times table shall I recite? ");
        double score = 0;
        int answer = 0;
        double upTo = 10;
        double grade;

        for (int i = 1; i <= upTo; i++) {

            answer = promptNumber(i + " * " + whatTimesTable + " is: ");
            if (answer == (i * whatTimesTable)) {
                score++;
                System.out.println("Correct! Score = " + score);
            } else {
                System.out.println("Sorry no, the answer is: " + (i * whatTimesTable));
            }
        }
        grade = score / upTo;
        if (grade > .8) {
            System.out.println("Your grade is: " + grade);
            System.out.println("You got " + score + " correct. Congratulations!!!");
        } else if (grade < .5) {
            System.out.println("Your grade is: " + grade);
            System.out.println("You need to study more. You got " + score + " correct.");
        } else {
            System.out.println("Your grade is: " + grade);
            System.out.println("You got " + score + " correct.");
        }

        //laugh like the count
        System.out.println("*** I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU! ***");
        int start = promptNumber("Start at: ");
        int stop = promptNumber("Stop at: ");
        int countBy = promptNumber("Count by: ");
        int doALaugh = 1;
        
        for(int i = start;i <= stop;i+= countBy)
        {
            System.out.print(i + " ");
            if (doALaugh % 3 == 0)
            {
                System.out.print(" - Ah Ah Ah!\n");
            }
            doALaugh++;
        }
        
        
        //two fors and ten years ago
        Scanner userInput = new Scanner(System.in);
        System.out.print("What year would you like to count back from? ");
        int year = userInput.nextInt();

        //start is 0 end is 10 -- 11 times
        //this one is clearer
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " years ago would be " + (year - i));
        }

        System.out.println("\nI can count backwards using a different way too...");
        
        //start is at the year entered the stop is that number -20 will happen 21 times
        for (int i = year; i >= year - 20; i--) {
            System.out.println( (year - i) + " years ago would be " + i);
        }
        
         
        //different kind of fish
        //change this into a for loop
//        int fish = 1;
//        while(fish < 10){
//            if(fish == 3){
//                System.out.println("RED fish!");
//            }else if(fish == 4){
//                System.out.println("BLUE fish!");
//            } else{
//                System.out.println(fish + " fish!");
//            }
//
//            fish++;
//        }
        //all that changed was the position of the 
        // start/ stop / incrementer
        for (int i = 1; i < 10; i++) {
            if (i == 3) {
                System.out.println("RED fish!");
            } else if (i == 4) {
                System.out.println("BLUE fish!");
            } else {
                System.out.println(i + " fish!");
            }

        }
        
        
        //for by for
        //loops inside loops
//        for (int i = 0; i < 3; i++) {
//            System.out.print("|");
//
//            for (int j = 0; j < 3; j++) {
//                for (int k = 0; k < 3; k++) {
//                    System.out.print("*");
//                }
//                System.out.print("|");
//            }
//            System.out.println("");
//        }
        //change to different design
        for (int i = 0; i < 3; i++) { //how many rows
            System.out.print("|");

            for (int j = 0; j < 3; j++) { //how many columns
                for (int k = 0; k < 3; k++) //how many chars inside
                {
                    //we use or || so it will happen on ethier or of these cases
                    if ( (j == 1 && i == 0) || (j == 1 && i == 2) ) //second column and row 1 and 3
                        System.out.print("$");
                    else if ( (j == 0 && i == 1) || (j == 2 && i == 1) ) //second row column 1 and 3
                        System.out.print("@");
                    else if ( (j == 1 && i == 1) ) //the middle
                        System.out.print("#");                    
                    else 
                        System.out.print("*");
                    

                }
                System.out.print("|");
            }
            System.out.println("");
        }
         */
        //traditional fizz buzz
        int end = promptNumber("How much units fizzing and buzzing do you need in your life? ");
        int count = 0;
        for (int i = 0; i < 100000; i++) {
            
            if( (i % 3 == 0) && (i % 5 ==0) && (i != 0))
            {
                System.out.println("fizz buzz");
                count++;
            }
            else if (i % 3 == 0 && (i != 0)) {
                System.out.println("fizz");
                count++;
            }
            else if (i % 5 ==0 && (i != 0))
            {
                System.out.println("buzz");
                count++;
            }
            else
                System.out.println(i);
            
            if(count >= end)
                break;
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

}
