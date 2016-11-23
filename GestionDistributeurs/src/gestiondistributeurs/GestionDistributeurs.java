/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondistributeurs;

import gestiondistributeurs.jms.Receiver;
import java.util.HashMap;
import java.util.Iterator;
import presse.distributeur;

/**
 *
 * @author Khadija
 */
public class GestionDistributeurs {
    public static HashMap<String, distributeur> lesdistributeurs = new HashMap<String, distributeur>();
    static int lastId;
    
    public GestionDistributeurs() {
        lesdistributeurs.put("CONTACT@HACHETTEDIFF.FR", new distributeur(1, "DISTRIBUTEURDIFF", "CONTACT@HACHETTEDIFF.FR", "111"));
        lesdistributeurs.put("UNION@UNION.COM", new distributeur(2, "UNION", "UNION@UNION.COM", "222"));
        lesdistributeurs.put("SODIS@SODIS.COM", new distributeur(3, "SODIS", "SODIS@SODIS.COM", "333"));
        
        lastId = 4;
        
        Receiver r = new Receiver();
    }
    
    public static distributeur inscription(String mail, String nom) {
        // On vérifie si le nom ou le mail sont déjà utilisés
        Iterator i = lesdistributeurs.keySet().iterator();
        boolean trouve = false;
        while (i.hasNext() && !trouve) {
            String distribI = (String) i.next();
            distributeur distrib = lesdistributeurs.get(distribI);
            if (distrib.getMailD().toUpperCase().equals(mail.toUpperCase()) || distrib.getNomD().toUpperCase().equals(nom.toUpperCase())) {
                trouve = true;
            }
        }
        
        // On crée un distributeur
        distributeur distrib = null;
        if(!trouve) {
            distrib = new distributeur(lastId, nom.toUpperCase(), mail.toUpperCase());
            lastId = lastId+1;
            lesdistributeurs.put(mail.toUpperCase(), distrib);
        }
        
        return distrib;
    }
    
    public static distributeur connecter(String mail, String mdp) {
        // On vérifie si le mail est déjà utilisé
        if (lesdistributeurs.containsKey(mail.toUpperCase())) {
            distributeur distrib = lesdistributeurs.get(mail.toUpperCase());

            // On vérifie le mdp
            if (distrib.getMdpD().toUpperCase().equals(mdp.toUpperCase())) {
                return distrib;
            }
        }
        return null;
    }
}
