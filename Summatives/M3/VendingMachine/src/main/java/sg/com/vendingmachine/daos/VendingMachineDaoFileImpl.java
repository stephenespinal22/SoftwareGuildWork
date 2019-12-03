/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingmachine.daos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import sg.com.vendingmachine.dtos.Item;

/**
 *
 * @author stephenespinal
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private Map<String, Item> itemInventory = new HashMap<>();
    public String INVENTORY_FILE;
    public static final String DELIMITER = "::";

    public VendingMachineDaoFileImpl(String filename) {
        INVENTORY_FILE = filename;
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistanceException {
        readInventoryFromFile();
        return new ArrayList<Item>(itemInventory.values());
    }

    @Override
    public Item getItem(String itemId) throws VendingMachinePersistanceException {
        readInventoryFromFile();
        return itemInventory.get(itemId);
    }

    @Override
    public Item editItem(Item itemToEdit) throws VendingMachinePersistanceException {
        readInventoryFromFile();
        itemInventory.replace(itemToEdit.getItemId(), itemToEdit);
        writeInventoryToFile();
        return itemToEdit;
    }

    private void readInventoryFromFile() throws VendingMachinePersistanceException {

        Scanner scanner = null;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(new FileReader(INVENTORY_FILE)));

            while (scanner.hasNextLine()) {
                // get the next line in the file
                // currentLine holds the most recent line read from the file

                String row = scanner.nextLine();

                Item currentItem = ItemMapper.parseItem(row, DELIMITER);

                itemInventory.put(currentItem.getItemId(), currentItem);
            }
            // close scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistanceException(
                    "Could not load inventory data into memory.", e);
        }

    }

    private void writeInventoryToFile() throws VendingMachinePersistanceException {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));

            List<Item> itemList = new ArrayList<Item>(itemInventory.values());

            for (Item currentItem : itemList) {

                String row = ItemMapper.toDelimitedString(currentItem, DELIMITER);

                out.println(row);
                // force PrintWriter to write line to the file
                out.flush();
            }
            // Clean up
            out.close();
        } catch (IOException e) {
            throw new VendingMachinePersistanceException(
                    "Could not write to inventory.", e);
        }

    }

}
