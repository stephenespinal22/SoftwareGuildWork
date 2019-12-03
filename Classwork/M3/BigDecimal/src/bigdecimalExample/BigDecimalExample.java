/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigdecimalExample;

import java.math.BigDecimal;
import java.math.RoundingMode;



/**
 *
 * @author stephenespinal
 */
public class BigDecimalExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        BigDecimal bd = new BigDecimal("10.49");
        
        BigDecimal a = bd.setScale(1,RoundingMode.HALF_UP);
        
        BigDecimal op1 = new BigDecimal("10");
        BigDecimal op2 = new BigDecimal("6");
        BigDecimal c = op1.divide(op2, RoundingMode.HALF_UP); //ERROR without RoundingMode
        c = op1.divide(op2,2, RoundingMode.HALF_UP); //ERROR
        c = op1.divide(op2,2, RoundingMode.HALF_DOWN); //ERROR
        
        
        
        System.out.println(bd);
        System.out.println(a);
        
    }
    
}
