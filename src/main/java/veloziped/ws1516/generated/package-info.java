/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(type=double.class, value=DoubleXMLAdapter.class)
})
package veloziped.ws1516.generated;


import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import veloziped.ws1516.util.DoubleXMLAdapter;

