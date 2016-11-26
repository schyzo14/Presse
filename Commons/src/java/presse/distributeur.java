package presse;

/**
 * Classe distributeur
 */
public class distributeur {
    //Numéro du distributeur
    private int numD;
    //Nom du distributeur
    private String nomD;
    //Mail du distributeur
    private String mailD;
    //Mot de passe du distributeur
    private String mdpD;

    /**
     * Constructeur sans mot de passe
     * @param numD le numéro du distributeur
     * @param nomD le nom du distributeur
     * @param mailD le mail du distributeur
     */
    public distributeur(int numD, String nomD, String mailD) {
        this.numD = numD;
        this.nomD = nomD;
        this.mailD = mailD;
        this.mdpD = Integer.toString(1 + (int)(Math.random() * ((1000 - 1) + 1)));
    }
    
    /**
     * Constructeur avec mot de passe
     * @param numD le numéro du distributeur
     * @param nomD le nom du distributeur
     * @param mailD le mail du distributeur
     * @param mdp le mot de passe du distributeur
     */
    public distributeur(int numD, String nomD, String mailD, String mdp) {
        this.numD = numD;
        this.nomD = nomD;
        this.mailD = mailD;
        this.mdpD = mdp;
    }

    /**
     * Récupérer le numéro du ditributeur
     * @return numD le numéro du distributeur
     */
    public int getNumD() {
        return numD;
    }

    /**
     * Saisir le nouveau numéro du distributeur
     * @param numD le numéro du distributeur
     */
    public void setNumD(int numD) {
        this.numD = numD;
    }

    /**
     * Récupérer le nom du ditributeur
     * @return nomD le nom du distributeur
     */
    public String getNomD() {
        return nomD;
    }

    /**
     * Saisir le nouveau nom du distributeur
     * @param nomD le nom du distributeur
     */
    public void setNomD(String nomD) {
        this.nomD = nomD;
    }

    /**
     * Récupérer le mail du ditributeur
     * @return mailD le mail du distributeur
     */
    public String getMailD() {
        return mailD;
    }

    /**
     * Saisir le nouveau mail du distributeur
     * @param mailD le mail du distributeur
     */
    public void setMailD(String mailD) {
        this.mailD = mailD;
    }

    /**
     * Récupérer le mot de passe du ditributeur
     * @return mdpD le mot de passe du distributeur
     */
    public String getMdpD() {
        return mdpD;
    }

    /**
     * Saisir le nouveau mot de passe du distributeur
     * @param mdpD le mot de passe du distributeur
     */
    public void setMdpD(String mdpD) {
        this.mdpD = mdpD;
    }
}
