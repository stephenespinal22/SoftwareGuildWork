/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interestcalcbigdecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author stephenespinal
 */
public class InterestCalcBigDecimal {

    /**
     * @param args the command line arguments
     */


//        - Get a user starting balance
//- get the current date
//- ask the user how many months they would like to invest thier money
//- calculate the invested money over the months they request
//- print out the montey to second scale round down
//- print out the Final date
//- Stretch:
//    -Print out out the balance at the end of each with the total interest earned 
//    - each month allow the user to DEPOSIT or WIDTHDRAW
//- use 1 file, Main method only
//    - BigDecimal
//    - LocalDate
//    - Scanner
//    - FlowControl (while, for)
//    - ENUM

        public static void main(String[] args) {
        // TODO code application logic here
        BigDecimal currentBalance = promptBigDecimal("What is the initial principal? ($): ");

        BigDecimal monthlyInterestRate = new BigDecimal(".01");


        LocalDate date = LocalDate.now();

        int numberOfMonths = promptNumber("How many months is the money to stay in the fund: ");

        for (int month = 0; month < numberOfMonths; month++) {

            System.out.println("--------------------------\nMonth " + date.plusMonths(month + 1));
            System.out.println("The Principal at the begining of the month is: $" + currentBalance);
            
            BigDecimal interest = currentBalance.multiply(monthlyInterestRate).setScale(2,RoundingMode.DOWN);
            
            currentBalance = currentBalance.add(interest);
            System.out.println("The total amount of interest earned for the month is: $" + interest);
            System.out.println("The principal at the end of this year is: $" + currentBalance);

        }
        
        /*
        public static void main(String[] args) {

       Account account = promptnewAccount();
       int numMonths = promptInt("How many months do you want to invest?");

       for (int i = 0; i < numMonths; i++) {
           DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
           System.out.println(account.getStartDate().plusMonths(i).format(format));
           System.out.println("Starting Balance:" + account.getBalance());
           BigDecimal interest = account.getBalance().multiply(account.getAPY().divide(new BigDecimal("12"))).setScale(2, RoundingMode.HALF_DOWN);
           account.setBalance(account.getBalance().add(interest));
           account.setInterestGained(account.getInterestGained().add(interest));
           System.out.println("Interest Earned: $" + interest);
           System.out.println("Total Interest Earned:" + NumberFormat.getCurrencyInstance().format(account.getInterestGained()));
           System.out.println("Ending Balance:" + NumberFormat.getCurrencyInstance().format(account.getBalance()));

       }

   }

   private static LocalDate promptDate(String message) {

       return LocalDate.parse(prompt(message), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
   }

   private static BigDecimal promptBigDecimal(String message) {

       return new BigDecimal(prompt(message), new MathContext(2, RoundingMode.HALF_DOWN));
   }

   private static String prompt(String message) {
       Scanner sc = new Scanner(System.in);
       System.out.println(message);
       return sc.nextLine();
   }

   private static int promptInt(String message) {
       return Integer.parseInt(prompt(message));
   }

   private static Account promptnewAccount() {
       Account account = new Account();
       LocalDate startDate = promptDate("EnterDate");
       BigDecimal startingBalance = promptBigDecimal("Enter Starting Balance");
       BigDecimal APY = new BigDecimal(".12");
       BigDecimal interestGained = new BigDecimal("0.00", new MathContext(2, RoundingMode.HALF_DOWN));
       BigDecimal balance = new BigDecimal(startingBalance.toString(), new MathContext(2, RoundingMode.HALF_DOWN));

       account.setAPY(APY);
       account.setStartingBalance(startingBalance);
       account.setInterestGained(interestGained);
       account.setBalance(balance);
       account.setStartDate(startDate);
       return account;
   }
        */
        

    }

    public static void display(String message) {
        System.out.println(message);
    }

    public static String prompt(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }

    public static int promptNumber(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(sc.nextLine());
    }

    public static BigDecimal promptBigDecimal(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);

        return new BigDecimal(sc.nextLine());
    }

}
