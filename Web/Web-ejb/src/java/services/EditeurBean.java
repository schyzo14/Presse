
package services;

import java.util.HashMap;
import javax.ejb.Singleton;
import presse.Editeur;

/**
 * EditeurBean implemente EditeurBeanLocal
 */
@Singleton
public class EditeurBean implements EditeurBeanLocal{
    
    // Liste des éditeurs
    public static HashMap<Integer, Editeur> lesEditeurs = new HashMap<Integer, Editeur>();

    /**
     * Constructeur
     */
    public EditeurBean() {
        // Initialisation de la liste des éditeurs
        lesEditeurs.put(1, new Editeur(1, "Flammarion", "contact@flam.fr"));
        lesEditeurs.put(2, new Editeur(2, "Gallimard", "contact@gall.fr"));
    }

    /**
     * Liste des éditeurs
     * 
     * @return      Liste des éditeurs
     */
    @Override
    public HashMap<Integer, Editeur> getListeEditeur() {
        return lesEditeurs;
    }
}
