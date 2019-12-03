/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.masteryoop.views;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
                    System.out.println("Invalid. Enter a number in the range.");
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
                    System.out.println("Invalid. Enter a number in the range.");
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
                    System.out.println("Invalid. Enter a number in the range.");
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
                    System.out.println("Invalid. Enter a number in the range.");
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
                    System.out.println("Invalid. Enter a value in the range.");
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

    @Override
    public String readStringDate(String prompt) {

        //this method for fun as parsing local date would be easier
        System.out.print(prompt);
        String date = scan.nextLine();

        try {

            //make sure date contains /
            if (!date.contains("/")) {
                System.out.println("Invalid Date. Please Enter Date as (MM/DD/YYYY)");
                //recursion here to try again
                date = readStringDate(prompt);
            }

            //check for each part of the date string
            String[] split = date.split("/");
            if (split.length != 3
                    || (Integer.parseInt(split[0]) < 1 || Integer.parseInt(split[0]) > 12)
                    || (Integer.parseInt(split[1]) < 1 || Integer.parseInt(split[1]) > 31)
                    || (split[2].length() != 4)) {
                System.out.println("Invalid Date. Please Enter Date as (MM/DD/YYYY)");
                //recursion here to try again
                date = readStringDate(prompt);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Date. Please Enter Date as (MM/DD/YYYY)");
            //recursion here to try again
            date = readStringDate(prompt);
        }
        return date;
    }

    @Override
    public String readState(String prompt) {
        System.out.print(prompt);
        String state = scan.nextLine();

        switch (state) {
            case "OH":
            case "PA":
            case "MI":
            case "IN":
                return state;
            default:
                System.out.println("Invalid Input.");
                state = readState(prompt);
        }
        return state;
    }

    @Override
    public String readProductType(String prompt) {
        System.out.print(prompt);
        String product = scan.nextLine();

        switch (product) {
            case "Carpet":
            case "Laminate":
            case "Tile":
            case "Wood":
                return product;
            default:
                System.out.println("Invalid Input.");
                product = readProductType(prompt);
        }
        return product;
    }

    @Override
    public BigDecimal readBigDecimalEdit(String prompt, BigDecimal min, BigDecimal max) {
        BigDecimal big;
        do {
            System.out.print(prompt);
            //make sure number inputted is not word
            try {
                String bigString = scan.nextLine();
                if (bigString.isEmpty()) {
                    return null;
                }
                big = new BigDecimal(bigString);
                if (big.compareTo(min) < 0 || big.compareTo(max) > 0) {
                    System.out.println("Invaild. Enter a value in the range.");
                }

            } catch (NumberFormatException e) {
                //recursion here to repeat process until correct
                System.out.println("Invalid Input. Try Again");
                big = readBigDecimalEdit(prompt, min, max);
                if (big == null) {
                    return null;
                }
            }

        } while (big.compareTo(min) < 0 || big.compareTo(max) > 0);
        return big;
    }

    @Override
    public String readStateEdit(String prompt) {
        System.out.print(prompt);
        String state = scan.nextLine();

        if (state.isEmpty()) {
            return null;
        }

        switch (state) {
            case "OH":
            case "PA":
            case "MI":
            case "IN":
                return state;
            default:
                System.out.println("Invalid Input.");
                state = readStateEdit(prompt);
                if (state == null) {
                    return null;
                }
        }
        return state;
    }

    @Override
    public String readProductTypeEdit(String prompt) {
        System.out.print(prompt);
        String product = scan.nextLine();

        if (product.isEmpty()) {
            return null;
        }

        switch (product) {
            case "Carpet":
            case "Laminate":
            case "Tile":
            case "Wood":
                return product;
            default:
                System.out.println("Invalid Input.");
                product = readProductTypeEdit(prompt);
                if (product == null) {
                    return null;
                }
        }
        return product;
    }

    @Override
    public String readName(String prompt) {
        System.out.print(prompt);
        String name = scan.nextLine();

        if (name.isEmpty()) {
            System.out.println("Invalid Name.");
            name = readName(prompt);
        }

        return name;
    }

    @Override
    public String validateStringAsDate(String prompt) {

        System.out.print(prompt);
        String dateString = scan.nextLine();

        DateTimeFormatter formatter;
        LocalDate dateNow = LocalDate.now();
        LocalDate date = LocalDate.now();
        String formatted = dateString;

        try {
            formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            date = LocalDate.parse(dateString, formatter);
            formatted = date.format(formatter);
        } catch (DateTimeParseException e) {

            System.out.println("Invalid Date. Please Enter Date as (MM/DD/YYYY)");
            //recursion here to try again
            formatted = validateStringAsDate(prompt);
        }

        if (date.isBefore(dateNow)) {
            System.out.println("Date is in the past. Please Enter Date as (MM/DD/YYYY)");
            formatted = validateStringAsDate(prompt);
        }
        return formatted;
    }

}
