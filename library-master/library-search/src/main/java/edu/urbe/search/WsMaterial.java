/**
 * WsMaterial.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.urbe.search;

public class WsMaterial  extends edu.urbe.search.Material  implements java.io.Serializable {
    private int typeMaterial;

    public WsMaterial() {
    }

    public WsMaterial(
           int asentamiento,
           edu.urbe.search.Content[] content,
           int id,
           int publica,
           edu.urbe.search.TypeMaterial type,
           int typeMaterial) {
        super(
            asentamiento,
            content,
            id,
            publica,
            type);
        this.typeMaterial = typeMaterial;
    }


    /**
     * Gets the typeMaterial value for this WsMaterial.
     * 
     * @return typeMaterial
     */
    public int getTypeMaterial() {
        return typeMaterial;
    }


    /**
     * Sets the typeMaterial value for this WsMaterial.
     * 
     * @param typeMaterial
     */
    public void setTypeMaterial(int typeMaterial) {
        this.typeMaterial = typeMaterial;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WsMaterial)) return false;
        WsMaterial other = (WsMaterial) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.typeMaterial == other.getTypeMaterial();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        _hashCode += getTypeMaterial();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WsMaterial.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.web.urbe.edu/", "wsMaterial"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("typeMaterial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "typeMaterial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
