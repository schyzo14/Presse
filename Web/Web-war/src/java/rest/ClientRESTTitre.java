package rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import presse.titre;

/**
 * Jersey REST client generated for REST resource:titreRessource [titre]<br>
 * USAGE:
 * <pre>
 *        ClientRESTTitre client = new ClientRESTTitre();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 */
public class ClientRESTTitre {

    private final WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "http://localhost:8080/Archives-war/webresources";

    /**
     * Constructeur du Client REST
     */
    public ClientRESTTitre() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("titre");
    }

    /**
     * Recherche des titres par nom
     * @param nomT nom du titre à chercher
     * @return ArrayList des titres trouvés
     * @throws ClientErrorException 
     */
    public ArrayList<titre> getTitreParNom(String nomT) throws ClientErrorException {
        WebTarget resource;
        resource = webTarget
                .queryParam("nomT", nomT);
        String titres = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        
        Gson gson = new Gson();
        
        java.lang.reflect.Type typeTitre = new TypeToken<ArrayList<titre>>(){}.getType();
        ArrayList<titre> listeTitres = gson.fromJson(titres, typeTitre);
        
        return listeTitres;
    }
    
    /**
     * Recherche des titres par mots-clés
     * @param mc les mots-clés à chercher
     * @return ArrayList des titres trouvés
     * @throws ClientErrorException 
     */
    public ArrayList<titre> getTitreParMC(String mc) throws ClientErrorException {
        WebTarget resource;
        resource = webTarget
                .queryParam("motsCles", mc);
        resource = resource.path("motsCles");
        String titres = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);

        Gson gson = new Gson();

        java.lang.reflect.Type typeTitre = new TypeToken<ArrayList<titre>>(){}.getType();
        ArrayList<titre> listeTitres = gson.fromJson(titres, typeTitre);

        return listeTitres;
    }

    /**
     * Récupération de tous les titres
     * @return les titres au format json
     * @throws ClientErrorException 
     */
    public String getTitres() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getTitres");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    /**
     * Fermeture de la connexion
     */
    public void close() {
        client.close();
    }
}
