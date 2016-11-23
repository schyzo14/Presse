
package services;

import java.util.HashMap;
import javax.ejb.Singleton;
import entities.Compte;
import entities.Payement;

/**
 * BanqueBean implemente BanqueBeanLocal
 */
@Singleton
public class BanqueBean implements BanqueBeanLocal {

    // Liste des comptes contenus dans la banque
    private HashMap<Integer, Compte> lescomptes;
    // Dernier Id des payements pour incrémenter
    private int lasIdPaiement;

    /**
     * Constructeur de BanqueBean
     * Il crée des comptes pour les distributeurs et les éditeurs
     */
    public BanqueBean() {
        this.lescomptes = new HashMap<>();
        
        // Compte distributeur
        lescomptes.put(10001111, new Compte(10001111, "Hachette Diffusion", 10000));
        lescomptes.put(10002222, new Compte(10002222, "Union", 20000));
        lescomptes.put(10003333, new Compte(10003333, "Sodis", 30000));
        
        // Compte Editeur
        lescomptes.put(11110000, new Compte(11110000, "Flammarion", 10000));
        lescomptes.put(22220000, new Compte(22220000, "Gallimard", 20000));
        
        // Initialisation d'id du dernier payement
        lasIdPaiement = 0;
    }

    /**
     * Tentative de payement
     * 
     * @param nomPayeur         nom du débiteur
     * @param numComptePayeur   numéro du débiteur
     * @param numCompteReception numéro du créditeur
     * @param montant           montant du payement
     * @return                  le payement
     */
    @Override
    public Payement payer(String nomPayeur, int numComptePayeur, int numCompteReception, double montant) {
        
        // Si le compte du payeur existe
        if (lescomptes.containsKey(numComptePayeur)) {
            // On récupère le compte du payeur (débiteur)
            Compte comptePayeur = lescomptes.get(numComptePayeur);
            
            // Si le nom du compte du payeur est correcte
            if (comptePayeur.getNomCompte().toUpperCase().equals(nomPayeur.toUpperCase())) {
                
                // Si le compte de reception existe
                if (lescomptes.containsKey(numCompteReception)) {
                    // On récupère le compte de réception
                    Compte compteReception = lescomptes.get(numCompteReception);
                    
                    // Si le payeur a assez d'argent
                    if ((comptePayeur.getSomme() - montant) >= 0) {
                        // On crée un payement
                        Payement payement = new Payement(lasIdPaiement+1, numComptePayeur, numCompteReception, montant);
                        // On incrémente l'id des payements pour le prochain
                        lasIdPaiement++;
                        
                        // On met à jour le nouveau montant disponible sur le compte du Débiteur
                        lescomptes.get(numComptePayeur).setSomme(comptePayeur.getSomme() - montant);
                        // On ajoute le payement au compte débiteur
                        lescomptes.get(numComptePayeur).addPayements(payement);
                        
                        // On met à jour le nouveau montant disponible sur le compte du Créditeur
                        lescomptes.get(numCompteReception).setSomme(compteReception.getSomme() + montant);
                        // On ajoute le payement au compte créditeur
                        lescomptes.get(numCompteReception).addPayements(payement);
                        
                        return payement;
                    } else {
                        throw new Error("Le compte à débiter n'a pas la somme nécéssaire pour réaliser le virement !");
                    }
                } else {
                    throw new Error("Le compte à créditer est introuvable !");
                }
            } else {
                throw new Error("Le nom du compte à débiter est introuvable !");
            }
        } else {
            throw new Error("Le compte à débiter est introuvable !");
        }
    }
}
