/**
 * TypeMaterial.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.urbe.search;

public class TypeMaterial implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected TypeMaterial(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _LIBROS = "LIBROS";
    public static final java.lang.String _PUBLICACIONES_PERIODICAS = "PUBLICACIONES_PERIODICAS";
    public static final java.lang.String _TESIS = "TESIS";
    public static final java.lang.String _VIDEOS = "VIDEOS";
    public static final java.lang.String _DOCUMENTOS_LEGALES = "DOCUMENTOS_LEGALES";
    public static final java.lang.String _ARTICULOS = "ARTICULOS";
    public static final java.lang.String _GACETAS_OFICALES = "GACETAS_OFICALES";
    public static final java.lang.String _INSTITUCIONAL = "INSTITUCIONAL";
    public static final java.lang.String _PUBLICACIONES = "PUBLICACIONES";
    public static final java.lang.String _PONENCIAS = "PONENCIAS";
    public static final java.lang.String _EVENTOS = "EVENTOS";
    public static final TypeMaterial LIBROS = new TypeMaterial(_LIBROS);
    public static final TypeMaterial PUBLICACIONES_PERIODICAS = new TypeMaterial(_PUBLICACIONES_PERIODICAS);
    public static final TypeMaterial TESIS = new TypeMaterial(_TESIS);
    public static final TypeMaterial VIDEOS = new TypeMaterial(_VIDEOS);
    public static final TypeMaterial DOCUMENTOS_LEGALES = new TypeMaterial(_DOCUMENTOS_LEGALES);
    public static final TypeMaterial ARTICULOS = new TypeMaterial(_ARTICULOS);
    public static final TypeMaterial GACETAS_OFICALES = new TypeMaterial(_GACETAS_OFICALES);
    public static final TypeMaterial INSTITUCIONAL = new TypeMaterial(_INSTITUCIONAL);
    public static final TypeMaterial PUBLICACIONES = new TypeMaterial(_PUBLICACIONES);
    public static final TypeMaterial PONENCIAS = new TypeMaterial(_PONENCIAS);
    public static final TypeMaterial EVENTOS = new TypeMaterial(_EVENTOS);
    public java.lang.String getValue() { return _value_;}
    public static TypeMaterial fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        TypeMaterial enumeration = (TypeMaterial)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static TypeMaterial fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TypeMaterial.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.web.urbe.edu/", "typeMaterial"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
