/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.distributeur;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
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
public class ClientRESTDistributeur {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Banque-war/webresources";

    public ClientRESTDistributeur(String numCompte) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        String resourcePath = java.text.MessageFormat.format("comptes/{0}", new Object[]{numCompte});
        webTarget = client.target(BASE_URI).path(resourcePath);
    }

    public void setResourcePath(String numCompte) {
        String resourcePath = java.text.MessageFormat.format("comptes/{0}", new Object[]{numCompte});
        webTarget = client.target(BASE_URI).path(resourcePath);
    }

    public Response virement(String numCompte, String nomPayeur, int numCompteReception, double montant) throws ClientErrorException {
        //return webTarget.request().put(null, Response.class);
       // WebTarget resource = webTarget;
      /*  String resourcePath = java.text.MessageFormat.format("comptes/{0}", new Object[]{numCompte});
        WebTarget service = client.target(BASE_URI).path(resourcePath);
        Form form =new Form();
        form.param("nomPayeur", nomPayeur);
        form.param("numCompteReception", Integer.toString(numCompteReception));
        form.param("montant", Double.toString(montant));
        Response response = service.request().put(Entity.entity(form,MediaType.APPLICATION_JSON),Response.class);
        return response;*/
        
      /*  webTarget.queryParam("nomPayeur", nomPayeur);
        webTarget.queryParam("numCompteReception", numCompteReception);
        webTarget.queryParam("montant", montant);
        return webTarget.request().put(entity);*/
      
      //  webTarget.request().post(entity, type);
      
        Form form =new Form();
        form.param("nomPayeur", nomPayeur);
        form.param("numCompteReception", Integer.toString(numCompteReception));
        form.param("montant", Double.toString(montant));
        Invocation.Builder builder = webTarget.request();
        Response response = builder.accept(MediaType.APPLICATION_JSON)
            .post(Entity.entity(form, MediaType.APPLICATION_JSON));
        
        return response;
    }

    public void close() {
        client.close();
    }
    
}