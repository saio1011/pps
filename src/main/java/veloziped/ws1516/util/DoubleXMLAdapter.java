/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.util;

import java.util.Locale;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Martin
 */
public class DoubleXMLAdapter extends XmlAdapter<String, Double> {

    public Double unmarshal(String value) {
        double res = Utils.getNumberFromString(value, Locale.GERMAN).doubleValue();
        return res;
    }

    public String marshal(Double value) {
        if (value == null) {
            return null;
        }
        return (javax.xml.bind.DatatypeConverter.printDouble(value));
    }

}
