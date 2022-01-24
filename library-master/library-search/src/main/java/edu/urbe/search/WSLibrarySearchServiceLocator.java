/**
 * WSLibrarySearchServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.urbe.search;

public class WSLibrarySearchServiceLocator extends org.apache.axis.client.Service implements edu.urbe.search.WSLibrarySearchService {

    public WSLibrarySearchServiceLocator() {
    }


    public WSLibrarySearchServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSLibrarySearchServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSLibrarySearchPort
    private java.lang.String WSLibrarySearchPort_address = "http://gf2-urbe.adm.urbe.edu:8080/WSLibrarySearchService/WSLibrarySearch";

    public java.lang.String getWSLibrarySearchPortAddress() {
        return WSLibrarySearchPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSLibrarySearchPortWSDDServiceName = "WSLibrarySearchPort";

    public java.lang.String getWSLibrarySearchPortWSDDServiceName() {
        return WSLibrarySearchPortWSDDServiceName;
    }

    public void setWSLibrarySearchPortWSDDServiceName(java.lang.String name) {
        WSLibrarySearchPortWSDDServiceName = name;
    }

    public edu.urbe.search.WSLibrarySearch getWSLibrarySearchPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSLibrarySearchPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSLibrarySearchPort(endpoint);
    }

    public edu.urbe.search.WSLibrarySearch getWSLibrarySearchPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            edu.urbe.search.WSLibrarySearchPortBindingStub _stub = new edu.urbe.search.WSLibrarySearchPortBindingStub(portAddress, this);
            _stub.setPortName(getWSLibrarySearchPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSLibrarySearchPortEndpointAddress(java.lang.String address) {
        WSLibrarySearchPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (edu.urbe.search.WSLibrarySearch.class.isAssignableFrom(serviceEndpointInterface)) {
                edu.urbe.search.WSLibrarySearchPortBindingStub _stub = new edu.urbe.search.WSLibrarySearchPortBindingStub(new java.net.URL(WSLibrarySearchPort_address), this);
                _stub.setPortName(getWSLibrarySearchPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WSLibrarySearchPort".equals(inputPortName)) {
            return getWSLibrarySearchPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.web.urbe.edu/", "WSLibrarySearchService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.web.urbe.edu/", "WSLibrarySearchPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSLibrarySearchPort".equals(portName)) {
            setWSLibrarySearchPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
