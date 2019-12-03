/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingmachine.dtos;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;

/**
 *
 * @author stephenespinal
 */
public class Change {

    private BigDecimal amount;

    private BigDecimal quarters;
    private BigDecimal dimes;
    private BigDecimal nickels;
    private BigDecimal pennies;

    public Change() {
        this.amount = new BigDecimal("0",new MathContext(2,RoundingMode.HALF_DOWN));
        calculateChange();
    }

    public BigDecimal getAmount() {
        calculateChange();
        return amount;
    }

    public BigDecimal getQuarters() {
        calculateChange();
        return quarters;
    }

    public BigDecimal getDimes() {
        calculateChange();
        return dimes;
    }

    public BigDecimal getNickels() {
        calculateChange();
        return nickels;
    }

    public BigDecimal getPennies() {
        calculateChange();
        return pennies;
    }

    public void addToAmount(BigDecimal amountToAdd) {
        //adding amount to total
        this.amount = this.amount.add(amountToAdd).setScale(2, RoundingMode.HALF_DOWN);
        calculateChange();
    }

    @Override
    public String toString() {
        calculateChange();
        return "quarters: " + quarters + ", dimes: " + dimes + ", nickels: " + nickels + ", pennies: " + pennies;
    }

    public void removeFromAmount(BigDecimal amountToSubtract) {
        //subtracting amount from total
        this.amount = this.amount.subtract(amountToSubtract).setScale(2, RoundingMode.HALF_DOWN);
        calculateChange();
    }

    private void calculateChange() {

        BigDecimal ManipulateTempAmount = this.amount;
        BigDecimal[] changeArray;

        //get quarters
        changeArray = ManipulateTempAmount.divideAndRemainder(new BigDecimal(".25"));
        this.quarters = changeArray[0];

        //get dimes
        changeArray = changeArray[1].divideAndRemainder(new BigDecimal(".10"));
        this.dimes = changeArray[0];

        //get nickels
        changeArray = changeArray[1].divideAndRemainder(new BigDecimal(".05"));
        this.nickels = changeArray[0];

        //get pennies
        changeArray = changeArray[1].divideAndRemainder(new BigDecimal(".01"));
        this.pennies = changeArray[0];
    }
    
       @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.amount);
        hash = 31 * hash + Objects.hashCode(this.quarters);
        hash = 31 * hash + Objects.hashCode(this.dimes);
        hash = 31 * hash + Objects.hashCode(this.nickels);
        hash = 31 * hash + Objects.hashCode(this.pennies);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Change other = (Change) obj;
        if (!Objects.equals(this.amount, other.amount)) {
            return false;
        }
        if (!Objects.equals(this.quarters, other.quarters)) {
            return false;
        }
        if (!Objects.equals(this.dimes, other.dimes)) {
            return false;
        }
        if (!Objects.equals(this.nickels, other.nickels)) {
            return false;
        }
        if (!Objects.equals(this.pennies, other.pennies)) {
            return false;
        }
        return true;
    }

}
