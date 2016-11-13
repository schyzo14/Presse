/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import services.publicitesBeanLocal;

/**
 *
 * @author Schyzo
 */
@Path("publicites")
public class publicitesRessource {
    //Accès backoffice
    publicitesBeanLocal publicitesBean;
    
    @Context
    private UriInfo context;
    
    //Convertisseur json
    private Gson gson;
    
    // Constructeur de la ressource
    public publicitesRessource() {
        this.gson = new Gson();
        this.publicitesBean = lookupPublicitesBeanLocal();
    }
    
    @GET
    public String getJson() {
        return this.gson.toJson("Une pub");
    }
    
    /**
     * Recherche JNDI BackOffice
     *
     * @return la référence vers le BackOffice
     */
    private publicitesBeanLocal lookupPublicitesBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (publicitesBeanLocal) c.lookup("java:global/GestionPublicites/GestionPublicites-ejb/publicitesBean!services.publicitesBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
