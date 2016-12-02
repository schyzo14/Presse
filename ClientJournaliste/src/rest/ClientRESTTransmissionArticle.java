package rest;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Jersey REST client generated for REST resource:articleRessource
 * [articles]<br>
 * USAGE:
 * <pre>
        ClientREST_TransmissionArticle client = new ClientREST_TransmissionArticle();
        Object response = client.XXX(...);
        // do whatever with response
        client.close();
 </pre>
 *
 * 
 */
public class ClientRESTTransmissionArticle {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/TransmissionArticles-war/webresources";

    
    public ClientRESTTransmissionArticle() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("articles");
    }
    
    /**
     * GET
     * @param idArticle
     * @return récupérer le détail d'un article en particulier
     * @throws ClientErrorException 
     */
    public String getDetailArticle(String idArticle) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("articles/{0}", new Object[]{idArticle}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    /**
     * POST
     * @param nomArticle
     * @param nomAuteur
     * @param contenu
     * @param motscles
     * @return Pour envoyer les informations saisis par l'utilisateur au serveur TransmettreArticle
     * @throws ClientErrorException 
     */
    public String postJsonArticleJournaliste(String nomArticle, String nomAuteur, String contenu, String motscles) throws ClientErrorException {
        System.out.println("postJsonArticle : "+contenu);
        WebTarget web = client.target(BASE_URI).path("articles");
        web = web.queryParam("nomArticle", nomArticle);
        web = web.queryParam("nomAuteur", nomAuteur);
        web = web.queryParam("contenu", contenu);
        web = web.queryParam("motscles", motscles);
        
        return web.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(MediaType.APPLICATION_JSON), String.class);
    
    }

    /**
     * GET
     * @return
     * @throws ClientErrorException 
     */
    public String getJson() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    /**
     * Fermer la connexion
     */
    public void close() {
        client.close();
    }
    
}
