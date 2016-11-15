package services;

import entities.Payement;
import javax.ejb.Local;

@Local
public interface BanqueBeanLocal {
    
    public Payement payer(String nomPayeur, int numComptePayeur, int numCompteReception, double montant);
    
}
