/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingmachine.services;

import java.math.BigDecimal;
import java.util.List;
import sg.com.vendingmachine.daos.VendingMachineDao;
import sg.com.vendingmachine.daos.VendingMachinePersistanceException;
import sg.com.vendingmachine.dtos.Change;
import sg.com.vendingmachine.dtos.Item;

/**
 *
 * @author stephenespinal
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    //field for dao
    private VendingMachineDao dao;
    //class level field for keeping track of money in machine
    private Change amountInMachine;
    //Item to be dealt with for transactions
    private Item itemBeingBought;

    //constructor dependency injection
    public VendingMachineServiceLayerImpl(VendingMachineDao dao) {
        this.dao = dao;
        this.amountInMachine = new Change();
    }

    //add money into machine
    @Override
    public void addMoney(BigDecimal money) {
        amountInMachine.addToAmount(money);
    }
    
    //accessor method for controller to display money in machine
    @Override
    public Change getMoneyInMachine() {
        return amountInMachine;
    }

    //accept a string and throw 2 custom exceptions if money was not entered and if the item was not found
    @Override
    public Item selectItem(String itemId) throws ItemNotFoundException, VendingMachinePersistanceException, EnterMoneyFirstException {

        if (amountInMachine.getAmount().compareTo(BigDecimal.ZERO) == 0) {
            throw new EnterMoneyFirstException("Enter some money before you select.");
        }

        //check if item is null, if its not null then there is an item in the inventory we will return the id for the controller
        itemBeingBought = dao.getItem(itemId);
        if (itemBeingBought != null) {
            return itemBeingBought;  
        }

        throw new ItemNotFoundException("Item was not found. Try another selection.");
    }

    //here we remove the total amount of the money in the machine and return a change object that has that amount
    @Override
    public Change returnChange() {
        Change changeToReturn = new Change();
        changeToReturn.addToAmount(amountInMachine.getAmount());
        amountInMachine.removeFromAmount(amountInMachine.getAmount());
        return changeToReturn;
    }

    //we check for two custom exceptions, if quantity is less than one
    //and if there is not enough money in the machine to buy the item
    //lastly we procced to updating the quantity of the item then we pass the item to the dao for updating
    @Override
    public Item buyItem(String itemId) throws ItemOutOfStockException, InsufficientFundsException, VendingMachinePersistanceException {
        itemBeingBought = dao.getItem(itemId);

        if (itemBeingBought.getQuantity() < 1) {
            throw new ItemOutOfStockException("Item is out of stock. Try another selection.");
        }

        if (itemBeingBought.getPrice().compareTo(amountInMachine.getAmount()) > 0) {
            throw new InsufficientFundsException("Not enough funds. Try another selection.");
        }

        //if no exception has been thrown then proceed
        int quantity = itemBeingBought.getQuantity();
        quantity--;
        itemBeingBought.setQuantity(quantity);
        dao.editItem(itemBeingBought);
        amountInMachine.removeFromAmount(itemBeingBought.getPrice());

        return itemBeingBought;
    }

    //return a list of items in inventory for display
    @Override
    public List<Item> viewItems() throws VendingMachinePersistanceException {
        return dao.getAllItems();
    }

}
