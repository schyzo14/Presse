package client.rest;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Jersey REST client generated for REST resource:volumeRessource [volume]<br>
 * USAGE:
 * <pre>
 *        ClientRESTVolume client = new ClientRESTVolume();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 */
public class ClientRESTVolume {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Archives-war/webresources";

    /**
     * Constructeur
     */
    public ClientRESTVolume() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("volume");
    }

    /**
     * Ajout d'un volume
     * @param v
     * @return String le volume ajouté au format json
     * @throws ClientErrorException 
     */
    public String addVolume(String v) throws ClientErrorException {
        return webTarget.request().post(Entity.entity(v, MediaType.APPLICATION_JSON), String.class);
    }

    /**
     * Fermeture de la connexion
     */
    public void close() {
        client.close();
    }
    
}
