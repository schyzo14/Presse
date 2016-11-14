/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.distributeur;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:CompteResource
 * [comptes/{numCompte}]<br>
 * USAGE:
 * <pre>
 *        banqueRestGenere client = new banqueRestGenere();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Aurore
 */
public class banqueRestGenere {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/BanqueREST/webresources";

    public banqueRestGenere(String numCompte) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        String resourcePath = java.text.MessageFormat.format("comptes/{0}", new Object[]{numCompte});
        webTarget = client.target(BASE_URI).path(resourcePath);
    }

    public void setResourcePath(String numCompte) {
        String resourcePath = java.text.MessageFormat.format("comptes/{0}", new Object[]{numCompte});
        webTarget = client.target(BASE_URI).path(resourcePath);
    }

    public Response putJson() throws ClientErrorException {
        return webTarget.request().put(null, Response.class);
    }

    public void close() {
        client.close();
    }
    
}
