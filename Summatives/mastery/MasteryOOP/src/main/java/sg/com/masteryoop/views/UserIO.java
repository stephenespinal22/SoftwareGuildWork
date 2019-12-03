/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.masteryoop.views;

import java.math.BigDecimal;

/**
 *
 * @author stephenespinal
 */
public interface UserIO {

    void printLine(String msg);

    void print(String msg);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);

    String readString(String prompt);

    BigDecimal readBigDecimal(String prompt);

    BigDecimal readBigDecimal(String prompt, BigDecimal min, BigDecimal max);

    //methods for Flooring
    String readStringDate(String prompt);
    
    String validateStringAsDate(String prompt);

    String readState(String prompt);

    String readProductType(String prompt);

    BigDecimal readBigDecimalEdit(String prompt, BigDecimal min, BigDecimal max);

    String readStateEdit(String string);

    String readProductTypeEdit(String string);

    String readName(String prompt);

}
