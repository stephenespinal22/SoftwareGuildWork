/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise9;

import java.util.Random;

/**
 *
 * @author stephenespinal
 */
public class Excercise9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /*
        //multidimensional arrays
        String[][] cityTeamNames = {
            {"Cleveland", "Browns", "Cavs", "Indians"},
            {"Columbus", "Bluejackets", "Buckeyes"},
            {"Pittsburgh", "Steelers", "Pirates", "Penguins"}
        };

        for (int i = 0; i < cityTeamNames.length; i++) {
            for (int j = 0; j < cityTeamNames[i].length; j++) {
                System.out.print(cityTeamNames[i][j] + " ");
            }
            System.out.println();
        }
        
        //a rainbow
        String[] colors = {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};

        System.out.println(colors[0]);
        System.out.println(colors[1]);
        System.out.println(colors[2]);
        System.out.println(colors[3]);
        System.out.println(colors[4]);
        System.out.println(colors[5]);
        System.out.println(colors[6]);
        
        //still positive
        int[] numbers = { 389, -447, 26, -485, 712, -884, 94, -64, 868, -776, 227, -744, 422, -109, 259, -500, 278, -219, 799, -311};
        for(int i: numbers)
        {
            if(i>0)
                System.out.print(i + " ");
        }

        
        //hidden Nuts
        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
        System.out.println("The nut has been hidden ...");
        
        //using enhanced for loop
        int count = 0;
        for(String i: hidingSpots)
        {
            if(i != null)
                System.out.println("Found it! It's in spot# " + count);
            count++;
        }

        //regular for loop
         for(int i = 0; i < hidingSpots.length; i++)
         {
              if(hidingSpots[i] != null)
                  System.out.println("Found it! It's in spot# " + i);
         }
         
         //

         
        //fruits basket
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple",
            "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple",
            "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple",
            "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange",
            "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange",
            "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple",
            "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};

        System.out.println("Total# of Fruit in Basket: " + fruit.length);

        int orangeCounter = 0;
        int appleCounter = 0;

        for (int i = 0; i < fruit.length; i++) {
            if (fruit[i].equals("Apple")) {
                appleCounter++;
            } else {
                orangeCounter++;
            }
        }

        String[] apples = new String[appleCounter];
        String[] oranges = new String[orangeCounter];

        for (int i = 0; i < apples.length; i++) {
            apples[i] = "Apple";
        }
        for (int i = 0; i < oranges.length; i++) {
            oranges[i] = "Oranges";
        }
        
        System.out.println("Number of Apples: " + apples.length);
        System.out.println("Number of Oranges: " + oranges.length);

        
        //Simple sort
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};

        int[] wholeNumbers = new int[24];

        int wNumi = 0;
        for (int i = 0; i < wholeNumbers.length / 2; i++)
        {
            
            if(firstHalf[i] > secondHalf[i])
            {
                wholeNumbers[wNumi] = secondHalf[i];
                wholeNumbers[wNumi+1] = firstHalf[i];
            }
            else if (firstHalf[i] < secondHalf[i])
            {
                wholeNumbers[wNumi] = firstHalf[i];
                wholeNumbers[wNumi+1] = secondHalf[i];
            }
            else
            {
                wholeNumbers[wNumi] = firstHalf[i];
                wholeNumbers[wNumi+1] = secondHalf[i];
            }
            wNumi += 2;
                
        }
        for(int i = 0; i < wholeNumbers.length; i ++)
        System.out.println(wholeNumbers[i]);

         */
        //fruit salad
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry",
            "Strawberry", "Navel Orange", "Pink Pearl Apple", "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple",
            "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};

        String[] fruitSalad = new String[12];
        int fruitAmt = 0;
        int appleAmt = 0;
        int orangeAmt = 0;

        for (int i = 0; i < fruit.length; i++) {
            if (fruitAmt > 11)//last position of the array
            {
                break;
            }
            if (fruit[i].contains("berry")) {
                fruitSalad[fruitAmt] = fruit[i];
                fruitAmt++;
            } else if (fruit[i].contains("Apple") && appleAmt < 3) {
                fruitSalad[fruitAmt] = fruit[i];
                fruitAmt++;
                appleAmt++;
            } else if (fruit[i].contains("Orange") && orangeAmt < 2) {
                fruitSalad[fruitAmt] = fruit[i];
                fruitAmt++;
                orangeAmt++;
            }

        }
        System.out.println("Our fruit Salad contains: ");
        for (String fruitSalad1 : fruitSalad) { //enhanced for loop
            if (fruitSalad1 != null) {
                System.out.println(fruitSalad1);
            }
        }
        System.out.println("That's " + fruitAmt + " fruits");
        // Code Recipe for fruit salad should go here!
    }

}
