package services;

import entities.Payement;
import javax.ejb.Local;

/**
 * Interface de BanqueBean
 */
@Local
public interface BanqueBeanLocal {
    
    /**
     * Tentative de payement
     * 
     * @param nomPayeur         nom du débiteur
     * @param numComptePayeur   numéro du débiteur
     * @param numCompteReception numéro du créditeur
     * @param montant           montant du payement
     * @return                  le payement
     */
    public Payement payer(String nomPayeur, int numComptePayeur, int numCompteReception, double montant);
    
}
