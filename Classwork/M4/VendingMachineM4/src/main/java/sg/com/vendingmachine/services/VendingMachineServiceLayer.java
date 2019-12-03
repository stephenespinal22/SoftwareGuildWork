/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingmachine.services;

import java.math.BigDecimal;
import java.util.List;
import sg.com.vendingmachine.daos.VendingMachinePersistanceException;
import sg.com.vendingmachine.dtos.Change;
import sg.com.vendingmachine.dtos.Item;

/**
 *
 * @author stephenespinal
 */
public interface VendingMachineServiceLayer {

    /**
     *add money into machine
     * 
     * @param money
     */
    void addMoney(BigDecimal money);

    /**
     * accept a string and throw 2 custom exceptions if money was not entered and if the item was not found
     *
     * @param itemId
     * @return
     * @throws ItemNotFoundException
     * @throws VendingMachinePersistanceException
     * @throws EnterMoneyFirstException
     */
    Item selectItem(String itemId) throws ItemNotFoundException, VendingMachinePersistanceException, EnterMoneyFirstException;

    /**
     *remove the total amount of the money in the machine and return a change object that has that amount
     * 
     * @return Change
     */
    Change returnChange();

    /**
     * we check for two custom exceptions, if quantity is less than one
     * and if there is not enough money in the machine to buy the item
     * lastly we proceed to updating the quantity of the item then we pass the item to the dao for updating
     * 
     * @param itemId
     * @return Item
     * @throws ItemOutOfStockException
     * @throws InsufficientFundsException
     * @throws VendingMachinePersistanceException
     */
    Item buyItem(String itemId) throws ItemOutOfStockException, InsufficientFundsException, VendingMachinePersistanceException;

    /**
     *return a list of items in inventory for display
     * 
     * @return List<Item>
     * @throws VendingMachinePersistanceException
     */
    List<Item> viewItems() throws VendingMachinePersistanceException;

    /**
     * accessor method for controller to display money in machine
     *
     * @return Change
     */
    Change getMoneyInMachine();

}
