/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import sg.com.vendingMachinePatTests.service.ItemServiceImpl;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import sg.com.vendingMachinePatTests.dto.Change;
import sg.com.vendingMachinePatTests.service.ItemService;
/**
 *
 * @author ptoner
 */
public class ItemServiceJUnitTest {
    ItemService itemService;
    public ItemServiceJUnitTest() {
        itemService = new ItemServiceImpl();
    }
    
    @Before
    public void setUp() {
        itemService.refund();
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testGetBalance() {
        //Arrange
        itemService.deposit(new BigDecimal("1.00"));
        //Act
        BigDecimal balance = itemService.getBalance();
        //Assert
        assertEquals(balance, new BigDecimal("1.00"));
    }
    @Test
    public void testDepositMore() {
        //Arrange
        itemService.deposit(new BigDecimal("1.00"));
        
        //Act
        itemService.deposit(new BigDecimal("1.50"));
        //Assert
        BigDecimal balance = itemService.getBalance();
        assertEquals(balance, new BigDecimal("2.50"));
    }
    @Test
    public void testReturnChange() {
        itemService.deposit(new BigDecimal("2.50"));
        
        //Act
        Change c = itemService.refund();
        //Assert 
        assertEquals(c.getQuarters(), 10);
        assertEquals(c.getDimes(), 0);
        assertEquals(c.getNickels(), 0);
        assertEquals(c.getPennies(), 0);
    }
    @Test
    public void testReturnDimes() {
        
        //Arrange
        itemService.deposit(new BigDecimal("0.40"));
        
        
        //Act
        Change c = itemService.refund();
        //Assert 
        assertEquals(c.getQuarters(), 1);
        assertEquals(c.getDimes(), 1);
        assertEquals(c.getNickels(), 1);
        assertEquals(c.getPennies(), 0);
        
    }
    @Test
    public void testReturnNickels() {
        
        //Arrange
        itemService.deposit(new BigDecimal("0.05"));
        
        //Act
        Change c = itemService.refund();
        //Assert 
        assertEquals(c.getQuarters(), 0);
        assertEquals(c.getDimes(), 0);
        assertEquals(c.getNickels(), 1);
        assertEquals(c.getPennies(), 0);
    }
    @Test
    public void testReturnPennies() {
        
        //Arrange
        itemService.deposit(new BigDecimal("0.04"));
        
        //Act
        Change c = itemService.refund();
        //Assert 
        assertEquals(c.getQuarters(), 0);
        assertEquals(c.getDimes(), 0);
        assertEquals(c.getNickels(), 0);
        assertEquals(c.getPennies(), 4);
    }
    
    @Test
    public void testReturnAll() {
        
        //Arrange
        itemService.deposit(new BigDecimal("0.41"));
        
        //Act
        Change c = itemService.refund();
        //Assert 
        assertEquals(c.getQuarters(), 1);
        assertEquals(c.getDimes(), 1);
        assertEquals(c.getNickels(), 1);
        assertEquals(c.getPennies(), 1);
    }
}