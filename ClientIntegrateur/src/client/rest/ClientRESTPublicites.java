package client.rest;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:publicitesRessource
 * [publicites]<br>
 * USAGE:
 * <pre>
        ClientRESTPublicites client = new ClientRESTPublicites();
        Object response = client.XXX(...);
        // do whatever with response
        client.close();
 </pre>
 */
public class ClientRESTPublicites {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/GestionPublicites-war/webresources";

    /**
     * Constructeur
     */
    public ClientRESTPublicites() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("publicites");
    }

    /**
     * Récupération des Publicites
     * @return String liste des publicités au format json
     * @throws ClientErrorException 
     */
    public String getListePubs() throws ClientErrorException {
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
