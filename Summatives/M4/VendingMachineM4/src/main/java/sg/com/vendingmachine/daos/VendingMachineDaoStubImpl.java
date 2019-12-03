/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingmachine.daos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sg.com.vendingmachine.dtos.Item;

/**
 *
 * @author stephenespinal
 */
//this class will be a mock implementation of the dao to test the service layer
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    private Map<String, Item> itemInventory = new HashMap<>();

    //empty refers to empty item meaning quantity is zero
    private Item emptyItem;
    private Item nonEmptyItem;

    public VendingMachineDaoStubImpl() {
        nonEmptyItem = new Item("nonEmptyItem");
        nonEmptyItem.setItemName("Snickers");
        nonEmptyItem.setQuantity(2);
        nonEmptyItem.setPrice(new BigDecimal("1.50"));

        itemInventory.put(nonEmptyItem.getItemId(), nonEmptyItem);

        emptyItem = new Item("emptyItem");
        emptyItem.setItemName("Snicker");
        emptyItem.setQuantity(0);
        emptyItem.setPrice(new BigDecimal("1.50"));

        itemInventory.put(emptyItem.getItemId(), emptyItem);
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistanceException {
        return new ArrayList<Item>(itemInventory.values());
    }

    @Override
    public Item getItem(String itemId) throws VendingMachinePersistanceException {
        //we are pretending that the item is getting deleted in the dao for the test of the service layer
        //we need to check fro nonempty item and empty item for both tests in service for buy item
        if (itemId.equals(nonEmptyItem.getItemId())) {
            return nonEmptyItem;
        } else if (itemId.equals(emptyItem.getItemId())) {
            return emptyItem;
        } else {
            return null;
        }
    }

    @Override
    public Item editItem(Item itemToEdit) throws VendingMachinePersistanceException {
        //we are pretending that the item is getting deleted in the dao for the test of the service layer

        //we need to check fro nonempty item and empty item for both tests in service for buy item
        if (itemToEdit.equals(nonEmptyItem.getItemId())) {
            return nonEmptyItem;
        } else if (itemToEdit.equals(emptyItem.getItemId())) {
            return emptyItem;
        } else {
            return null;
        }
    }

}
