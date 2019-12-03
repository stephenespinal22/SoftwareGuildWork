/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingmachine.views;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class UserIOConsoleImpl implements UserIO {

    private Scanner scan = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void printLine(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) throws NumberFormatException {
        double d;
        System.out.print(prompt);
        //make sure number inputted is not string
        try {

            d = Double.parseDouble(scan.nextLine());

        } catch (NumberFormatException e) {
            //recursion here to repeat process until correct
            System.out.println("Invalid Input. Try Again");
            d = readDouble(prompt);
        }
        return d;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        double d;
        do {
            System.out.print(prompt);
            try {

                d = Double.parseDouble(scan.nextLine());
                if (d < min || d > max) {
                    System.out.println("Invaild. Enter a number in the range.");
                }

            } catch (NumberFormatException e) {
                //recursion here to repeat process until correct
                System.out.println("Invalid Input. Try Again");
                d = readDouble(prompt, min, max);
            }
        } while (d < min || d > max);
        //we want to continue this if (condition == true)

        return d;
    }

    @Override
    public float readFloat(String prompt) throws NumberFormatException {
        float f;
        System.out.print(prompt);
        //make sure number inputted is not string
        try {

            f = Float.parseFloat(scan.nextLine());

        } catch (NumberFormatException e) {
            //recursion here to repeat process until correct
            System.out.println("Invalid Input. Try Again");
            f = readFloat(prompt);
        }
        return f;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        float f;
        do {
            System.out.print(prompt);
            try {

                f = Float.parseFloat(scan.nextLine());
                if (f < min || f > max) {
                    System.out.println("Invaild. Enter a number in the range.");
                }

            } catch (NumberFormatException e) {
                //recursion here to repeat process until correct
                System.out.println("Invalid Input. Try Again");
                f = readFloat(prompt, min, max);
            }
        } while (f < min || f > max);
        //we want to continue this if (condition == true)

        return f;
    }

    @Override
    public int readInt(String prompt) throws NumberFormatException {
        int i;
        System.out.print(prompt);
        //make sure number inputted is not string
        try {

            i = Integer.parseInt(scan.nextLine());

        } catch (NumberFormatException e) {
            //recursion here to repeat process until correct
            System.out.println("Invalid Input. Try Again");
            i = readInt(prompt);
        }
        return i;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        int i;
        do {
            System.out.print(prompt);
            try {

                i = Integer.parseInt(scan.nextLine());
                if (i < min || i > max) {
                    System.out.println("Invaild. Enter a number in the range.");
                }

            } catch (NumberFormatException e) {
                //recursion here to repeat process until correct
                System.out.println("Invalid Input. Try Again");
                i = readInt(prompt, min, max);
            }
        } while (i < min || i > max);
        //we want to continue this if (condition == true)

        return i;
    }

    @Override
    public long readLong(String prompt) throws NumberFormatException {
        long l;
        System.out.print(prompt);
        //make sure number inputted is not string
        try {

            l = Long.parseLong(scan.nextLine());

        } catch (NumberFormatException e) {
            //recursion here to repeat process until correct
            System.out.println("Invalid Input. Try Again");
            l = readLong(prompt);
        }
        return l;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        long l;
        do {
            System.out.print(prompt);
            try {

                l = Long.parseLong(scan.nextLine());
                if (l < min || l > max) {
                    System.out.println("Invaild. Enter a number in the range.");
                }

            } catch (NumberFormatException e) {
                //recursion here to repeat process until correct
                System.out.println("Invalid Input. Try Again");
                l = readLong(prompt, min, max);
            }
        } while (l < min || l > max);
        //we want to continue this if (condition == true)

        return l;
    }

    @Override
    public String readString(String prompt) {
        System.out.print(prompt);
        return scan.nextLine();
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) throws NumberFormatException {
        BigDecimal big = null;
        System.out.print(prompt);
        //make sure number inputted is not string
        try {

            big = new BigDecimal(scan.nextLine());

        } catch (NumberFormatException e) {
            //recursion here to repeat process until correct
            System.out.println("Invalid Input. Try Again");
            big = readBigDecimal(prompt);
        }
        return big;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt, BigDecimal min, BigDecimal max) {
        if (min.compareTo(max) >= 0) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        BigDecimal big;
        do {
            System.out.print(prompt);
            //make sure number inputted is a number not string
            try {

                big = new BigDecimal(scan.nextLine());
                if (big.compareTo(min) < 0 || big.compareTo(max) > 0) {
                    System.out.println("Invaild. Enter a value in the range.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid Input. Try Again");
                big = readBigDecimal(prompt, min, max);
            }
            //firstBigDecimal.compareTo(secondBigDecimal) < 0 // "<"
            //firstBigDecimal.compareTo(secondBigDecimal) > 0 // ">"    
            //firstBigDecimal.compareTo(secondBigDecimal) == 0 // "=="  
            //firstBigDecimal.compareTo(secondBigDecimal) >= 0 // ">="    
            //a.compareTo(b) returns a number greater than zero if a > b, 0 if a == b, and less than zero if a < b
        } while (big.compareTo(min) < 0 || big.compareTo(max) > 0);
        //we want to continue this if (condition == true)

        return big;
    }

}
