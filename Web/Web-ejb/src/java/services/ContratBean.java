/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.ejb.Singleton;
import presse.contrat;
import presse.distributeur;
import presse.editeur;
import presse.titre;
import static services.DistributeurBean.lesdistributeurs;

/**
 *
 * @author Aurore
 */
@Singleton
public class ContratBean implements ContratBeanLocal {
    
    public HashMap<Integer, contrat> lesContrats;
    public int dernierId;
    public HashMap<Integer, String> lesEtats;

    public ContratBean() {
        lesContrats = new HashMap<Integer, contrat>();
        lesContrats.put(1, new contrat(1, 10, 12, 0, null, null, "ATTENTECOUT", EditeurBean.lesEditeurs.get(1), DistributeurBean.lesdistributeurs.get("CONTACT@HACHETTEDIFF.FR"), TitreBean.lesTitres.get(1)));
        lesContrats.put(2, new contrat(2, 10, 12, 0, null, null, "ATTENTEVALDISTRIB", EditeurBean.lesEditeurs.get(1), DistributeurBean.lesdistributeurs.get("CONTACT@HACHETTEDIFF.FR"), TitreBean.lesTitres.get(2)));
        lesContrats.put(3, new contrat(3, 10, 12, 0, null, null, "ATTENTERECEPISSE", EditeurBean.lesEditeurs.get(2), DistributeurBean.lesdistributeurs.get("CONTACT@HACHETTEDIFF.FR"), TitreBean.lesTitres.get(3)));
        lesContrats.put(4, new contrat(4, 10, 12, 0, null, null, "ATTENTEVALEDITEUR", EditeurBean.lesEditeurs.get(1), DistributeurBean.lesdistributeurs.get("CONTACT@HACHETTEDIFF.FR"), TitreBean.lesTitres.get(1)));
        lesContrats.put(5, new contrat(5, 10, 12, 0, null, null, "VALIDATIONEDITEUR", EditeurBean.lesEditeurs.get(2), DistributeurBean.lesdistributeurs.get("CONTACT@HACHETTEDIFF.FR"), TitreBean.lesTitres.get(2)));
        lesContrats.put(6, new contrat(6, 10, 12, 0, null, null, "REFUSDISTRIBUTEUR", EditeurBean.lesEditeurs.get(1), DistributeurBean.lesdistributeurs.get("CONTACT@HACHETTEDIFF.FR"), TitreBean.lesTitres.get(3)));
        dernierId = 6;
        
        lesEtats = new HashMap<Integer, String>();
        lesEtats.put(1, "ATTENTECOUT");
        lesEtats.put(2, "ATTENTEVALDISTRIB");
        lesEtats.put(3, "ATTENTERECEPISSE");
        lesEtats.put(4, "ATTENTEVALEDITEUR");
        lesEtats.put(5, "VALIDATIONEDITEUR");
        lesEtats.put(6, "REFUSDISTRIBUTEUR");
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
        titre t = TitreBean.lesTitres.get(titreId);
        distributeur distrib = null;
        Iterator i = DistributeurBean.lesdistributeurs.values().iterator();
        while (i.hasNext()) {
            distributeur dis = (distributeur) i.next();
            if (dis.getNumD() == distributeurId) {
                distrib = dis;
                System.out.println(distrib.getNomD());
                contrat con = new contrat(numC, nbCopies, duree, cout, dateVal, datePaie, etat, ed, distrib, t);
                lesContrats.put(numC, con);
                return con;
            }
        }
        return null;
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
    public contrat refuserContrat(int contratId) {
        // Passer le contrat à refuser par distributeur
        lesContrats.get(contratId).setEtatC(lesEtats.get(6));
        
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

    
    @Override
    public HashMap<Integer, contrat> listeContratAttenteCout(int editeurId) {
        // Initialisation : Liste des contrats en attente de cout
        HashMap<Integer, contrat> listeContratAttenteCout = new HashMap<Integer, contrat>();
        
        // parcours des contrats
        for (int key : lesContrats.keySet()) {
            contrat con = lesContrats.get(key);
            
            // Si l'état est en attente du cout
            if (con.getEtatC().equals(lesEtats.get(1))) {
                
                // Si le contrat est à l'éditeur
                if (con.getEditeurC().getNumE()== editeurId) {
                    
                    // on ajoute le contrat à la liste qui sera renvoyée
                    listeContratAttenteCout.put(key, con);
                }
            }
        }
        
        return listeContratAttenteCout;
    }

    
    @Override
    public contrat setCout(int contratId, float cout) {
        // Mettre le cout dans le contrat 
        lesContrats.get(contratId).setCoutC(cout);
        // Passer le contrat à attente de validation du distributeur
        lesContrats.get(contratId).setEtatC(lesEtats.get(2));
        
        return lesContrats.get(contratId);
    }

    
    @Override
    public HashMap<Integer, contrat> listeContratAValiderEditeur(int editeurId) {
                // Initialisation : Liste des contrats en attente de cout
        HashMap<Integer, contrat> listeContratAValiderEditeur = new HashMap<Integer, contrat>();
        
        // parcours des contrats
        for (int key : lesContrats.keySet()) {
            contrat con = lesContrats.get(key);
            
            // Si l'état est en attente du cout
            if (con.getEtatC().equals(lesEtats.get(4))) {
                
                // Si le contrat est à l'éditeur
                if (con.getEditeurC().getNumE()== editeurId) {
                    
                    // on ajoute le contrat à la liste qui sera renvoyée
                    listeContratAValiderEditeur.put(key, con);
                }
            }
        }
        
        return listeContratAValiderEditeur;
    }

    
    @Override
    public contrat validerContratEditeur(int contratId) {
        // Passer le contrat à valider
        lesContrats.get(contratId).setEtatC(lesEtats.get(5));
        
        return lesContrats.get(contratId);
    }
    
    
}
