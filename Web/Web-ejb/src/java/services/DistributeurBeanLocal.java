/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.HashMap;
import javax.ejb.Local;
import presse.distributeur;
import presse.editeur;
import presse.publicite;
import presse.titre;

/**
 *
 * @author Aurore
 */
@Local
public interface DistributeurBeanLocal {
    
    public distributeur inscrire(String mail, String nom);
    
    public distributeur connecter(String mail, String mdp);
   
}
