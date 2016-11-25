package rest;

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
import services.archivesBeanLocal;

/**
 * Ressource volume
 */
@Path("volume")
public class volumeRessource {
    //Accès backoffice
    archivesBeanLocal archivesBean;
    
    @Context
    private UriInfo context;
    
    //Convertisseur json
    private Gson gson;
    
    /**
     * Constructeur
     */
    public volumeRessource() {
        this.gson = new Gson();
        this.archivesBean = lookupArchivesBeanLocal();
    }
    
    /**
     * Recherche des volumes à partir d'un titre et d'un numéro de volume
     * @param nomT
     * @param numV
     * @return Le volume trouvé au format json
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getVolume(@QueryParam("nomT") String nomT, @QueryParam("numV") String numV) {
        return this.gson.toJson(this.archivesBean.getVolume(numV, nomT));
    }
    
    /**
     * Ajout d'un nouveau volume
     * @param content
     * @return Le volume ajouté
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String addVolume(String content) {
        return this.gson.toJson(this.archivesBean.addVolume(content));
    }
    
    /**
     * Recherche JNDI BackOffice
     *
     * @return la référence vers le BackOffice
     */
    private archivesBeanLocal lookupArchivesBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (archivesBeanLocal) c.lookup("java:global/Archives/Archives-ejb/archivesBean!services.archivesBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
