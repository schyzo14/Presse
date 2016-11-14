package org.miage.jee.eai.banque.services;

import javax.ejb.Local;
import org.miage.jee.eai.banque.entities.Payement;

@Local
public interface BanqueBeanLocal {
    
    public Payement payer(int numPayement, String nomPayeur, int numComptePayeur, int numCompteReception, double montant);
    
}
