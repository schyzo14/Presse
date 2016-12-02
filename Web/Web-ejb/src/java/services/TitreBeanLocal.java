
package services;

import java.util.HashMap;
import javax.ejb.Local;
import presse.Titre;

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
    public HashMap<Integer, Titre> getListeTitre();
    
    /**
     * Initialiser la liste des titres
     * 
     * @param listTitres 
     */
    public void setListeTitre(HashMap<Integer, Titre> listTitres);
    
}
