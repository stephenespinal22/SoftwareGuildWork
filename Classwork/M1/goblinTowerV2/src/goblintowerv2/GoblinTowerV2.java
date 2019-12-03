/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goblintowerv2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class GoblinTowerV2 {

    //TODO: Every 5th+ allow the player to buy a potion for 2.5
    //TODO: For every goblin encountered add 1 gold to the player's gold
    //TODO: Every 2 levels increase the chance of encounter to 10, max of 60
    //TODO: Add summary after the game has ended, lvl achieved, gold obtained
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Comment, the IDE will ignore this when compiling 
        int[] potions = {5, 5, 5, 5, 5};
//        int[] potions = new int[5];
        boolean isAlive = true;
        double gold = 10.5;
        int hp = 10;
        int maxHp = 10;
        int encounterRate = 10;
        int level = 0;
        Random r = new Random();

        //replacing the heroName value with user's input
        String heroName = prompt("What is your hero's name");
        int heroAge = Integer.parseInt(prompt("What is your hero's age?"));
        isAlive = "y".equalsIgnoreCase(prompt("Is your hero alive? (y/n)"));

        // two lines below are the same
        gold *= heroAge;

        display("Your name is : " + heroName);
        display("You are " + heroAge + " years old.");
        display("Your hero is living: " + isAlive);

        // hero takes 1 step has a chance to encounter goblin
        while (isAlive == true) {
            for (int i = 0; i < 10; i++) {

                if (level % 2 == 0) {
                    if (encounterRate < 60) {
                        encounterRate += 10;
                    }

                }

                display(heroName + " takes a step");
                int encounter = r.nextInt(100);
                if (encounter < encounterRate) { //percent chance of encounter
                    display("\tYou have encountered a goblin, loss 1hp, earned 1 gold");
                    hp--;
                    gold++;
                    if (hp < 0) {
                        isAlive = false;
                        display("Game over! You Died\nLevel " + level + " Achieved.\nGold is: " + gold);
                        break;
                    }
                }
            }
            if (isAlive == true) {
                level++;
                hp += 1;
                display("\nLevel Complete!\nLevel " + level + " Achieved.\nHealth is: " + hp + "\nGold is: " + gold);

                if (level % 5 == 0) {
                    if ("y".equalsIgnoreCase(prompt("Would you like to buy a potion?")));
                    {
                        for (int i = 0; i < potions.length; i++) {
                            if (potions[i] == 0) {
                                potions[i] = 5;
                                display("added potion to inventory");
                                gold-=2.5;
                                break;
                            } else {
                                display("inventory full");
                            }
                        }
                    }
                }

                    if ("y".equalsIgnoreCase(prompt("Would you like to use a potion?"))) {
                        for (int i = 0; i < potions.length; i++) {
                            if (potions[i] > 0) {
                                if (hp + potions[i] > maxHp) {
                                    hp = maxHp;
                                } else {
                                    hp += potions[i];
                                }
                                potions[i] = 0;
                                display("You have regained 5pts of health");
                                prompt("Press Enter to Continue\n");
                                break;
                            }
                        }
                    }
                }
            }

            // if hero encounters a goblin, loses 1 point of health
            // hero takes up to 10 steps to complete a level
            // repeate until character is no longer alive
        
    }

    public static void display(String message) {
        System.out.println(message);
    }

    public static String prompt(String message) {
        Scanner sc = new Scanner(System.in);
        display(message);
        return sc.nextLine();
    }
}
