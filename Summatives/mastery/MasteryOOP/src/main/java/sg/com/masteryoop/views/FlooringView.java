/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.masteryoop.views;

import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import sg.com.masteryoop.dtos.Order;
import sg.com.masteryoop.dtos.OrderInfo;

/**
 *
 * @author stephenespinal
 */
public class FlooringView {

    private UserIO io;

    public FlooringView(UserIO io) {
        this.io = io;
    }

    public void printBanner(String title) {
        io.printLine(StringUtils.center(title, 48, '='));
    }

    public void printEndBanner() {
        io.printLine("================================================");
    }

    public int getMainMenuChoice() {
        printBanner("Flooring Program");
        io.printLine("1) Display Orders");
        io.printLine("2) Add an Order");
        io.printLine("3) Edit an Order");
        io.printLine("4) Remove an Order");
        io.printLine("5) Save Current Work");
        io.printLine("6) Exit");
        printEndBanner();

        return io.readInt("Please enter a number to select a menu option: ", 1, 6);
    }

    public int getModeChoice() {
        printBanner("Flooring Program");
        io.printLine("1) Production Mode");
        io.printLine("2) Training Mode");
        printEndBanner();

        return io.readInt("Please enter a number to select a menu option: ", 1, 2);
    }

    public void displayUnknownCommand() {
        io.printLine("Unknown Command!!!");
    }

    public OrderInfo promptOrderCreation() {
        printBanner("Create an Order");
        io.printLine("\nPlease Fill All Fields.\n");

        String date = io.validateStringAsDate("Enter Date as (MM/DD/YYYY): ");
        io.printLine("Date entered as: " + date);
        String name = io.readName("Enter Customer Name: ");
        String state = io.readState("Enter one of the following States (OH) (PA) (MI) (IN): ");
        String productType = io.readProductType("Enter one of the following Product Types,\n(Carpet) (Laminate) (Tile) (Wood): ");
        BigDecimal area = io.readBigDecimal("Enter Area(sqft): ", BigDecimal.ONE, new BigDecimal("1000"));

        io.printLine("\n\tOrder Summary"
                + "\n--------------------------------" + "\n\tDate: " + date
                + "\n\tName: " + name
                + "\n\tState: " + state
                + "\n\tProduct Type: " + productType
                + "\n\tArea (sqft): " + area
                + "\n--------------------------------\n\n");

        String answer = "";

        while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
            answer = io.readString("Is this correct? (Yes/No): ");
        }

        if (answer.equalsIgnoreCase("yes")) {
            //order info object to pass to the service layer
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setDate(date);
            orderInfo.setName(name);
            orderInfo.setState(state);
            orderInfo.setProductType(productType);
            orderInfo.setArea(area);

            return orderInfo;

        } else {

            io.readString("\nOrder Was Not Created. Press Enter To Continue.");
            return null;
        }

    }

    public void displaySuccessfulOrderCreation(Order order) {
        io.readString("\nOrder Number #" + order.getOrderId() + " Has Been Successfully Created. Your total is: $" 
                + order.getTotal() + ". Press Enter To Continue.");
    }

    public void displayErrorMessage(String ex) {
        io.printLine(ex);
    }

    public String promptDate(String prompt) {
        return io.readStringDate(prompt);
    }

    public void displayOrders(List<Order> listOfOrders) {

        for (Order currentOrder : listOfOrders) {
            io.printLine("\n--------------------------------");
            io.printLine(currentOrder.toString());
            io.printLine("--------------------------------");
        }
        io.readString("\nPlease hit enter to continue.");
    }

    public int promptOrderId(String prompt) {
        return io.readInt(prompt);
    }

    public OrderInfo promptEditOrder(Order orderToEdit) {

        io.printLine("\nType to Edit, Press Enter to Leave Unchanged.\n");

        String name = io.readString("Enter Customer Name - Currently (" + orderToEdit.getCustomerName() + "): ");
        String state = io.readStateEdit("Enter one of the following States (OH) (PA) (MI) (IN) - Currently (" + orderToEdit.getState() + "): ");
        String productType = io.readProductTypeEdit("Enter one of the following Product Types,\n(Carpet) (Laminate) (Tile) (Wood) - Currently (" + orderToEdit.getProductType() + "): ");
        BigDecimal area = io.readBigDecimalEdit("Enter Area(sqft) - Currently (" + orderToEdit.getArea() + "): ", BigDecimal.ONE, new BigDecimal("1000"));

        //order info object to pass to the service layer
        OrderInfo orderInfo = new OrderInfo();

        //series of checks to see if any changes were made
        //if changes are made then fill the OrderInfo object
        if (!name.equals("")) {
            orderInfo.setName(name);
        } else {
            orderInfo.setName(orderToEdit.getCustomerName());
        }
        if (state != null) {
            orderInfo.setState(state);
        } else {
            orderInfo.setState(orderToEdit.getState());
        }
        if (productType != null) {
            orderInfo.setProductType(productType);
        } else {
            orderInfo.setProductType(orderToEdit.getProductType());
        }
        if (area != null) {
            orderInfo.setArea(area);
        } else {
            orderInfo.setArea(orderToEdit.getArea());
        }

        //series of checks to see if any changes were made
        if ((name.equals("") || name.equals(orderToEdit.getCustomerName()))
                && (state == null || state.equals(orderToEdit.getState()))
                && (productType == null || productType.equals(orderToEdit.getProductType()))
                && (area == null || area.equals(orderToEdit.getArea()))) {
            return null;
        } else {
            return orderInfo;
        }
    }

    public void displaySuccessfulOrderEdit(Order editedOrder) {
        io.readString("\nOrder Number #" + editedOrder.getOrderId()
                + " Was Successfully Edited.\n--------------------------------\n"
                + editedOrder.toString() + "\n--------------------------------\nPress Enter To Continue.");
    }

    public void displayUnsuccessfulOrderEdit() {
        io.readString("\nNo Changes Were Made. Press Enter To Continue.");
    }

    public boolean promptRemove(Order orderToRemove) {

        io.printLine("\n--------------------------------");
        io.printLine(orderToRemove.toString());
        io.printLine("--------------------------------\n\n");

        String answer = "";

        while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
            answer = io.readString("Are You Sure You Would Like To Remove Order# " + orderToRemove.getOrderId() + " (Yes/No): ");
        }

        if (answer.equalsIgnoreCase("yes")) {
            io.readString("\nOrder Was Removed. Press Enter To Continue.");
            return true;
        } else {
            io.readString("\nOrder Was Not Removed. Press Enter To Continue.");
            return false;
        }

    }

    public void displaySaved(String string) {
        io.printLine("\n" + string + "\n");
    }


}
