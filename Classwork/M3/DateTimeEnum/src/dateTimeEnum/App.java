/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dateTimeEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author stephenespinal
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        LocalDate now = LocalDate.now();
        LocalDate ld = LocalDate.parse("2019-05-31");
        LocalDate dtwFormat = LocalDate.parse("02/07/2010", DateTimeFormatter.ofPattern("MM/dd/yyyy"));  
        
        LocalDate past = now.minusDays(8);
        LocalDate future = now.plusDays(8);
        LocalDateTime dateTime = LocalDateTime.now();
        
        Period diff = now.until(past);
        
        //while (LocalDate.now().until(now).getDays() < 1) //loop will run for 1 day
        {
            
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate ld2 = LocalDate.parse("02/07/2010", formatter);
        String formatted = ld2.format(formatter);
        System.out.println(formatted);
        
    }

}
