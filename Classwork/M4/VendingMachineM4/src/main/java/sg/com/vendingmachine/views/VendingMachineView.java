/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingmachine.views;

import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import sg.com.vendingmachine.dtos.Change;
import sg.com.vendingmachine.dtos.Item;

/**
 *
 * @author stephenespinal
 */
public class VendingMachineView {

    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public void printBanner(String title) {
        io.printLine(StringUtils.center(title, 48, '='));
    }

    public void printEndBanner() {
        io.printLine("================================================");
    }

    public int getMainMenuChoice() {
        printBanner("Vending Machine Menu");
        io.printLine("1) Insert Money");
        io.printLine("2) View Items");
        io.printLine("3) Return Change");
        io.printLine("4) Exit");
        printEndBanner();

        return io.readInt("Please enter a number to select a menu option: ", 1, 4);
    }

    public int getItemMenuChoice() {
        io.printLine("1) Buy Item");
        io.printLine("2) Return to Main Menu");
        printEndBanner();

        return io.readInt("Please enter a number to select a menu option: ", 1, 2);
    }

    public BigDecimal displayAddMoney() {
        printBanner("Add Money");
        io.printLine("Enter your cash. (Max $5) ");
        BigDecimal big = io.readBigDecimal("Money To Insert: ", new BigDecimal("0"), new BigDecimal("5"));
        printEndBanner();

        return big;
    }

    public void displayItems(List<Item> itemList) {
        printBanner("Items");
        io.printLine("");
        io.printLine("Number    Item Name        Quantity  Price");
        for (Item currentItem : itemList) {

            if (currentItem.getQuantity() > 0) {
                io.print(StringUtils.rightPad("  " + currentItem.getItemId(), 10, " "));
                io.print(StringUtils.rightPad(currentItem.getItemName(), 20, " "));
                io.print(StringUtils.rightPad(currentItem.getQuantity() + "", 7, " "));
                io.print("$" + currentItem.getPrice().toString());
                io.printLine("");
            }
        }
    }

    public void displayMoneyInMachine(Change change) {
        io.printLine("");
        if (change.getAmount().compareTo(BigDecimal.ZERO) > 0) {
            io.printLine("Amount in Machine: $" + change.getAmount());
        } else {
            io.printLine("Amount in Machine: $0.00");
        }
        io.printLine("");
    }

    public void displayChange(Change change) {
        printBanner("Collect Change");
        if (change.getAmount().compareTo(BigDecimal.ZERO) > 0) {
            io.printLine("Your Change is: ($" + change.getAmount() + ") \n" + change.toString());
        } else {
            io.printLine("No change available.");
        }
        printEndBanner();
    }

    public String getItemId() {
        printBanner("Item Selection");
        String itemId = io.readString("Enter your selection (Item Number): ");
        printEndBanner();
        return itemId;
    }

    public void displayBuyResult(Item boughtItem) {
        io.printLine("Thud! " + boughtItem.getItemName() + " popped out!");
        io.printLine("Enjoy!");
        io.readString("Press Enter To Continue.");

    }

    public void displayUnknownCommand() {
        io.printLine("Unknown Command!!!");
    }

    public void displayExitMessage() {
        io.printLine("\nHope You Didn't Forget Your Change...\nThank You. Good Bye!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        if (errorMsg.equals("Enter some money before you select.")) {
            io.printLine(errorMsg);
            io.readString("Press Enter To Continue.");
        } else {
            io.printLine(errorMsg + " Try another selection.");
            io.readString("Press Enter To Continue.");
        }
    }

}
