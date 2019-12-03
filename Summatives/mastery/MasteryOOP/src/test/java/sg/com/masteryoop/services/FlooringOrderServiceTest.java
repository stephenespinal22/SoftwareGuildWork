/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.masteryoop.services;

import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sg.com.masteryoop.daos.FlooringPersistanceException;
import sg.com.masteryoop.dtos.Order;
import sg.com.masteryoop.dtos.OrderInfo;

/**
 *
 * @author stephenespinal
 */
public class FlooringOrderServiceTest {

    private FlooringOrderService serviceInstance;

    public FlooringOrderServiceTest() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        serviceInstance = ctx.getBean("testService", FlooringOrderServiceProdImpl.class);
    }

    /**
     * Test of createOrder method, of class FlooringOrderService.
     */
    @Test
    public void testCreateOrder() throws Exception {
        //arrange
        OrderInfo info = new OrderInfo();
        info.setDate("01/01/1000");
        info.setName("Test");
        info.setState("OH");
        info.setProductType("Wood");
        info.setArea(BigDecimal.ONE);

        //act
        Order orderToCompare = serviceInstance.createOrder(info);

        //assert
        assertEquals(orderToCompare.getCustomerName(), "Test");
    }

    /**
     * Test of createOrder method, of class FlooringOrderService.
     */
    @Test
    public void testCreateOrderOrderIdCounter() throws Exception {
        //arrange
        OrderInfo info = new OrderInfo();
        info.setDate("01/01/1000");
        info.setName("Test");
        info.setState("OH");
        info.setProductType("Wood");
        info.setArea(BigDecimal.ONE);

        int orderIdBefore = serviceInstance.getOrderIdCounter();

        //act
        Order orderToCompare = serviceInstance.createOrder(info);

        //assert
        assertNotEquals(orderIdBefore, orderToCompare.getOrderId());
    }

    /**
     * Test of displayOrders method, of class FlooringOrderService.
     */
    @Test
    public void testDisplayOrders() throws Exception {
        //arrange
        String date = "01/01/9999";

        //act
        List<Order> orderList = serviceInstance.displayOrders(date);

        //assert
        assertEquals(orderList.size(), 1);
    }

    /**
     * Test of displayOrders method, of class FlooringOrderService.
     */
    @Test
    public void testDisplayOrdersBadPath() throws Exception {
        //arrange
        String date = "01/01/1000";

        //act assert
        try {
            serviceInstance.displayOrders(date);

            //if we get here, the exception wasn't thrown
            fail("Expected FlooringPersistanceException was not thrown.");
        } catch (FlooringPersistanceException ex) {
            return;
        }
    }

    /**
     * Test of getOrder method, of class FlooringOrderService.
     */
    @Test
    public void testGetOrder() throws Exception {
        //arrange
        String date = "01/01/1000";
        int orderId = 6;

        //act assert
        try {
            serviceInstance.displayOrders(date);

            //if we get here, the exception wasn't thrown
            fail("Expected FlooringPersistanceException was not thrown.");
        } catch (FlooringPersistanceException ex) {
            return;
        }
    }

    /**
     * Test of editOrder method, of class FlooringOrderService.
     */
    @Test
    public void testEditOrder() throws Exception {
        //arrange
        String date = "01/01/9999";
        int orderId = 6;

        OrderInfo info = new OrderInfo();
        info.setDate("01/01/9999");
        info.setName("Test");
        info.setState("OH");
        info.setProductType("Wood");
        info.setArea(BigDecimal.ONE);

        //act
        Order orderToCompare = serviceInstance.editOrder(date, orderId,info);

        //assert
        assertEquals(orderToCompare.getCustomerName(),info.getName());
    }

}
