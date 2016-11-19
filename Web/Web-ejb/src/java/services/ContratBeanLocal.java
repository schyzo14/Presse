/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.HashMap;
import javax.ejb.Local;
import presse.contrat;

/**
 *
 * @author Aurore
 */
@Local
public interface ContratBeanLocal {
    
    public contrat créerContrat(int distributeurId, int editeurId, int titreId, int nbCopies, int duree);
    
    public HashMap<Integer, contrat> listContratAValider(int distributeurId);
    
    public contrat validerContrat(int contratId);
    
    public contrat refuserContrat(int contratId);
    
    public HashMap<Integer, contrat> listeContratRecepisse(int distributeurId);
    
    public contrat setRecepisse(int contratId, String recepisse);
    
    public HashMap<Integer, contrat> listeContratAttenteCout(int editeurId);
    
    public contrat setCout(int contratId, float cout);
    
    public HashMap<Integer, contrat> listeContratAValiderEditeur(int editeurId);
    
    public contrat validerContratEditeur(int contratId);
    
}
