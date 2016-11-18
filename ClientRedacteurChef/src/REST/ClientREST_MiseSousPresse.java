/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:articlesRessource
 * [articles]<br>
 * USAGE:
 * <pre>
 *        ClientREST_MiseSousPresse client = new ClientREST_MiseSousPresse();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author manou
 */
public class ClientREST_MiseSousPresse {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/MiseSousPresse-war/webresources";

    public ClientREST_MiseSousPresse() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("articles");
    }

    public String getDetailArticle(int idArticle) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("articles/{0}", new Object[]{idArticle}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public String getListeArticles() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public void close() {
        client.close();
    }
    
}