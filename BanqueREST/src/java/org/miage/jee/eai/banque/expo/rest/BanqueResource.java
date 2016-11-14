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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.miage.jee.eai.banque.services.BanqueBeanLocal;

/**
 * REST Web Service pour l'ensemble des comptes
 *
 * @author Cédric Teyssié
 */
@Path("comptes")
public class BanqueResource {

    // Accès BackOffice
    BanqueBeanLocal banqueBean;

    @Context
    private UriInfo context;

    // Convertisseur JSON
    private Gson gson;

    /**
     * Constructeur Ressource
     */
    public BanqueResource() {
        this.gson = new Gson();
        this.banqueBean = lookupBanqueBeanLocal();
    }

    /**
     * Pas d'export de la liste des comptes
     *
     * @return une réponse HTTP avec le code d'erreur 403
     */
    @GET
    public Response getJson() {
        return Response.status(Response.Status.FORBIDDEN).build();
    }

    /**
     * Creation d'un nouveau compte. Le solde est facultatif (défaut = 0.0). Pour appeler cette méthode on doit utiliser l'URL :
     * http://localhost:8080/BanqueREST/webresources/comptes/?solde=1000
     *
     * @param solde le solde du compte
     *
     * @return le compte en notation JSON de la forme {"idCompte":0,"pos":{"date":1475757207292,"somme":1000.0}}
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String postJson(@QueryParam("solde") String solde) {
        if ((solde == null) || (solde.isEmpty())) {
            solde = "0.0";
        }
        return this.gson.toJson(this.banqueBean.ajouterCompte(Double.parseDouble(solde)));
    }

    /**
     * Recherche JNDI BackOffice
     *
     * @return la référence vers le BackOffice
     */
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
