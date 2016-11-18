/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import services.DistributeurBean;
import com.google.gson.Gson;
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
     * @return true si succès false sinon
     */
    @WebMethod(operationName="inscription")
    public String inscription(@WebParam(name="mail") String mail, @WebParam(name="nom") String nom) {
        return this.gson.toJson(this.distributeurBean.inscrire(mail, nom));
    }
    
    /**
     * connection d'un distributeur
     * 
     * @param mail
     * @param mdp
     * 
     * @return 
     */
    @WebMethod(operationName="connection")
    public String connection(@WebParam(name="mail") String mail, @WebParam(name="mdp") String mdp) {
        return this.gson.toJson(this.distributeurBean.connecter(mail, mdp));
    }
    
    
    /**
     * recupère la liste des éditeurs
     * 
     * @return 
     */
    @WebMethod(operationName="getListeEditeur")
    public String getListeEditeur() {
        return this.gson.toJson(this.editeurBean.getListeEditeur());
    }
    
    
    /**
     * récupère la liste des titres
     * 
     * @return 
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
     * @return true si succès false sinon
     */
	@WebMethod(operationName="demandeContrat")
	public boolean demandeContrat(@WebParam(name="editeurId") Integer editeurId, @WebParam(name="titreId") Integer titreId, 
                @WebParam(name="nbCopies") Integer nbCopies, @WebParam(name="duree") Integer duree) {
            return false;
        }
	
	/**
     * validation du cout par le distributeur
     *
     * @return true si succès false sinon
     */
	@WebMethod(operationName="validerContrat")
	public boolean validerContrat() {
            return false;
        }
	
	
	/**
     * envoi d'un récépissé
     * 
     * @param infos	liste des informations du paiement
     *
     * @return true si succès false sinon
     */
	@WebMethod(operationName="envoiRecepisse")
	public boolean envoiRecepisse(@WebParam(name="infos") List<String> infos) {
            return false;
        }
	
	


}
