
package services;

import java.util.HashMap;
import javax.ejb.Local;
import presse.Editeur;

/**
 * Interface EditeurBeanLocal
 */
@Local
public interface EditeurBeanLocal {
    
    /**
     * Liste des éditeurs
     * 
     * @return      Liste des éditeurs
     */
    public HashMap<Integer, Editeur> getListeEditeur();
    
}
