package entities;

import java.util.ArrayList;
import java.util.List;

public class Compte {

    private int numCompte;
    private String nomCompte;   
    private double somme;
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
