package client.rest;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

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

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Archives-war/webresources";

    /**
     * Constructeur
     */
    public ClientRESTTitre() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("titre");
    }

    /**
     * Récupération de tous les titres
     * @return String liste des titres au format json
     * @throws ClientErrorException 
     */
    public String getTitres() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getTitres");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    /**
     * Recherche de titres par nom
     * @param nomT
     * @return String titres trouves au format json
     * @throws ClientErrorException 
     */
    public String getTitreParNom(String nomT) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (nomT != null) {
            resource = resource.queryParam("nomT", nomT);
        }
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    /**
     * Recherche de titres par mots-clés
     * @param motsCles
     * @return String titres trouves au format json
     * @throws ClientErrorException 
     */
    public String getTitreParMC(String motsCles) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (motsCles != null) {
            resource = resource.queryParam("motsCles", motsCles);
        }
        resource = resource.path("motsCles");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    /**
     * Fermeture de la connexion
     */
    public void close() {
        client.close();
    }
    
}
