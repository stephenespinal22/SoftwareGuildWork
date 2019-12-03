/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.testing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author stephenespinal
 */
public class App {

    public static void main(String[] args) {
        String answer = "";
        ArrayList<Integer> intArray = new ArrayList<>();

        while (intArray.size() < 4) {
            int randomNum = 1;
            randomNum++;
            intArray.add(randomNum);
        }

        for (int i = 0; i < intArray.size(); i++) {
            answer = answer + intArray.get(i);
        }

        //  System.out.println(answer);
        String dateTimeNow = LocalDateTime.now().toString();

        String answer1 = "1234";
        String guess1 = "6742";
        
        int countExact = 0;
        int countNumInString = 0;

        //try converting to arrayList then checking if inside, how many inside, then checking if in right position?
        for (int i = 0; i < answer1.length(); i++) {
            if (answer1.charAt(i) == guess1.charAt(i)) {
                countExact++;
            }
        }

        //get partial
        for (int i = 0; i < guess1.length(); i++) {
            for (int j = 0; j < answer1.length(); j++) {
                if (guess1.charAt(i) == answer1.charAt(j)) {
                    countNumInString++;
                }
            }
        }

        System.out.println(countExact);
        System.out.println(countNumInString);
    }
}
