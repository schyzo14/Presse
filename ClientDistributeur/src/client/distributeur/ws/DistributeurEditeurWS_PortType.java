/**
 * DistributeurEditeurWS_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client.distributeur.ws;

public interface DistributeurEditeurWS_PortType extends java.rmi.Remote {
    public java.lang.String connection(java.lang.String mail, java.lang.String mdp) throws java.rmi.RemoteException;
    public java.lang.String getListTitre() throws java.rmi.RemoteException;
    public java.lang.String validerContrat(java.lang.Integer contratId) throws java.rmi.RemoteException;
    public java.lang.String getListeEditeur() throws java.rmi.RemoteException;
    public java.lang.String listeContratRecepisse(java.lang.Integer distributeurId) throws java.rmi.RemoteException;
    public java.lang.String listContratAValider(java.lang.Integer distributeurId) throws java.rmi.RemoteException;
    public java.lang.String validerContratEditeur(java.lang.Integer numContrat) throws java.rmi.RemoteException;
    public java.lang.String listeContratAttenteCout(java.lang.Integer editeurId) throws java.rmi.RemoteException;
    public java.lang.String listeContratAValiderEditeur(java.lang.Integer editeurId) throws java.rmi.RemoteException;
    public java.lang.String refusContrat(java.lang.Integer contratId) throws java.rmi.RemoteException;
    public java.lang.String coutContrat(java.lang.Integer contratId, float cout) throws java.rmi.RemoteException;
    public java.lang.String envoiRecepisse(java.lang.Integer contratId, java.lang.String recepisse) throws java.rmi.RemoteException;
    public java.lang.String demandeContrat(java.lang.Integer distributeurId, java.lang.Integer editeurId, java.lang.Integer titreId, java.lang.Integer nbCopies, java.lang.Integer duree) throws java.rmi.RemoteException;
    public java.lang.String inscription(java.lang.String mail, java.lang.String nom) throws java.rmi.RemoteException;
}
