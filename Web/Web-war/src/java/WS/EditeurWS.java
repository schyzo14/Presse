/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Aurore
 */
@WebService(serviceName = "EditeurWS")
public class EditeurWS {
    
    	/**
     * cout d'un contrat
     *
     * @param cout	le cout
     *
     * @return le cout du contrat
     */
	@WebMethod(operationName="coutContrat")
	public Long coutContrat(@WebParam(name="cout") Long cout) {
            return null;
        }
        
     	/**
     * validation du contrat après récéption d'un récépissé
     * 
     * @param numContrat	numéro du contrat à valider
     *
     * @return true si succès false sinon
     */
	@WebMethod(operationName="validerContratEditeur")
	public boolean validerContratEditeur(@WebParam(name="numContrat") Integer numContrat) {
            return false;
        }


}
