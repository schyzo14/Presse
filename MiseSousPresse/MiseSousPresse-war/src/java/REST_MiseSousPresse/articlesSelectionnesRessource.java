package REST_MiseSousPresse;

import REST.PresseBeanLocal;
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

/**
 * Ressource Article Sélectionnés
 */
@Path("articlesSel")
public class articlesSelectionnesRessource {
    //Accès backoffice
    PresseBeanLocal presseBean;
    
    @Context
    private UriInfo context;
    
    //Convertisseur json
    private final Gson gson;
    
    /**
     * Constructeur
     */
    public articlesSelectionnesRessource() {
        this.gson = new Gson();
        this.presseBean = lookupPresseBeanLocal();
    }
    
    /**
     * Récupérer la liste des articles sélectionnés
     * @return la liste des articles sélectionnés au format json
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getListeArticlesSelectionnes() {
        return this.gson.toJson(this.presseBean.listeArticleSelect());
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
