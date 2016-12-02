package presse;

import java.util.HashMap;

/**
 * Classe titre
 */
public class Titre {
    //Le numéro du titre
    private int numT;
    //Le nom du titre
    private String nomT;
    //La liste des mots-clés
    private HashMap<Integer,MotsCles> listeMotsCles;
    //La liste des volumes
    private HashMap<Integer,Volume> listeVolumes;
    //La liste des contrats
    private HashMap<Integer,Contrat> listeContrats;

    /**
     * Constructeur
     * @param numT numéro du titre
     * @param nomT nom du titre
     */
    public Titre(int numT, String nomT) {
        //Le numéro du titre
        this.numT = numT;
        //Le nom du titre
        this.nomT = nomT;
        //Les mots-clés du titre
        this.listeMotsCles = new HashMap<>();
        //Les volumes du titre
        this.listeVolumes = new HashMap<>();
        //Les contrats du titre
        this.listeContrats = new HashMap<>();
    }

    /**
     * Récupérer le numéro du titre
     * @return numT le numéro du titre
     */
    public int getNumT() {
        return numT;
    }

    /**
     * Saisir le nouveau numéro du titre
     * @param numT le numéro du titre
     */
    public void setNumT(int numT) {
        this.numT = numT;
    }

    /**
     * Récupérer le nom du titre
     * @return nomT le nom du titre
     */
    public String getNomT() {
        return nomT;
    }

    /**
     * Saisir le nouveau nom du titre
     * @param nomT le nom du titre
     */
    public void setNomT(String nomT) {
        this.nomT = nomT;
    }

    /**
     * Récupérer les mots-clés du titre
     * @return listeMotsCles les mots-clés du titre
     */
    public HashMap<Integer, MotsCles> getListeMotsCles() {
        return listeMotsCles;
    }

    /**
     * Saisir les nouveaux mots-clés du titre
     * @param listeMotsCles les mots-clés du titre
     */
    public void setListeMotsCles(HashMap<Integer, MotsCles> listeMotsCles) {
        this.listeMotsCles = listeMotsCles;
    }

    /**
     * Récupérer les volumes du titre
     * @return listeVolumes les volumes du titre
     */
    public HashMap<Integer, Volume> getListeVolumes() {
        return listeVolumes;
    }

    /**
     * Saisir les nouveaux volumes du titre
     * @param listeVolumes les volumes du titre
     */
    public void setListeVolumes(HashMap<Integer, Volume> listeVolumes) {
        this.listeVolumes = listeVolumes;
    }

    /**
     * Récupérer les contrats du titre
     * @return listeContrats les contrats du titre
     */
    public HashMap<Integer, Contrat> getListeContrats() {
        return listeContrats;
    }

    /**
     * Saisir les nouveaux contrats du titre
     * @param listeContrats les contrats du titre
     */
    public void setListeContrats(HashMap<Integer, Contrat> listeContrats) {
        this.listeContrats = listeContrats;
    }
}
