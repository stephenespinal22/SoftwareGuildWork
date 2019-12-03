/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingmachine.services;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.com.vendingmachine.daos.VendingMachineDao;
import sg.com.vendingmachine.daos.VendingMachineDaoStubImpl;
import sg.com.vendingmachine.dtos.Change;
import sg.com.vendingmachine.dtos.Item;

/**
 *
 * @author stephenespinal
 */
public class VendingMachineServiceLayerTest {

    private VendingMachineServiceLayer service;

    public VendingMachineServiceLayerTest() {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();

        service = new VendingMachineServiceLayerImpl(dao);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addMoney method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testAddMoney() {

        //arrange
        BigDecimal two = new BigDecimal("2.00");

        //act
        service.addMoney(new BigDecimal("2.00"));

        //assert
        assertEquals(service.getMoneyInMachine().getAmount(), two);
    }

    /**
     * Test of selectItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testSelectItemGoodPath() throws Exception {
        //arrange
        String itemId = "nonEmptyItem";
        service.addMoney(BigDecimal.ONE);

        //act
        Item itemIdTest = service.selectItem(itemId);

        //arrange
        assertEquals(itemId, itemIdTest.getItemId());

    }

    /**
     * Test of selectItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testSelectItemNullPath() throws Exception {
        //arrange
        String itemId = "9999xyz";
        service.addMoney(BigDecimal.ONE);

        //act arrange
        try {
            service.selectItem(itemId);
            //if we get here the test fails which is what we want to happen because amount in machine is zero
            fail("Expected ItemNotFoundException was not thrown.");
        } catch (ItemNotFoundException e) {
            return; //we caught the exception we wanted to catch in this case we are golden if we reach here
        }

    }

    /**
     * Test of selectItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testSelectItemZeroAmountInMachine() throws Exception {
        //every instance of Service layer has balance as zero to start
        String itemId = "nonEmptyItem";

        //act
        try {
            service.selectItem(itemId);
            //if we get here the test fails which is what we want to happen because amount in machine is zero
            fail("Expected EnterMoneyFirstException was not thrown.");
        } catch (EnterMoneyFirstException e) {
            return;
        }
    }

    /**
     * Test of selectItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testSelectItemWithAmountInMachine() throws Exception {
        //every instance of Service layer has balance as zero to start
        String itemId = "nonEmptyItem";
        service.addMoney(new BigDecimal("2.00"));

        //act
        try {
            service.selectItem(itemId);
            //this means we got through and we can successfully return
            return;
        } catch (EnterMoneyFirstException e) {

        }
    }

    /**
     * Test of returnChange method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testReturnChange() {

        //arrange
        service.addMoney(new BigDecimal("2.00"));
        //create new change object for comparison
        Change changeToBeReturned = new Change();
        changeToBeReturned.addToAmount(service.getMoneyInMachine().getAmount());

        //act
        Change changeReturned = service.returnChange();

        //assert
        assertEquals(changeReturned, changeToBeReturned);
    }

    /**
     * Test of buyItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testBuyItemGoodPath() throws Exception {

        //arrange
        String itemId = "nonEmptyItem";
        service.addMoney(new BigDecimal("2.00"));
        int quantityBefore = service.selectItem(itemId).getQuantity();
        //quantity is 2

        //act
        Item item = service.buyItem(itemId);

        //assert
        assertEquals(item.getQuantity(), quantityBefore - 1);

    }

    /**
     * Test of buyItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testBuyItemQuantityZeroWithSufficientAmount() throws Exception {

        //arrange
        String itemId = "emptyItem";
        service.addMoney(new BigDecimal("2.00"));

        //act
        try {
            service.buyItem(itemId);
            //if we get here the test fails which is what we want to happen because amount in machine is zero
            fail("Expected ItemOutOfStockException was not thrown.");
        } catch (ItemOutOfStockException e) {
            return;
        }

    }
    
        /**
     * Test of buyItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testBuyItemQuantityInSufficientAmount() throws Exception {

        //arrange
        String itemId = "nonEmptyItem";
        service.addMoney(new BigDecimal("1.00"));

        //act
        try {
            service.buyItem(itemId);
            //if we get here the test fails which is what we want to happen because amount in machine is zero
            fail("Expected InsufficientFundsException was not thrown.");
        } catch (InsufficientFundsException e) {
            return;
        }

    }

    /**
     * Test of viewItems method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testViewItems() throws Exception {
        //theres two items in the dao
        assertEquals(2, service.viewItems().size());
    }

    /**
     * Test of getMoneyInMachine method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetMoneyInMachine() {
        //arrange
        //create new change object for comparison
        Change change = new Change();
        change.addToAmount(new BigDecimal("2.00"));
        service.addMoney(new BigDecimal("2.00"));

        //act
        Change changeFromMethod = new Change();
        changeFromMethod.addToAmount(service.getMoneyInMachine().getAmount());

        //assert
        assertEquals(changeFromMethod, change);
    }

}
