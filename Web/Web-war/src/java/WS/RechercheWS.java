/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import presse.titre;
import presse.volume;

/**
 *
 * @author Aurore
 */
@WebService(serviceName = "RechercheWS")
public class RechercheWS {

	/**
     * recherche d'un titre
     *
     * @param titreNom	nom du titre
     *
     * @return le titre trouvé
     */
	@WebMethod(operationName="rechercherTitre")
	public titre rechercherTitre(@WebParam(name="titreNom") String titreNom) {
            return null;
        }
	
	/**
     * recherche d'un titre
     *
     * @param motscles	liste de mots-clés
     *
     * @return le titre trouvé
     */
	@WebMethod(operationName="rechercherTitre")
	public titre rechercherTitre(@WebParam(name="motscles") List<String> motscles) {
            return null;
        }
	
	/**
     * recherche d'un volume
     *
     * @param numTitre	numéro d'un titre
     * @param nomVol	nom du volume
     *
     * @return le volume trouvé
     */
	@WebMethod(operationName="rechercherVolume")
	public volume rechercherVolume(@WebParam(name="numTitre") Integer numTitre, @WebParam(name="nomVol") String nomVol) {
            return null;
        }
}
