/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package summativesums;

/**
 *
 * @author stephenespinal
 */
public class SummativeSums {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int [] array1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int [] array2 = { 999, -60, -77, 14, 160, 301 };
        int [] array3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
        140, 150, 160, 170, 180, 190, 200, -99 };
        
        System.out.println("#1 Array Sum: " + sumOfArray(array1));
        System.out.println("#2 Array Sum: " + sumOfArray(array2));
        System.out.println("#3 Array Sum: " + sumOfArray(array3));
        
    }
    
    //accepts an array of integers and returns the sum of all the values in the array
    public static int sumOfArray(int [] array)
    {
        //go through loop and add to the sum each time
        int sum = 0;
        for (int i : array)
            sum += i;
        return sum;
    }
    
}
