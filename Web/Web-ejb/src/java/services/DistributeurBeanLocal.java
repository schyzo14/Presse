package services;

import javax.ejb.Local;
import presse.Distributeur;

/**
 *
 * @author Aurore
 */
@Local
public interface DistributeurBeanLocal {
    
    /**
     * Le distributeur s'inscrit
     * 
     * @param mail  mail
     * @param nom   nom
     * @return      le distributeur
     */
    public Distributeur inscrire(String mail, String nom);
    
    /**
     * Le distributeur se connecte
     * 
     * @param mail      mail
     * @param mdp       mdp
     * @return          le distributeur identifié
     */
    public Distributeur connecter(String mail, String mdp);
   
}
