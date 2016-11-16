package rest;

import com.google.gson.Gson;
import entities.Payement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import services.BanqueBeanLocal;
//import entities.Payement;

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
     * http://localhost:8080/Banque-war/webresources/comptes/10001111/?nomPayeur=Hachette Diffusion&numCompteReception=11110000&montant=1000
     *
     * @param numCompte
     * @param numPayement
     * @param nomPayeur
     * @param numCompteReception
     * @param montant
     * @return 
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(
            @PathParam("numCompte") String numCompte, 
            @QueryParam("nomPayeur") String nomPayeur, @QueryParam("numCompteReception") String numCompteReception, @QueryParam("montant") String montant) {
        
        System.out.println("POST - numCompte : "+numCompte+" - nomPayeur : "+nomPayeur+" - numCompteReception : "+numCompteReception+" - montant : "+montant);
        
        int numComptePayeur = Integer.parseInt(numCompte);
        int numCompteReceptionInt = Integer.parseInt(numCompteReception);
        double montantD = Double.parseDouble(montant);
        Payement payement;
        
        try {
            payement = this.banqueBean.payer(nomPayeur, numComptePayeur, numCompteReceptionInt, montantD);
        } catch (Throwable e) {
            return Response.ok(this.gson.toJson(e)).build();
        }

        return Response.ok(this.gson.toJson(payement)).build();
    }

    private BanqueBeanLocal lookupBanqueBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (BanqueBeanLocal) c.lookup("java:global/Banque/Banque-ejb/BanqueBean!services.BanqueBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
