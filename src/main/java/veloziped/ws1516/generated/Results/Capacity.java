//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.08 at 09:13:59 AM CET 
//


package veloziped.ws1516.generated.Results;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="all" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="average" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="current" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "capacity")
public class Capacity {

    @XmlAttribute(name = "all", required = true)
    protected long all;
    @XmlAttribute(name = "average", required = true)
    protected double average;
    @XmlAttribute(name = "current", required = true)
    protected long current;

    /**
     * Gets the value of the all property.
     * 
     */
    public long getAll() {
        return all;
    }

    /**
     * Sets the value of the all property.
     * 
     */
    public void setAll(long value) {
        this.all = value;
    }

    /**
     * Gets the value of the average property.
     * 
     */
    public double getAverage() {
        return average;
    }

    /**
     * Sets the value of the average property.
     * 
     */
    public void setAverage(double value) {
        this.average = value;
    }

    /**
     * Gets the value of the current property.
     * 
     */
    public long getCurrent() {
        return current;
    }

    /**
     * Sets the value of the current property.
     * 
     */
    public void setCurrent(long value) {
        this.current = value;
    }

}