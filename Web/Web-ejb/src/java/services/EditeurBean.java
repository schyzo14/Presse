/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.HashMap;
import presse.editeur;

/**
 *
 * @author Aurore
 */
public class EditeurBean implements EditeurBeanLocal{
    
    public static HashMap<Integer, editeur> lesEditeurs = new HashMap<Integer, editeur>();

    public EditeurBean() {
        lesEditeurs.put(1, new editeur(1, "Flammarion", "contact@flam.fr"));
        lesEditeurs.put(2, new editeur(2, "Gallimard", "contact@gall.fr"));
    }

    
    @Override
    public HashMap<Integer, editeur> getListeEditeur() {
        return lesEditeurs;
    }
    
}
