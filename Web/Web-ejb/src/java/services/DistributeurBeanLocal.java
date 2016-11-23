/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.Local;
import presse.distributeur;

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
    public distributeur inscrire(String mail, String nom);
    
    /**
     * Le distributeur se connecte
     * 
     * @param mail      mail
     * @param mdp       mdp
     * @return          le distributeur identifié
     */
    public distributeur connecter(String mail, String mdp);
   
}
