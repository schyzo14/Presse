package presse;

import java.util.Date;

/**
 * Classe contrat
 */
public class contrat {
    //Numéro du contrat
    private int numC;
    //Nombre de copies du contrat
    private int nbCopieC;
    //Durée du contrat en mois
    private int dureeC;
    //Coût du contrat
    private float coutC;
    //Date de validation du contrat
    private Date dateValC;
    //Date du paiement du contrat
    private Date datePaieC;
    //Distributeur du contrat
    private distributeur distributeurC;
    //Editeur du contrat
    private editeur editeurC;
    //Titre du contrat
    private titre titreC;
    //Etat du contrat
    //ATTENTECOUT, ATTENTEVALDISTRIB, ATTENTERECEPISSE, ATTENTEVALEDITEUR, VALIDATIONEDITEUR, REFUSDISTRIBUTEUR
    private String etatC;
    //Récépissé du contrat
    private String recepisseC;

    /**
     * Constructeur
     * @param numC le numéro du contrat
     * @param nbCopieC le nombre de copies du contrat
     * @param dureeC la durée du contrat
     * @param coutC le coût du contrat
     * @param dateValC la date de validation du contrat
     * @param datePaieC la date de paiement du contrat
     * @param etat l'état du contrat
     * @param ed l'éditeur du contrat
     * @param distrib le distributeur du contrat
     * @param t le titre du contrat
     */
    public contrat(int numC, int nbCopieC, int dureeC, float coutC, 
            Date dateValC, Date datePaieC, String etat, editeur ed, 
            distributeur distrib, titre t) {
        this.numC = numC;
        this.nbCopieC = nbCopieC;
        this.dureeC = dureeC;
        this.coutC = coutC;
        this.dateValC = dateValC;
        this.datePaieC = datePaieC;
        this.distributeurC = distrib;
        this.editeurC = ed;
        this.titreC = t;
        this.recepisseC = "";
        this.etatC = etat;
    }

    /**
     * Récupérer le numéro du contrat
     * @return numC le numéro du contrat
     */
    public int getNumC() {
        return numC;
    }

    /**
     * Saisir le nouveau numéro du contrat
     * @param numC le numéro du contrat
     */
    public void setNumC(int numC) {
        this.numC = numC;
    }

    /**
     * Récupérer le nombre de copies du contrat
     * @return nbCopieC le nombre copies du contrat
     */
    public int getNbCopieC() {
        return nbCopieC;
    }

    /**
     * Saisir le nouveau nombre de copies du contrat
     * @param nbCopieC le nombre de copies du contrat
     */
    public void setNbCopieC(int nbCopieC) {
        this.nbCopieC = nbCopieC;
    }

    /**
     * Récupérer la durée du contrat
     * @return dureeC la durée du contrat
     */
    public int getDureeC() {
        return dureeC;
    }

    /**
     * Saisir la nouvelle durée du contrat
     * @param dureeC la nouvelle durée du contrat
     */
    public void setDureeC(int dureeC) {
        this.dureeC = dureeC;
    }

    /**
     * Récupérer le coût du contrat
     * @return coutC le coût du contrat
     */
    public float getCoutC() {
        return coutC;
    }

    /**
     * Saisir le nouveau coût du contrat
     * @param coutC le coût du contrat
     */
    public void setCoutC(float coutC) {
        this.coutC = coutC;
    }

    /**
     * Récupérer la date de validation du contrat
     * @return dateValC la date de validation du contrat
     */
    public Date getDateValC() {
        return dateValC;
    }

    /**
     * Saisir la nouvelle date de validation du contrat
     * @param dateValC la date de validation du contrat
     */
    public void setDateValC(Date dateValC) {
        this.dateValC = dateValC;
    }

    /**
     * Récupérer la date de paiement du contrat
     * @return datePaieC la date de paiement du contrat
     */
    public Date getDatePaieC() {
        return datePaieC;
    }

    /**
     * Saisir la nouvelle date de paiement du contrat
     * @param datePaieC la date de paiement du contrat
     */
    public void setDatePaieC(Date datePaieC) {
        this.datePaieC = datePaieC;
    }

    /**
     * Récupérer le distributeur du contrat
     * @return distributeurC le distributeur du contrat
     */
    public distributeur getDistributeurC() {
        return distributeurC;
    }

    /**
     * Saisir le nouveau distributeur du contrat
     * @param distributeurC le distributeur du contrat
     */
    public void setDistributeurC(distributeur distributeurC) {
        this.distributeurC = distributeurC;
    }

    /**
     * Récupérer l'éditeur du contrat
     * @return editeurC l'éditeur du contrat
     */
    public editeur getEditeurC() {
        return editeurC;
    }

    /**
     * Saisir le nouvel éditeur du contrat
     * @param editeurC le nouvel éditeur du contrat
     */
    public void setEditeurC(editeur editeurC) {
        this.editeurC = editeurC;
    }

    /**
     * Récupérer le titre du contrat
     * @return titreC le titre du contrat
     */
    public titre getTitreC() {
        return titreC;
    }

    /**
     * Saisir le nouveau titre du contrat
     * @param titreC le titre du contrat
     */
    public void setTitreC(titre titreC) {
        this.titreC = titreC;
    }

    /**
     * Récupérer l'état du contrat
     * @return etatC l'état du contrat
     */
    public String getEtatC() {
        return etatC;
    }

    /**
     * Saisir le nouvel état du contrat
     * @param etatC l'état du contrat
     */
    public void setEtatC(String etatC) {
        this.etatC = etatC;
    }

    /**
     * Récupérer le récépissé du contrat
     * @return recepisse le récépissé du contrat
     */
    public String getRecepisseC() {
        return recepisseC;
    }

    /**
     * Saisir le nouveau récépissé du contrat
     * @param recepisseC le récépissé du contrat
     */
    public void setRecepisseC(String recepisseC) {
        this.recepisseC = recepisseC;
    }
}
