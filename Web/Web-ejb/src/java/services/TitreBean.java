/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.HashMap;
import presse.titre;

/**
 *
 * @author Aurore
 */
public class TitreBean implements TitreBeanLocal{
    
    public static HashMap<Integer, titre> lesTitres = new HashMap<Integer, titre>();

    public TitreBean() {
        // TODO : récupérer les titres de quelques part
        lesTitres.put(1, new titre(1, "Titre 1"));
        lesTitres.put(2, new titre(1, "Titre 2"));
        lesTitres.put(3, new titre(1, "Titre 3"));
    }
    

    @Override
    public HashMap<Integer, titre> getListeTitre() {
        return lesTitres;
    }
    
}
