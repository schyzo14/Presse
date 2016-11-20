/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST_MiseSousPresse;

import REST.PresseBeanLocal;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import presse.article;
import presse.volume;

/**
 *
 * @author Schyzo
 */
@Path("articles")
public class articlesRessource {
    //Accès backoffice
    PresseBeanLocal presseBean;
    
    @Context
    private UriInfo context;
    
    //Convertisseur json
    private final Gson gson;
    
    // Constructeur de la ressource
    public articlesRessource() {
        this.gson = new Gson();
        this.presseBean = lookupPresseBeanLocal();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getListeArticles() {
        return this.gson.toJson(this.presseBean.getListeArticles());
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String postJsonArticle(@QueryParam("unArticle") String art) {
        System.out.println("postJsonArticle articlesRessource : "+art);
        return this.gson.toJson(this.presseBean.addArticleSelect(art));
    }
    
    /**
     * Recherche JNDI BackOffice
     *
     * @return la référence vers le BackOffice
     */
    private PresseBeanLocal lookupPresseBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (PresseBeanLocal) c.lookup("java:global/MiseSousPresse/MiseSousPresse-ejb/PresseBean!REST.PresseBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
