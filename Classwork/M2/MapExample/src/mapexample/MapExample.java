/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapexample;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author stephenespinal
 */
public class MapExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // create a map that maps a country to its population
        HashMap<String, Integer> populations = new HashMap<>();

        // add the first country
        populations.put("USA", 313);

        // add the next country
        populations.put("Canada", 340);

        // add another country
        populations.put("United Kingdom", 630);

        // add another country
        populations.put("Japan", 127);

        // ask the map for its size
        System.out.println("Map size is: " + populations.size());

        // replace the mapping for population of the USA - original
        // number was too low
        populations.put("USA", 313);

        // get the poplation of Japan and print it to the screen
        Integer japanPopulation = populations.get("Japan");
        System.out.println("The population of Japan is: "
                + japanPopulation);

        // get the Set of keys from the map
        Set<String> keys = populations.keySet();

        // print the keys to the screen - is the order they are printed
        // what you would expect?
        for (String k : keys) {
            System.out.println(k);
        }

        // print the keys and associated values to the screen
        for (String k : keys) {
            System.out.println("The population of " + k
                    + " is " + populations.get(k));
        }

        // get the Collection of values from the Map
        Collection<Integer> popValues = populations.values();

        // list all of the population values - how can we tell which 
        // population value goes with each country?
        for (Integer p : popValues) {
            System.out.println(p);
        }
    }

}
