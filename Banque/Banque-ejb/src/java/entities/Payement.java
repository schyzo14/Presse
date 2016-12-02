
package entities;

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

    /**
     * Récupérer le numéro du payement
     * @return le numéro du payement
     */
    public int getNumPayement() {
        return numPayement;
    }

    /**
     * Mettre le numéro du payement
     * @param numPayement le numéro du payement
     */
    public void setNumPayement(int numPayement) {
        this.numPayement = numPayement;
    }

    /**
     * Récupérer le numéro de compte du payeur
     * @return le numéro de compte du payeur
     */
    public int getNumComptePayeur() {
        return numComptePayeur;
    }

    /**
     * Mettre le numéro de compte du payeur
     * @param numComptePayeur le numéro de compte du payeur
     */
    public void setNumComptePayeur(int numComptePayeur) {
        this.numComptePayeur = numComptePayeur;
    }

    /**
     * Récupérer le numéro de compte de réception
     * @return le numéro de compte de réception
     */
    public int getNumCompteReception() {
        return numCompteReception;
    }
    
    /**
     * Mettre le numéro de compte de réception
     * @param numCompteReception le numéro de compte de réception
     */
    public void setNumCompteReception(int numCompteReception) {
        this.numCompteReception = numCompteReception;
    }

    /**
     * Récupérer le montant
     * @return le montant
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Mettre le montant
     * @param montant le montant
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

    /**
     * Récupérer la date du payement
     * @return la date du payement
     */
    public Date getDate() {
        return date;
    }

    /**
     * Mettre la date de payement
     * @param date la date de payement
     */
    private void setDate(Date date) {
        this.date = date;
    }

    /**
     * Mettre la date du jour au payement
     */
    private void setDate() {
        this.date = Calendar.getInstance(Locale.FRANCE).getTime();
    }

}
