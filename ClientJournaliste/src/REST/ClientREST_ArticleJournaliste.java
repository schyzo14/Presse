/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

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
 *        ClientREST_ArticleJournaliste client = new ClientREST_ArticleJournaliste();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author manou
 */
public class ClientREST_ArticleJournaliste {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/TransmissionArticles-war/webresources";

    public ClientREST_ArticleJournaliste() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("articles");
    }

    public String postJsonArticleJournaliste(String nomArticle, String nomAuteur, String contenu, String motscles) throws ClientErrorException {
        webTarget = webTarget.queryParam("nomArticle", nomArticle);
        webTarget = webTarget.queryParam("nomAuteur", nomAuteur);
        webTarget = webTarget.queryParam("contenu", contenu);
        webTarget = webTarget.queryParam("motscles", motscles);
        
        return webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(MediaType.APPLICATION_JSON), String.class);
    
    }

    public String getJson() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public String postJsonRedacteur() throws ClientErrorException {
        return webTarget.request().post(null, String.class);
    }

    public void close() {
        client.close();
    }
    
}