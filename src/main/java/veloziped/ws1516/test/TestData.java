/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Martin
 */
public class TestData {
    
    public static Map<String, Long> getOrderQuantities() {
        Map<String, Long> values = new HashMap<>();
        
        values.put("4", Long.valueOf("170"));
        values.put("5", Long.valueOf("120"));
        values.put("6", Long.valueOf("0"));
        
        values.put("7", Long.valueOf("170"));
        values.put("8", Long.valueOf("70"));
        values.put("9", Long.valueOf("40"));
        
        values.put("10", Long.valueOf("170"));
        values.put("11", Long.valueOf("120"));
        values.put("12", Long.valueOf("0"));
        
        values.put("13", Long.valueOf("170"));
        values.put("14", Long.valueOf("70"));
        values.put("15", Long.valueOf("130"));
        
        values.put("16", Long.valueOf("190"));
        values.put("17", Long.valueOf("390"));
        
        values.put("18", Long.valueOf("170"));
        values.put("19", Long.valueOf("70"));
        values.put("20", Long.valueOf("30"));
        
        values.put("26", Long.valueOf("430"));
        
        values.put("49", Long.valueOf("170"));
        values.put("54", Long.valueOf("70"));
        values.put("29", Long.valueOf("0"));
        
        values.put("50", Long.valueOf("170"));
        values.put("55", Long.valueOf("90"));
        values.put("30", Long.valueOf("0"));
        
        values.put("51", Long.valueOf("180"));
        values.put("56", Long.valueOf("170"));
        values.put("31", Long.valueOf("20"));
        
        values.put("1", Long.valueOf("140"));
        values.put("2", Long.valueOf("170"));
        values.put("3", Long.valueOf("50"));
        
        return values;
    }
}
