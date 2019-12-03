/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingmachine.controller;

import java.math.BigDecimal;
import sg.com.vendingmachine.dtos.Change;
import sg.com.vendingmachine.daos.VendingMachinePersistanceException;
import sg.com.vendingmachine.dtos.Item;
import sg.com.vendingmachine.services.EnterMoneyFirstException;
import sg.com.vendingmachine.services.InsufficientFundsException;
import sg.com.vendingmachine.services.ItemNotFoundException;
import sg.com.vendingmachine.services.ItemOutOfStockException;
import sg.com.vendingmachine.services.VendingMachineServiceLayer;
import sg.com.vendingmachine.views.VendingMachineView;

/**
 *
 * @author stephenespinal
 */
public class VendingMachineController {

    private VendingMachineView view;
    private VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineView view, VendingMachineServiceLayer service) {

        //if you type new instantiate it is tightly coupled
        //when you do this.view the classes are dependency injection/loosely coupled with each other
        this.view = view;
        this.service = service;

    }

    public void run() {
        boolean keepGoing = true;

        while (keepGoing) {
            try {
                int choice = view.getMainMenuChoice();
                switch (choice) {

                    case 1: //insert money
                        addMoney();
                        break;
                    case 2: //view items
                        displayItems();
                        break;
                    case 3: //return change
                        returnChange();
                        break;
                    case 4: //exit
                        keepGoing = false;
                        break;
                    default:
                        view.displayUnknownCommand();

                }//end of switch
            } catch (VendingMachinePersistanceException e) {
                view.displayErrorMessage(e.getMessage());
            }//end of catch

        }//end of while

        view.displayExitMessage();

    }//end of run

    private void addMoney() {
        BigDecimal amountToAdd;
        amountToAdd = view.displayAddMoney();
        service.addMoney(amountToAdd);
    }
    
    private void displayItems() throws VendingMachinePersistanceException {

        //another menu here
        boolean keepGoing = true;

        while (keepGoing) {
            try {
                view.displayItems(service.viewItems());
                view.displayMoneyInMachine(service.getMoneyInMachine());
                int choice = view.getItemMenuChoice();
                switch (choice) {

                    case 1: //buy item
                        Item itemToBuy = service.selectItem(view.getItemId());
                        Item boughtItem = service.buyItem(itemToBuy.getItemId());
                        view.displayBuyResult(boughtItem);
                        break;
                    case 2: //return to menu
                        keepGoing = false;
                        break;
                    default:
                        view.displayUnknownCommand();
                        
                }//end of switch
            } catch (ItemNotFoundException
                    | EnterMoneyFirstException
                    | ItemOutOfStockException
                    | InsufficientFundsException e) {
                view.displayErrorMessage(e.getMessage());
            }//end of catch
        }//end of while
    }//end of method

    private void returnChange() {
        Change change = service.returnChange();
        view.displayChange(change);
    }

}
