/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.masteryoop.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import sg.com.masteryoop.daos.FlooringOrderDao;
import sg.com.masteryoop.daos.FlooringPersistanceException;
import sg.com.masteryoop.daos.FlooringProductDao;
import sg.com.masteryoop.daos.FlooringTaxDao;
import sg.com.masteryoop.dtos.Order;
import sg.com.masteryoop.dtos.OrderInfo;

/**
 *
 * @author stephenespinal
 */
public class FlooringOrderServiceProdImpl implements FlooringOrderService {

    private FlooringOrderDao orderDao;
    private FlooringTaxDao taxDao;
    private FlooringProductDao productDao;
    private int orderIdCounter;

    public FlooringOrderServiceProdImpl(FlooringOrderDao orderDao,FlooringTaxDao taxDao, FlooringProductDao productDao) {
        this.orderDao = orderDao;
        this.taxDao = taxDao;
        this.productDao = productDao;
    }

    @Override
    public Order createOrder(OrderInfo info) throws FlooringPersistanceException {

        orderIdCounter = orderDao.getOrderIdCounter();

        //use the user info to enter data into object for creation
        Order order = new Order(orderIdCounter);
        order.setCustomerName(info.getName());
        order.setState(info.getState());
        order.setProductType(info.getProductType());
        order.setArea(info.getArea());

        order = createOrderMath(order);

        orderIdCounter++;

        return orderDao.createOrder(info.getDate(), order, orderIdCounter);
    }
    
    @Override
    public int getOrderIdCounter() {
        return orderIdCounter;
    }
    

    @Override
    public List<Order> displayOrders(String date) throws OrderNotFoundException, FlooringPersistanceException {

        if (orderDao.getAllOrdersForDate(date) == null) {
            throw new OrderNotFoundException("\nNo Orders Found For This Date: " + date);
        }

        return orderDao.getAllOrdersForDate(date);
    }

    @Override
    public Order getOrder(String date, int orderId) throws OrderNotFoundException, FlooringPersistanceException {
        if (orderDao.getOrder(date, orderId) == null) {
            throw new OrderNotFoundException("\nNo Order Found For Date: " + date + " and Order #" + orderId + ".");
        }

        return orderDao.getOrder(date, orderId);

    }

    @Override
    public Order editOrder(String date, int orderId, OrderInfo info) throws OrderNotFoundException, FlooringPersistanceException {

        if (orderDao.getOrder(date, orderId) == null) {
            throw new OrderNotFoundException("\nNo Order Found For Date: " + date + " and Order #" + orderId + ".");
        }

        Order orderToEdit = orderDao.getOrder(date, orderId);

        orderToEdit.setCustomerName(info.getName());
        orderToEdit.setState(info.getState());
        orderToEdit.setProductType(info.getProductType());
        orderToEdit.setArea(info.getArea());

        orderToEdit = createOrderMath(orderToEdit);

        return orderDao.editOrder(date, orderId, orderToEdit);
    }

    @Override
    public void removeOrder(String date, int orderId) throws OrderNotFoundException, FlooringPersistanceException {

        if (orderDao.getOrder(date, orderId) == null) {
            throw new OrderNotFoundException("\nNo Order Found For Date: " + date + " and Order #" + orderId + ".");
        }

        orderDao.removeOrder(date, orderId);
    }

    private Order createOrderMath(Order order) throws FlooringPersistanceException {
        //use the tax and product daos to fill out dependent fields
        order.setTaxRate(taxDao.getTaxRate(order.getState()));
        order.setCostSqft(productDao.getCostPerSquareFoot(order.getProductType()));
        order.setLaborCostSqft(productDao.getLaborCostPerSquareFoot(order.getProductType()));

        //calculations based on rest of info
        BigDecimal materialCost = (order.getArea().multiply(order.getCostSqft()).setScale(2, RoundingMode.HALF_UP));
        order.setMaterialCost(materialCost);

        BigDecimal laborCost = (order.getArea().multiply(order.getLaborCostSqft()).setScale(2, RoundingMode.HALF_UP));
        order.setLaborCost(laborCost);

        BigDecimal totalBeforeTax = materialCost.add(laborCost).setScale(2, RoundingMode.HALF_UP);
        BigDecimal taxRate = order.getTaxRate().divide(new BigDecimal("100").setScale(2, RoundingMode.HALF_UP));
        BigDecimal tax = taxRate.multiply(totalBeforeTax).setScale(2, RoundingMode.HALF_UP);
        BigDecimal total = tax.add(totalBeforeTax).setScale(2, RoundingMode.HALF_UP);
        order.setTax(tax);
        order.setTotal(total);

        return order;
    }

    @Override
    public String saveWork() throws FlooringPersistanceException{
        return orderDao.writeMapToFile();
    }
}
