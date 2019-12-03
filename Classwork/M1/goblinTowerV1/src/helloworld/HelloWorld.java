/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //comment, the IDE will ignore this line

        System.out.println("What's your hero's name?");

        String heroName = "Goku";
        int heroAge = 30;
        boolean isAlive = true;
        double gold = 10.5;
        Scanner sc = new Scanner(System.in);
        heroName = sc.nextLine();
        System.out.println("What's your hero's age?");
        heroAge = Integer.parseInt(sc.nextLine());

        System.out.println("Is your hero alive? (y/n)");
        isAlive = "y".equals(sc.nextLine());

        System.out.println("Your name is: " + heroName);
        System.out.println("You are " + heroAge + " years old.");
        System.out.println("Your hero is living: " + isAlive);

        //two lines below are the same
        gold *= heroAge;
        gold = gold * heroAge;
        //add, subtract, divide, multiply

        // % returns the remainder
        int divided = 3 / 2;
        int remainder = 3 % 2;

        System.out.println(divided);
        System.out.println(remainder);
        boolean isEven = 3 % 2 == 0;

        //control flow
        int hp = 10;
        int level = 0;
        Random r = new Random();

        while (isAlive == true) {
            //hero takes 1 step and has a chance to encounter a goblin
            for (int i = 0; i < 10; i++) {
                System.out.println(heroName + " takes a step");
                int encounter = r.nextInt(100);
                if (encounter < 50)//50% chance of encounter
                {
                    System.out.println("\tYou have encountered a goblin, loss 1 hp");
                    hp--;
                    if (hp < 0) {
                        isAlive = false;
                        System.out.println("Game over! You Died" + "\nLevel achieved: " + level );
                        break;
                    }
                }
            }
            if (isAlive == true) {
                level++;
                hp += 1;
            }

        }
        //if hero encounters a goblin, loses 1 point of health
        //hero takes up to 10 steps to complete a level
        //repeat until character is no longer alive

    }

    public static void display(String message){
        System.out.println(message);
    }
    
    public static String prompt(String message){
        Scanner sc = new Scanner(System.in);
        display(message);
        return sc.nextLine();
    }
}
