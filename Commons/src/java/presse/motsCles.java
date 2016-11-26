package presse;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe mots-clés
 */
public class motsCles {
    //Le numéro du mot-clé
    private int numMC;
    //Le mot-clé
    private String motCle;
    //La liste des articles où le mot-clé est utilisé
    private HashMap<Integer,article> listeArticles;
    //La liste des titres où le mot-clé est utilisé
    private ArrayList<Integer> listeTitres;
    
    /**
     * Constructeur
     * @param n le numéro du mot-clé
     * @param m le mot-clé
     */
    public motsCles(int n, String m) {
        this.numMC = n;
        this.motCle = m;
        listeArticles = new HashMap<>();
        listeTitres = new ArrayList<>();
    }

    /**
     * Récupérer le numéro du mot-clé
     * @return numMC le numéro du mot-clé
     */
    public int getNumMC() {
        return numMC;
    }

    /**
     * Saisir le nouveau numéro du mot-clé
     * @param numMC le numéro du mot-clé
     */
    public void setNumMC(int numMC) {
        this.numMC = numMC;
    }

    /**
     * Récupérer le numéro du mot-clé
     * @return numMC le numéro du mot-clé
     */
    public String getMotCle() {
        return motCle;
    }

    /**
     * Saisir le nouveau texte du mot-clé
     * @param motCle le texte du mot-clé
     */
    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    /**
     * Récupérer le numéro du mot-clé
     * @return numMC le numéro du mot-clé
     */
    public HashMap<Integer, article> getListeArticles() {
        return listeArticles;
    }

    /**
     * Saisir la nouvelle liste des articles du mot-clé
     * @param listeArticles la liste des articles du mot-clé
     */
    public void setListeArticles(HashMap<Integer, article> listeArticles) {
        this.listeArticles = listeArticles;
    }

    /**
     * Récupérer le numéro du mot-clé
     * @return numMC le numéro du mot-clé
     */
    public ArrayList<Integer> getListeTitres() {
        return listeTitres;
    }

    /**
     * Saisir la nouvelle liste des titres du mot-clé
     * @param listeTitres la liste des titres du mot-clé
     */
    public void setListeTitres(ArrayList<Integer> listeTitres) {
        this.listeTitres = listeTitres;
    }
}
