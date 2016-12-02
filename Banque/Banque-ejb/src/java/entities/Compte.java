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

    /**
     * Constructeur
     * @param numCompte
     * @param nomCompte
     * @param somme 
     */
    public Compte(int numCompte, String nomCompte, double somme) {
        this.setNumCompte(numCompte);
        this.setNomCompte(nomCompte);
        this.setSomme(somme);
    }

    /**
     * Récupérer le numéro de compte
     * @return numéro de compte
     */
    public int getNumCompte() {
        return numCompte;
    }

    /**
     * Mettre le numéro de compte
     * @param numCompte numéro de compte
     */
    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    /**
     * Récupérer le nom du compte
     * @return nom du compte
     */
    public String getNomCompte() {
        return nomCompte;
    }

    /**
     * Mettre le nom du compte
     * @param nomCompte nom de compte
     */
    public void setNomCompte(String nomCompte) {
        this.nomCompte = nomCompte;
    }

    /**
     * Récupérer la somme disponible sur le compte
     * @return la somme disponible
     */
    public double getSomme() {
        return somme;
    }

    /**
     * Mettre la somme dans le compte
     * @param somme la somme disponible
     */
    public void setSomme(double somme) {
        this.somme = somme;
    }

    /**
     * Récupérer la liste des payements
     * @return la liste des payements
     */
    public ArrayList<Payement> getListPayements() {
        return listPayements;
    }

    /**
     * Mettre la liste des payements
     * @param listPayements la liste des payements
     */
    public void setListPayements(ArrayList<Payement> listPayements) {
        this.listPayements = listPayements;
    }
       
    /**
     * Ajouter un payement à la liste des payements
     * @param payement le payement à ajouter
     */
    public void addPayements(Payement payement) {
        this.listPayements.add(payement);
        this.setSomme(this.getSomme() - payement.getMontant());
    }
}
