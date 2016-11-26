/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.HashMap;
import javax.ejb.Local;
import presse.publicite;

/**
 *
 * @author Schyzo
 */
@Local
public interface publicitesBeanLocal {
    
    /**
     * Récupérer la publicité
     * @param num numéro de la publicité
     * @return publicite la publicité trouvée
     */
    public publicite getPublicites(int num);
    
    /**
     * Récupérer toutes les publicités
     * @return listePubs la liste des publicités
     */
    public HashMap<Integer, publicite> getListePubs();
    
    /**
     * Saisir la nouvelle liste de publicités
     * @param listePubs la liste des publicités
     */
    public void setListePubs(HashMap<Integer, publicite> listePubs);
}
