//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.9-03/31/2009 04:14 PM(snajper)-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.11.01 at 10:45:03 PM EST 
//


package seg.jUCMNav.importexport.z151.generated;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for PluginBinding complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PluginBinding">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}ID"/>
 *         &lt;element name="probability" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="replicationFactor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="in" type="{}InBinding" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="out" type="{}OutBinding" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="plugin" type="{http://www.w3.org/2001/XMLSchema}IDREF"/>
 *         &lt;element name="precondition" type="{}Condition" minOccurs="0"/>
 *         &lt;element name="components" type="{}ComponentBinding" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PluginBinding", propOrder = {
    "id",
    "probability",
    "replicationFactor",
    "in",
    "out",
    "plugin",
    "precondition",
    "components"
})
public class PluginBinding {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlElement(required = true, defaultValue = "100")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger probability;
    @XmlElement(required = true)
    protected String replicationFactor;
    protected List<InBinding> in;
    protected List<OutBinding> out;
    @XmlElement(required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object plugin;
    protected Condition precondition;
    protected List<ComponentBinding> components;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the probability property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getProbability() {
        return probability;
    }

    /**
     * Sets the value of the probability property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setProbability(BigInteger value) {
        this.probability = value;
    }

    /**
     * Gets the value of the replicationFactor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplicationFactor() {
        return replicationFactor;
    }

    /**
     * Sets the value of the replicationFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplicationFactor(String value) {
        this.replicationFactor = value;
    }

    /**
     * Gets the value of the in property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the in property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InBinding }
     * 
     * 
     */
    public List<InBinding> getIn() {
        if (in == null) {
            in = new ArrayList<InBinding>();
        }
        return this.in;
    }

    /**
     * Gets the value of the out property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the out property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOut().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OutBinding }
     * 
     * 
     */
    public List<OutBinding> getOut() {
        if (out == null) {
            out = new ArrayList<OutBinding>();
        }
        return this.out;
    }

    /**
     * Gets the value of the plugin property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getPlugin() {
        return plugin;
    }

    /**
     * Sets the value of the plugin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setPlugin(Object value) {
        this.plugin = value;
    }

    /**
     * Gets the value of the precondition property.
     * 
     * @return
     *     possible object is
     *     {@link Condition }
     *     
     */
    public Condition getPrecondition() {
        return precondition;
    }

    /**
     * Sets the value of the precondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Condition }
     *     
     */
    public void setPrecondition(Condition value) {
        this.precondition = value;
    }

    /**
     * Gets the value of the components property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the components property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComponents().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComponentBinding }
     * 
     * 
     */
    public List<ComponentBinding> getComponents() {
        if (components == null) {
            components = new ArrayList<ComponentBinding>();
        }
        return this.components;
    }

}
