
package services;

import java.util.HashMap;
import javax.ejb.Singleton;
import presse.editeur;

/**
 * EditeurBean implemente EditeurBeanLocal
 */
@Singleton
public class EditeurBean implements EditeurBeanLocal{
    
    // Liste des éditeurs
    public static HashMap<Integer, editeur> lesEditeurs = new HashMap<Integer, editeur>();

    /**
     * Constructeur
     */
    public EditeurBean() {
        // Initialisation de la liste des éditeurs
        lesEditeurs.put(1, new editeur(1, "Flammarion", "contact@flam.fr"));
        lesEditeurs.put(2, new editeur(2, "Gallimard", "contact@gall.fr"));
    }

    /**
     * Liste des éditeurs
     * 
     * @return      Liste des éditeurs
     */
    @Override
    public HashMap<Integer, editeur> getListeEditeur() {
        return lesEditeurs;
    }
}
