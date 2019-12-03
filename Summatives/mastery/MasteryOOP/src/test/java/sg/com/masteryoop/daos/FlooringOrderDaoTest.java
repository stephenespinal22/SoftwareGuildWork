/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.masteryoop.daos;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sg.com.masteryoop.dtos.Order;

/**
 *
 * @author stephenespinal
 */
public class FlooringOrderDaoTest {

    private FlooringOrderDao daoProductionInstance;

    public FlooringOrderDaoTest() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        daoProductionInstance = ctx.getBean("productionDaoTestFile", FlooringOrderDaoProdImpl.class);
    }

    /**
     * Test of createOrder method, of class FlooringOrderDao.
     */
    @Test
    public void testCreateOrderReturnsOrder() throws FlooringPersistanceException {

        //arrange
        String date = "10/22/2019";
        int orderIdCounter = 1;
        Order order = new Order(orderIdCounter);

        //act
        Order orderToCompare = daoProductionInstance.createOrder(date, order, orderIdCounter);

        //assert
        assertEquals(orderToCompare, order);
    }

    /**
     * Test of createOrder method, of class FlooringOrderDao.
     */
    @Test
    public void testCreateOrderDateMapPopulates() throws FlooringPersistanceException {

        //arrange
        String date = "10/22/2019";
        int orderIdCounter = 1;
        Order order = new Order(orderIdCounter);

        //act
        daoProductionInstance.createOrder(date, order, orderIdCounter);

        //assert
        assertFalse(daoProductionInstance.getDateMap().isEmpty());
    }

    /**
     * Test of createOrder method, of class FlooringOrderDao.
     */
    @Test
    public void testCreateOrderReadsFromFile() throws FlooringPersistanceException {

        //arrange
        String date = "01/01/9999";
        int orderIdCounter = 0;
        Order order = new Order(orderIdCounter);

        //act
        daoProductionInstance.createOrder(date, order, orderIdCounter);

        //assert
        assertEquals(daoProductionInstance.getDateMap().get(date).values().size(), 2);
    }

    /**
     * Test of getAllOrdersForDate method, of class FlooringOrderDao.
     */
    @Test
    public void testGetAllOrdersForDate() throws Exception {
        //arrange
        String date = "01/01/9999";

        //act
        List<Order> orderList = daoProductionInstance.getAllOrdersForDate(date);

        //assert
        assertEquals(orderList.size(), 1);
    }

    /**
     * Test of getAllOrdersForDate method, of class FlooringOrderDao.
     */
    @Test
    public void testGetAllOrdersForDateBadPath() throws Exception {
        //arrange
        String date = "01/01/1000";

        //act assert
        try {
            daoProductionInstance.getAllOrdersForDate(date);

            //if we get here, the exception wasn't thrown
            fail("Expected FlooringPersistanceException was not thrown.");
        } catch (FlooringPersistanceException ex) {
            return;
        }
    }

    /**
     * Test of getOrder method, of class FlooringOrderDao.
     */
    @Test
    public void testGetOrderWasNotFound() throws FlooringPersistanceException {
        //arrange
        String date = "01/01/1000";
        int orderId = 6;

        //act assert
        try {
            daoProductionInstance.getOrder(date, orderId);

            //if we get here, the exception wasn't thrown
            fail("Expected FlooringPersistanceException was not thrown.");
        } catch (FlooringPersistanceException ex) {
            return;
        }

    }

    /**
     * Test of getOrder method, of class FlooringOrderDao.
     */
    @Test
    public void testGetOrderWasFound() throws FlooringPersistanceException {
        //arrange
        String date = "01/01/9999";
        int orderId = 6;

        //act assert
        try {
            daoProductionInstance.getOrder(date, orderId);
            return;
        } catch (FlooringPersistanceException ex) {
            //if we get here, the exception was thrown
            fail("Expected FlooringPersistanceException was not thrown.");;
        }

    }

    /**
     * Test of editOrder method, of class FlooringOrderDao.
     */
    @Test
    public void testEditOrder() throws FlooringPersistanceException {
        //arrange
        String date = "01/01/9999";
        int orderId = 6;
        Order order = new Order(6);

        //act
        Order orderToCompare = daoProductionInstance.editOrder(date, orderId, order);

        //assert
        assertEquals(orderToCompare, order);
    }

    /**
     * Test of removeOrder method, of class FlooringOrderDao.
     */
    @Test
    public void testRemoveOrder() throws FlooringPersistanceException {
        //arrange
        String date = "01/01/9999";
        int orderId = 6;

        //act
        daoProductionInstance.removeOrder(date, orderId);

        //assert
        assertTrue(daoProductionInstance.getDateMap().get(date).isEmpty());
    }

    /**
     * Test of getOrderIdCounter method, of class FlooringOrderDao.
     */
    @Test
    public void testGetOrderIdCounter() throws FlooringPersistanceException {
        //arrange
        int orderIdCounter = 1;

        //act
        int orderIdCounterToCompare = daoProductionInstance.getOrderIdCounter();

        //assert
        assertEquals(orderIdCounter, orderIdCounterToCompare);
    }

    /**
     * Test of writeMapToFile method, of class FlooringOrderDao.
     */
    @Test
    public void testWriteMapToFile() throws FlooringPersistanceException {
        //arrange
        String date = "01/01/9999";
        int orderId = 6;
        Order order = new Order(6);
        order.setCustomerName("Test");
        order.setState("OH");
        order.setProductType("Wood");
        order.setArea(BigDecimal.ONE);
        order.setCostSqft(new BigDecimal("5.15"));
        order.setLaborCost(new BigDecimal("4.75"));
        order.setLaborCostSqft(new BigDecimal("4.75"));
        order.setMaterialCost(new BigDecimal("5.15"));
        order.setTax(new BigDecimal("0.62"));
        order.setTaxRate(new BigDecimal("6.25"));
        order.setTotal(new BigDecimal("10.52"));
        

        //act
        daoProductionInstance.editOrder(date, orderId, order);

        //assert
        daoProductionInstance.writeMapToFile();
    }

}
