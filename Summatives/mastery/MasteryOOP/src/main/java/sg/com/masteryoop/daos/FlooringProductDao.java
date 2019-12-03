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
public interface FlooringProductDao {

    BigDecimal getCostPerSquareFoot(String product) throws FlooringPersistanceException;

    BigDecimal getLaborCostPerSquareFoot(String product) throws FlooringPersistanceException;

}
