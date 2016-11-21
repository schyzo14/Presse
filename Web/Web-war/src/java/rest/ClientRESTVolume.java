/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import presse.volume;

/**
 * Jersey REST client generated for REST resource:volumeRessource [volume]<br>
 * USAGE:
 * <pre>
 *        ClientRESTVolume client = new ClientRESTVolume();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Khadija
 */
public class ClientRESTVolume {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Archives-war/webresources";

    public ClientRESTVolume() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("volume");
    }

    public volume getVolume(String nomT, String numV) throws ClientErrorException {
        WebTarget resource = webTarget
                .queryParam("nomT", nomT)
                .queryParam("numV", numV);
        String s = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        
        Gson gson = new Gson();
        
        java.lang.reflect.Type typeVolume = new TypeToken<volume>(){}.getType();
        volume v = gson.fromJson(s, typeVolume);
        
        return v;
    }

    public String addVolume() throws ClientErrorException {
        return webTarget.request().post(null, String.class);
    }

    public void close() {
        client.close();
    }
    
}
