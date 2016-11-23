package entities;

import java.util.ArrayList;

/**
 * Compte bancaire dans la Banque
 */
public class Compte {

    // Numéro de compte
    private int numCompte;
    // Nom du compte
    private String nomCompte;
    // Somme disponible sur le compte
    private double somme;
    // Liste des actions sur le compte
    private ArrayList<Payement> listPayements = new ArrayList<Payement> ();

    public Compte(int numCompte, String nomCompte, double somme) {
        this.setNumCompte(numCompte);
        this.setNomCompte(nomCompte);
        this.setSomme(somme);
    }

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public String getNomCompte() {
        return nomCompte;
    }

    public void setNomCompte(String nomCompte) {
        this.nomCompte = nomCompte;
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

    public ArrayList<Payement> getListPayements() {
        return listPayements;
    }

    public void setListPayements(ArrayList<Payement> listPayements) {
        this.listPayements = listPayements;
    }
                
    public void addPayements(Payement payement) {
        this.listPayements.add(payement);
        this.setSomme(this.getSomme() - payement.getMontant());
    }
}
