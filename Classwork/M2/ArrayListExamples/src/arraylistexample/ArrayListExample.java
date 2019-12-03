/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylistexample;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author stephenespinal
 */
public class ArrayListExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // create an ArrayList of String objects
        ArrayList<String> stringList = new ArrayList<>();

        // ask the list how big it is
        System.out.println("List size before adding any Strings: "
                + stringList.size());

        // add a String object to our list
        stringList.add("My First String");

        // ask the list how big it is
        System.out.println("List size after adding one String: "
                + stringList.size());

        // add another String object to our list
        stringList.add("My Second String");

        // ask the list how big it is
        System.out.println("List size after adding two Strings: "
                + stringList.size());

        // remove the second String object from our list - remember that
        // our indexes start counting at 0 instead of 1
        stringList.remove(1);

        // ask the list how big it is
        System.out.println("List size after removing one String: "
                + stringList.size());

        // remove the remaining String object from our list - remember
        // that the list resizes automatically so if there is only one
        // element in a list it is always at index 0
        stringList.remove(0);

        // ask the list how big it is
        System.out.println("List size after removing last String: "
                + stringList.size());

        // what happens if you try to remove another element? Give it a
        // try...
        // visiting all elements
        // create an ArrayList of String objects
        ArrayList<String> stringList2 = new ArrayList<>();

        // add a String object to our list
        stringList2.add("My First String");

        // add another String object to our list
        stringList2.add("My Second String");

        // add another String object to our list
        stringList2.add("My Third String");

        // add another String object to our list
        stringList2.add("My Fourth String");

        // ask the list how big it is
        System.out.println("Second list size: " + stringList2.size());

        // print every String in our list with an enhanced for loop
        for (String s : stringList2) {
            System.out.println(s);
        }

        // print every String in our list with an iterator
        // ask for the iterator - we must ask for an iterator of Strings
        // What happens if we don't?
        Iterator<String> iter = stringList.iterator();

        // get String objects from the list while there are still Strings
        // remaining
        while (iter.hasNext()) {
            String current = iter.next();
            System.out.println(current);
        }
        
    }

}
