
package services;

import java.util.HashMap;
import javax.ejb.Local;
import presse.titre;

/**
 * Interface TitreBeanLocal
 */
@Local
public interface TitreBeanLocal {
    
    /**
     * Liste des titres
     * 
     * @return  liste des titres
     */
    public HashMap<Integer, titre> getListeTitre();
    
    /**
     * Initialiser la liste des titres
     * 
     * @param listTitres 
     */
    public void setListeTitre(HashMap<Integer, titre> listTitres);
    
}
