/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.masteryoop.daos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import sg.com.masteryoop.dtos.Product;

/**
 *
 * @author stephenespinal
 */
public class FlooringProductDaoImpl implements FlooringProductDao {

    List<Product> productList = new ArrayList<>();
    public String PRODUCT_FILE;
    public static final String DELIMITER = "::";

    public FlooringProductDaoImpl(String PRODUCT_FILE) {
        this.PRODUCT_FILE = PRODUCT_FILE;
    }

    @Override
    public BigDecimal getCostPerSquareFoot(String product) throws FlooringPersistanceException {
        loadProducts();
        
        return productList.stream().filter(s -> s.getProductType().equals(product)).findAny().get().getCostPerSquareFoot();

    }

    @Override
    public BigDecimal getLaborCostPerSquareFoot(String product) throws FlooringPersistanceException {
        loadProducts();
        
        return productList.stream().filter(s -> s.getProductType().equals(product)).findAny().get().getLaborCostPerSquareFoot();

    }

    private void loadProducts() throws FlooringPersistanceException {

        Scanner scanner = null;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(new FileReader(PRODUCT_FILE)));

            while (scanner.hasNextLine()) {

                String currentLine = scanner.nextLine();
                // break up the line into tokens
                String[] currentTokens = currentLine.split(DELIMITER);

                Product currentProduct = new Product();
                currentProduct.setProductType(currentTokens[0]);
                currentProduct.setCostPerSquareFoot(new BigDecimal(currentTokens[1]));
                currentProduct.setLaborCostPerSquareFoot(new BigDecimal(currentTokens[2]));

                productList.add(currentProduct);

            }
            // close scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new FlooringPersistanceException(
                    "Could not load Taxes From FIle.", e);
        }

    }

}
