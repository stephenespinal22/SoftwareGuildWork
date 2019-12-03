/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingmachine.daos;

import java.util.List;
import sg.com.vendingmachine.dtos.Item;

/**
 *
 * @author stephenespinal
 */
public interface VendingMachineDao {

    /**
     *return all items in inventory
     * @return List<Item>
     * @throws VendingMachinePersistanceException
     */
    List<Item> getAllItems() throws VendingMachinePersistanceException;

    /**
     * return single item
     *
     * @param itemId
     * @return Item
     * @throws VendingMachinePersistanceException
     */
    Item getItem(String itemId) throws VendingMachinePersistanceException;

    /**
     * replace item with another in inventory
     *
     * @param itemToEdit
     * @return Item
     * @throws VendingMachinePersistanceException
     */
    Item editItem(Item itemToEdit) throws VendingMachinePersistanceException;

}
