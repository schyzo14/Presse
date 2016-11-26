package presse;

import java.util.HashMap;

/**
 * Classe auteur
 */
public class auteur {
    //Numéro de l'auteur
    private int numA;
    //Nom de l'auteur
    private String nomA;
    //Prénom de l'auteur
    private String prenomA;
    //Les articles de l'auteur
    private HashMap<Integer,article> listeArticles;
    
    /**
     * Constructeur
     * @param n le numéro de l'auteur
     * @param no le nom de l'auteur
     * @param p le prénom de l'auteur
     */
    public auteur(int n, String no, String p) {
        this.numA = n;
        this.nomA = no;
        this.prenomA = p;
    }
    
    /**
     * Récupérer le numéro de l'auteur
     * @return numA le numéro de l'auteur
     */
    public int getNumA() {
        return this.numA;
    }
    
    /**
     * Saisir le nouveau numéro de l'auteur
     * @param n le numéro de l'auteur
     */
    public void setNumA(int n) {
        this.numA = n;
    }
    
    /**
     * Récupérer le nom de l'auteur
     * @return nomA le nom de l'auteur
     */
    public String getNomA() {
        return this.nomA;
    }
    
    /**
     * Saisir le nouveau nom de l'auteur
     * @param nomA le nom de l'auteur
     */
    public void setNomA(String nomA) {
        this.nomA = nomA;
    }
    
    /**
     * Récupérer le prénom de l'auteur
     * @return prenomA le prénom de l'auteur
     */
    public String getPrenomA() {
        return this.prenomA;
    }
    
    /**
     * Saisir le nouveau prénom de l'auteur
     * @param prenomA le prénom de l'auteur
     */
    public void setPrenomA(String prenomA) {
        this.prenomA = prenomA;
    }

    /**
     * Récupérer la liste des articles de l'auteur
     * @return listeArticles les articles de l'auteur
     */
    public HashMap<Integer, article> getListeArticles() {
        return listeArticles;
    }

    /**
     * Saisir la nouvelle liste des articles de l'auteur
     * @param listeArticles la liste des articles de l'auteur
     */
    public void setListeArticles(HashMap<Integer, article> listeArticles) {
        this.listeArticles = listeArticles;
    }
}
