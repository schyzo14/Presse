
package services;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.ejb.Singleton;
import presse.contrat;
import presse.distributeur;
import presse.editeur;
import presse.titre;

/**
 * ContratBean implemente ContratBeanLocal
 */
@Singleton
public class ContratBean implements ContratBeanLocal {
    
    // liste des contrats
    public HashMap<Integer, contrat> lesContrats;
    // dernier Id des contrats
    public int dernierId;
    // Liste des états possibles pour un contrats
    public HashMap<Integer, String> lesEtats;

    /**
     * Constructeur
     */
    public ContratBean() {
        lesContrats = new HashMap<Integer, contrat>();
        
        // Liste de contrats (pour exemple)
        lesContrats.put(1, new contrat(1, 10, 12, 0, null, null, "ATTENTECOUT", EditeurBean.lesEditeurs.get(1), DistributeurBean.lesdistributeurs.get("CONTACT@HACHETTEDIFF.FR"), TitreBean.lesTitres.get(1)));
        lesContrats.put(2, new contrat(2, 10, 12, 0, null, null, "ATTENTEVALDISTRIB", EditeurBean.lesEditeurs.get(1), DistributeurBean.lesdistributeurs.get("CONTACT@HACHETTEDIFF.FR"), TitreBean.lesTitres.get(2)));
        lesContrats.get(2).setCoutC((float) 1000.0);
        lesContrats.put(3, new contrat(3, 10, 12, 0, null, null, "ATTENTERECEPISSE", EditeurBean.lesEditeurs.get(1), DistributeurBean.lesdistributeurs.get("CONTACT@HACHETTEDIFF.FR"), TitreBean.lesTitres.get(1)));
        lesContrats.get(3).setCoutC((float) 500.0);
        lesContrats.put(4, new contrat(4, 10, 12, 0, null, null, "ATTENTEVALEDITEUR", EditeurBean.lesEditeurs.get(1), DistributeurBean.lesdistributeurs.get("CONTACT@HACHETTEDIFF.FR"), TitreBean.lesTitres.get(1)));
        lesContrats.get(4).setRecepisseC("Numéro du virement : 1\nNuméro du compte débité : 10002222\nNuméro du compte crédité : 11110000\nMontant du virement : 1000.0 €\nDate du virement : 22/11/16 14:53");
        lesContrats.get(4).setCoutC((float) 1000.0);
        lesContrats.put(5, new contrat(5, 10, 12, 0, null, null, "VALIDATIONEDITEUR", EditeurBean.lesEditeurs.get(1), DistributeurBean.lesdistributeurs.get("CONTACT@HACHETTEDIFF.FR"), TitreBean.lesTitres.get(2)));
        lesContrats.put(6, new contrat(6, 10, 12, 0, null, null, "REFUSDISTRIBUTEUR", EditeurBean.lesEditeurs.get(1), DistributeurBean.lesdistributeurs.get("CONTACT@HACHETTEDIFF.FR"), TitreBean.lesTitres.get(2)));
        dernierId = 6;
        
        lesEtats = new HashMap<Integer, String>();
        
        // Liste des états possibles pour un contrat
        lesEtats.put(1, "ATTENTECOUT");
        lesEtats.put(2, "ATTENTEVALDISTRIB");
        lesEtats.put(3, "ATTENTERECEPISSE");
        lesEtats.put(4, "ATTENTEVALEDITEUR");
        lesEtats.put(5, "VALIDATIONEDITEUR");
        lesEtats.put(6, "REFUSDISTRIBUTEUR");
    }
    
    /**
     * Créer un contrat
     * 
     * @param distributeurId    Id du distributeur
     * @param editeurId         Id de l'éditeur
     * @param titreId           Id du titre
     * @param nbCopies          nombre de copie
     * @param duree             durée
     * @return                  contrat créé
     */
    @Override
    public contrat créerContrat(int distributeurId, int editeurId, int titreId, int nbCopies, int duree) {
        float cout = 0;
        Date dateVal = null;
        Date datePaie = null;
        String etat = lesEtats.get(1);
        
        // numéro de contrat
        int numC = dernierId+1;
        dernierId++;
        
        // récupération de l'éditeur
        editeur ed = EditeurBean.lesEditeurs.get(editeurId);
        
        // récupération du titre
        titre t = TitreBean.lesTitres.get(titreId);
        
        // récupération du distributeur
        distributeur distrib = null;
        Iterator i = DistributeurBean.lesdistributeurs.values().iterator();
        // parcours des distributeurs
        while (i.hasNext()) {
            distributeur dis = (distributeur) i.next();
            // Si c'est le même id, alors c'est le bon distributeur
            if (dis.getNumD() == distributeurId) {
                distrib = dis;
                // créer le contrat
                contrat con = new contrat(numC, nbCopies, duree, cout, dateVal, datePaie, etat, ed, distrib, t);
                // mettre la contrat dans la liste
                lesContrats.put(numC, con);
                // renvoyer le contrat créé
                return con;
            }
        }
        return null;
    }

