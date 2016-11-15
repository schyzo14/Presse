package services;

import javax.ejb.Local;
import entities.Payement;

@Local
public interface BanqueBeanLocal {
    
    public Payement payer(String nomPayeur, int numComptePayeur, int numCompteReception, double montant);
    
}
