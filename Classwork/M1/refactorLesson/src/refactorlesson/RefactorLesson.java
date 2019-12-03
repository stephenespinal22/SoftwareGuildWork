/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactorlesson;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class RefactorLesson {

    /**
     * @param args the command line arguments
     */
    //Every 5th+ allow the player to buy a potion for 2.5
    //Every 2 levels increase the chance of encounter to 10, max of 60
    //For every goblin encountered add 1 gold to the player's gold
    //Add summary after the game has ended, lvl achieved, gold obtained
    static String heroName;
    static Random r = new Random();
    static int[] potions = {5, 5, 5, 5, 5};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Comment, the IDE will ignore this when compiling 

//        int[] potions = new int[5];
        boolean isAlive = true;
        double gold = 10.5;
        int hp = 10;
        int maxHp = 10;
        int level = 0;
        int encounterChance = 10;

        //replacing the heroName value with user's input
        heroName = prompt("What is yoru hero's name");
        int heroAge = Integer.parseInt(prompt("What is your hero's age?"));
        isAlive = "y".equalsIgnoreCase(prompt("Is your hero alive? (y/n)"));

        // two lines below are the same
        gold *= heroAge;

        display("Your name is : " + heroName);
        display("You are " + heroAge + " years old.");
        display("Your hero is living: " + isAlive);
        do {
            level = 0;
            hp = 10;
            maxHp = 10;
            potions = new int[]{5, 5, 5, 5, 5};
            PlayGame(isAlive, encounterChance, hp, gold, level, potions, maxHp);
        } while (promptQuestion("Would you like to play again?") == true);

        // if hero encounters a goblin, loses 1 point of health
        // hero takes up to 10 steps to complete a level
        // repeate until character is no longer alive
    }

    //challenge 2 
    //fight or run
    //
    public static void PlayGame(boolean isAlive,
            int encounterChance, int hp, double gold, int level, int[] potions, int maxHp) {
        // hero takes 1 step has a chance to encounter goblin
        while (isAlive == true) {
            for (int i = 0; i < 10; i++) {
                display(heroName + " takes a step");
                int encounter = r.nextInt(100);
                if (encounter < encounterChance) {
                    if (promptQuestion("You have encountered a goblin. Will you fight? (y/n) ")) {
                        display("\tYou fight the goblin, loss 1hp");
                        hp--;
                        if (hp < 0) {
                            isAlive = false;
                            display("Game over! You Died");
                            break;
                        }
                        display("You've gained 1 gold");
                        gold++;
                    } else {
                        display("You chickened out, no gold attained");
                    }

                }
            }
            levelUp(isAlive, level, encounterChance, potions, maxHp, hp, gold);
            //method call here
        }
        display("Current Level: " + level);
        display("Current Gold: " + gold);
    }

    public static void display(String message) {
        System.out.println(message);
    }

    public static boolean promptQuestion(String question) {
        return "y".equalsIgnoreCase(prompt(question));
    }

    public static String prompt(String message) {
        Scanner sc = new Scanner(System.in);
        display(message);
        return sc.nextLine();
    }

    public static int RollDice(int numDice, int numSides) {
        int sum = numDice + numSides;
        return sum;
    }

    public static void levelUp(boolean isAlive, int level, int encounterChance, int[] potions, int maxHp, int hp, double gold) {

        if (isAlive == true) {
            level++;
            if (level % 2 == 0 && encounterChance < 60) {
                encounterChance += 10;
            }
            if (level % 5 == 0 && promptQuestion("Level Complete!\nWould you like to buy a potion") == true) {
                gold -= 2.5;
                for (int i = 0; i < potions.length; i++) {
                    if (potions[i] == 0) {
                        potions[i] = 5;
                        break;
                    }
                }
            }
            hp += 1;
            if (promptQuestion("Level Complete!\nWould you like to use a potion?")) {
                for (int i = 0; i < potions.length; i++) {
                    if (potions[i] > 0) {
                        if (hp + potions[i] > maxHp) {
                            hp = maxHp;
                        } else {
                            hp += potions[i];
                        }
                        potions[i] = 0;
                        display("You have regained 5pt of health");
                        prompt("Press Enter to Continue");
                        break;
                    }
                }
            }
        }
    }
}
