package gestiondistributeurs;

import gestiondistributeurs.jms.Receiver;
import java.util.HashMap;
import java.util.Iterator;
import presse.Distributeur;

/**
 * Classe GestionDistributeurs
 */
public class GestionDistributeurs {
    //Liste des distributeurs
    public static HashMap<String, Distributeur> lesdistributeurs = new HashMap<String, Distributeur>();
    //Dernier id utilisé à l'insertion
    static int lastId;
    
    /**
     * Constructeur
     */
    public GestionDistributeurs() {
        lesdistributeurs.put("CONTACT@HACHETTEDIFF.FR", new Distributeur(1, "DISTRIBUTEURDIFF", "CONTACT@HACHETTEDIFF.FR", "111"));
        lesdistributeurs.put("UNION@UNION.COM", new Distributeur(2, "UNION", "UNION@UNION.COM", "222"));
        lesdistributeurs.put("SODIS@SODIS.COM", new Distributeur(3, "SODIS", "SODIS@SODIS.COM", "333"));
        
        lastId = 4;
        
        Receiver r = new Receiver();
    }
    
    /**
     * Inscription d'un nouveau distributeur
     * @param mail le mail du distributeur
     * @param nom le nom du distributeur
     * @return distributeur
     */
    public static Distributeur inscription(String mail, String nom) {
        // On vérifie si le nom ou le mail sont déjà utilisés
        Iterator i = lesdistributeurs.keySet().iterator();
        boolean trouve = false;
        while (i.hasNext() && !trouve) {
            String distribI = (String) i.next();
            Distributeur distrib = lesdistributeurs.get(distribI);
            if (distrib.getMailD().toUpperCase().equals(mail.toUpperCase()) || distrib.getNomD().toUpperCase().equals(nom.toUpperCase())) {
                trouve = true;
            }
        }
        
        // On crée un distributeur
        Distributeur distrib = null;
        if(!trouve) {
            distrib = new Distributeur(lastId, nom.toUpperCase(), mail.toUpperCase());
            lastId = lastId+1;
            lesdistributeurs.put(mail.toUpperCase(), distrib);
        }
        
        return distrib;
    }
    
    /**
     * Connexon du distributeur à l'application
     * @param mail le mail du distributeur
     * @param mdp le mot de passe du distributeur
     * @return distributeur
     */
    public static Distributeur connecter(String mail, String mdp) {
        // On vérifie si le mail est déjà utilisé
        if (lesdistributeurs.containsKey(mail.toUpperCase())) {
            Distributeur distrib = lesdistributeurs.get(mail.toUpperCase());

            // On vérifie le mdp
            if (distrib.getMdpD().toUpperCase().equals(mdp.toUpperCase())) {
                return distrib;
            }
        }
        return null;
    }
}
