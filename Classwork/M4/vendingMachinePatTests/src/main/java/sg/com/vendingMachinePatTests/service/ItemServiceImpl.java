/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingMachinePatTests.service;
import java.math.BigDecimal;
import java.util.List;
import sg.com.vendingMachinePatTests.dto.Change;
import sg.com.vendingMachinePatTests.dto.Item;
/**
 *
 * @author ptoner
 */
public class ItemServiceImpl implements ItemService {
    private BigDecimal balance = BigDecimal.ZERO;
    
    @Override
    public BigDecimal getBalance() {
        return balance;
    }
    @Override
    public void deposit(BigDecimal money) {
        balance = balance.add(money);
    }
    @Override
    public List<Item> getItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Change refund() {
        
        
        Change change = new Change();
        
        
        BigDecimal ManipulateTempAmount = balance;
        BigDecimal[] changeArray;
        
        
        //get quarters
        changeArray = ManipulateTempAmount.divideAndRemainder(new BigDecimal(".25"));
        change.setQuarters(changeArray[0].intValue());
        //get dimes
        changeArray = changeArray[1].divideAndRemainder(new BigDecimal(".10"));
        change.setDimes(changeArray[0].intValue());
        //get nickels
        changeArray = changeArray[1].divideAndRemainder(new BigDecimal(".05"));
        change.setNickels(changeArray[0].intValue());
        
        //get pennies
        changeArray = changeArray[1].divideAndRemainder(new BigDecimal(".01"));
        change.setPennies(changeArray[0].intValue());
        
        balance = BigDecimal.ZERO;
        
        
        return change;
    }

    @Override
    public void purchaseItem(Item item) throws InsufficentFundsException, NoInventoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




    
}