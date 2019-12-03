/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 *
 * @author stephenespinal
 */
public class Exercise2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // You can declare all KINDS of variables.
        String walrus;
        double piesEaten;
        float weightOfTeacupPig;
        int grainsOfSand;

        // But declaring them just sets up the space for data
        // to use the variable, you have to put data IN it first!
        walrus = "Sir Leroy Jenkins III";
        piesEaten = 42.1;

        System.out.println("Meet my pet Walrus, " + walrus);
        System.out.print("He was a bit hungry today, and ate this many pies : ");
        System.out.println(piesEaten);

        // Declare ALL THE THINGS
        // (Usually it's a good idea to declare them at the beginning of the program)
        int butterflies, beetles, bugs;
        String color, size, shape, thing;
        double number;

        // Now give a couple of them some values
        butterflies = 2;
        beetles = 4;

        bugs = butterflies + beetles;
        System.out.println("There are only " + butterflies + " butterflies,");
        System.out.println("but " + bugs + " bugs total.\n");

        System.out.println("Uh oh, my dog ate one.");
        butterflies--;
        System.out.println("Now there are only " + butterflies + " butterflies left.");
        System.out.println("But still " + bugs + " bugs left, wait a minute!!!");
        System.out.println("Maybe I just counted wrong the first time...\n");

        int number1 = 1;
        int number2 = 2;
        int number3 = 3;

        System.out.println(number1 + "," + number2 + "," + number3);

        System.out.println(number1 + number2 + number3 + "\n");

        String name = "stephen";
        int numberOfPets = 4;
        boolean haveEatenGnocchi = true;
        int age = 6;

        System.out.println("I am " + name);
        System.out.println("I have " + numberOfPets + " pets.");
        System.out.println("It is " + haveEatenGnocchi + " that I have eanten gnocchi");;
        System.out.println("When I was " + age + ", I learned to whistle\n");

        String food1 = "Slice of Big Rico Pizza";
        String food2 = "Invisible Strawberry Pie";
        String food3 = "Denver Omelet";

        double price1 = 500.00;
        double price2 = 2.50;
        double price3 = 1.50;

        System.out.println(food1 + " $ " + price1);
        System.out.println(food2 + " $ " + price2);
        System.out.println(food3 + " $ " + price3);

    }

}
