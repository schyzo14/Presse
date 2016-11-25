package client.rest;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:articlesSelectionnesRessource
 * [articlesSel]<br>
 * USAGE:
 * <pre>
 *        ClientRESTArticlesSelectionnes client = new ClientRESTArticlesSelectionnes();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 */
public class ClientRESTArticlesSelectionnes {

    private final WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "http://localhost:8080/MiseSousPresse-war/webresources";

    /**
     * Constructeur
     */
    public ClientRESTArticlesSelectionnes() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("articlesSel");
    }

    /**
     * Récupération des Articles Selectionnes
     * @return String articleSelectionnes au format json
     * @throws ClientErrorException 
     */
    public String getListeArticlesSelectionnes() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    /**
     * Fermeture de la connexion
     */
    public void close() {
        client.close();
    }
    
}
