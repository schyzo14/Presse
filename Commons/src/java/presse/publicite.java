package presse;

import java.util.HashMap;

/**
 * Classe publicite
 */
public class publicite {
    //Le numéro de la publicité
    private int numP;
    //Le nom de la publicité
    private String nomP;
    //La compagnie de la publicité
    private String compagnie;
    //Le contenu de la publicité
    private String contenuP;
    //Les volumes qui utilisent la publicité
    private HashMap<Integer,volume> listeVolumes;

    /**
     * Constructeur
     * @param numP le numéro de la publicité
     * @param nomP le nom de la publicité
     * @param compagnie la compagnie de la publicité
     * @param contenuP le contenu de la publicité
     */
    public publicite(int numP, String nomP, String compagnie, String contenuP) {
        this.numP = numP;
        this.nomP = nomP;
        this.compagnie = compagnie;
        this.contenuP = contenuP;
        listeVolumes = new HashMap<>();
    }

    /**
     * Récupérer le numéro de la publicité
     * @return numP le numéro de la publicité
     */
    public int getNumP() {
        return numP;
    }

    /**
     * Saisir le nouveau numéro de la publicité
     * @param numP le numéro de la publicité
     */
    public void setNumP(int numP) {
        this.numP = numP;
    }

    /**
     * Récupérer le nom de la publicité
     * @return nomP le nom de la publicité
     */
    public String getNomP() {
        return nomP;
    }

    /**
     * Saisir le nouveau nom de la publicité
     * @param nomP le nom de la publicité
     */
    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    /**
     * Récupérer la compagnie de la publicité
     * @return compagnie la compagnie de la publicité
     */
    public String getCompagnie() {
        return compagnie;
    }

    /**
     * Saisir la nouvelle compagnie de la publicité
     * @param compagnie la compagnie de la publicité
     */
    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }

    /**
     * Récupérer le contenu de la publicité
     * @return contenuP le contenu de la publicité
     */
    public String getContenuP() {
        return contenuP;
    }

    /**
     * Saisir le nouveau contenu de la publicité
     * @param contenuP le contenu de la publicité
     */
    public void setContenuP(String contenuP) {
        this.contenuP = contenuP;
    }

    /**
     * Récupérer la liste des volumes de la publicité
     * @return listeVolumes la liste des volumes de la publicité
     */
    public HashMap<Integer, volume> getListeVolumes() {
        return listeVolumes;
    }

    /**
     * Saisir la nouvelle liste des volumes de la publicité
     * @param listeVolumes la liste des volumes de la publicité
     */
    public void setListeVolumes(HashMap<Integer, volume> listeVolumes) {
        this.listeVolumes = listeVolumes;
    }
}