    /**
     * Liste des contrats à valider par le distributeur
     * 
     * @param distributeurId    Id du distributeur
     * @return                  liste des contrats à valider
     */
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

    /**
     * Le distributeur valide un contrat
     * 
     * @param contratId Id du contrat
     * @return          Contrat
     */
    @Override
    public contrat validerContrat(int contratId) {
        // Mettre l'etat à ATTENTERECEPISSE
        lesContrats.get(contratId).setEtatC(lesEtats.get(3));
        
        // renvoyer le contrat
        return lesContrats.get(contratId);
    }
    
    /**
     * Le distributeur refuse un contrat
     * 
     * @param contratId
     * @return 
     */
    @Override
    public contrat refuserContrat(int contratId) {
        // Passer le contrat à refuser par distributeur
        lesContrats.get(contratId).setEtatC(lesEtats.get(6));
        
        // renvoyer le contrat
        return lesContrats.get(contratId);
    }
    
    /**
     * Liste des contrats en attente de récépissés
     * 
     * @param distributeurId    Id du distributeur
     * @return                  Liste des contrats en attente de récépissé
     */
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

    /**
     * Le distributeur envoie un récépissé
     * 
     * @param contratId     Id du contrat
     * @param recepisse     récépissé
     * @return              le contrat
     */
    @Override
    public contrat setRecepisse(int contratId, String recepisse) {
        // Mettre le recepisse dans le contrat 
        lesContrats.get(contratId).setRecepisseC(recepisse);
        // Passer le contrat à attente de validation de l'editeur
        lesContrats.get(contratId).setEtatC(lesEtats.get(4));
        
        // renvoyer le contrat
        return lesContrats.get(contratId);
    }

    /**
     * Liste des contrats en attente de cout
     * 
     * @param editeurId     Id de l'éditeur
     * @return              liste des contrats
     */
    @Override
    public HashMap<Integer, contrat> listeContratAttenteCout(int editeurId) {
        // Initialisation : Liste des contrats en attente de recepisse
        HashMap<Integer, contrat> listeContratAttenteCout = new HashMap<Integer, contrat>();
        
        // parcours des contrats
        for (int key : lesContrats.keySet()) {
            contrat con = lesContrats.get(key);
            
            // Si l'état est en attente de recepisse
            if (con.getEtatC().equals(lesEtats.get(1))) {
                
                // Si le contrat est au distributeur
                if (con.getEditeurC().getNumE()== editeurId) {
                    
                    // on ajoute le contrat à la liste qui sera renvoyée
                    listeContratAttenteCout.put(key, con);
                }
            }
        }
        // renvoie la liste des contrats
        return listeContratAttenteCout;
    }
    
    /**
     * L'éditeur met un cout à un contrat
     * 
     * @param contratId     Id du contrat
     * @param cout          le cout
     * @return              le contrat
     */
    @Override
    public contrat setCout(int contratId, float cout) {
        // Mettre le cout dans le contrat 
        lesContrats.get(contratId).setCoutC(cout);
        // Passer le contrat à attente de validation du distributeur
        lesContrats.get(contratId).setEtatC(lesEtats.get(2));
        
        // renvoyer le contrat
        return lesContrats.get(contratId);
    }

    /**
     * Liste des contrats en attente de validation de l'éditeur
     * 
     * @param editeurId     Id de l'éditeur
     * @return              Liste de contrats
     */
    @Override
    public HashMap<Integer, contrat> listeContratAValiderEditeur(int editeurId) {
        // Initialisation : Liste des contrats en attente de validation
        HashMap<Integer, contrat> listeContratAValiderEditeur = new HashMap<Integer, contrat>();
        
        // parcours des contrats
        for (int key : lesContrats.keySet()) {
            contrat con = lesContrats.get(key);
            
            // Si l'état est en attente du validation
            if (con.getEtatC().equals(lesEtats.get(4))) {
                
                // Si le contrat est à l'éditeur
                if (con.getEditeurC().getNumE()== editeurId) {
                    
                    // on ajoute le contrat à la liste qui sera renvoyée
                    listeContratAValiderEditeur.put(key, con);
                }
            }
        }
        // renvoyer la liste des contrats
        return listeContratAValiderEditeur;
    }

    /**
     * L'éditeur valide un contrat
     * 
     * @param contratId     Id du contrat
     * @return              le contrat
     */
    @Override
    public contrat validerContratEditeur(int contratId) {
        // Passer le contrat à valider
        lesContrats.get(contratId).setEtatC(lesEtats.get(5));
        
        // renvoyer le contrat
        return lesContrats.get(contratId);
    }
}
