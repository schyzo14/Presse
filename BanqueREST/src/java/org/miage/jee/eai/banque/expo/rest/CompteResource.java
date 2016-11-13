/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.miage.jee.eai.banque.expo.rest;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.miage.jee.eai.banque.services.BanqueBeanLocal;

/**
 * REST Web Service pour un Compte
 *
 * @author Cédric Teyssié
 */
@Path("comptes/{idCompte}")
public class CompteResource {

    BanqueBeanLocal banqueBean;

    @Context
    private UriInfo context;

    private Gson gson;

    public CompteResource() {
        this.banqueBean = lookupBanqueBeanLocal();
        this.gson = new Gson();
    }

    /**
     * Renvoie la représentation JSON d'un compte Pour l'appeler on doit utiliser l'URL :
     * http://localhost:8080/BanqueREST/webresources/comptes/0
     *
     * @param idCompte id du compte
     *
     * @return le compte en notation JSON de la forme {"idCompte":0,"pos":{"date":1475757207292,"somme":1000.0}}
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("idCompte") String idCompte) {
        return this.gson.toJson(this.banqueBean.getCompte(Integer.parseInt(idCompte)));
    }

    private BanqueBeanLocal lookupBanqueBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (BanqueBeanLocal) c.lookup("java:global/BanqueJEE-REST/BanqueEJB/BanqueBean!org.miage.jee.eai.banque.services.BanqueBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
