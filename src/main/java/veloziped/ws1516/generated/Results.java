//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.11.17 um 11:16:28 AM CET 
//


package veloziped.ws1516.generated;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java-Klasse f�r anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="warehousestock">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="article" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                           &lt;attribute name="startamount" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                           &lt;attribute name="pct" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="price" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="stockvalue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="totalstockvalue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="inwardstockmovement">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="order" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="orderperiod" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="mode" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="article" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                           &lt;attribute name="time" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="materialcosts" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ordercosts" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="entirecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="piececosts" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="futureinwardstockmovement">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="order" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="orderperiod" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="mode" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="article" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="idletimecosts">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="workplace" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="setupevents" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="idletime" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                           &lt;attribute name="wageidletimecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="wagecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="machineidletimecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="sum">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="setupevents" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                           &lt;attribute name="idletime" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                           &lt;attribute name="wageidletimecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="wagecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="machineidletimecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="waitinglistworkstations">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="workplace" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="waitinglist" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                     &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                     &lt;attribute name="firstbatch" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                     &lt;attribute name="lastbatch" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                     &lt;attribute name="item" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                     &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                                     &lt;attribute name="timeneed" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="timeneed" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="waitingliststock">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="missingpart" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="waitinglist">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                     &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                     &lt;attribute name="firstbatch" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                     &lt;attribute name="lastbatch" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                     &lt;attribute name="item" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                     &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ordersinwork">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="workplace" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="batch" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="item" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="timeneed" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="completedorders">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="order" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="batch" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                     &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                     &lt;attribute name="cycletime" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                                     &lt;attribute name="cost" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="item" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="quantity" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                           &lt;attribute name="cost" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="averageunitcosts" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="cycletimes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="order" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="starttime" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="finishtime" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="cycletimemin" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                           &lt;attribute name="cycletimefactor" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="startedorders" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                 &lt;attribute name="waitingorders" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="result">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="general">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="capacity">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="possiblecapacity">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="relpossiblenormalcapacity">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="productivetime">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="effiency">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="sellwish">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="salesquantity">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="deliveryreliability">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="idletime">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="idletimecosts">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="storevalue">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="storagecosts">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="defectivegoods">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="quantity">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="costs">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="normalsale">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="salesprice">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="profit">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="profitperunit">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="directsale">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="profit">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="contractpenalty">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="marketplacesale">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="profit">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="summary">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="profit">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="game" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="group" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "warehousestock",
    "inwardstockmovement",
    "futureinwardstockmovement",
    "idletimecosts",
    "waitinglistworkstations",
    "waitingliststock",
    "ordersinwork",
    "completedorders",
    "cycletimes",
    "result"
})
@XmlRootElement(name = "results")
public class Results {

    @XmlElement(required = true)
    protected Results.Warehousestock warehousestock;
    @XmlElement(required = true)
    protected Results.Inwardstockmovement inwardstockmovement;
    @XmlElement(required = true)
    protected Results.Futureinwardstockmovement futureinwardstockmovement;
    @XmlElement(required = true)
    protected Results.Idletimecosts idletimecosts;
    @XmlElement(required = true)
    protected Results.Waitinglistworkstations waitinglistworkstations;
    @XmlElement(required = true)
    protected Results.Waitingliststock waitingliststock;
    @XmlElement(required = true)
    protected Results.Ordersinwork ordersinwork;
    @XmlElement(required = true)
    protected Results.Completedorders completedorders;
    @XmlElement(required = true)
    protected Results.Cycletimes cycletimes;
    @XmlElement(required = true)
    protected Results.Result result;
    @XmlAttribute(name = "game")
    protected Short game;
    @XmlAttribute(name = "group")
    protected Byte group;
    @XmlAttribute(name = "period")
    protected Byte period;

    /**
     * Ruft den Wert der warehousestock-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Results.Warehousestock }
     *     
     */
    public Results.Warehousestock getWarehousestock() {
        return warehousestock;
    }

    /**
     * Legt den Wert der warehousestock-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Results.Warehousestock }
     *     
     */
    public void setWarehousestock(Results.Warehousestock value) {
        this.warehousestock = value;
    }

    /**
     * Ruft den Wert der inwardstockmovement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Results.Inwardstockmovement }
     *     
     */
    public Results.Inwardstockmovement getInwardstockmovement() {
        return inwardstockmovement;
    }

    /**
     * Legt den Wert der inwardstockmovement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Results.Inwardstockmovement }
     *     
     */
    public void setInwardstockmovement(Results.Inwardstockmovement value) {
        this.inwardstockmovement = value;
    }

    /**
     * Ruft den Wert der futureinwardstockmovement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Results.Futureinwardstockmovement }
     *     
     */
    public Results.Futureinwardstockmovement getFutureinwardstockmovement() {
        return futureinwardstockmovement;
    }

    /**
     * Legt den Wert der futureinwardstockmovement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Results.Futureinwardstockmovement }
     *     
     */
    public void setFutureinwardstockmovement(Results.Futureinwardstockmovement value) {
        this.futureinwardstockmovement = value;
    }

    /**
     * Ruft den Wert der idletimecosts-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Results.Idletimecosts }
     *     
     */
    public Results.Idletimecosts getIdletimecosts() {
        return idletimecosts;
    }

    /**
     * Legt den Wert der idletimecosts-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Results.Idletimecosts }
     *     
     */
    public void setIdletimecosts(Results.Idletimecosts value) {
        this.idletimecosts = value;
    }

    /**
     * Ruft den Wert der waitinglistworkstations-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Results.Waitinglistworkstations }
     *     
     */
    public Results.Waitinglistworkstations getWaitinglistworkstations() {
        return waitinglistworkstations;
    }

    /**
     * Legt den Wert der waitinglistworkstations-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Results.Waitinglistworkstations }
     *     
     */
    public void setWaitinglistworkstations(Results.Waitinglistworkstations value) {
        this.waitinglistworkstations = value;
    }

    /**
     * Ruft den Wert der waitingliststock-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Results.Waitingliststock }
     *     
     */
    public Results.Waitingliststock getWaitingliststock() {
        return waitingliststock;
    }

    /**
     * Legt den Wert der waitingliststock-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Results.Waitingliststock }
     *     
     */
    public void setWaitingliststock(Results.Waitingliststock value) {
        this.waitingliststock = value;
    }

    /**
     * Ruft den Wert der ordersinwork-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Results.Ordersinwork }
     *     
     */
    public Results.Ordersinwork getOrdersinwork() {
        return ordersinwork;
    }

    /**
     * Legt den Wert der ordersinwork-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Results.Ordersinwork }
     *     
     */
    public void setOrdersinwork(Results.Ordersinwork value) {
        this.ordersinwork = value;
    }

    /**
     * Ruft den Wert der completedorders-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Results.Completedorders }
     *     
     */
    public Results.Completedorders getCompletedorders() {
        return completedorders;
    }

    /**
     * Legt den Wert der completedorders-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Results.Completedorders }
     *     
     */
    public void setCompletedorders(Results.Completedorders value) {
        this.completedorders = value;
    }

    /**
     * Ruft den Wert der cycletimes-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Results.Cycletimes }
     *     
     */
    public Results.Cycletimes getCycletimes() {
        return cycletimes;
    }

