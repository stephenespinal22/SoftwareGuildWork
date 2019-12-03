/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise4;

import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class Excercise4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /*
        //llamas and dodos
        int llamas = 20;
        int whales = 15;
        int dodos = 0;

        if (dodos > 0) {
            System.out.println("Egads, I thought dodos were extinct!");
        }

        if (dodos < 0) {
            System.out.println("Hold on, how can we have NEGATIVE dodos??!");
        }

        if (llamas > whales) {
            System.out.println("Whales may be bigger, but llamas are better, ha!");
        }

        if (llamas <= whales) {
            System.out.println("Aw man, brawn over brains I guess. Whales beat llamas.");
        }

        System.out.println("There's been a huge increase in the dodo population via cloning!");
        dodos += 100;

        if ((whales + llamas) < dodos) {
            System.out.println("I never thought I'd see the day when dodos ruled the earth.");
        }

        if (llamas > whales && llamas > dodos) {
            System.out.println("I don't know how, but the llamas have come out ahead! Sneaky!");
        }

        //guessing game
        Scanner sc = new Scanner(System.in);
        int guess = 0;
        System.out.println("I've chosen a number. Betcha can't guess it!");

        System.out.print("Guess: ");

        guess = sc.nextInt();

        if (guess < 11) {
            System.out.println("Too low. I chose 11\n");
        } else if (guess > 11) {
            System.out.println("Too high. I chose 11\n");
        } else {
            System.out.println("You got it!\n");
        }

        //you are old
        String name = prompt("Hey, let's play a game! What's your name?");

        int yearBorn = Integer.parseInt(prompt("Ok," + name + ", when were you born?"));

        if (yearBorn < 2005) {
            display("Did you know that Pixar's 'Up' came out half a decade ago?");
        }
        if (yearBorn < 1995) {
            display("And that the first Harry Potter came out over 15 years ago!");
        }
        if (yearBorn < 1985) {
            display("Also, Space Jam came out not last decade, but the one before THAT.");
        }
        if (yearBorn < 1975) {
            display("The original Jurassic Park release is closer to the "
                    + "date of the first lunar landing than it is to today.");
        }
        if (yearBorn < 1965) {
            display("The MASH TV series has been around for almost half a century!");
        }

        //cows and spaceships
        int spaceships = 10;
        int aliens = 25;
        int cows = 100;

        if (aliens > spaceships) {
            System.out.println("Vrroom, vroom! Let's get going!");
        } else {
            System.out.println("There aren't enough green guys to drive these ships!");
        }

        if (cows == spaceships) { //if this results to true... do the following code
            System.out.println("Wow, way to plan ahead! JUST enough room for all these walking hamburgers!");
        } // if we remove the else from this statement it will check
        //for this condition regardless of the above condition
        else if (cows > spaceships) {
            System.out.println("Dangit! I don't how we're going to fit all these cows in here!");
        } else {
            System.out.println("Too many ships! Not enough cows.");
        }

        if (aliens > cows) {
            System.out.println("Hurrah, we've got the grub! Hamburger party on Alpha Centauri!");
        } else {
            System.out.println("Oh no! The herds got restless and took over! Looks like _we're_ hamburger now!!");
        }

        //birthstones
        int birthMonth = Integer.parseInt(prompt("What month's birthstone are you wanting to know?"));

        switch (birthMonth) {
            case 1:
                display("January's birth stone is Garnet");
                break;
            case 2:
                display("Feburary's birth stone is Amethyst");
                break;

            case 3:
                display("March's birth stone is Aqua Marine");
                break;

            case 4:
                display("April's birth stone is Diamond");
                break;

            case 5:
                display("May's birth stone is Emerald");
                break;

            case 6:
                display("June's birth stone is Pearl");
                break;

            case 7:
                display("July's birth stone is Ruby");
                break;

            case 8:
                display("August's birth stone is Peridot");
                break;

            case 9:
                display("September's birth stone is Sapphire");
                break;

            case 10:
                display("October's birth stone is Opal");
                break;

            case 11:
                display("November's birth stone is Topaz");
                break;

            case 12:
                display("December's birth stone is Turquoise");
                break;

            default:
                display("I think you must be confused, " + birthMonth + " doesn't match a month.");
        }
         
        //trivia night
        int score = 0;
        display("It's TRIVIA NIGHT! Are you ready?!\n\n"
                + "FIRST QUESTION!\nWhat is the Lowest Level Programming Language?\n"
                + "1) Source Code		2) Assembly Language\n"
                + "3) C#				4) Machine Code\n");

        if (4 == Integer.parseInt(prompt("Your Answer: "))) {
            score++;
        }

        display("\nSECOND QUESTION!\n"
                + "Website Security CAPTCHA Forms Are Descended From the Work of?\n"
                + "1) Grace Hopper		2) Alan Turing\n"
                + "3) Charles Babbage		4) Larry Page\n");

        if (2 == Integer.parseInt(prompt("Your Answer: "))) {
            score++;
        }

        display("\nLAST QUESTION!\n"
                + "Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?\n"
                + "1) Serenity			2) The Battlestar Galactica\n"
                + "3) The USS Enterprise	4) The Millennium Falcon\n");

        if (3 == Integer.parseInt(prompt("Your Answer: "))) {
            score++;
        }
        
        display("\nNice job - you got " + score + " correct!");
        
        
        
        //Knock Knock .equals for strings
        Scanner inputReader = new Scanner(System.in);

        System.out.print("Knock Knock! Guess who!! ");
        
        //we can use.ignoreCase to ignore the capitalization
        String nameGuess = inputReader.nextLine();
        
        //we use .equals to compare if the values are the same for
        //these objects if you change it to ==,
        //even if the values are the same, the conditon won't return true
        if(nameGuess.equals("Marty McFly")){
            System.out.println("Hey! That's right! I'm back!");
            System.out.println(".... from the Future."); // Sorry, had to!
        }else{
            System.out.println("Dude, do I -look- like " + nameGuess);
        }
        
        
        //Picky eater
        Scanner userInput = new Scanner(System.in);

        System.out.print("How many times has it been fried? (#) ");
        int timesFried = userInput.nextInt();

        System.out.print("Does it have any spinach in it? (y/n) ");
        String hasSpinach = userInput.next();

        System.out.print("Is it covered in cheese? (y/n) ");
        String cheeseCovered = userInput.next();

        System.out.print("How many pats of butter are on top? (#) ");
        int butterPats = userInput.nextInt();

        System.out.print("Is it covered in chocolate? (y/n) ");
        String chocolatedCovered = userInput.next();

        System.out.print("Does it have a funny name? (y/n) ");
        String funnyName = userInput.next();

        System.out.print("Is it broccoli? (y/n) ");
        String isBroccoli = userInput.next();

        // Conditionals should go here! Here's the first one for FREE!
        if (hasSpinach.equals("y") || funnyName.equals("y")) {
            System.out.println("There's no way that'll get eaten.");
        }
        if ((timesFried > 2 && timesFried < 4) && chocolatedCovered.equals("y")) {
            System.out.println("Oh, it's like a deep-fried Snickers. That'll be a hit!");
        }
        if (timesFried == 2 && cheeseCovered.equals("y"))
        {
            System.out.println("Mmm. Yeah, fried cheesy doodles will get et");
        }
        if ( isBroccoli.equals("y") && butterPats > 6 && cheeseCovered.equals("y"))
        {
            System.out.println("As long as the green is hidden by cheddar, it'll happen!");
        }
        else if (isBroccoli.equals("y"))
        {
            System.out.println("Oh, green stuff like that might as well go in the bin.");
        }
        
         
        //fieldDay
        String name = prompt("What's your last name? ").toLowerCase();
        System.out.println(name);
        String teamName = "";

        if (name.compareTo("baggins") < 0) {
            teamName = "Red Dragons";
        } else if (name.compareTo("dresden") < 0) {
            teamName = "Dark Wizards";
        } else if (name.compareTo("howl") < 0) {
            teamName = "Moving Castles";
        } else if (name.compareTo("potter") < 0) {
            teamName = "Golden Snitches";
        } else if (name.compareTo("vimes") < 0) {
            teamName = "Night Guards";
        } else if (name.compareTo("vimes") >= 0) {
            teamName = "Black Holes";
        }

        display("Aha! You’re on the team " + teamName + "!\n"
                + "Good luck in the games!");
         */
        
        //mini zork
        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, or open the mailbox? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) 
            {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                }
            }else if (action.equals("stick your hand in")) 
            {
                System.out.println("Something grabs your hand");
                System.out.println("You pull it out quick and you have some gold");
            }
        } else if (action.equals("go to the house")) {
            System.out.println("You find some food and eat it");
        }
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
