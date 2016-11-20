/**
 * DistributeurEditeurWS_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client.distributeur.ws;

public class DistributeurEditeurWS_ServiceLocator extends org.apache.axis.client.Service implements DistributeurEditeurWS_Service {

    public DistributeurEditeurWS_ServiceLocator() {
    }


    public DistributeurEditeurWS_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DistributeurEditeurWS_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DistributeurEditeurWSPort
    private java.lang.String DistributeurEditeurWSPort_address = "http://localhost:8080/Web-war/DistributeurEditeurWS";

    public java.lang.String getDistributeurEditeurWSPortAddress() {
        return DistributeurEditeurWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DistributeurEditeurWSPortWSDDServiceName = "DistributeurEditeurWSPort";

    public java.lang.String getDistributeurEditeurWSPortWSDDServiceName() {
        return DistributeurEditeurWSPortWSDDServiceName;
    }

    public void setDistributeurEditeurWSPortWSDDServiceName(java.lang.String name) {
        DistributeurEditeurWSPortWSDDServiceName = name;
    }

    public DistributeurEditeurWS_PortType getDistributeurEditeurWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DistributeurEditeurWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDistributeurEditeurWSPort(endpoint);
    }

    public DistributeurEditeurWS_PortType getDistributeurEditeurWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            DistributeurEditeurWSPortBindingStub _stub = new DistributeurEditeurWSPortBindingStub(portAddress, this);
            _stub.setPortName(getDistributeurEditeurWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDistributeurEditeurWSPortEndpointAddress(java.lang.String address) {
        DistributeurEditeurWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (DistributeurEditeurWS_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                DistributeurEditeurWSPortBindingStub _stub = new DistributeurEditeurWSPortBindingStub(new java.net.URL(DistributeurEditeurWSPort_address), this);
                _stub.setPortName(getDistributeurEditeurWSPortWSDDServiceName());
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
        if ("DistributeurEditeurWSPort".equals(inputPortName)) {
            return getDistributeurEditeurWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://WS/", "DistributeurEditeurWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://WS/", "DistributeurEditeurWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DistributeurEditeurWSPort".equals(portName)) {
            setDistributeurEditeurWSPortEndpointAddress(address);
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
