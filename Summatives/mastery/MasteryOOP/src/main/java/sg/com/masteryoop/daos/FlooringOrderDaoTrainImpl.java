/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.masteryoop.daos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import sg.com.masteryoop.dtos.Order;

/**
 *
 * @author stephenespinal
 */
public class FlooringOrderDaoTrainImpl implements FlooringOrderDao {

    private Map<String, Map<Integer, Order>> dateMap = new HashMap<>();
    int orderIdCounter = 0;
    public String PATH;

    public String ORDERIDCOUNTER_FILE;
    public static final String DELIMITER = "::";

    public FlooringOrderDaoTrainImpl(String orderIdFile, String PATH) {
        this.ORDERIDCOUNTER_FILE = orderIdFile;
        this.PATH = PATH;
    }

    //for unit testing
    @Override
    public Map<String, Map<Integer, Order>> getDateMap() {
        return dateMap;
    }

    @Override
    public Order createOrder(String date, Order order, int updatedOrderIdCounter) throws FlooringPersistanceException {

        //temporary map of orders
        Map<Integer, Order> orderMap = new HashMap<>();

        //try to see if there is already a file for this date, if there is then load up the map
        //if not, the caught exception will add a new date key for the map
        try {
            //load orders of this date into our main map
            readOrdersFromFile(date);

            //get existing map
            orderMap = dateMap.get(date);

            orderMap.put(orderIdCounter, order);

            dateMap.put(date, orderMap);
        } catch (FlooringPersistanceException ex) {

            //add the order into the map with the idcounter as the key
            orderMap.put(orderIdCounter, order);

            //create a new date key
            dateMap.put(date, orderMap);
        }

        orderIdCounter = updatedOrderIdCounter;

        return order;
    }

    @Override
    public List<Order> getAllOrdersForDate(String date) throws FlooringPersistanceException {
        //load orders of this date into our main map
        readOrdersFromFile(date);

        //check to see if map contains anything or if it is even in the map
        if (dateMap.get(date) == null || dateMap.get(date).isEmpty()) {
            return null;
        } else {
            //if it is in the map the we return a list of values to display in the controller/view
            return new ArrayList<Order>(dateMap.get(date).values());
        }
    }

    @Override
    public Order getOrder(String date, int orderId) throws FlooringPersistanceException {
        //load orders of this date into our main map
        readOrdersFromFile(date);

        if (dateMap.get(date) == null) {
            return null;
        } else if (dateMap.get(date).get(orderId) == null) {
            return null;
        }

        return dateMap.get(date).get(orderId);
    }

    @Override
    public Order editOrder(String date, int orderId, Order order) throws FlooringPersistanceException {
        //load orders of this date into our main map
        readOrdersFromFile(date);

        if (dateMap.get(date) == null) {
            return null;
        } else if (dateMap.get(date).get(orderId) == null) {
            return null;
        } else {
            dateMap.get(date).replace(orderId, order);
        }

        return dateMap.get(date).get(orderId);
    }

    @Override
    public void removeOrder(String date, int orderId) throws FlooringPersistanceException {
        //load orders of this date into our main map
        readOrdersFromFile(date);
        dateMap.get(date).remove(orderId);
    }

    //id counter
    @Override
    public int getOrderIdCounter() throws FlooringPersistanceException {
        //if idCounter is 0 then program just opened and we want to read from file
        //we only want to read from the file if the program just opened 
        //if not then we want to update the id in this dao until it comes time to save
        if (orderIdCounter < 1) {
            readOrderIdCounterFromFile();
            return orderIdCounter;
        } else {
            return orderIdCounter;
        }
    }

    private void readOrderIdCounterFromFile() throws FlooringPersistanceException {
        Scanner scanner = null;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(new FileReader(ORDERIDCOUNTER_FILE)));

            while (scanner.hasNextLine()) {
                // get the next line in the file
                // currentLine holds the most recent line read from the file

                String numberOfOrders = scanner.nextLine();

                orderIdCounter = Integer.parseInt(numberOfOrders);
            }
            // close scanner
            scanner.close();
        } catch (FileNotFoundException | NumberFormatException ex) {
            throw new FlooringPersistanceException(
                    "Could not load OrderId.", ex);
        }

    }

    @Override
    public String writeMapToFile() throws FlooringPersistanceException {
        //do nothing
        return "Can't save in training mode.";
    }

    private void readOrdersFromFile(String date) throws FlooringPersistanceException {
        Scanner scanner = null;

        if (dateMap.get(date) != null) {
            return;
        }

        String fileToReadFrom = DateMapper.stringDateToFileString(date,PATH);

        //temporary map of orders
        Map<Integer, Order> orderMap = new HashMap<>();

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(fileToReadFrom)));

            while (scanner.hasNextLine()) {
                // get the next line in the file
                // currentLine holds the most recent line read from the file

                String row = scanner.nextLine();

                Order currentOrder = OrderMapper.parseOrder(row, DELIMITER);

                orderMap.put(currentOrder.getOrderId(), currentOrder);
                dateMap.put(date, orderMap);

            }
            // close scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new FlooringPersistanceException("\nNo Orders Found For This Date: " + date, e);
        }
    }

}
