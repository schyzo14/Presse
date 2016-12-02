
package services;

import java.util.HashMap;
import javax.ejb.Singleton;
import presse.Titre;

/**
 * TitreBean implemente TitreBeanLocal
 */
@Singleton
public class TitreBean implements TitreBeanLocal{
    
    // Liste des titres
    public static HashMap<Integer, Titre> lesTitres = new HashMap<Integer, Titre>();

    public TitreBean() {
    }
    
    /**
     * Liste des titres
     * 
     * @return  liste des titres
     */
    @Override
    public HashMap<Integer, Titre> getListeTitre() {
        return lesTitres;
    }

    /**
     * Initialiser la liste des titres
     * 
     * @param listTitres 
     */
    @Override
    public void setListeTitre(HashMap<Integer, Titre> listTitres) {
        lesTitres = listTitres;
    }
    
}
