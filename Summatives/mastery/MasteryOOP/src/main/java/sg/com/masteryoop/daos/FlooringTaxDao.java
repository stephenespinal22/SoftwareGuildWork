/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.masteryoop.daos;

import java.math.BigDecimal;

/**
 *
 * @author stephenespinal
 */
public interface FlooringTaxDao {
    
    BigDecimal getTaxRate(String state) throws FlooringPersistanceException ;
}
