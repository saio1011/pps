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
 *       &lt;attribute name="startedorders" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="waitingorders" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "cycletimes")
public class Cycletimes {

    @XmlAttribute(name = "startedorders", required = true)
    protected long startedorders;
    @XmlAttribute(name = "waitingorders", required = true)
    protected long waitingorders;

    /**
     * Gets the value of the startedorders property.
     * 
     */
    public long getStartedorders() {
        return startedorders;
    }

    /**
     * Sets the value of the startedorders property.
     * 
     */
    public void setStartedorders(long value) {
        this.startedorders = value;
    }

    /**
     * Gets the value of the waitingorders property.
     * 
     */
    public long getWaitingorders() {
        return waitingorders;
    }

    /**
     * Sets the value of the waitingorders property.
     * 
     */
    public void setWaitingorders(long value) {
        this.waitingorders = value;
    }

}