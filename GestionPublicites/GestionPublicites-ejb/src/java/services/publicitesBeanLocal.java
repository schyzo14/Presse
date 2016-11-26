package services;

import java.util.HashMap;
import javax.ejb.Local;
import presse.publicite;

/**
 * Interface du serveur de publicités
 * Implémentée par publicitesBean
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
