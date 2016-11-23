
package services;

import java.util.HashMap;
import javax.ejb.Local;
import presse.editeur;

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
    public HashMap<Integer, editeur> getListeEditeur();
    
}
