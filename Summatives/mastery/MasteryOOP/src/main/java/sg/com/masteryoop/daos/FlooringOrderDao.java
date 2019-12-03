/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.masteryoop.daos;

import java.util.List;
import java.util.Map;
import sg.com.masteryoop.dtos.Order;

/**
 *
 * @author stephenespinal
 */
public interface FlooringOrderDao {

    Order createOrder(String date, Order order, int updatedOrderIdCounter) throws FlooringPersistanceException;

    List<Order> getAllOrdersForDate(String date) throws FlooringPersistanceException;

    Order getOrder(String date, int orderId) throws FlooringPersistanceException;

    Order editOrder(String date, int orderId, Order order) throws FlooringPersistanceException;

    void removeOrder(String date, int orderId) throws FlooringPersistanceException;

    int getOrderIdCounter() throws FlooringPersistanceException;

    String writeMapToFile() throws FlooringPersistanceException;
    
    Map<String, Map<Integer, Order>> getDateMap();
}
