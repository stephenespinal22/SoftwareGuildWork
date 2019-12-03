/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingmachine.daos;

import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.com.vendingmachine.dtos.Item;

/**
 *
 * @author stephenespinal
 */
public class VendingMachineDaoTest {

    public VendingMachineDaoTest() {
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
     * Test of getAllItems method, of class VendingMachineDao.
     */
    @Test
    public void testGetAllItems() throws Exception {
        //we need to test against a file
        //arrange
        VendingMachineDaoFileImpl instance = new VendingMachineDaoFileImpl("testInventory.txt");
        //act
        List<Item> result = instance.getAllItems();
        //assert
        assertEquals(1, result.size());
        assertEquals("Hotdog", result.get(0).getItemName());
    }

    /**
     * Test of getItem method, of class VendingMachineDao.
     */
    @Test
    public void testGetItem() throws Exception {
        //arrange
        VendingMachineDaoFileImpl instance2 = new VendingMachineDaoFileImpl("testInventory.txt");
        //act
        Item result = instance2.getItem("1");
     
        //assert that the price is equal to the one in the file
        assertEquals(new BigDecimal("1.90"), result.getPrice());
    }

    /**
     * Test of editItem method, of class VendingMachineDao.
     */
    @Test
    public void testEditItem() throws Exception {
        //arrange
        VendingMachineDaoFileImpl instance3 = new VendingMachineDaoFileImpl("testInventory.txt");
        Item item = instance3.getItem("1");

        //set it to six and check if the quantity is correct after calling method
        item.setQuantity(6);
        //act
        Item result = instance3.editItem(item);
        //arrange
        assertEquals(6,result.getQuantity());
    }

}
