/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import presse.titre;

/**
 * Jersey REST client generated for REST resource:titreRessource
 * [titre/{nomT}]<br>
 * USAGE:
 * <pre>
 *        ClientTitre client = new ClientTitre();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Khadija
 */
public class ClientTitre {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Archives-war/webresources";

    public ClientTitre(String nomT) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        String resourcePath = java.text.MessageFormat.format("titre/{0}", new Object[]{nomT});
        webTarget = client.target(BASE_URI).path(resourcePath);
    }

    public void setResourcePath(String nomT) {
        String resourcePath = java.text.MessageFormat.format("titre/{0}", new Object[]{nomT});
        webTarget = client.target(BASE_URI).path(resourcePath);
    }

    public ArrayList<titre> getTitreParNom() throws ClientErrorException {
        WebTarget resource = webTarget;
        String titres = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(titres);
        
        Gson gson = new Gson();
        
        java.lang.reflect.Type typeTitre = new TypeToken<ArrayList<titre>>(){}.getType();
        ArrayList<titre> listeTitres = gson.fromJson(titres, typeTitre);
        
        System.out.println(listeTitres.toString());
        
        return listeTitres;
    }

    public void close() {
        client.close();
    }
    
}
