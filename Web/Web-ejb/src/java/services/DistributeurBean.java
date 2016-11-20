/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.HashMap;
import java.util.Iterator;
import javax.ejb.Singleton;
import presse.contrat;
import presse.distributeur;

/**
 *
 * @author Aurore
 */
@Singleton
public class DistributeurBean implements DistributeurBeanLocal {
    
    public static HashMap<String, distributeur> lesdistributeurs = new HashMap<String, distributeur>();
    int lastId;

    public DistributeurBean() {        
        // Compte distributeur déjà existant
        // TODO : récupérer les distributeurs de GestionDistributeurs
        lesdistributeurs.put("CONTACT@HACHETTEDIFF.FR", new distributeur(1, "DISTRIBUTEURDIFF", "CONTACT@HACHETTEDIFF.FR", "111"));
        lesdistributeurs.put("UNION@UNION.COM", new distributeur(2, "UNION", "UNION@UNION.COM", "222"));
        lesdistributeurs.put("SODIS@SODIS.COM", new distributeur(3, "SODIS", "SODIS@SODIS.COM", "333"));
        
        lastId = 4;
    }
    
    
    @Override
    public distributeur inscrire(String mail, String nom) {            
        // On vérifie si le nom est déjà utilisé
        Iterator i = lesdistributeurs.keySet().iterator();
        boolean trouve = false;
        while (i.hasNext()) {
            String distribI = (String) i.next();
            distributeur distrib = lesdistributeurs.get(distribI);
            if (distrib.getMailD().toUpperCase().equals(mail.toUpperCase()) || distrib.getNomD().toUpperCase().equals(nom.toUpperCase())) {
                return null;
            }
        }
        
        // On créait un distributeur
        distributeur distrib = new distributeur(lastId, nom.toUpperCase(), mail.toUpperCase());
        lastId = lastId+1;
        lesdistributeurs.put(mail.toUpperCase(), distrib);
        return distrib;
    }

    
    @Override
    public distributeur connecter(String mail, String mdp) {
        // On vérifie si le mail est déjà utilisé
        if (lesdistributeurs.containsKey(mail)) {
            distributeur distrib = lesdistributeurs.get(mail);
            
            // On vérifie le mdp
            if (distrib.getMdpD().equals(mdp)) {
                return distrib;
            }
        }
        return null;
    }

}
