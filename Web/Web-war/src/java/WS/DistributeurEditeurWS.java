package WS;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import presse.distributeur;
import presse.titre;
import rest.ClientRESTTitre;
import services.ContratBean;
import services.ContratBeanLocal;
import services.DistributeurBean;
import services.DistributeurBeanLocal;
import services.EditeurBean;
import services.EditeurBeanLocal;
import services.TitreBean;
import services.TitreBeanLocal;

/**
 * WS : DistributeurEditeurWS
 */
@WebService(serviceName = "DistributeurEditeurWS")
public class DistributeurEditeurWS {
    
    @EJB
    private DistributeurBeanLocal distributeurBean = new DistributeurBean();
    
    @EJB
    private EditeurBeanLocal editeurBean = new EditeurBean();
    
    @EJB
    private TitreBeanLocal titreBean = new TitreBean();
    
    @EJB
    private ContratBeanLocal contratBean = new ContratBean();

    private Gson gson;

    /**
     * Constructeur
     */
    public DistributeurEditeurWS() {
        this.gson = new Gson();
    }

    
    /**
     * Inscription d'un distributeur
     *
     * @param mail	mail du distributeur
     * @param nom	nom du distributeur
     * @return          le distributeur
     */
    @WebMethod(operationName="inscription")
    public String inscription(@WebParam(name="mail") String mail, @WebParam(name="nom") String nom) {
        distributeur d = this.distributeurBean.inscrire(mail, nom);
        if (d == null) {
            // Le compte n'a pas été créé donc on envoit un message d'erreur
            return this.gson.toJson(new Exception("Le mail ou le nom est déjà utilisé !", new Exception()));
        }
        // On envoie un distributeur
        return this.gson.toJson(d);
    }
    
    
    /**
     * Connection d'un distributeur
     * 
     * @param mail      mail
     * @param mdp       mdp
     * @return          le distributeur
     */
    @WebMethod(operationName="connection")
    public String connection(@WebParam(name="mail") String mail, @WebParam(name="mdp") String mdp) {
        distributeur d = this.distributeurBean.connecter(mail, mdp);
        if (d == null) {
            // La connexion a échoué donc on envoit un message d'erreur
            return this.gson.toJson(new Exception("La connexion a échouée !", new Exception()));
        }
        // on envoit le distributeur
        return this.gson.toJson(d);
    }
    
    
    /**
     * Recupère la liste des éditeurs
     * 
     * @return      la liste des editeurs
     */
    @WebMethod(operationName="getListeEditeur")
    public String getListeEditeur() {
        // on envoie la liste des distributeurs
        return this.gson.toJson(this.editeurBean.getListeEditeur());
    }
    
    
    /**
     * récupère la liste des titres
     * 
     * @return      la liste des titres
     */
    @WebMethod(operationName="getListTitre")
    public String getListeTitre() {
        // On récupère les titres en REST
        getLesTitres();
        // On renvoie la liste des titres
        return this.gson.toJson(titreBean.getListeTitre());
    }

    
    /**
     * demande d'un contrat entre distributeur et éditeur
     *
     * @param titreId	le titre du contrat
     * @param nbCopies	nombre de copies du titre
     * @param duree	duree du contrat
     *
     * @return          le contrat
     */
    @WebMethod(operationName="demandeContrat")
    public String demandeContrat(@WebParam(name="distributeurId") Integer distributeurId, @WebParam(name="editeurId") Integer editeurId, @WebParam(name="titreId") Integer titreId, 
            @WebParam(name="nbCopies") Integer nbCopies, @WebParam(name="duree") Integer duree) {
        // on met à jour la liste des titres
        getLesTitres();
        // on envoie le contrat
        return this.gson.toJson(this.contratBean.créerContrat(distributeurId, editeurId, titreId, nbCopies, duree));
    }
	
    
    /**
     * Liste des contrats à valider
     * 
     * @return      les contrats a valider
     */
    @WebMethod(operationName="listContratAValider")
    public String listContratAValider(@WebParam(name="distributeurId") Integer distributeurId) {
        // on met à jour la liste des titres
        getLesTitres();
        // on envoie la liste de contrats
        return this.gson.toJson(this.contratBean.listContratAValider(distributeurId));
    }
        
        
    /**
     * validation du contrat
     *
     * @return le contrat
     */
    @WebMethod(operationName="validerContrat")
    public String validerContrat(@WebParam(name="contratId") Integer contratId) {
        // on met à jour la liste des titres
        getLesTitres();
        // on envoie le contrat
        return this.gson.toJson(this.contratBean.validerContrat(contratId));
    }
	
    
    /**
     * le distributeur refuse le contrat
     * 
     * @param contratId
     * 
     * @return le contrat
     */
    @WebMethod(operationName="refusContrat")
    public String refusContrat(@WebParam(name="contratId") Integer contratId) {
        // on met à jour la liste des titres
        getLesTitres();
        // on envoie le contrat
        return this.gson.toJson(this.contratBean.refuserContrat(contratId));
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
        // on met à jour la liste des titres
        getLesTitres();
        // on envoie la liste de contrats
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
        // on met à jour la liste des titres
        getLesTitres();
        // on envoie le contrat
        return this.gson.toJson(this.contratBean.setRecepisse(contratId, recepisse));
    }
    
    
    
