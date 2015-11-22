/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mihai Sava
 */
public class Utils {
    public static ResourceBundle getResourceBundle(String lang, String country){
        Locale l = new Locale(lang, country);
        ResourceBundle r = ResourceBundle.getBundle("veloziped.ws1516.i18n.i18n",l);
        return r;
    }
    
    public static Number getNumberFromString(String text, Locale locale) {
        NumberFormat format = NumberFormat.getInstance(Locale.GERMANY);

        Number number;
        try {
            number = format.parse(text);
        } catch (ParseException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            number = 0;
        }
        
        return number;
    }
}
