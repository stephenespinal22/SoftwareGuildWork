/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalculator;

import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class App {

    public static void main(String args[]) {
        int choice = 0;
        boolean exit = false;
        System.out.println("Welcome to the simple calculator!");
        while (!exit) {
            choice = promptNumber("What would you like to do: \n"
                    + "1 = addition | 2 = subtraction | 3 = multiplication | 4 = division "
                    + "| 5 = exit");

            if (choice == 5) {
                System.out.println("Thank you, goodbye.");
                exit = true;
                break;
            }

            double operand1 = promptOperand(1);
            double operand2 = promptOperand(2);

            switch (choice) {
                case 1:
                    System.out.println(SimpleCalculator.add(operand1, operand2));
                    break;
                case 2:
                    System.out.println(SimpleCalculator.subtract(operand1, operand2));
                    break;
                case 3:
                    System.out.println(SimpleCalculator.multiply(operand1, operand2));
                    break;
                case 4:
                    System.out.println(SimpleCalculator.divide(operand1, operand2));
                    break;
            }
        }

    }

    public static double promptOperand(int amount) {
        System.out.print("Enter operand " + amount + ": ");
        Scanner sc = new Scanner(System.in);
        return Double.parseDouble(sc.nextLine());
    }

    public static int promptNumber(String input) {
        System.out.println(input);
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
}
