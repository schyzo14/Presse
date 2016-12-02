package rest;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import services.PublicitesBeanLocal;

/**
 * Ressource publicites
 */
@Path("publicites")
public class PublicitesRessource {
    //Accès backoffice
    PublicitesBeanLocal publicitesBean;
    
    @Context
    private UriInfo context;
    
    //Convertisseur json
    private Gson gson;
    
    /**
     * Constructeur
     */
    public PublicitesRessource() {
        this.gson = new Gson();
        this.publicitesBean = lookupPublicitesBeanLocal();
    }
    
    /**
     * Récupérer la liste des publicités
     * @return Liste des publicités au format json
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getListePubs() {
        return this.gson.toJson(this.publicitesBean.getListePubs());
    }
    
    /**
     * Recherche JNDI BackOffice
     *
     * @return la référence vers le BackOffice
     */
    private PublicitesBeanLocal lookupPublicitesBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (PublicitesBeanLocal) c.lookup("java:global/GestionPublicites/GestionPublicites-ejb/PublicitesBean!services.PublicitesBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
