
package services;

import java.util.HashMap;
import javax.ejb.Singleton;
import presse.titre;

/**
 * TitreBean implemente TitreBeanLocal
 */
@Singleton
public class TitreBean implements TitreBeanLocal{
    
    // Liste des titres
    public static HashMap<Integer, titre> lesTitres = new HashMap<Integer, titre>();

    public TitreBean() {
    }
    
    /**
     * Liste des titres
     * 
     * @return  liste des titres
     */
    @Override
    public HashMap<Integer, titre> getListeTitre() {
        return lesTitres;
    }

    /**
     * Initialiser la liste des titres
     * 
     * @param listTitres 
     */
    @Override
    public void setListeTitre(HashMap<Integer, titre> listTitres) {
        lesTitres = listTitres;
    }
    
}
