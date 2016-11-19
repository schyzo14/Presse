/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import services.ContratBean;

/**
 *
 * @author Aurore
 */
@WebService(serviceName = "EditeurWS")
public class EditeurWS {
    
    @EJB
    private ContratBean contratBean;

    private Gson gson;

    public EditeurWS() {
        this.gson = new Gson();
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
        return this.gson.toJson(this.contratBean.validerContratEditeur(numContrat));
    }


}
