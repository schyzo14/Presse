
package client.distributeur;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Payement réalisé auprès de la banque
 */
public class Payement {

    // Numéro du payement
    private int numPayement;
    // Numéro de compte Débiteur
    private int numComptePayeur;
    // Numéro de compte Créditeur
    private int numCompteReception;
    // Montant du payement
    private double montant;
    // Date du payement
    private Date date;

    public Payement(int numPayement, int numComptePayeur, int numCompteReception, double montant) {
        this.setNumPayement(numPayement);
        this.setNumComptePayeur(numComptePayeur);
        this.setNumCompteReception(numCompteReception);
        this.setMontant(montant);
        this.setDate();
    }

    public int getNumPayement() {
        return numPayement;
    }

    public void setNumPayement(int numPayement) {
        this.numPayement = numPayement;
    }

    public int getNumComptePayeur() {
        return numComptePayeur;
    }

    public void setNumComptePayeur(int numComptePayeur) {
        this.numComptePayeur = numComptePayeur;
    }

    public int getNumCompteReception() {
        return numCompteReception;
    }

    public void setNumCompteReception(int numCompteReception) {
        this.numCompteReception = numCompteReception;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    private void setDate(Date date) {
        this.date = date;
    }

    private void setDate() {
        this.date = Calendar.getInstance(Locale.FRANCE).getTime();
    }

}
