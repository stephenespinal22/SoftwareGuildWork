/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorsrefactor;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class RockPaperScissor {
    

    //we need these to keep track of the wins and ties
    static int playerWins = 0;
    static int computerWins = 0;
    static int ties = 0;

    
    public void run() {
        // TODO code application logic here

        //start of program set flag to true to begin
        //main while loop for program to continue
        while (true) {

            //variables needed initilize each time going through this loop
            int howManyRounds = 0;
            int roundsPlayed = 0;

            //these will be the choices for the game
            int computerChoice;
            int playerChoice;

            //we re-set these to 0 so for each time we play we start over
            playerWins = 0;
            computerWins = 0;
            ties = 0;

            //ask player how many rounds we are playing
            howManyRounds = promptNumber("How many rounds would you like to play? (1-10) ");

            //check for correct input of rounds 
            //need to check if input is between 1 and 10
            //<= 0 is 1 || > 10 is after 10
            if (howManyRounds <= 0 || howManyRounds > 10) {
                System.out.println("Error - wrong input");
                break; //end program
            }

            //now we start the game
            while (roundsPlayed < howManyRounds) {

                //computer chooses an option
                computerChoice = getRandomNumber(1, 3);

                //ask for player's choice
                //continue doing this while input is not between 1 and 3
                do {
                    //display round + 1 to avoid displaying round 0
                    playerChoice = promptNumber("Round " + (roundsPlayed + 1)
                            + "\n1 = Rock, 2 = Paper, 3 = Scissors\n"
                            + "Rock, Paper, or Scissors? ");
                } while (playerChoice <= 0 || playerChoice > 3);

                //play the round passing in the choices
                playRound(playerChoice, computerChoice);
                //update the rounds played
                roundsPlayed++;
            }//end of game

            //display final results
            endGameResults();

            //ask if user would like to play again
            if (!prompt("\nWould you like to play again? (y for yes/ anything else for no) ").equals("y")) {
                System.out.println("Thanks for playing! Goodbye.");
                break; //end program
            }

        }//end of program while loop
    }

    //methods used
    
    //display the final results and print out who won depending on those results
    public static void endGameResults() {
        System.out.println("\n----------------------------------------\nGame Over! Let's see the final results...\n"
                + "----------------------------------------\n");
        System.out.println("Player Wins: " + playerWins);
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("Ties: " + ties);
        if (playerWins > computerWins) {
            System.out.println("\nThe winner is ... YOU!");
        } else if (computerWins > playerWins) {
            System.out.println("\nSorry, The winner is ... Computer!");
        } else {
            System.out.println("\nIt's a tie!");
        }

    }

    //display the status after the computer and players make a choice
    //check who won the game
    //display who won the round and update those variables
    public static void playRound(int playerChoice, int computerChoice) {
        //print out status of round
        System.out.println("--------------------------------------\nYou chose "
                + translateChoice(playerChoice)
                + "\nComputer chose "
                + translateChoice(computerChoice) + "\n");
        //check who won is called
        String result = checkWhoWon(computerChoice, playerChoice);

        //display what beats what
        roundUpdate(result, computerChoice, playerChoice);

    }

    //check who won based of rock paper scissors game
    public static String checkWhoWon(int comChoice, int playChoice) {
        //if a tie
        if (comChoice == playChoice) {
            return "It's a Tie!";
        } //paper beats rock
        else if (comChoice == 2 && playChoice == 1) {
            return "Computer Wins";
        } //scissors beats paper
        else if (comChoice == 3 && playChoice == 2) {
            return "Computer Wins";
        } //rock beats scissors
        else if (comChoice == 1 && playChoice == 3) {
            return "Computer Wins";
        } //in any other case, the player wins
        else {
            return "Player Wins";
        }
    }
    
    //display round and update wins and update
    public static void roundUpdate(String result, int computerChoice, int playerChoice) {
        //display what beats what
        if (result.equals("Computer Wins")) {
            //call the translate method here
            System.out.println(translateChoice(computerChoice) + " beats " + translateChoice(playerChoice) + "\n");
            //update computer wins
            computerWins++;
        } else if (result.equals("Player Wins")) {
            //call the translate method here
            System.out.println(translateChoice(playerChoice) + " beats " + translateChoice(computerChoice) + "\n");
            //update player wins
            playerWins++;
        } else {
            ties++;
        }

        //display results
        System.out.println("Result: " + result);
        System.out.println("----------------------------------------");
    }

    //translate number into corresponding string for display purposes
    public static String translateChoice(int choice) {
        //translate the number into the corresponding string
        switch (choice) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
        }
        return "error";
    }
    
    //get a random number in the range passed by the arguments
    public static int getRandomNumber(int min, int max) {
        //error
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


