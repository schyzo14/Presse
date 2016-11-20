/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public String addVolume(String v) throws ClientErrorException {
        return webTarget.request().post(Entity.entity(v, MediaType.APPLICATION_JSON), String.class);
    }

    public void close() {
        client.close();
    }
    
}
