/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.miage.jee.eai.banque.expo.ws;

import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.miage.jee.eai.banque.services.BanqueBeanLocal;

/**
 * WebService qui gère la Banque Ce webservice est disponible à l'URL : http://localhost:8080/BourseWS/BourseWS?WSDL
 *
 * @author Cédric Teyssié
 */
@WebService(serviceName = "BanqueWS")
public class BanqueWS {

    @EJB
    private BanqueBeanLocal banqueBean;

    private Gson gson;

    public BanqueWS() {
        this.gson = new Gson();
    }

    /**
     * ajoute un compte
     *
     * @param somme_init somme initiale
     *
     * @return le compte au format JSON
     */
    @WebMethod(operationName = "ajouterCompte")
    public String ajouterCompte(@WebParam(name = "sommeInitiale") Double somme_init) {
        return this.gson.toJson(this.banqueBean.ajouterCompte(somme_init));
    }

    /**
     * retourne la position d'un compte
     *
     * @param idCompte id du compte
     *
     * @return la position du compte au format JSON
     */
    @WebMethod(operationName = "getPosition")
    public String getPosition(@WebParam(name = "idCompte") Integer idCompte) {
        return this.gson.toJson(this.banqueBean.getPosition(idCompte));
    }

    /**
     * crédite un compte
     *
     * @param idCompte id du compte
     * @param somme    somme à créditer
     *
     * @return la position du compte au format JSON
     */
    @WebMethod(operationName = "crediter")
    public String crediter(@WebParam(name = "idCompte") Integer idCompte, @WebParam(name = "somme") Double somme) {
        return this.gson.toJson(this.banqueBean.crediter(idCompte, somme));
    }

    /**
     * débite un compte
     *
     * @param idCompte id du compte
     * @param somme    somme à débiter
     *
     * @return la position du compte au format JSON
     */
    @WebMethod(operationName = "debiter")
    public String debiter(@WebParam(name = "idCompte") Integer idCompte, @WebParam(name = "somme") Double somme) {
        return this.gson.toJson(this.banqueBean.debiter(idCompte, somme));
    }

}
