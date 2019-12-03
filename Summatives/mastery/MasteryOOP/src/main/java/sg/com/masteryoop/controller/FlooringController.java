/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.masteryoop.controller;

import java.util.List;
import org.springframework.context.ApplicationContext;
import sg.com.masteryoop.daos.FlooringPersistanceException;
import sg.com.masteryoop.dtos.Order;
import sg.com.masteryoop.dtos.OrderInfo;
import sg.com.masteryoop.services.FlooringOrderService;
import sg.com.masteryoop.services.OrderNotFoundException;
import sg.com.masteryoop.views.FlooringView;

/**
 *
 * @author stephenespinal
 */
public class FlooringController {

    ApplicationContext ctx;
    private FlooringView view;
    private FlooringOrderService service;

    public FlooringController(FlooringView view) {
        //if you type new instantiate it is tightly coupled
        //when you do this.view the classes are dependency injection/loosely coupled with each other
        this.view = view;
    }

    public void setService(FlooringOrderService service) {
        this.service = service;
    }

    public void setCtx(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    public void run() {

        boolean keepGoing = true;

        int choiceOfMode = view.getModeChoice();
        switch (choiceOfMode) {

            case 1: // production mode
                setService(ctx.getBean("productionService", FlooringOrderService.class));
                break;
            case 2: // training
                setService(ctx.getBean("trainingService", FlooringOrderService.class));
                break;
            default:
                view.displayUnknownCommand();
        }

        while (keepGoing) {
            try {

                int choice = view.getMainMenuChoice();
                switch (choice) {

                    case 1: // display orders
                        displayOrders();
                        break;
                    case 2: // add an order
                        addOrder();
                        break;
                    case 3: // edit an order
                        editOrder();
                        break;
                    case 4: // remove an order
                        removeOrder();
                        break;
                    case 5: // save current work
                        saveWork();
                        break;
                    case 6: // exit 
                        keepGoing = false;
                        break;
                    default:
                        view.displayUnknownCommand();
                }//end switch
            } catch (FlooringPersistanceException ex) {
                view.displayErrorMessage(ex.getMessage());
            }//end of catch
        }//end of while
    }//end of run

    private void addOrder() throws FlooringPersistanceException {

        OrderInfo orderInfoToBeAdded = view.promptOrderCreation();

        if (orderInfoToBeAdded != null) {
            Order order = service.createOrder(orderInfoToBeAdded);
            view.displaySuccessfulOrderCreation(order);
        }
    }

    private void displayOrders() {
        try {

            view.printBanner("Display Orders");
            String dateToDisplay = view.promptDate("Enter Date as (MM/DD/YYYY): ");
            List<Order> listOfOrders = service.displayOrders(dateToDisplay);
            view.displayOrders(listOfOrders);

        } catch (OrderNotFoundException | FlooringPersistanceException ex) {
            view.displayErrorMessage(ex.getMessage());
        }
    }

    private void editOrder() {
        try {
            view.printBanner("Edit an Order");

            String dateToLookUp = view.promptDate("Enter Date as (MM/DD/YYYY): ");
            int orderIdToLookUp = view.promptOrderId("Enter Order #: ");
            Order orderToEdit = service.getOrder(dateToLookUp, orderIdToLookUp);

            OrderInfo orderInfoToBeEdited = view.promptEditOrder(orderToEdit);
            if (orderInfoToBeEdited != null) {
                Order editedOrder = service.editOrder(dateToLookUp, orderIdToLookUp, orderInfoToBeEdited);
                view.displaySuccessfulOrderEdit(editedOrder);
            } else {
                view.displayUnsuccessfulOrderEdit();
            }

        } catch (OrderNotFoundException | FlooringPersistanceException ex) {
            view.displayErrorMessage(ex.getMessage());
        }
    }

    private void removeOrder() {
        try {
            view.printBanner("Remove an Order");

            String dateToLookUp = view.promptDate("Enter Date as (MM/DD/YYYY): ");
            int orderIdToLookUp = view.promptOrderId("Enter Order #: ");
            Order orderToRemove = service.getOrder(dateToLookUp, orderIdToLookUp);

            boolean removeAnswer = view.promptRemove(orderToRemove);

            if (removeAnswer == true) {
                service.removeOrder(dateToLookUp, orderIdToLookUp);
            }
        } catch (OrderNotFoundException | FlooringPersistanceException ex) {
            view.displayErrorMessage(ex.getMessage());
        }
    }

    private void saveWork() {
        try {

            String response = service.saveWork();
            view.displaySaved(response);

        } catch (FlooringPersistanceException ex) {
            view.displayErrorMessage(ex.getMessage());

        }
    }
}
