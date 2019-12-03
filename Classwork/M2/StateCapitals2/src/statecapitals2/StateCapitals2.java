/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author stephenespinal
 */
public class StateCapitals2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Capital alabama = new Capital("Montgomery", 205000, 156);
        Capital alaska = new Capital("Juneau", 31000, 3255);
        Capital arizona = new Capital("Phoenix", 1445000, 517);
        Capital arkansas = new Capital("Little Rock", 193000, 116);
        
        HashMap<String, Capital> stateCapitals = new HashMap<>();

        stateCapitals.put("Alabama", alabama);
        stateCapitals.put("Alaska", alaska);
        stateCapitals.put("Arizona", arizona);
        stateCapitals.put("Arkansas", arkansas);
//        stateCapitals.put("California", "Sacramento");
//        stateCapitals.put("Colorado", "Denver");
//        stateCapitals.put("Connecticut", "Hartford");
//        stateCapitals.put("Delaware", "Dover");
//        stateCapitals.put("Florida", "Tallahassee");
//        stateCapitals.put("Georgia", "Atlanta");
//        stateCapitals.put("Hawaii", "Honolulu");
//        stateCapitals.put("Idaho", "Boise");
//        stateCapitals.put("Illinois", "Springfield");
//        stateCapitals.put("Indiana", "Indianapolis");
//        stateCapitals.put("Iowa", "Des Moines");
//        stateCapitals.put("Kansas", "Topeka");
//        stateCapitals.put("Kentucky", "Frankfort");
//        stateCapitals.put("Louisiana", "Baton Rouge");
//        stateCapitals.put("Maine", "Augusta");
//        stateCapitals.put("Maryland", "Annapolis");
//        stateCapitals.put("Massachussetts", "Boston");
//        stateCapitals.put("Michigan", "Lansing");
//        stateCapitals.put("Minnesota", "St.Paul");
//        stateCapitals.put("Mississippi", "Jackson");
//        stateCapitals.put("Missouri", "Jefferson City");
//        stateCapitals.put("Montana", "Helena");
//        stateCapitals.put("Nebraska", "Lincoln");
//        stateCapitals.put("Nevada", "Carson City");
//        stateCapitals.put("New Hampshire", "Concord");
//        stateCapitals.put("New Jersey", "Trenton");
//        stateCapitals.put("New Mexico", "Santa Fe");
//        stateCapitals.put("New York", "Albany");
//        stateCapitals.put("North Carolina", "Raleigh");
//        stateCapitals.put("North Dakota", "Bismarck");
//        stateCapitals.put("Ohio", "Colombus");
//        stateCapitals.put("Oklahoma", "Oklahoma City");
//        stateCapitals.put("Oregon", "Salem");
//        stateCapitals.put("Pennsylvania", "Harrisburg");
//        stateCapitals.put("Rhode Island", "Providence");
//        stateCapitals.put("South Carolina", "Columbia");
//        stateCapitals.put("South Dakota", "Pierre");
//        stateCapitals.put("Tennesse", "Nashville");
//        stateCapitals.put("Texas", "Austin");
//        stateCapitals.put("Utah", "Salt Lake City");
//        stateCapitals.put("Vermont", "Montpelier");
//        stateCapitals.put("Virgina", "Richmond");
//        stateCapitals.put("Washington", "Olympia");
//        stateCapitals.put("West Virgina", "Charleston");
//        stateCapitals.put("Wisconsin", "Madison");
//        stateCapitals.put("Wyoming", "Cheyenne");

        System.out.println("STATE/CAPITAL PAIRS:\n==========");

        Set<String> keys = stateCapitals.keySet();

        // print the keys and associated values to the screen
        for (String k : keys) {
            System.out.println(k + " - " + stateCapitals.get(k));
        }

        System.out.print("\nPlease enter the lower limit for capital city population: ");
        Scanner sc = new Scanner(System.in);
        int lowerLimitPop = Integer.parseInt(sc.nextLine());

        System.out.println("\nLISTING CAPITALS WITH POPULATIONS GREATER THAN 150000:");

        // print the keys and associated values to the screen
        for (String k : keys) {

            if (stateCapitals.get(k).getPopulation() > lowerLimitPop) {
                System.out.println(k + " - " + stateCapitals.get(k).toString());
            }

        }

    }

}
