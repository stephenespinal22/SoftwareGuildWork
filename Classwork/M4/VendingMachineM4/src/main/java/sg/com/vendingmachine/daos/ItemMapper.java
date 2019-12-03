/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingmachine.daos;

import java.math.BigDecimal;
import sg.com.vendingmachine.dtos.Item;

/**
 *
 * @author stephenespinal
 */
public class ItemMapper {

    public static Item parseItem(String row, String DELIMITER) {
        // break up the line into tokens
        String[] cols = row.split(DELIMITER);
        Item item = new Item(cols[0]);
        item.setItemName(cols[1]);
        item.setQuantity(Integer.parseInt(cols[2]));
        item.setPrice(new BigDecimal(cols[3]));
        return item;
    }

    public static String toDelimitedString(Item currentItem, String DELIMITER) {
        String row = currentItem.getItemId() + DELIMITER
                + currentItem.getItemName() + DELIMITER
                + currentItem.getQuantity() + DELIMITER
                + currentItem.getPrice();
        return row;
    }

}
