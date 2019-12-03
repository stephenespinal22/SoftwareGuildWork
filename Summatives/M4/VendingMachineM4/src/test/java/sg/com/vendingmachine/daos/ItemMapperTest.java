/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingmachine.daos;

import java.math.BigDecimal;
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
public class ItemMapperTest {
    
    public ItemMapperTest() {
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
     * Test of parseItem method, of class ItemMapper.
     */
    @Test
    public void testParseItem() {
        
        String row = "1::Snickers::2::1.00";
        Item item = new Item("1");
        item.setItemName("Snickers");
        item.setQuantity(2);
        item.setPrice(new BigDecimal("1.00"));
        Item result = ItemMapper.parseItem(row, "::");
        assertEquals(item,result);

    }

    /**
     * Test of toDelimitedString method, of class ItemMapper.
     */
    @Test
    public void testToDelimitedString() {
        Item item = new Item("1");
        item.setItemName("Snickers");
        item.setQuantity(2);
        item.setPrice(new BigDecimal("1.00"));
        String expResult = "1::Snickers::2::1.00";
        String result = ItemMapper.toDelimitedString(item, "::");
        assertEquals(expResult,result);
    }
    
}
