//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.24 at 10:15:15 AM CET 
//


package veloziped.ws1516.generated;

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
 *       &lt;attribute name="amount" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="cost" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="cycletime" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "batch")
public class Batch {

    @XmlAttribute(name = "amount", required = true)
    protected long amount;
    @XmlAttribute(name = "cost", required = true)
    protected double cost;
    @XmlAttribute(name = "cycletime", required = true)
    protected long cycletime;
    @XmlAttribute(name = "id", required = true)
    protected long id;

    /**
     * Gets the value of the amount property.
     * 
     */
    public long getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(long value) {
        this.amount = value;
    }

    /**
     * Gets the value of the cost property.
     * 
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets the value of the cost property.
     * 
     */
    public void setCost(double value) {
        this.cost = value;
    }

    /**
     * Gets the value of the cycletime property.
     * 
     */
    public long getCycletime() {
        return cycletime;
    }

    /**
     * Sets the value of the cycletime property.
     * 
     */
    public void setCycletime(long value) {
        this.cycletime = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

}
