/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.masteryoop.daos;

import java.math.BigDecimal;
import sg.com.masteryoop.dtos.Order;

/**
 *
 * @author stephenespinal
 */
public class OrderMapper {

    public static Order parseOrder(String row, String DELIMITER) {
        // break up the line into tokens
        String[] cols = row.split(DELIMITER);
        Order order = new Order(Integer.parseInt(cols[0]));
        order.setCustomerName(cols[1]);
        order.setState(cols[2]);
        order.setTaxRate(new BigDecimal(cols[3]));
        order.setProductType(cols[4]);
        order.setArea(new BigDecimal(cols[5]));
        order.setCostSqft(new BigDecimal(cols[6]));
        order.setLaborCostSqft(new BigDecimal(cols[7]));
        order.setMaterialCost(new BigDecimal(cols[8]));
        order.setLaborCost(new BigDecimal(cols[9]));
        order.setTax(new BigDecimal(cols[10]));
        order.setTotal(new BigDecimal(cols[11]));

        return order;
    }

    public static String toDelimitedString(Order currentOrder, String DELIMITER) {
        String row = currentOrder.getOrderId() + DELIMITER
                + currentOrder.getCustomerName() + DELIMITER
                + currentOrder.getState() + DELIMITER
                + currentOrder.getTaxRate() + DELIMITER
                + currentOrder.getProductType() + DELIMITER
                + currentOrder.getArea() + DELIMITER
                + currentOrder.getCostSqft() + DELIMITER
                + currentOrder.getLaborCostSqft() + DELIMITER
                + currentOrder.getMaterialCost() + DELIMITER
                + currentOrder.getLaborCost() + DELIMITER
                + currentOrder.getTax() + DELIMITER
                + currentOrder.getTotal();
        
        return row;
    }
}