    /**
     * Liste des contrats en attente du cout
     * 
     * @param editeurId
     * 
     * @return liste des contrat
     */
    @WebMethod(operationName="listeContratAttenteCout")
    public String listeContratAttenteCout(@WebParam(name="editeurId") Integer editeurId) {
        // on met à jour la liste des titres
        getLesTitres();
        // on envoie la liste de contrats
        return this.gson.toJson(this.contratBean.listeContratAttenteCout(editeurId));
    }

    
    /**
     * cout d'un contrat
     * 
     * @param contratId
     * @param cout
     * 
     * @return le contrat
     */
    @WebMethod(operationName="coutContrat")
    public String coutContrat(@WebParam(name="contratId") Integer contratId, @WebParam(name="cout") float cout) {
        // on met à jour la liste des titres
        getLesTitres();
        // on envoie le contrat
        return this.gson.toJson(this.contratBean.setCout(contratId, cout));
    }
    
    
    /**
     * liste des contrat a valider par l'éditeur
     * 
     * @param editeurId
     * 
     * @return liste des contrats
     */
    @WebMethod(operationName="listeContratAValiderEditeur")
    public String listeContratAValiderEditeur(@WebParam(name="editeurId") Integer editeurId) {
        // on met à jour la liste des titres
        getLesTitres();
        // on envoie la liste des contrats
        return this.gson.toJson(this.contratBean.listeContratAValiderEditeur(editeurId));
    }
    

    /**
     * validation du contrat après récéption d'un récépissé
     * 
     * @param numContrat    numéro du contrat à valider
     *
     * @return le contrat
     */
    @WebMethod(operationName="validerContratEditeur")
    public String validerContratEditeur(@WebParam(name="numContrat") Integer numContrat) {
        // on met à jour la liste des titres
        getLesTitres();
        // on envoie le contrat
        return this.gson.toJson(this.contratBean.validerContratEditeur(numContrat));
    }
    
    
    /**
     * Récupère les titres depuis Archive en REST
     */
    public void getLesTitres() {
        // On récupère les titres dans Archive avec REST
        ClientRESTTitre clientRESTTitre = new ClientRESTTitre();
        String s = clientRESTTitre.getTitres();
        
        // on transforme en liste de titres
        java.lang.reflect.Type type = new TypeToken<ArrayList<titre>>(){}.getType();
        Gson gson = new Gson();
        ArrayList<titre> lesTitres = gson.fromJson(s, type);
        
        // On parcours les titres REST pour les transformer et les envoyer en WS
        HashMap<Integer, titre> lesTitresMap = new HashMap<Integer, titre>();
        for (titre titr : lesTitres) {
            lesTitresMap.put(titr.getNumT(), titr);
        }
        titreBean.setListeTitre(lesTitresMap);
    }
}
