/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.HashMap;
import java.util.Iterator;
import presse.distributeur;
import presse.editeur;
import presse.titre;

/**
 *
 * @author Aurore
 */
public class DistributeurBean implements DistributeurBeanLocal {
    
    private static HashMap<String, distributeur> lesdistributeurs;

    public DistributeurBean() {
        lesdistributeurs = new HashMap<>();
        
        // Compte distributeur déjà existant
        lesdistributeurs.put("contact@hachetteDiff.fr", new distributeur(1, "DistributeurDiff", "contact@hachetteDiff.fr"));
        lesdistributeurs.put("union@union.com", new distributeur(2, "Union", "union@union.com"));
        lesdistributeurs.put("sodis@sodis.com", new distributeur(3, "Sodis", "sodis@sodis.com"));
    }
    
    @Override
    public distributeur inscrire(String mail, String nom) {
        // On vérifie si le mail est déjà utilisé
        if (! lesdistributeurs.containsKey(mail)) {
            
            // On vérifie si le nom est déjà utilisé
            Iterator i = lesdistributeurs.keySet().iterator();
            while (i.hasNext()) {
                distributeur distrib = (distributeur) i.next();
                if (distrib.getMailD().equals(nom)) {
                    new Throwable("Le nom est déjà utilisé !");
                }
            }
            
            // On créait un distributeur
            distributeur distrib = new distributeur(0, nom, mail);
            return distrib;
            
        } else {
            new Throwable("Le mail est déjà utilisé !");
        }
        return null;
    }

    @Override
    public distributeur connecter(String mail, String mdp) {
        // On vérifie si le mail est déjà utilisé
        if (! lesdistributeurs.containsKey(mail)) {
            
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     
}
