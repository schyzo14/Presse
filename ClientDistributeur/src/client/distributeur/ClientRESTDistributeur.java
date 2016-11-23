package client.distributeur;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Client REST qui communique avec la banque
 */
public class ClientRESTDistributeur {

    // REST
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Banque-war/webresources";

    /**
     * Constructeur
     * 
     * @param numCompte numéro du compte du débiteur
     */
    public ClientRESTDistributeur(String numCompte) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        String resourcePath = java.text.MessageFormat.format("comptes/{0}", new Object[]{numCompte});
        webTarget = client.target(BASE_URI).path(resourcePath);
    }

    public void setResourcePath(String numCompte) {
        String resourcePath = java.text.MessageFormat.format("comptes/{0}", new Object[]{numCompte});
        webTarget = client.target(BASE_URI).path(resourcePath);
    }
    
    /**
     * Faire un virement avec REST vers la banque
     * 
     * @param numCompte         numéro du compte du débiteur
     * @param nomPayeur         nom du compte du débiteur
     * @param numCompteReception numéro du compte du créditeur
     * @param montant           montant du payement
     * @return                  la demande de payement
     * @throws ClientErrorException 
     */
    public String virement(String numCompte, String nomPayeur, int numCompteReception, double montant) throws ClientErrorException {
    
        // Ajout des paramètres à la requête
        webTarget = webTarget.queryParam("nomPayeur", nomPayeur);
        webTarget = webTarget.queryParam("numCompteReception", numCompteReception);
        webTarget = webTarget.queryParam("montant", montant);
        
        // Envoyer la requête vers le serveur REST
        return webTarget.request(MediaType.APPLICATION_JSON_TYPE)
            .post(Entity.json(MediaType.APPLICATION_JSON), String.class);
    }

    /**
     * Fermer la connexion au REST
     */
    public void close() {
        client.close();
    }
}