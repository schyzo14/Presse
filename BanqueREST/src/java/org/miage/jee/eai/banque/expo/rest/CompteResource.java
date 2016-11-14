package org.miage.jee.eai.banque.expo.rest;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.miage.jee.eai.banque.entities.Payement;
import org.miage.jee.eai.banque.services.BanqueBeanLocal;

@Path("comptes/{numCompte}")
public class CompteResource {

    BanqueBeanLocal banqueBean;

    @Context
    private UriInfo context;

    private Gson gson;

    public CompteResource() {
        this.banqueBean = lookupBanqueBeanLocal();
        this.gson = new Gson();
    }
    
    /**
     * http://localhost:8080/BanqueREST/webresources/comptes/10001111/compte?numPayement=1&nomPayeur=Hachette Diffusion&numCompteReception=11110000&montant=1000
     *
     * @param numCompte
     * @param numPayement
     * @param nomPayeur
     * @param numCompteReception
     * @param montant
     * @return 
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response putJson(
            @PathParam("numCompte") String numCompte, 
            @QueryParam("numPayement") String numPayement, @QueryParam("nomPayeur") String nomPayeur, @QueryParam("numCompteReception") String numCompteReception, @QueryParam("montant") String montant) {
        
        int numComptePayeur = Integer.parseInt(numCompte);
        int numPayementInt = Integer.parseInt(numPayement);
        int numCompteReceptionInt = Integer.parseInt(numCompteReception);
        double montantD = Double.parseDouble(montant);
        Payement payement;
        
        try {
            payement = this.banqueBean.payer(numPayementInt, nomPayeur, numComptePayeur, numCompteReceptionInt, montantD);
        } catch (Throwable e) {
            return Response.ok(this.gson.toJson(e)).build();
        }

        return Response.ok(this.gson.toJson(payement)).build();
    }

    private BanqueBeanLocal lookupBanqueBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (BanqueBeanLocal) c.lookup("java:global/BanqueJEE-REST/BanqueEJB/BanqueBean!org.miage.jee.eai.banque.services.BanqueBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
