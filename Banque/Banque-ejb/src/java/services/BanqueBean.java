
package services;

import java.util.HashMap;
import javax.ejb.Singleton;
import entities.Compte;
import entities.Payement;

@Singleton
public class BanqueBean implements BanqueBeanLocal {

    private HashMap<Integer, Compte> lescomptes;

    public BanqueBean() {
        this.lescomptes = new HashMap<>();
        
        // Compte distributeur
        lescomptes.put(10001111, new Compte(10001111, "Hachette Diffusion", 10000));
        lescomptes.put(10002222, new Compte(10002222, "Union", 20000));
        lescomptes.put(10003333, new Compte(10003333, "Sodis", 30000));
        
        // Compte Editeur
        lescomptes.put(11110000, new Compte(11110000, "Flammarion", 10000));
        lescomptes.put(22220000, new Compte(22220000, "Gallimard", 20000));
    }

    @Override
    public Payement payer(String nomPayeur, int numComptePayeur, int numCompteReception, double montant) {
        // Si le compte du payeur existe
        if (lescomptes.containsKey(numComptePayeur)) {
            Compte comptePayeur = lescomptes.get(numComptePayeur);
            
            // Si le nom du compte du payeur est correcte
            if (comptePayeur.getNomCompte().toUpperCase().equals(nomPayeur.toUpperCase())) {
                
                // Si le compte de reception existe
                if (lescomptes.containsKey(numCompteReception)) {
                    Compte compteReception = lescomptes.get(numCompteReception);
                    
                    // Si le payeur a assez d'argent
                    if ((comptePayeur.getSomme() - montant) >= 0) {
                        Payement payement = new Payement(numComptePayeur, numCompteReception, montant);
                        
                        lescomptes.get(numComptePayeur).setSomme(comptePayeur.getSomme() - montant);
                        lescomptes.get(numComptePayeur).addPayements(payement);
                        
                        lescomptes.get(numCompteReception).setSomme(compteReception.getSomme() + montant);
                        lescomptes.get(numCompteReception).addPayements(payement);
                        
                        return payement;
                    } else {
                        throw new Error("Le payeur n'a pas assez d'argent !");
                    }
                } else {
                    throw new Error("Le compte de réception est introuvable !");
                }
            } else {
                throw new Error("Le nom du compte du payeur est introuvable !");
            }
        } else {
            throw new Error("Le compte du payeur est introuvable !");
        }
    }

}