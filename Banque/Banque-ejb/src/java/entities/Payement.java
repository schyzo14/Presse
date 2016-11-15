
package entities;

import java.util.Calendar;

public class Payement {

    private int numPayement;
    private int numComptePayeur;
    private int numCompteReception;
    private double montant;
    private long date;

    public Payement(int numComptePayeur, int numCompteReception, double montant) {
        this.setNumPayement(1 + (int)(Math.random() * ((1000000 - 1) + 1)));
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

    public long getDate() {
        return date;
    }

    private void setDate(long date) {
        this.date = date;
    }

    private void setDate() {
        this.date = Calendar.getInstance().getTimeInMillis();
    }

}
