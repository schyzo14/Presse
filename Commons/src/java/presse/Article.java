package presse;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe article
 */
public class Article {
    //Numéro de l'article
    private int numA;
    //Nom de l'article
    private String nomA;
    //Contenu de l'article
    private String contenuA;
    
    //Numéro du volume qui contient l'article
    private int numV;
    //Liste des auteurs de l'article
    private HashMap<Integer,Auteur> listeAuteurs;
    //Liste des mots-clés de l'article
    private HashMap<Integer,MotsCles> listeMotsCles;
    //Liste des publicités de l'article
    private ArrayList<Publicite> listePublicites;
    
    /**
     * Constructeur
     * @param n le numéro de l'article
     * @param no le nom de l'article
     * @param c le contenu de l'article
     */
    public Article(int n, String no, String c) {
        this.numA = n;
        this.nomA = no;
        this.contenuA = c;
        listeAuteurs = new HashMap<>();
        listeMotsCles = new HashMap<>();
        listePublicites = new ArrayList<>();
    }
    
    /**
     * Récupérer le numéro de l'article
     * @return numA le numéro de l'article
     */
    public int getNumA() {
        return this.numA;
    }
    
    /**
     * Saisir le numéro de l'article
     * @param n le nouveau numéro de l'article
     */
    public void setNumA(int n) {
        this.numA = n;
    }
    
    /**
     * Récupérer le nom de l'article
     * @return nomA le nom de l'article
     */
    public String getNomA() {
        return this.nomA;
    }
    
    /**
     * Saisir le nom de l'article
     * @param no le nouveau nom de l'article
     */
    public void setNomA(String n) {
        this.nomA = n;
    }
    
    /**
     * Récupérer le contenu de l'article
     * @return contenuA le contenu de l'article
     */
    public String getContenuA() {
        return this.contenuA;
    }
    
    /**
     * Saisir le contenu de l'article
     * @param c le nouveau contenu de l'article
     */
    public void setContenuA(String c) {
        this.contenuA = c;
    }

    /**
     * Récupérer les auteurs de l'article
     * @return listeAuteurs la liste des auteurs de l'article
     */
    public HashMap<Integer, Auteur> getListeAuteurs() {
        return listeAuteurs;
    }

    /**
     * Saisir la liste des auteurs de l'article
     * @param listeAuteurs les nouveaux auteurs de l'article
     */
    public void setListeAuteurs(HashMap<Integer, Auteur> listeAuteurs) {
        this.listeAuteurs = listeAuteurs;
    }

    /**
     * Récupérer les mots-clés de l'article
     * @return listeMotsCles la liste des mots-clés de l'article
     */
    public HashMap<Integer, MotsCles> getListeMotsCles() {
        return listeMotsCles;
    }

    /**
     * Saisir la liste des mots-clés de l'article
     * @param listeMotsCles les nouveaux mots-clés de l'article
     */
    public void setListeMotsCles(HashMap<Integer, MotsCles> listeMotsCles) {
        this.listeMotsCles = listeMotsCles;
    }

    /**
     * Récupérer les publicités de l'article
     * @return listePublicites la liste des publicités de l'article
     */
    public ArrayList<Publicite> getListePublicites() {
        return listePublicites;
    }

    /**
     * Saisir la liste des publicités de l'article
     * @param listePublicites les nouvelles publicites de l'article
     */
    public void setListePublicites(ArrayList<Publicite> listePublicites) {
        this.listePublicites = listePublicites;
    }

    /**
     * Récupérer le numéro du volume de l'article
     * @return numV le numéro du volume de l'article
     */
    public int getNumV() {
        return numV;
    }

    /**
     * Saisir le numéro du volume l'article
     * @param numV le nouveau numéro de volume de l'article
     */
    public void setNumV(int numV) {
        this.numV = numV;
    }
}
