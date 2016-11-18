/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import services.DistributeurBean;
import com.google.gson.Gson;
import services.ContratBean;
import services.EditeurBean;
import services.TitreBean;

/**
 *
 * @author Aurore
 */
@WebService(serviceName = "DistributeurWS")
public class DistributeurWS {
    
    @EJB
    private DistributeurBean distributeurBean;
    
    @EJB
    private EditeurBean editeurBean;
    
    @EJB
    private TitreBean titreBean;
    
    @EJB
    private ContratBean contratBean;

    private Gson gson;

    public DistributeurWS() {
        this.gson = new Gson();
    }

    /**
     * inscription d'un distributeur
     *
     * @param mail	mail du distributeur
     * @param nom	nom du distributeur
     *
     * @return le distributeur
     */
    @WebMethod(operationName="inscription")
    public String inscription(@WebParam(name="mail") String mail, @WebParam(name="nom") String nom) {
        try {
            return this.gson.toJson(this.distributeurBean.inscrire(mail, nom));
        } catch (Throwable e) {
            return this.gson.toJson(e);
        }
    }
    
    /**
     * connection d'un distributeur
     * 
     * @param mail
     * @param mdp
     * 
     * @return le distributeur
     */
    @WebMethod(operationName="connection")
    public String connection(@WebParam(name="mail") String mail, @WebParam(name="mdp") String mdp) {
        try {
            return this.gson.toJson(this.distributeurBean.connecter(mail, mdp));
        } catch (Throwable e) {
            return this.gson.toJson(e);
        }
    }
    
    
    /**
     * recupère la liste des éditeurs
     * 
     * @return la liste des editeurs
     */
    @WebMethod(operationName="getListeEditeur")
    public String getListeEditeur() {
        return this.gson.toJson(this.editeurBean.getListeEditeur());
    }
    
    
    /**
     * récupère la liste des titres
     * 
     * @return la liste des titres
     */
    @WebMethod(operationName="getListTitre")
    public String getListeTitre() {
        return this.gson.toJson(this.titreBean.getListeTitre());
    }

    
    /**
     * demande d'un contrat entre distributeur et éditeur
     *
     * @param titreId	le titre du contrat
     * @param nbCopies	nombre de copies du titre
     * @param duree	duree du contrat
     *
     * @return le contrat
     */
    @WebMethod(operationName="demandeContrat")
    public String demandeContrat(@WebParam(name="distributeurId") Integer distributeurId, @WebParam(name="editeurId") Integer editeurId, @WebParam(name="titreId") Integer titreId, 
            @WebParam(name="nbCopies") Integer nbCopies, @WebParam(name="duree") Integer duree) {
        return this.gson.toJson(this.contratBean.créerContrat(distributeurId, editeurId, titreId, nbCopies, duree));
    }
	
    
    /**
     * Liste des contrats à valider
     * 
     * @return les contrats a valider
     */
    @WebMethod(operationName="listContratAValider")
    public String listContratAValider(@WebParam(name="distributeurId") Integer distributeurId) {
        return this.gson.toJson(this.contratBean.listContratAValider(distributeurId));
    }
        
        
    /**
     * validation du contrat
     *
     * @return le contrat
     */
    @WebMethod(operationName="validerContrat")
    public String validerContrat(@WebParam(name="contratId") Integer contratId) {
        return this.gson.toJson(this.contratBean.validerContrat(contratId));
    }
	
    
    /**
     * Liste des contrats en attente d'un recepissé
     * 
     * @param distributeurId
     * 
     * @return liste des contrats
     */
    @WebMethod(operationName="listeContratRecepisse")
    public String listeContratRecepisse(@WebParam(name="distributeurId") Integer distributeurId) {
        return this.gson.toJson(this.contratBean.listeContratRecepisse(distributeurId));
    }
    
	
    /**
     * envoi d'un récépissé
     * 
     * @param infos	liste des informations du paiement
     *
     * @return true si succès false sinon
     */
    @WebMethod(operationName="envoiRecepisse")
    public String envoiRecepisse(@WebParam(name="contratId") Integer contratId, @WebParam(name="recepisse") String recepisse) {
        return this.gson.toJson(this.contratBean.setRecepisse(contratId, recepisse));
    }

}
