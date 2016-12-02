package rest;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import services.ArchivesBeanLocal;

/**
 * Ressource titre
 */
@Path("titre")
public class TitreRessource {
    //Accès backoffice
    ArchivesBeanLocal archivesBean;
    
    @Context
    private UriInfo context;
    
    //Convertisseur json
    private Gson gson;
    
    /**
     * Constructeur
     */
    public TitreRessource() {
        this.gson = new Gson();
        this.archivesBean = lookupArchivesBeanLocal();
    }
    
    /**
     * Recherche de titres par nom
     * @param nomTitre
     * @return Liste des titres trouvés au format json
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getTitreParNom(@QueryParam("nomT") String nomTitre) {
        return this.gson.toJson(this.archivesBean.getTitreParNom(nomTitre));
    }
    
    /**
     * Recherche de titres par mots-clés
     * @param mc
     * @return Liste des titres trouvés au format json
     */
    @Path("/motsCles")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getTitreParMC(@QueryParam("motsCles") String mc) {
        return this.gson.toJson(this.archivesBean.getTitreParMC(mc));
    }
    
    /**
     * Récupération de tous les titres
     * @return Tous les titres au format json
     */
    @Path("/getTitres")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getTitres() {
        return this.gson.toJson(this.archivesBean.getTitres());
    }
    
    /**
     * Recherche JNDI BackOffice
     *
     * @return la référence vers le BackOffice
     */
    private ArchivesBeanLocal lookupArchivesBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (ArchivesBeanLocal) c.lookup("java:global/Archives/Archives-ejb/ArchivesBean!services.ArchivesBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
