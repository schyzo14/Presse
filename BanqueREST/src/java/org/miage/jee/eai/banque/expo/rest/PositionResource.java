package org.miage.jee.eai.banque.expo.rest;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.miage.jee.eai.banque.entities.Position;
import org.miage.jee.eai.banque.services.BanqueBeanLocal;

/**
 * REST Web Service pour la Position d'un Compte
 *
 * @author Cédric Teyssié
 */
@Path("comptes/{idCompte}/position")
public class PositionResource {

    // Accès BackOffice
    BanqueBeanLocal banqueBean;

    @Context
    private UriInfo context;

    private Gson gson;

    /**
     * Constructeur
     */
    public PositionResource() {
        this.banqueBean = lookupBanqueBeanLocal();
        this.gson = new Gson();
    }

    /**
     * Renvoie la position d'un compte Pour l'appeler on doit utiliser une URL du type :
     * http://localhost:8080/BanqueREST/webresources/comptes/0/position
     *
     * @param idCompte id du compte
     *
     * @return la position en notation JSON du type : {"date":1475757403726,"somme":1000.0}
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("idCompte") String idCompte) {
        return this.gson.toJson(this.banqueBean.getPosition(Integer.parseInt(idCompte)));
    }

    /**
     * Permet de créditer ou de débiter (en fonction du signe de la somme) un compte Pour l'appeler on doit utiliser une URL du type :
     * http://localhost:8080/BanqueREST/webresources/comptes/0/position?somme=100
     *
     * @param idCompte le compte
     * @param somme    la somme à créditer (si > 0) ou à débiter (si < 0)
     *
     * @return la nouvelle position en notation JSON du type : {"date":1475757403726,"somme":1100.0}
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response putJson(@PathParam("idCompte") String idCompte, @QueryParam("somme") String somme) {
        int idcpt = Integer.parseInt(idCompte);
        double som = Double.parseDouble(somme);
        Position pos;
        if (som > 0) {
            pos = this.banqueBean.crediter(idcpt, som);
        } else {
            pos = this.banqueBean.debiter(idcpt, -som);
        }
        return Response.ok(this.gson.toJson(pos)).build();
    }

    /**
     * Recherche JNDI BackOffice
     *
     * @return la référence de l'EJB qui gère le Back Office
     */
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
