/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.masteryoop.daos;

/**
 *
 * @author stephenespinal
 */
public class DateMapper {
    
        public static String stringDateToFileString(String date, String path) {
        //remove / from date to make it safe to write file (cant use / in filename)

        String[] split = date.split("/");
        String dateFile = split[0] + split[1] + split[2];

        return new String(path + "resources/data/Orders_" + dateFile + ".txt");
    }

}
