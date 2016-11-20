/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import static javax.ws.rs.client.Entity.json;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.uri.UriComponent;

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

    public String postJsonArticle(String art) throws ClientErrorException {
        String encoded = UriComponent.encode(art, UriComponent.Type.QUERY_PARAM_SPACE_ENCODED);
        System.out.println("postJsonArticle ClientREST : "+art);
        WebTarget web = client.target(BASE_URI).path("articles");
        web = web.queryParam("unArticle", encoded);
        
        return web.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(MediaType.APPLICATION_JSON), String.class);
    }

    public String getListeArticles() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public void close() {
        client.close();
    }
    
}
