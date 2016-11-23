
package services;

import java.util.HashMap;
import java.util.Iterator;
import javax.ejb.Singleton;
import presse.distributeur;

/**
 * DistributeurBean implemente DistributeurBeanLocal
 */
@Singleton
public class DistributeurBean implements DistributeurBeanLocal {
    
    // Liste de distributeurs
    public static HashMap<String, distributeur> lesdistributeurs = new HashMap<String, distributeur>();
    // dernier id 
    int lastId;

    /**
     * Constructeur
     */
    public DistributeurBean() {        
        // Compte distributeur déjà existant
        // TODO : récupérer les distributeurs de GestionDistributeurs
        lesdistributeurs.put("CONTACT@HACHETTEDIFF.FR", new distributeur(1, "DISTRIBUTEURDIFF", "CONTACT@HACHETTEDIFF.FR", "111"));
        lesdistributeurs.put("UNION@UNION.COM", new distributeur(2, "UNION", "UNION@UNION.COM", "222"));
        lesdistributeurs.put("SODIS@SODIS.COM", new distributeur(3, "SODIS", "SODIS@SODIS.COM", "333"));
        
        lastId = 4;
    }
    
    /**
     * Le distributeur s'inscrit
     * 
     * @param mail  mail
     * @param nom   nom
     * @return      le distributeur
     */
    @Override
    public distributeur inscrire(String mail, String nom) {            
        // On vérifie si le nom ou le mail sont déjà utilisés
        Iterator i = lesdistributeurs.keySet().iterator();
        boolean trouve = false;
        while (i.hasNext()) {
            String distribI = (String) i.next();
            distributeur distrib = lesdistributeurs.get(distribI);
            // si le nom ou le mail sont déjà utilisés
            if (distrib.getMailD().toUpperCase().equals(mail.toUpperCase()) || distrib.getNomD().toUpperCase().equals(nom.toUpperCase())) {
                return null;
            }
        }
        
        // On créait un distributeur
        distributeur distrib = new distributeur(lastId, nom.toUpperCase(), mail.toUpperCase());
        lastId = lastId+1;
        // on rajoute le distributeur à la liste des distributeurs
        lesdistributeurs.put(mail.toUpperCase(), distrib);
        
        // retourner le distributeur
        return distrib;
    }

    /**
     * Le distributeur se connecte
     * 
     * @param mail      mail
     * @param mdp       mdp
     * @return          le distributeur identifié
     */
    @Override
    public distributeur connecter(String mail, String mdp) {
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
