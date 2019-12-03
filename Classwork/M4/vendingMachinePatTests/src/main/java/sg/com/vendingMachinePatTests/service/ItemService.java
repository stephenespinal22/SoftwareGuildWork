/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingMachinePatTests.service;

import java.math.BigDecimal;
import java.util.List;
import sg.com.vendingMachinePatTests.dto.Change;
import sg.com.vendingMachinePatTests.dto.Item;

/**
 *
 * @author stephenespinal
 */
public interface ItemService {

    public BigDecimal getBalance();

    public void deposit(BigDecimal money);
    
    public List<Item> getItems();
    
    public Change refund();
    
    public void purchaseItem(Item item) throws InsufficentFundsException, NoInventoryException;
    
    
}