    /**
     * Legt den Wert der cycletimes-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Results.Cycletimes }
     *     
     */
    public void setCycletimes(Results.Cycletimes value) {
        this.cycletimes = value;
    }

    /**
     * Ruft den Wert der result-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Results.Result }
     *     
     */
    public Results.Result getResult() {
        return result;
    }

    /**
     * Legt den Wert der result-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Results.Result }
     *     
     */
    public void setResult(Results.Result value) {
        this.result = value;
    }

    /**
     * Ruft den Wert der game-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getGame() {
        return game;
    }

    /**
     * Legt den Wert der game-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setGame(Short value) {
        this.game = value;
    }

    /**
     * Ruft den Wert der group-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getGroup() {
        return group;
    }

    /**
     * Legt den Wert der group-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setGroup(Byte value) {
        this.group = value;
    }

    /**
     * Ruft den Wert der period-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getPeriod() {
        return period;
    }

    /**
     * Legt den Wert der period-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setPeriod(Byte value) {
        this.period = value;
    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="order" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="batch" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                           &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                           &lt;attribute name="cycletime" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                           &lt;attribute name="cost" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="item" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="quantity" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                 &lt;attribute name="cost" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="averageunitcosts" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "order"
    })
    public static class Completedorders {

        protected List<Results.Completedorders.Order> order;

        /**
         * Gets the value of the order property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the order property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOrder().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Results.Completedorders.Order }
         * 
         * 
         */
        public List<Results.Completedorders.Order> getOrder() {
            if (order == null) {
                order = new ArrayList<Results.Completedorders.Order>();
            }
            return this.order;
        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="batch" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                 &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                 &lt;attribute name="cycletime" type="{http://www.w3.org/2001/XMLSchema}short" />
         *                 &lt;attribute name="cost" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="item" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="quantity" type="{http://www.w3.org/2001/XMLSchema}short" />
         *       &lt;attribute name="cost" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="averageunitcosts" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "batch"
        })
        public static class Order {

            protected List<Results.Completedorders.Order.Batch> batch;
            @XmlAttribute(name = "period")
            protected Byte period;
            @XmlAttribute(name = "id")
            protected Byte id;
            @XmlAttribute(name = "item")
            protected Byte item;
            @XmlAttribute(name = "quantity")
            protected Short quantity;
            @XmlAttribute(name = "cost")
            protected String cost;
            @XmlAttribute(name = "averageunitcosts")
            protected String averageunitcosts;

            /**
             * Gets the value of the batch property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the batch property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getBatch().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Results.Completedorders.Order.Batch }
             * 
             * 
             */
            public List<Results.Completedorders.Order.Batch> getBatch() {
                if (batch == null) {
                    batch = new ArrayList<Results.Completedorders.Order.Batch>();
                }
                return this.batch;
            }

            /**
             * Ruft den Wert der period-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getPeriod() {
                return period;
            }

            /**
             * Legt den Wert der period-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setPeriod(Byte value) {
                this.period = value;
            }

            /**
             * Ruft den Wert der id-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getId() {
                return id;
            }

            /**
             * Legt den Wert der id-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setId(Byte value) {
                this.id = value;
            }

            /**
             * Ruft den Wert der item-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getItem() {
                return item;
            }

            /**
             * Legt den Wert der item-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setItem(Byte value) {
                this.item = value;
            }

            /**
             * Ruft den Wert der quantity-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getQuantity() {
                return quantity;
            }

            /**
             * Legt den Wert der quantity-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setQuantity(Short value) {
                this.quantity = value;
            }

            /**
             * Ruft den Wert der cost-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCost() {
                return cost;
            }

            /**
             * Legt den Wert der cost-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCost(String value) {
                this.cost = value;
            }

            /**
             * Ruft den Wert der averageunitcosts-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAverageunitcosts() {
                return averageunitcosts;
            }

            /**
             * Legt den Wert der averageunitcosts-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAverageunitcosts(String value) {
                this.averageunitcosts = value;
            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="cycletime" type="{http://www.w3.org/2001/XMLSchema}short" />
             *       &lt;attribute name="cost" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Batch {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "id")
                protected Byte id;
                @XmlAttribute(name = "amount")
                protected Byte amount;
                @XmlAttribute(name = "cycletime")
                protected Short cycletime;
                @XmlAttribute(name = "cost")
                protected String cost;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der id-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getId() {
                    return id;
                }

                /**
                 * Legt den Wert der id-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setId(Byte value) {
                    this.id = value;
                }

                /**
                 * Ruft den Wert der amount-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getAmount() {
                    return amount;
                }

                /**
                 * Legt den Wert der amount-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setAmount(Byte value) {
                    this.amount = value;
                }

                /**
                 * Ruft den Wert der cycletime-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getCycletime() {
                    return cycletime;
                }

                /**
                 * Legt den Wert der cycletime-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setCycletime(Short value) {
                    this.cycletime = value;
                }

                /**
                 * Ruft den Wert der cost-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCost() {
                    return cost;
                }

                /**
                 * Legt den Wert der cost-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCost(String value) {
                    this.cost = value;
                }

            }

        }

    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="order" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="starttime" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="finishtime" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="cycletimemin" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                 &lt;attribute name="cycletimefactor" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="startedorders" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *       &lt;attribute name="waitingorders" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "order"
    })
    public static class Cycletimes {

        protected List<Results.Cycletimes.Order> order;
        @XmlAttribute(name = "startedorders")
        protected Byte startedorders;
        @XmlAttribute(name = "waitingorders")
        protected Byte waitingorders;

        /**
         * Gets the value of the order property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the order property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOrder().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Results.Cycletimes.Order }
         * 
         * 
         */
        public List<Results.Cycletimes.Order> getOrder() {
            if (order == null) {
                order = new ArrayList<Results.Cycletimes.Order>();
            }
            return this.order;
        }

        /**
         * Ruft den Wert der startedorders-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getStartedorders() {
            return startedorders;
        }

        /**
         * Legt den Wert der startedorders-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setStartedorders(Byte value) {
            this.startedorders = value;
        }

        /**
         * Ruft den Wert der waitingorders-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getWaitingorders() {
            return waitingorders;
        }

        /**
         * Legt den Wert der waitingorders-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setWaitingorders(Byte value) {
            this.waitingorders = value;
        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="starttime" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="finishtime" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="cycletimemin" type="{http://www.w3.org/2001/XMLSchema}short" />
         *       &lt;attribute name="cycletimefactor" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Order {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "id")
            protected Byte id;
            @XmlAttribute(name = "period")
            protected Byte period;
            @XmlAttribute(name = "starttime")
            protected String starttime;
            @XmlAttribute(name = "finishtime")
            protected String finishtime;
            @XmlAttribute(name = "cycletimemin")
            protected Short cycletimemin;
            @XmlAttribute(name = "cycletimefactor")
            protected String cycletimefactor;

            /**
             * Ruft den Wert der value-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Legt den Wert der value-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Ruft den Wert der id-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getId() {
                return id;
            }

            /**
             * Legt den Wert der id-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setId(Byte value) {
                this.id = value;
            }

            /**
             * Ruft den Wert der period-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getPeriod() {
                return period;
            }

            /**
             * Legt den Wert der period-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setPeriod(Byte value) {
                this.period = value;
            }

            /**
             * Ruft den Wert der starttime-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStarttime() {
                return starttime;
            }

            /**
             * Legt den Wert der starttime-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStarttime(String value) {
                this.starttime = value;
            }

            /**
             * Ruft den Wert der finishtime-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFinishtime() {
                return finishtime;
            }

            /**
             * Legt den Wert der finishtime-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFinishtime(String value) {
                this.finishtime = value;
            }

            /**
             * Ruft den Wert der cycletimemin-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCycletimemin() {
                return cycletimemin;
            }

            /**
             * Legt den Wert der cycletimemin-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCycletimemin(Short value) {
                this.cycletimemin = value;
            }

            /**
             * Ruft den Wert der cycletimefactor-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCycletimefactor() {
                return cycletimefactor;
            }

            /**
             * Legt den Wert der cycletimefactor-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCycletimefactor(String value) {
                this.cycletimefactor = value;
            }

        }

    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="order" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="orderperiod" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="mode" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="article" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}short" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "order"
    })
    public static class Futureinwardstockmovement {

        protected List<Results.Futureinwardstockmovement.Order> order;

        /**
         * Gets the value of the order property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the order property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOrder().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Results.Futureinwardstockmovement.Order }
         * 
         * 
         */
        public List<Results.Futureinwardstockmovement.Order> getOrder() {
            if (order == null) {
                order = new ArrayList<Results.Futureinwardstockmovement.Order>();
            }
            return this.order;
        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="orderperiod" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="mode" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="article" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}short" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Order {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "orderperiod")
            protected Byte orderperiod;
            @XmlAttribute(name = "id")
            protected Byte id;
            @XmlAttribute(name = "mode")
            protected Byte mode;
            @XmlAttribute(name = "article")
            protected Byte article;
            @XmlAttribute(name = "amount")
            protected Short amount;

            /**
             * Ruft den Wert der value-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Legt den Wert der value-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Ruft den Wert der orderperiod-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getOrderperiod() {
                return orderperiod;
            }

            /**
             * Legt den Wert der orderperiod-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setOrderperiod(Byte value) {
                this.orderperiod = value;
            }

            /**
             * Ruft den Wert der id-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getId() {
                return id;
            }

            /**
             * Legt den Wert der id-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setId(Byte value) {
                this.id = value;
            }

            /**
             * Ruft den Wert der mode-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getMode() {
                return mode;
            }

            /**
             * Legt den Wert der mode-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setMode(Byte value) {
                this.mode = value;
            }

            /**
             * Ruft den Wert der article-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getArticle() {
                return article;
            }

            /**
             * Legt den Wert der article-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setArticle(Byte value) {
                this.article = value;
            }

            /**
             * Ruft den Wert der amount-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getAmount() {
                return amount;
            }

            /**
             * Legt den Wert der amount-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setAmount(Short value) {
                this.amount = value;
            }

        }

    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="workplace" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="setupevents" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="idletime" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                 &lt;attribute name="wageidletimecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="wagecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="machineidletimecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="sum">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="setupevents" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                 &lt;attribute name="idletime" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                 &lt;attribute name="wageidletimecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="wagecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="machineidletimecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "workplace",
        "sum"
    })
    public static class Idletimecosts {

        protected List<Results.Idletimecosts.Workplace> workplace;
        @XmlElement(required = true)
        protected Results.Idletimecosts.Sum sum;

        /**
         * Gets the value of the workplace property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the workplace property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getWorkplace().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Results.Idletimecosts.Workplace }
         * 
         * 
         */
        public List<Results.Idletimecosts.Workplace> getWorkplace() {
            if (workplace == null) {
                workplace = new ArrayList<Results.Idletimecosts.Workplace>();
            }
            return this.workplace;
        }

        /**
         * Ruft den Wert der sum-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Results.Idletimecosts.Sum }
         *     
         */
        public Results.Idletimecosts.Sum getSum() {
            return sum;
        }

        /**
         * Legt den Wert der sum-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Results.Idletimecosts.Sum }
         *     
         */
        public void setSum(Results.Idletimecosts.Sum value) {
            this.sum = value;
        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="setupevents" type="{http://www.w3.org/2001/XMLSchema}short" />
         *       &lt;attribute name="idletime" type="{http://www.w3.org/2001/XMLSchema}short" />
         *       &lt;attribute name="wageidletimecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="wagecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="machineidletimecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Sum {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "setupevents")
            protected Short setupevents;
            @XmlAttribute(name = "idletime")
            protected Short idletime;
            @XmlAttribute(name = "wageidletimecosts")
            protected String wageidletimecosts;
            @XmlAttribute(name = "wagecosts")
            protected String wagecosts;
            @XmlAttribute(name = "machineidletimecosts")
            protected String machineidletimecosts;

            /**
             * Ruft den Wert der value-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Legt den Wert der value-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Ruft den Wert der setupevents-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getSetupevents() {
                return setupevents;
            }

            /**
             * Legt den Wert der setupevents-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setSetupevents(Short value) {
                this.setupevents = value;
            }

            /**
             * Ruft den Wert der idletime-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getIdletime() {
                return idletime;
            }

            /**
             * Legt den Wert der idletime-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setIdletime(Short value) {
                this.idletime = value;
            }

            /**
             * Ruft den Wert der wageidletimecosts-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWageidletimecosts() {
                return wageidletimecosts;
            }

            /**
             * Legt den Wert der wageidletimecosts-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWageidletimecosts(String value) {
                this.wageidletimecosts = value;
            }

            /**
             * Ruft den Wert der wagecosts-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWagecosts() {
                return wagecosts;
            }

            /**
             * Legt den Wert der wagecosts-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWagecosts(String value) {
                this.wagecosts = value;
            }

            /**
             * Ruft den Wert der machineidletimecosts-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMachineidletimecosts() {
                return machineidletimecosts;
            }

            /**
             * Legt den Wert der machineidletimecosts-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMachineidletimecosts(String value) {
                this.machineidletimecosts = value;
            }

        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="setupevents" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="idletime" type="{http://www.w3.org/2001/XMLSchema}short" />
         *       &lt;attribute name="wageidletimecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="wagecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="machineidletimecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Workplace {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "id")
            protected Byte id;
            @XmlAttribute(name = "setupevents")
            protected Byte setupevents;
            @XmlAttribute(name = "idletime")
            protected Short idletime;
            @XmlAttribute(name = "wageidletimecosts")
            protected String wageidletimecosts;
            @XmlAttribute(name = "wagecosts")
            protected String wagecosts;
            @XmlAttribute(name = "machineidletimecosts")
            protected String machineidletimecosts;

            /**
             * Ruft den Wert der value-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Legt den Wert der value-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Ruft den Wert der id-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getId() {
                return id;
            }

            /**
             * Legt den Wert der id-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setId(Byte value) {
                this.id = value;
            }

            /**
             * Ruft den Wert der setupevents-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getSetupevents() {
                return setupevents;
            }

            /**
             * Legt den Wert der setupevents-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setSetupevents(Byte value) {
                this.setupevents = value;
            }

            /**
             * Ruft den Wert der idletime-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getIdletime() {
                return idletime;
            }

            /**
             * Legt den Wert der idletime-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setIdletime(Short value) {
                this.idletime = value;
            }

            /**
             * Ruft den Wert der wageidletimecosts-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWageidletimecosts() {
                return wageidletimecosts;
            }

            /**
             * Legt den Wert der wageidletimecosts-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWageidletimecosts(String value) {
                this.wageidletimecosts = value;
            }

            /**
             * Ruft den Wert der wagecosts-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWagecosts() {
                return wagecosts;
            }

            /**
             * Legt den Wert der wagecosts-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWagecosts(String value) {
                this.wagecosts = value;
            }

            /**
             * Ruft den Wert der machineidletimecosts-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMachineidletimecosts() {
                return machineidletimecosts;
            }

            /**
             * Legt den Wert der machineidletimecosts-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMachineidletimecosts(String value) {
                this.machineidletimecosts = value;
            }

        }

    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="order" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="orderperiod" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="mode" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="article" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                 &lt;attribute name="time" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="materialcosts" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ordercosts" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="entirecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="piececosts" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "order"
    })
    public static class Inwardstockmovement {

        protected List<Results.Inwardstockmovement.Order> order;

        /**
         * Gets the value of the order property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the order property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOrder().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Results.Inwardstockmovement.Order }
         * 
         * 
         */
        public List<Results.Inwardstockmovement.Order> getOrder() {
            if (order == null) {
                order = new ArrayList<Results.Inwardstockmovement.Order>();
            }
            return this.order;
        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="orderperiod" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="mode" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="article" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}short" />
         *       &lt;attribute name="time" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="materialcosts" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ordercosts" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="entirecosts" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="piececosts" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Order {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "orderperiod")
            protected Byte orderperiod;
            @XmlAttribute(name = "id")
            protected Byte id;
            @XmlAttribute(name = "mode")
            protected Byte mode;
            @XmlAttribute(name = "article")
            protected Byte article;
            @XmlAttribute(name = "amount")
            protected Short amount;
            @XmlAttribute(name = "time")
            protected Integer time;
            @XmlAttribute(name = "materialcosts")
            protected String materialcosts;
            @XmlAttribute(name = "ordercosts")
            protected String ordercosts;
            @XmlAttribute(name = "entirecosts")
            protected String entirecosts;
            @XmlAttribute(name = "piececosts")
            protected String piececosts;

            /**
             * Ruft den Wert der value-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Legt den Wert der value-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Ruft den Wert der orderperiod-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getOrderperiod() {
                return orderperiod;
            }

            /**
             * Legt den Wert der orderperiod-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setOrderperiod(Byte value) {
                this.orderperiod = value;
            }

            /**
             * Ruft den Wert der id-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getId() {
                return id;
            }

            /**
             * Legt den Wert der id-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setId(Byte value) {
                this.id = value;
            }

            /**
             * Ruft den Wert der mode-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getMode() {
                return mode;
            }

            /**
             * Legt den Wert der mode-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setMode(Byte value) {
                this.mode = value;
            }

            /**
             * Ruft den Wert der article-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getArticle() {
                return article;
            }

            /**
             * Legt den Wert der article-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setArticle(Byte value) {
                this.article = value;
            }

            /**
             * Ruft den Wert der amount-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getAmount() {
                return amount;
            }

            /**
             * Legt den Wert der amount-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setAmount(Short value) {
                this.amount = value;
            }

            /**
             * Ruft den Wert der time-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getTime() {
                return time;
            }

            /**
             * Legt den Wert der time-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setTime(Integer value) {
                this.time = value;
            }

            /**
             * Ruft den Wert der materialcosts-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMaterialcosts() {
                return materialcosts;
            }

            /**
             * Legt den Wert der materialcosts-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMaterialcosts(String value) {
                this.materialcosts = value;
            }

            /**
             * Ruft den Wert der ordercosts-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOrdercosts() {
                return ordercosts;
            }

            /**
             * Legt den Wert der ordercosts-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOrdercosts(String value) {
                this.ordercosts = value;
            }

            /**
             * Ruft den Wert der entirecosts-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEntirecosts() {
                return entirecosts;
            }

            /**
             * Legt den Wert der entirecosts-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEntirecosts(String value) {
                this.entirecosts = value;
            }

            /**
             * Ruft den Wert der piececosts-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPiececosts() {
                return piececosts;
            }

            /**
             * Legt den Wert der piececosts-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPiececosts(String value) {
                this.piececosts = value;
            }

        }

    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="workplace" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="batch" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="item" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="timeneed" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "workplace"
    })
    public static class Ordersinwork {

        protected List<Results.Ordersinwork.Workplace> workplace;

        /**
         * Gets the value of the workplace property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the workplace property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getWorkplace().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Results.Ordersinwork.Workplace }
         * 
         * 
         */
        public List<Results.Ordersinwork.Workplace> getWorkplace() {
            if (workplace == null) {
                workplace = new ArrayList<Results.Ordersinwork.Workplace>();
            }
            return this.workplace;
        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="batch" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="item" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="timeneed" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Workplace {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "id")
            protected Byte id;
            @XmlAttribute(name = "period")
            protected Byte period;
            @XmlAttribute(name = "order")
            protected Byte order;
            @XmlAttribute(name = "batch")
            protected Byte batch;
            @XmlAttribute(name = "item")
            protected Byte item;
            @XmlAttribute(name = "amount")
            protected Byte amount;
            @XmlAttribute(name = "timeneed")
            protected Byte timeneed;

            /**
             * Ruft den Wert der value-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Legt den Wert der value-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Ruft den Wert der id-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getId() {
                return id;
            }

            /**
             * Legt den Wert der id-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setId(Byte value) {
                this.id = value;
            }

            /**
             * Ruft den Wert der period-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getPeriod() {
                return period;
            }

            /**
             * Legt den Wert der period-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setPeriod(Byte value) {
                this.period = value;
            }

            /**
             * Ruft den Wert der order-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getOrder() {
                return order;
            }

            /**
             * Legt den Wert der order-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setOrder(Byte value) {
                this.order = value;
            }

            /**
             * Ruft den Wert der batch-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getBatch() {
                return batch;
            }

            /**
             * Legt den Wert der batch-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setBatch(Byte value) {
                this.batch = value;
            }

            /**
             * Ruft den Wert der item-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getItem() {
                return item;
            }

            /**
             * Legt den Wert der item-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setItem(Byte value) {
                this.item = value;
            }

            /**
             * Ruft den Wert der amount-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getAmount() {
                return amount;
            }

            /**
             * Legt den Wert der amount-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setAmount(Byte value) {
                this.amount = value;
            }

            /**
             * Ruft den Wert der timeneed-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getTimeneed() {
                return timeneed;
            }

            /**
             * Legt den Wert der timeneed-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setTimeneed(Byte value) {
                this.timeneed = value;
            }

        }

    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="general">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="capacity">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="possiblecapacity">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="relpossiblenormalcapacity">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="productivetime">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="effiency">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="sellwish">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="salesquantity">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="deliveryreliability">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="idletime">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="idletimecosts">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="storevalue">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="storagecosts">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="defectivegoods">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="quantity">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="costs">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="normalsale">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="salesprice">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="profit">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="profitperunit">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="directsale">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="profit">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="contractpenalty">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="marketplacesale">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="profit">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="summary">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="profit">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "general",
        "defectivegoods",
        "normalsale",
        "directsale",
        "marketplacesale",
        "summary"
    })
    public static class Result {

        @XmlElement(required = true)
        protected Results.Result.General general;
        @XmlElement(required = true)
        protected Results.Result.Defectivegoods defectivegoods;
        @XmlElement(required = true)
        protected Results.Result.Normalsale normalsale;
        @XmlElement(required = true)
        protected Results.Result.Directsale directsale;
        @XmlElement(required = true)
        protected Results.Result.Marketplacesale marketplacesale;
        @XmlElement(required = true)
        protected Results.Result.Summary summary;

        /**
         * Ruft den Wert der general-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Results.Result.General }
         *     
         */
        public Results.Result.General getGeneral() {
            return general;
        }

        /**
         * Legt den Wert der general-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Results.Result.General }
         *     
         */
        public void setGeneral(Results.Result.General value) {
            this.general = value;
        }

        /**
         * Ruft den Wert der defectivegoods-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Results.Result.Defectivegoods }
         *     
         */
        public Results.Result.Defectivegoods getDefectivegoods() {
            return defectivegoods;
        }

        /**
         * Legt den Wert der defectivegoods-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Results.Result.Defectivegoods }
         *     
         */
        public void setDefectivegoods(Results.Result.Defectivegoods value) {
            this.defectivegoods = value;
        }

        /**
         * Ruft den Wert der normalsale-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Results.Result.Normalsale }
         *     
         */
        public Results.Result.Normalsale getNormalsale() {
            return normalsale;
        }

        /**
         * Legt den Wert der normalsale-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Results.Result.Normalsale }
         *     
         */
        public void setNormalsale(Results.Result.Normalsale value) {
            this.normalsale = value;
        }

        /**
         * Ruft den Wert der directsale-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Results.Result.Directsale }
         *     
         */
        public Results.Result.Directsale getDirectsale() {
            return directsale;
        }

        /**
         * Legt den Wert der directsale-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Results.Result.Directsale }
         *     
         */
        public void setDirectsale(Results.Result.Directsale value) {
            this.directsale = value;
        }

        /**
         * Ruft den Wert der marketplacesale-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Results.Result.Marketplacesale }
         *     
         */
        public Results.Result.Marketplacesale getMarketplacesale() {
            return marketplacesale;
        }

        /**
         * Legt den Wert der marketplacesale-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Results.Result.Marketplacesale }
         *     
         */
        public void setMarketplacesale(Results.Result.Marketplacesale value) {
            this.marketplacesale = value;
        }

        /**
         * Ruft den Wert der summary-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Results.Result.Summary }
         *     
         */
        public Results.Result.Summary getSummary() {
            return summary;
        }

        /**
         * Legt den Wert der summary-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Results.Result.Summary }
         *     
         */
        public void setSummary(Results.Result.Summary value) {
            this.summary = value;
        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="quantity">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="costs">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "quantity",
            "costs"
        })
        public static class Defectivegoods {

            @XmlElement(required = true)
            protected Results.Result.Defectivegoods.Quantity quantity;
            @XmlElement(required = true)
            protected Results.Result.Defectivegoods.Costs costs;

            /**
             * Ruft den Wert der quantity-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.Defectivegoods.Quantity }
             *     
             */
            public Results.Result.Defectivegoods.Quantity getQuantity() {
                return quantity;
            }

            /**
             * Legt den Wert der quantity-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.Defectivegoods.Quantity }
             *     
             */
            public void setQuantity(Results.Result.Defectivegoods.Quantity value) {
                this.quantity = value;
            }

            /**
             * Ruft den Wert der costs-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.Defectivegoods.Costs }
             *     
             */
            public Results.Result.Defectivegoods.Costs getCosts() {
                return costs;
            }

            /**
             * Legt den Wert der costs-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.Defectivegoods.Costs }
             *     
             */
            public void setCosts(Results.Result.Defectivegoods.Costs value) {
                this.costs = value;
            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Costs {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected String current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected String all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCurrent(String value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAll(String value) {
                    this.all = value;
                }

            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Quantity {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected Byte current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected Byte all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setCurrent(Byte value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setAll(Byte value) {
                    this.all = value;
                }

            }

        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="profit">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="contractpenalty">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "profit",
            "contractpenalty"
        })
        public static class Directsale {

            @XmlElement(required = true)
            protected Results.Result.Directsale.Profit profit;
            @XmlElement(required = true)
            protected Results.Result.Directsale.Contractpenalty contractpenalty;

            /**
             * Ruft den Wert der profit-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.Directsale.Profit }
             *     
             */
            public Results.Result.Directsale.Profit getProfit() {
                return profit;
            }

            /**
             * Legt den Wert der profit-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.Directsale.Profit }
             *     
             */
            public void setProfit(Results.Result.Directsale.Profit value) {
                this.profit = value;
            }

            /**
             * Ruft den Wert der contractpenalty-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.Directsale.Contractpenalty }
             *     
             */
            public Results.Result.Directsale.Contractpenalty getContractpenalty() {
                return contractpenalty;
            }

            /**
             * Legt den Wert der contractpenalty-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.Directsale.Contractpenalty }
             *     
             */
            public void setContractpenalty(Results.Result.Directsale.Contractpenalty value) {
                this.contractpenalty = value;
            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Contractpenalty {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected String current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected String all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCurrent(String value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAll(String value) {
                    this.all = value;
                }

            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Profit {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected String current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected String all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCurrent(String value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAll(String value) {
                    this.all = value;
                }

            }

        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="capacity">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}int" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}int" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="possiblecapacity">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}int" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}int" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="relpossiblenormalcapacity">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="productivetime">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}int" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}int" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="effiency">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="sellwish">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}short" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}short" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="salesquantity">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}short" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}short" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="deliveryreliability">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="idletime">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}short" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}int" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="idletimecosts">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="storevalue">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="storagecosts">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "capacity",
            "possiblecapacity",
            "relpossiblenormalcapacity",
            "productivetime",
            "effiency",
            "sellwish",
            "salesquantity",
            "deliveryreliability",
            "idletime",
            "idletimecosts",
            "storevalue",
            "storagecosts"
        })
        public static class General {

            @XmlElement(required = true)
            protected Results.Result.General.Capacity capacity;
            @XmlElement(required = true)
            protected Results.Result.General.Possiblecapacity possiblecapacity;
            @XmlElement(required = true)
            protected Results.Result.General.Relpossiblenormalcapacity relpossiblenormalcapacity;
            @XmlElement(required = true)
            protected Results.Result.General.Productivetime productivetime;
            @XmlElement(required = true)
            protected Results.Result.General.Effiency effiency;
            @XmlElement(required = true)
            protected Results.Result.General.Sellwish sellwish;
            @XmlElement(required = true)
            protected Results.Result.General.Salesquantity salesquantity;
            @XmlElement(required = true)
            protected Results.Result.General.Deliveryreliability deliveryreliability;
            @XmlElement(required = true)
            protected Results.Result.General.Idletime idletime;
            @XmlElement(required = true)
            protected Results.Result.General.Idletimecosts idletimecosts;
            @XmlElement(required = true)
            protected Results.Result.General.Storevalue storevalue;
            @XmlElement(required = true)
            protected Results.Result.General.Storagecosts storagecosts;

            /**
             * Ruft den Wert der capacity-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.General.Capacity }
             *     
             */
            public Results.Result.General.Capacity getCapacity() {
                return capacity;
            }

            /**
             * Legt den Wert der capacity-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.General.Capacity }
             *     
             */
            public void setCapacity(Results.Result.General.Capacity value) {
                this.capacity = value;
            }

            /**
             * Ruft den Wert der possiblecapacity-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.General.Possiblecapacity }
             *     
             */
            public Results.Result.General.Possiblecapacity getPossiblecapacity() {
                return possiblecapacity;
            }

            /**
             * Legt den Wert der possiblecapacity-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.General.Possiblecapacity }
             *     
             */
            public void setPossiblecapacity(Results.Result.General.Possiblecapacity value) {
                this.possiblecapacity = value;
            }

            /**
             * Ruft den Wert der relpossiblenormalcapacity-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.General.Relpossiblenormalcapacity }
             *     
             */
            public Results.Result.General.Relpossiblenormalcapacity getRelpossiblenormalcapacity() {
                return relpossiblenormalcapacity;
            }

            /**
             * Legt den Wert der relpossiblenormalcapacity-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.General.Relpossiblenormalcapacity }
             *     
             */
            public void setRelpossiblenormalcapacity(Results.Result.General.Relpossiblenormalcapacity value) {
                this.relpossiblenormalcapacity = value;
            }

            /**
             * Ruft den Wert der productivetime-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.General.Productivetime }
             *     
             */
            public Results.Result.General.Productivetime getProductivetime() {
                return productivetime;
            }

            /**
             * Legt den Wert der productivetime-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.General.Productivetime }
             *     
             */
            public void setProductivetime(Results.Result.General.Productivetime value) {
                this.productivetime = value;
            }

            /**
             * Ruft den Wert der effiency-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.General.Effiency }
             *     
             */
            public Results.Result.General.Effiency getEffiency() {
                return effiency;
            }

            /**
             * Legt den Wert der effiency-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.General.Effiency }
             *     
             */
            public void setEffiency(Results.Result.General.Effiency value) {
                this.effiency = value;
            }

            /**
             * Ruft den Wert der sellwish-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.General.Sellwish }
             *     
             */
            public Results.Result.General.Sellwish getSellwish() {
                return sellwish;
            }

            /**
             * Legt den Wert der sellwish-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.General.Sellwish }
             *     
             */
            public void setSellwish(Results.Result.General.Sellwish value) {
                this.sellwish = value;
            }

            /**
             * Ruft den Wert der salesquantity-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.General.Salesquantity }
             *     
             */
            public Results.Result.General.Salesquantity getSalesquantity() {
                return salesquantity;
            }

            /**
             * Legt den Wert der salesquantity-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.General.Salesquantity }
             *     
             */
            public void setSalesquantity(Results.Result.General.Salesquantity value) {
                this.salesquantity = value;
            }

            /**
             * Ruft den Wert der deliveryreliability-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.General.Deliveryreliability }
             *     
             */
            public Results.Result.General.Deliveryreliability getDeliveryreliability() {
                return deliveryreliability;
            }

            /**
             * Legt den Wert der deliveryreliability-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.General.Deliveryreliability }
             *     
             */
            public void setDeliveryreliability(Results.Result.General.Deliveryreliability value) {
                this.deliveryreliability = value;
            }

            /**
             * Ruft den Wert der idletime-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.General.Idletime }
             *     
             */
            public Results.Result.General.Idletime getIdletime() {
                return idletime;
            }

            /**
             * Legt den Wert der idletime-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.General.Idletime }
             *     
             */
            public void setIdletime(Results.Result.General.Idletime value) {
                this.idletime = value;
            }

            /**
             * Ruft den Wert der idletimecosts-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.General.Idletimecosts }
             *     
             */
            public Results.Result.General.Idletimecosts getIdletimecosts() {
                return idletimecosts;
            }

            /**
             * Legt den Wert der idletimecosts-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.General.Idletimecosts }
             *     
             */
            public void setIdletimecosts(Results.Result.General.Idletimecosts value) {
                this.idletimecosts = value;
            }

            /**
             * Ruft den Wert der storevalue-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.General.Storevalue }
             *     
             */
            public Results.Result.General.Storevalue getStorevalue() {
                return storevalue;
            }

            /**
             * Legt den Wert der storevalue-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.General.Storevalue }
             *     
             */
            public void setStorevalue(Results.Result.General.Storevalue value) {
                this.storevalue = value;
            }

            /**
             * Ruft den Wert der storagecosts-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.General.Storagecosts }
             *     
             */
            public Results.Result.General.Storagecosts getStoragecosts() {
                return storagecosts;
            }

            /**
             * Legt den Wert der storagecosts-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.General.Storagecosts }
             *     
             */
            public void setStoragecosts(Results.Result.General.Storagecosts value) {
                this.storagecosts = value;
            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}int" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}int" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Capacity {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected Integer current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected Integer all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setCurrent(Integer value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setAll(Integer value) {
                    this.all = value;
                }

            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Deliveryreliability {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected String current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected Byte all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCurrent(String value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setAll(Byte value) {
                    this.all = value;
                }

            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Effiency {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected String current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected Byte all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCurrent(String value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setAll(Byte value) {
                    this.all = value;
                }

            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}short" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}int" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Idletime {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected Short current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected Integer all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setCurrent(Short value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setAll(Integer value) {
                    this.all = value;
                }

            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Idletimecosts {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected String current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected String all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCurrent(String value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAll(String value) {
                    this.all = value;
                }

            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}int" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}int" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Possiblecapacity {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected Integer current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected Integer all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setCurrent(Integer value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setAll(Integer value) {
                    this.all = value;
                }

            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}int" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}int" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Productivetime {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected Integer current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected Integer all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setCurrent(Integer value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setAll(Integer value) {
                    this.all = value;
                }

            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Relpossiblenormalcapacity {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected String current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected Byte all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCurrent(String value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setAll(Byte value) {
                    this.all = value;
                }

            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}short" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}short" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Salesquantity {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected Short current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected Short all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setCurrent(Short value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setAll(Short value) {
                    this.all = value;
                }

            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}short" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}short" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Sellwish {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected Short current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected Short all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setCurrent(Short value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setAll(Short value) {
                    this.all = value;
                }

            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Storagecosts {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected String current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected String all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCurrent(String value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAll(String value) {
                    this.all = value;
                }

            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Storevalue {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected String current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected Byte all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCurrent(String value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setAll(Byte value) {
                    this.all = value;
                }

            }

        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="profit">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "profit"
        })
        public static class Marketplacesale {

            @XmlElement(required = true)
            protected Results.Result.Marketplacesale.Profit profit;

            /**
             * Ruft den Wert der profit-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.Marketplacesale.Profit }
             *     
             */
            public Results.Result.Marketplacesale.Profit getProfit() {
                return profit;
            }

            /**
             * Legt den Wert der profit-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.Marketplacesale.Profit }
             *     
             */
            public void setProfit(Results.Result.Marketplacesale.Profit value) {
                this.profit = value;
            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Profit {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected String current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected String all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCurrent(String value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAll(String value) {
                    this.all = value;
                }

            }

        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="salesprice">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="profit">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="profitperunit">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "salesprice",
            "profit",
            "profitperunit"
        })
        public static class Normalsale {

            @XmlElement(required = true)
            protected Results.Result.Normalsale.Salesprice salesprice;
            @XmlElement(required = true)
            protected Results.Result.Normalsale.Profit profit;
            @XmlElement(required = true)
            protected Results.Result.Normalsale.Profitperunit profitperunit;

            /**
             * Ruft den Wert der salesprice-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.Normalsale.Salesprice }
             *     
             */
            public Results.Result.Normalsale.Salesprice getSalesprice() {
                return salesprice;
            }

            /**
             * Legt den Wert der salesprice-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.Normalsale.Salesprice }
             *     
             */
            public void setSalesprice(Results.Result.Normalsale.Salesprice value) {
                this.salesprice = value;
            }

            /**
             * Ruft den Wert der profit-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.Normalsale.Profit }
             *     
             */
            public Results.Result.Normalsale.Profit getProfit() {
                return profit;
            }

            /**
             * Legt den Wert der profit-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.Normalsale.Profit }
             *     
             */
            public void setProfit(Results.Result.Normalsale.Profit value) {
                this.profit = value;
            }

            /**
             * Ruft den Wert der profitperunit-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.Normalsale.Profitperunit }
             *     
             */
            public Results.Result.Normalsale.Profitperunit getProfitperunit() {
                return profitperunit;
            }

            /**
             * Legt den Wert der profitperunit-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.Normalsale.Profitperunit }
             *     
             */
            public void setProfitperunit(Results.Result.Normalsale.Profitperunit value) {
                this.profitperunit = value;
            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Profit {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected String current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected String all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCurrent(String value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAll(String value) {
                    this.all = value;
                }

            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Profitperunit {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected String current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected Byte all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCurrent(String value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setAll(Byte value) {
                    this.all = value;
                }

            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Salesprice {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected String current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected Byte all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCurrent(String value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setAll(Byte value) {
                    this.all = value;
                }

            }

        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="profit">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "profit"
        })
        public static class Summary {

            @XmlElement(required = true)
            protected Results.Result.Summary.Profit profit;

            /**
             * Ruft den Wert der profit-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Result.Summary.Profit }
             *     
             */
            public Results.Result.Summary.Profit getProfit() {
                return profit;
            }

            /**
             * Legt den Wert der profit-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Result.Summary.Profit }
             *     
             */
            public void setProfit(Results.Result.Summary.Profit value) {
                this.profit = value;
            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="average" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Profit {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "current")
                protected String current;
                @XmlAttribute(name = "average")
                protected String average;
                @XmlAttribute(name = "all")
                protected String all;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der current-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCurrent() {
                    return current;
                }

                /**
                 * Legt den Wert der current-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCurrent(String value) {
                    this.current = value;
                }

                /**
                 * Ruft den Wert der average-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAverage() {
                    return average;
                }

                /**
                 * Legt den Wert der average-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAverage(String value) {
                    this.average = value;
                }

                /**
                 * Ruft den Wert der all-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAll() {
                    return all;
                }

                /**
                 * Legt den Wert der all-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAll(String value) {
                    this.all = value;
                }

            }

        }

    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="missingpart" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="waitinglist">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                           &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                           &lt;attribute name="firstbatch" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                           &lt;attribute name="lastbatch" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                           &lt;attribute name="item" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                           &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "missingpart"
    })
    public static class Waitingliststock {

        protected List<Results.Waitingliststock.Missingpart> missingpart;

        /**
         * Gets the value of the missingpart property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the missingpart property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMissingpart().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Results.Waitingliststock.Missingpart }
         * 
         * 
         */
        public List<Results.Waitingliststock.Missingpart> getMissingpart() {
            if (missingpart == null) {
                missingpart = new ArrayList<Results.Waitingliststock.Missingpart>();
            }
            return this.missingpart;
        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="waitinglist">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                 &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                 &lt;attribute name="firstbatch" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                 &lt;attribute name="lastbatch" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                 &lt;attribute name="item" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                 &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "waitinglist"
        })
        public static class Missingpart {

            @XmlElement(required = true)
            protected Results.Waitingliststock.Missingpart.Waitinglist waitinglist;
            @XmlAttribute(name = "id")
            protected Byte id;

            /**
             * Ruft den Wert der waitinglist-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Results.Waitingliststock.Missingpart.Waitinglist }
             *     
             */
            public Results.Waitingliststock.Missingpart.Waitinglist getWaitinglist() {
                return waitinglist;
            }

            /**
             * Legt den Wert der waitinglist-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Waitingliststock.Missingpart.Waitinglist }
             *     
             */
            public void setWaitinglist(Results.Waitingliststock.Missingpart.Waitinglist value) {
                this.waitinglist = value;
            }

            /**
             * Ruft den Wert der id-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getId() {
                return id;
            }

            /**
             * Legt den Wert der id-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setId(Byte value) {
                this.id = value;
            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="firstbatch" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="lastbatch" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="item" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Waitinglist {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "period")
                protected Byte period;
                @XmlAttribute(name = "order")
                protected Byte order;
                @XmlAttribute(name = "firstbatch")
                protected Byte firstbatch;
                @XmlAttribute(name = "lastbatch")
                protected Byte lastbatch;
                @XmlAttribute(name = "item")
                protected Byte item;
                @XmlAttribute(name = "amount")
                protected Byte amount;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der period-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getPeriod() {
                    return period;
                }

                /**
                 * Legt den Wert der period-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setPeriod(Byte value) {
                    this.period = value;
                }

                /**
                 * Ruft den Wert der order-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getOrder() {
                    return order;
                }

                /**
                 * Legt den Wert der order-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setOrder(Byte value) {
                    this.order = value;
                }

                /**
                 * Ruft den Wert der firstbatch-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getFirstbatch() {
                    return firstbatch;
                }

                /**
                 * Legt den Wert der firstbatch-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setFirstbatch(Byte value) {
                    this.firstbatch = value;
                }

                /**
                 * Ruft den Wert der lastbatch-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getLastbatch() {
                    return lastbatch;
                }

                /**
                 * Legt den Wert der lastbatch-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setLastbatch(Byte value) {
                    this.lastbatch = value;
                }

                /**
                 * Ruft den Wert der item-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getItem() {
                    return item;
                }

                /**
                 * Legt den Wert der item-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setItem(Byte value) {
                    this.item = value;
                }

                /**
                 * Ruft den Wert der amount-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getAmount() {
                    return amount;
                }

                /**
                 * Legt den Wert der amount-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setAmount(Byte value) {
                    this.amount = value;
                }

            }

        }

    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="workplace" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="waitinglist" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                           &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                           &lt;attribute name="firstbatch" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                           &lt;attribute name="lastbatch" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                           &lt;attribute name="item" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                           &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                           &lt;attribute name="timeneed" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="timeneed" type="{http://www.w3.org/2001/XMLSchema}short" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "workplace"
    })
    public static class Waitinglistworkstations {

        protected List<Results.Waitinglistworkstations.Workplace> workplace;

        /**
         * Gets the value of the workplace property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the workplace property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getWorkplace().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Results.Waitinglistworkstations.Workplace }
         * 
         * 
         */
        public List<Results.Waitinglistworkstations.Workplace> getWorkplace() {
            if (workplace == null) {
                workplace = new ArrayList<Results.Waitinglistworkstations.Workplace>();
            }
            return this.workplace;
        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="waitinglist" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                 &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                 &lt;attribute name="firstbatch" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                 &lt;attribute name="lastbatch" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                 &lt;attribute name="item" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                 &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}short" />
         *                 &lt;attribute name="timeneed" type="{http://www.w3.org/2001/XMLSchema}short" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="timeneed" type="{http://www.w3.org/2001/XMLSchema}short" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "content"
        })
        public static class Workplace {

            @XmlElementRef(name = "waitinglist", type = JAXBElement.class, required = false)
            @XmlMixed
            protected List<Serializable> content;
            @XmlAttribute(name = "id")
            protected Byte id;
            @XmlAttribute(name = "timeneed")
            protected Short timeneed;

            /**
             * Gets the value of the content property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the content property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getContent().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link JAXBElement }{@code <}{@link Results.Waitinglistworkstations.Workplace.Waitinglist }{@code >}
             * {@link String }
             * 
             * 
             */
            public List<Serializable> getContent() {
                if (content == null) {
                    content = new ArrayList<Serializable>();
                }
                return this.content;
            }

            /**
             * Ruft den Wert der id-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getId() {
                return id;
            }

            /**
             * Legt den Wert der id-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setId(Byte value) {
                this.id = value;
            }

            /**
             * Ruft den Wert der timeneed-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getTimeneed() {
                return timeneed;
            }

            /**
             * Legt den Wert der timeneed-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setTimeneed(Short value) {
                this.timeneed = value;
            }


            /**
             * <p>Java-Klasse f�r anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="firstbatch" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="lastbatch" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="item" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}short" />
             *       &lt;attribute name="timeneed" type="{http://www.w3.org/2001/XMLSchema}short" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Waitinglist {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "period")
                protected Byte period;
                @XmlAttribute(name = "order")
                protected Byte order;
                @XmlAttribute(name = "firstbatch")
                protected Byte firstbatch;
                @XmlAttribute(name = "lastbatch")
                protected Byte lastbatch;
                @XmlAttribute(name = "item")
                protected Byte item;
                @XmlAttribute(name = "amount")
                protected Short amount;
                @XmlAttribute(name = "timeneed")
                protected Short timeneed;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der period-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getPeriod() {
                    return period;
                }

                /**
                 * Legt den Wert der period-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setPeriod(Byte value) {
                    this.period = value;
                }

                /**
                 * Ruft den Wert der order-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getOrder() {
                    return order;
                }

                /**
                 * Legt den Wert der order-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setOrder(Byte value) {
                    this.order = value;
                }

                /**
                 * Ruft den Wert der firstbatch-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getFirstbatch() {
                    return firstbatch;
                }

                /**
                 * Legt den Wert der firstbatch-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setFirstbatch(Byte value) {
                    this.firstbatch = value;
                }

                /**
                 * Ruft den Wert der lastbatch-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getLastbatch() {
                    return lastbatch;
                }

                /**
                 * Legt den Wert der lastbatch-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setLastbatch(Byte value) {
                    this.lastbatch = value;
                }

                /**
                 * Ruft den Wert der item-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getItem() {
                    return item;
                }

                /**
                 * Legt den Wert der item-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setItem(Byte value) {
                    this.item = value;
                }

                /**
                 * Ruft den Wert der amount-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getAmount() {
                    return amount;
                }

                /**
                 * Legt den Wert der amount-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setAmount(Short value) {
                    this.amount = value;
                }

                /**
                 * Ruft den Wert der timeneed-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getTimeneed() {
                    return timeneed;
                }

                /**
                 * Legt den Wert der timeneed-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setTimeneed(Short value) {
                    this.timeneed = value;
                }

            }

        }

    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="article" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                 &lt;attribute name="startamount" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                 &lt;attribute name="pct" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="price" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="stockvalue" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="totalstockvalue" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "article",
        "totalstockvalue"
    })
    public static class Warehousestock {

        protected List<Results.Warehousestock.Article> article;
        @XmlElement(required = true)
        protected String totalstockvalue;

        /**
         * Gets the value of the article property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the article property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getArticle().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Results.Warehousestock.Article }
         * 
         * 
         */
        public List<Results.Warehousestock.Article> getArticle() {
            if (article == null) {
                article = new ArrayList<Results.Warehousestock.Article>();
            }
            return this.article;
        }

        /**
         * Ruft den Wert der totalstockvalue-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTotalstockvalue() {
            return totalstockvalue;
        }

        /**
         * Legt den Wert der totalstockvalue-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTotalstockvalue(String value) {
            this.totalstockvalue = value;
        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}short" />
         *       &lt;attribute name="startamount" type="{http://www.w3.org/2001/XMLSchema}short" />
         *       &lt;attribute name="pct" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="price" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="stockvalue" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Article {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "id")
            protected Byte id;
            @XmlAttribute(name = "amount")
            protected Short amount;
            @XmlAttribute(name = "startamount")
            protected Short startamount;
            @XmlAttribute(name = "pct")
            protected String pct;
            @XmlAttribute(name = "price")
            protected String price;
            @XmlAttribute(name = "stockvalue")
            protected String stockvalue;

            /**
             * Ruft den Wert der value-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Legt den Wert der value-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Ruft den Wert der id-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getId() {
                return id;
            }

            /**
             * Legt den Wert der id-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setId(Byte value) {
                this.id = value;
            }

            /**
             * Ruft den Wert der amount-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getAmount() {
                return amount;
            }

            /**
             * Legt den Wert der amount-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setAmount(Short value) {
                this.amount = value;
            }

            /**
             * Ruft den Wert der startamount-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getStartamount() {
                return startamount;
            }

            /**
             * Legt den Wert der startamount-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setStartamount(Short value) {
                this.startamount = value;
            }

            /**
             * Ruft den Wert der pct-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPct() {
                return pct;
            }

            /**
             * Legt den Wert der pct-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPct(String value) {
                this.pct = value;
            }

            /**
             * Ruft den Wert der price-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPrice() {
                return price;
            }

            /**
             * Legt den Wert der price-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPrice(String value) {
                this.price = value;
            }

            /**
             * Ruft den Wert der stockvalue-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStockvalue() {
                return stockvalue;
            }

            /**
             * Legt den Wert der stockvalue-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStockvalue(String value) {
                this.stockvalue = value;
            }

        }

    }

}
