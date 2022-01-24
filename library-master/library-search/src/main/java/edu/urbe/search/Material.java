/**
 * Material.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.urbe.search;

public class Material  implements java.io.Serializable {
    private int asentamiento;

    private edu.urbe.search.Content[] content;

    private int id;

    private int publica;

    private edu.urbe.search.TypeMaterial type;

    public Material() {
    }

    public Material(
           int asentamiento,
           edu.urbe.search.Content[] content,
           int id,
           int publica,
           edu.urbe.search.TypeMaterial type) {
           this.asentamiento = asentamiento;
           this.content = content;
           this.id = id;
           this.publica = publica;
           this.type = type;
    }


    /**
     * Gets the asentamiento value for this Material.
     * 
     * @return asentamiento
     */
    public int getAsentamiento() {
        return asentamiento;
    }


    /**
     * Sets the asentamiento value for this Material.
     * 
     * @param asentamiento
     */
    public void setAsentamiento(int asentamiento) {
        this.asentamiento = asentamiento;
    }


    /**
     * Gets the content value for this Material.
     * 
     * @return content
     */
    public edu.urbe.search.Content[] getContent() {
        return content;
    }


    /**
     * Sets the content value for this Material.
     * 
     * @param content
     */
    public void setContent(edu.urbe.search.Content[] content) {
        this.content = content;
    }

    public edu.urbe.search.Content getContent(int i) {
        return this.content[i];
    }

    public void setContent(int i, edu.urbe.search.Content _value) {
        this.content[i] = _value;
    }


    /**
     * Gets the id value for this Material.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Material.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the publica value for this Material.
     * 
     * @return publica
     */
    public int getPublica() {
        return publica;
    }


    /**
     * Sets the publica value for this Material.
     * 
     * @param publica
     */
    public void setPublica(int publica) {
        this.publica = publica;
    }


    /**
     * Gets the type value for this Material.
     * 
     * @return type
     */
    public edu.urbe.search.TypeMaterial getType() {
        return type;
    }


    /**
     * Sets the type value for this Material.
     * 
     * @param type
     */
    public void setType(edu.urbe.search.TypeMaterial type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Material)) return false;
        Material other = (Material) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.asentamiento == other.getAsentamiento() &&
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              java.util.Arrays.equals(this.content, other.getContent()))) &&
            this.id == other.getId() &&
            this.publica == other.getPublica() &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getAsentamiento();
        if (getContent() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContent());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContent(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getId();
        _hashCode += getPublica();
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Material.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.web.urbe.edu/", "material"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("asentamiento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "asentamiento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("", "content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.web.urbe.edu/", "content"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publica");
        elemField.setXmlName(new javax.xml.namespace.QName("", "publica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.web.urbe.edu/", "typeMaterial"));
        elemField.setMinOccurs(0);
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
