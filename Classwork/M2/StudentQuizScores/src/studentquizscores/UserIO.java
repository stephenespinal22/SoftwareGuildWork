/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentquizscores;

import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class UserIO {
       private Scanner scan = new Scanner(System.in);

    public void print(String message) {
        System.out.println(message);
    }

    public double readDouble(String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(scan.nextLine());
    }

    public double readDouble(String prompt, double min, double max) {
        double d;
        do {
            System.out.print(prompt);
            d = Double.parseDouble(scan.nextLine());
        } while (d < min || d > max);
        //we want to continue this if (condition == true)

        return d;
    }

    public float readFloat(String prompt) {
        System.out.print(prompt);
        return Float.parseFloat(scan.nextLine());
    }

    public float readFloat(String prompt, float min, float max) {
        float f;
        do {
            System.out.print(prompt);
            f = Float.parseFloat(scan.nextLine());
        } while (f < min || f > max);
        //we want to continue this if (condition == true)

        return f;
    }

    public int readInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scan.nextLine());
    }

    public int readInt(String prompt, int min, int max) {
        int i;
        do {
            System.out.print(prompt);
            i = Integer.parseInt(scan.nextLine());
        } while (i < min || i > max);
        //we want to continue this if (condition == true)

        return i;
    }

    public long readLong(String prompt) {
        System.out.print(prompt);
        return Long.parseLong(scan.nextLine());
    }

    public long readLong(String prompt, long min, long max) {
        long l;
        do {
            System.out.print(prompt);
            l = Integer.parseInt(scan.nextLine());
        } while (l < min || l > max);
        //we want to continue this if (condition == true)

        return l;
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return scan.nextLine();
    }
}
