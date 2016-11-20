package client.distributeur.ws;

import client.distributeur.ws.*;
import org.apache.axis.client.*;

public class DistributeurEditeurWSProxy implements DistributeurEditeurWS_PortType {
  private String _endpoint = null;
  private DistributeurEditeurWS_PortType distributeurEditeurWS_PortType = null;
  
  public DistributeurEditeurWSProxy() {
    _initDistributeurEditeurWSProxy();
  }
  
  public DistributeurEditeurWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initDistributeurEditeurWSProxy();
  }
  
  private void _initDistributeurEditeurWSProxy() {
    try {
      distributeurEditeurWS_PortType = (new DistributeurEditeurWS_ServiceLocator()).getDistributeurEditeurWSPort();
      if (distributeurEditeurWS_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)distributeurEditeurWS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)distributeurEditeurWS_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (distributeurEditeurWS_PortType != null)
      ((javax.xml.rpc.Stub)distributeurEditeurWS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DistributeurEditeurWS_PortType getDistributeurEditeurWS_PortType() {
    if (distributeurEditeurWS_PortType == null)
      _initDistributeurEditeurWSProxy();
    return distributeurEditeurWS_PortType;
  }
  
  public java.lang.String connection(java.lang.String mail, java.lang.String mdp) throws java.rmi.RemoteException{
    if (distributeurEditeurWS_PortType == null)
      _initDistributeurEditeurWSProxy();
    return distributeurEditeurWS_PortType.connection(mail, mdp);
  }
  
  public java.lang.String getListTitre() throws java.rmi.RemoteException{
    if (distributeurEditeurWS_PortType == null)
      _initDistributeurEditeurWSProxy();
    return distributeurEditeurWS_PortType.getListTitre();
  }
  
  public java.lang.String validerContrat(java.lang.Integer contratId) throws java.rmi.RemoteException{
    if (distributeurEditeurWS_PortType == null)
      _initDistributeurEditeurWSProxy();
    return distributeurEditeurWS_PortType.validerContrat(contratId);
  }
  
  public java.lang.String getListeEditeur() throws java.rmi.RemoteException{
    if (distributeurEditeurWS_PortType == null)
      _initDistributeurEditeurWSProxy();
    return distributeurEditeurWS_PortType.getListeEditeur();
  }
  
  public java.lang.String listeContratRecepisse(java.lang.Integer distributeurId) throws java.rmi.RemoteException{
    if (distributeurEditeurWS_PortType == null)
      _initDistributeurEditeurWSProxy();
    return distributeurEditeurWS_PortType.listeContratRecepisse(distributeurId);
  }
  
  public java.lang.String listContratAValider(java.lang.Integer distributeurId) throws java.rmi.RemoteException{
    if (distributeurEditeurWS_PortType == null)
      _initDistributeurEditeurWSProxy();
    return distributeurEditeurWS_PortType.listContratAValider(distributeurId);
  }
  
  public java.lang.String validerContratEditeur(java.lang.Integer numContrat) throws java.rmi.RemoteException{
    if (distributeurEditeurWS_PortType == null)
      _initDistributeurEditeurWSProxy();
    return distributeurEditeurWS_PortType.validerContratEditeur(numContrat);
  }
  
  public java.lang.String listeContratAttenteCout(java.lang.Integer editeurId) throws java.rmi.RemoteException{
    if (distributeurEditeurWS_PortType == null)
      _initDistributeurEditeurWSProxy();
    return distributeurEditeurWS_PortType.listeContratAttenteCout(editeurId);
  }
  
  public java.lang.String listeContratAValiderEditeur(java.lang.Integer editeurId) throws java.rmi.RemoteException{
    if (distributeurEditeurWS_PortType == null)
      _initDistributeurEditeurWSProxy();
    return distributeurEditeurWS_PortType.listeContratAValiderEditeur(editeurId);
  }
  
  public java.lang.String refusContrat(java.lang.Integer contratId) throws java.rmi.RemoteException{
    if (distributeurEditeurWS_PortType == null)
      _initDistributeurEditeurWSProxy();
    return distributeurEditeurWS_PortType.refusContrat(contratId);
  }
  
  public java.lang.String coutContrat(java.lang.Integer contratId, float cout) throws java.rmi.RemoteException{
    if (distributeurEditeurWS_PortType == null)
      _initDistributeurEditeurWSProxy();
    return distributeurEditeurWS_PortType.coutContrat(contratId, cout);
  }
  
  public java.lang.String envoiRecepisse(java.lang.Integer contratId, java.lang.String recepisse) throws java.rmi.RemoteException{
    if (distributeurEditeurWS_PortType == null)
      _initDistributeurEditeurWSProxy();
    return distributeurEditeurWS_PortType.envoiRecepisse(contratId, recepisse);
  }
  
  public java.lang.String demandeContrat(java.lang.Integer distributeurId, java.lang.Integer editeurId, java.lang.Integer titreId, java.lang.Integer nbCopies, java.lang.Integer duree) throws java.rmi.RemoteException{
    if (distributeurEditeurWS_PortType == null)
      _initDistributeurEditeurWSProxy();
    return distributeurEditeurWS_PortType.demandeContrat(distributeurId, editeurId, titreId, nbCopies, duree);
  }
  
  public java.lang.String inscription(java.lang.String mail, java.lang.String nom) throws java.rmi.RemoteException{
    if (distributeurEditeurWS_PortType == null)
      _initDistributeurEditeurWSProxy();
    return distributeurEditeurWS_PortType.inscription(mail, nom);
  }
  
  
}