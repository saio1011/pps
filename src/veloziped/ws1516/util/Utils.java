/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.util;

import java.util.Locale;
import java.util.ResourceBundle;

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
}
