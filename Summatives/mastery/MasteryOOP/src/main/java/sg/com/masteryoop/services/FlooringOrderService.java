/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.masteryoop.services;

import java.util.List;
import sg.com.masteryoop.daos.FlooringPersistanceException;
import sg.com.masteryoop.dtos.Order;
import sg.com.masteryoop.dtos.OrderInfo;

/**
 *
 * @author stephenespinal
 */
public interface FlooringOrderService {
    
    Order createOrder(OrderInfo info) throws FlooringPersistanceException;
    
    List<Order> displayOrders(String date) throws OrderNotFoundException, FlooringPersistanceException ;
    
    Order getOrder(String date, int orderId) throws OrderNotFoundException, FlooringPersistanceException ;
    
    Order editOrder(String date, int orderId, OrderInfo info) throws OrderNotFoundException,FlooringPersistanceException;
    
    void removeOrder(String date, int orderId) throws OrderNotFoundException, FlooringPersistanceException ;
    
    String saveWork()throws FlooringPersistanceException;
    
    int getOrderIdCounter();

    
}
