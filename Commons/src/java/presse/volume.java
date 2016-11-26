package presse;

import java.util.HashMap;

/**
 * Classe volume
 */
public class volume {
    //Le numéro du volume
    private int numV;
    //Les articles du volume
    private HashMap<Integer,article> listeArticles;
    //Le numéro du titre du volume
    private int numT;

    /**
     * Constructeur
     * @param numV le numéro du volume
     */
    public volume(int numV) {
        this.numV = numV;
        this.listeArticles = new HashMap<>();
    }

    /**
     * Récupérer le numéro du volume
     * @return numV le numéro du volume
     */
    public int getNumV() {
        return numV;
    }

    /**
     * Saisir le nouveau numéro du volume
     * @param numV le numéro du volume
     */
    public void setNumV(int numV) {
        this.numV = numV;
    }

    /**
     * Récupérer les articles du volume
     * @return listeArticles les articles du volume
     */
    public HashMap<Integer, article> getListeArticles() {
        return listeArticles;
    }

    /**
     * Saisir les nouveaux articles du volume
     * @param listeArticles les articles du volume
     */
    public void setListeArticles(HashMap<Integer, article> listeArticles) {
        this.listeArticles = listeArticles;
    }

    /**
     * Récupérer le numéro du titre du volume
     * @return numT le numéro du titre du volume
     */
    public int getNumT() {
        return numT;
    }

    /**
     * Saisir le nouveau numéro du titre du volume
     * @param numT le numéro du titre du volume
     */
    public void setNumT(int numT) {
        this.numT = numT;
    }
}
