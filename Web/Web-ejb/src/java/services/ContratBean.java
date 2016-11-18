/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Date;
import java.util.HashMap;
import presse.contrat;
import presse.distributeur;
import presse.editeur;
import presse.titre;

/**
 *
 * @author Aurore
 */
public class ContratBean implements ContratBeanLocal {
    
    public HashMap<Integer, contrat> lesContrats;
    public int dernierId;
    public HashMap<Integer, String> lesEtats;

    public ContratBean() {
        lesContrats = new HashMap<Integer, contrat>();
        dernierId = 1;
        
        lesEtats.put(1, "ATTENTECOUT");
        lesEtats.put(2, "ATTENTEVALDISTRIB");
        lesEtats.put(3, "ATTENTERECEPISSE");
        lesEtats.put(4, "ATTENTEVALEDITEUR");
    }

    
    @Override
    public contrat créerContrat(int distributeurId, int editeurId, int titreId, int nbCopies, int duree) {
        // num de contrat
        int numC = dernierId+1;
        dernierId++;
        
        float cout = 0;
        Date dateVal = null;
        Date datePaie = null;
        String etat = lesEtats.get(1);
        
        editeur ed = EditeurBean.lesEditeurs.get(editeurId);
        distributeur distrib = DistributeurBean.lesdistributeurs.get(distributeurId);
        titre t = TitreBean.lesTitres.get(titreId);
        
        return new contrat(numC, nbCopies, duree, cout, dateVal, datePaie, etat, ed, distrib, t);
    }

    
    @Override
    public HashMap<Integer, contrat> listContratAValider(int distributeurId) {
        // Initialisation : Liste des contrats à valider par le distributeur
        HashMap<Integer, contrat> lesContratsAValiderDistrib = new HashMap<Integer, contrat>();
        
        // parcours des contrats
        for (int key : lesContrats.keySet()) {
            contrat con = lesContrats.get(key);
            
            // Si l'état est en attente de validation du distributeur
            if (con.getEtatC().equals(lesEtats.get(2))) {
                
                // Si le contrat est au distributeur
                if (con.getDistributeurC().getNumD() == distributeurId) {
                    
                    // on ajoute le contrat à la liste qui sera renvoyée
                    lesContratsAValiderDistrib.put(key, con);
                }
            }
        }
        
        return lesContratsAValiderDistrib;
    }

    
    @Override
    public contrat validerContrat(int contratId) {
        // Mettre l'etat à ATTENTERECEPISSE
        lesContrats.get(contratId).setEtatC(lesEtats.get(3));
        
        return lesContrats.get(contratId);
    }

    
    @Override
    public HashMap<Integer, contrat> listeContratRecepisse(int distributeurId) {
        // Initialisation : Liste des contrats en attente de recepisse
        HashMap<Integer, contrat> lesContratsAttenteRecepisse = new HashMap<Integer, contrat>();
        
        // parcours des contrats
        for (int key : lesContrats.keySet()) {
            contrat con = lesContrats.get(key);
            
            // Si l'état est en attente de recepisse
            if (con.getEtatC().equals(lesEtats.get(3))) {
                
                // Si le contrat est au distributeur
                if (con.getDistributeurC().getNumD() == distributeurId) {
                    
                    // on ajoute le contrat à la liste qui sera renvoyée
                    lesContratsAttenteRecepisse.put(key, con);
                }
            }
        }
        
        return lesContratsAttenteRecepisse;
    }

    
    @Override
    public contrat setRecepisse(int contratId, String recepisse) {
        // Mettre le recepisse dans le contrat 
        lesContrats.get(contratId).setRecepisseC(recepisse);
        // Passer le contrat à attente de validation de l'editeur
        lesContrats.get(contratId).setEtatC(lesEtats.get(4));
        
        return lesContrats.get(contratId);
    }
    
}
