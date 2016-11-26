package REST_TransmissionArticles;

import REST.ArticlesBeanLocal;
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
import javax.ws.rs.core.UriInfo;

/**
 * Ressource Auteurs
 */
@Path("auteurs")
public class auteurRessource {
    //Accès backoffice
    ArticlesBeanLocal articlesBean;

    @Context
    private UriInfo context;
    
    //Convertisseur json
    private Gson gson;
    
    /**
     * Constructeur de la ressource
     */
    public auteurRessource() {
        this.gson = new Gson();
        this.articlesBean = lookupArticlesBeanLocal();
    }
    
    /**
     * Retrieves representation of an instance of REST_TransmissionArticles.articleRessource
     * @return an instance of java.lang.String
     */
    @GET
    public String getJson() {
        return this.gson.toJson(this.articlesBean.getListeArticles());
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String postJsonAuteurJournaliste(@QueryParam("nomArticle") String nomA, @QueryParam("nomAuteur") String nomAut, @QueryParam("contenu") String contenu, @QueryParam("motscles") String motcles) {
        System.out.println("POST : nomA : "+nomA +" nomAut :"+nomAut+" contenu : "+contenu+" motscles : "+motcles);
        return this.gson.toJson(this.articlesBean.addArticles(nomA, nomAut, contenu, motcles));
    }
    
    /**
     * Recherche JNDI BackOffice
     *
     * @return la référence vers le BackOffice
     */
    private ArticlesBeanLocal lookupArticlesBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (ArticlesBeanLocal) c.lookup("java:global/TransmissionArticles/TransmissionArticles-ejb/ArticlesBean!REST.ArticlesBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
