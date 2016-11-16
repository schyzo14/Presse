/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondistributeurs;

import java.util.HashMap;
import presse.distributeur;

/**
 *
 * @author Aurore
 */
public class GestionDistributeurs {

    private static HashMap<String, distributeur> lesdistributeurs;
        
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        initialisationDistributeurs();
        
        
    }
    
    public static void initialisationDistributeurs() {
        lesdistributeurs = new HashMap<>();
        
        // Compte distributeur déjà existant
        lesdistributeurs.put("contact@hachetteDiff.fr", new distributeur(1, "DistributeurDiff", "contact@hachetteDiff.fr"));
        lesdistributeurs.put("union@union.com", new distributeur(2, "Union", "union@union.com"));
        lesdistributeurs.put("sodis@sodis.com", new distributeur(3, "Sodis", "sodis@sodis.com"));
    }
    
}
