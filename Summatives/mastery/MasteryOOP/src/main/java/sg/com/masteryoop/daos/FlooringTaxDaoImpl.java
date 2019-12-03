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
import sg.com.masteryoop.dtos.Tax;

/**
 *
 * @author stephenespinal
 */
public class FlooringTaxDaoImpl implements FlooringTaxDao {

    List<Tax> taxList = new ArrayList<>();
    public String TAX_FILE;
    public static final String DELIMITER = "::";

    public FlooringTaxDaoImpl(String TAX_FILE) {
        this.TAX_FILE = TAX_FILE;
    }

    @Override
    public BigDecimal getTaxRate(String state) throws FlooringPersistanceException {
        loadTaxes();
        
       return taxList.stream().filter(s->s.getState().equals(state)).findFirst().get().getTaxRate();

    }

    private void loadTaxes() throws FlooringPersistanceException {

        Scanner scanner = null;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(new FileReader(TAX_FILE)));

            while (scanner.hasNextLine()) {

                String currentLine = scanner.nextLine();
                // break up the line into tokens
                String[] currentTokens = currentLine.split(DELIMITER);

                Tax currentTax = new Tax();
                currentTax.setState(currentTokens[0]);
                currentTax.setTaxRate(new BigDecimal(currentTokens[1]));

                taxList.add(currentTax);

            }
            // close scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new FlooringPersistanceException(
                    "Could not load Taxes From FIle.", e);
        }

    }
}
