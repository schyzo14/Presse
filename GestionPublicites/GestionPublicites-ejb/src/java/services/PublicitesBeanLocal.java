package services;

import java.util.HashMap;
import javax.ejb.Local;
import presse.Publicite;

/**
 * Interface du serveur de publicités
 * Implémentée par publicitesBean
 */
@Local
public interface PublicitesBeanLocal {
    
    /**
     * Récupérer la publicité
     * @param num numéro de la publicité
     * @return publicite la publicité trouvée
     */
    public Publicite getPublicites(int num);
    
    /**
     * Récupérer toutes les publicités
     * @return listePubs la liste des publicités
     */
    public HashMap<Integer, Publicite> getListePubs();
    
    /**
     * Saisir la nouvelle liste de publicités
     * @param listePubs la liste des publicités
     */
    public void setListePubs(HashMap<Integer, Publicite> listePubs);
}
