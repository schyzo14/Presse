/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.HashMap;
import java.util.Iterator;
import javax.ejb.Singleton;
import presse.distributeur;

/**
 *
 * @author Aurore
 */
@Singleton
public class DistributeurBean implements DistributeurBeanLocal {
    
    public static HashMap<String, distributeur> lesdistributeurs;

    public DistributeurBean() {
        lesdistributeurs = new HashMap<>();
        
        // Compte distributeur déjà existant
        // TODO : récupérer les distributeurs de GestionDistributeurs
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
        if (lesdistributeurs.containsKey(mail)) {
            distributeur distrib = lesdistributeurs.get(mail);
            
            // On vérifie le mdp
            if (distrib.getMdpD().equals(mdp)) {
                return distrib;
            } else {
                new Throwable("Le mot de passe est incorrect !");
            }
            
        } else {
            new Throwable("Le mail est inconnu !");
        }
        return null;
        
    }

     
}
