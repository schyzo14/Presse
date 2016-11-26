package presse;

/**
 * Classe éditeur
 */
public class editeur {
    //Le numéro de l'éditeur
    private int numE;
    //Le nom de l'éditeur
    private String nomE;
    //Le mail de l'éditeur
    private String mailE;

    /**
     * Construcuteur
     * @param numE le numéro de l'éditeur
     * @param nomE le nom de l'éditeur
     * @param mailE le mail de l'éditeur
     */
    public editeur(int numE, String nomE, String mailE) {
        this.numE = numE;
        this.nomE = nomE;
        this.mailE = mailE;
    }

    /**
     * Récupérer le numéro de l'éditeur
     * @return numE le numéro de l'éditeur
     */
    public int getNumE() {
        return numE;
    }

    /**
     * Saisir le nouveau numéro de l'éditeur
     * @param numE le numéro de l'éditeur
     */
    public void setNumE(int numE) {
        this.numE = numE;
    }

    /**
     * Récupérer le nom de l'éditeur
     * @return nomE le nom de l'éditeur
     */
    public String getNomE() {
        return nomE;
    }

    /**
     * Saisir le nouveau nom de l'éditeur
     * @param nomE le nom de l'éditeur
     */
    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    /**
     * Récupérer le mail de l'éditeur
     * @return mailE le mail de l'éditeur
     */
    public String getMailE() {
        return mailE;
    }

    /**
     * Saisir le nouveau mail de l'éditeur
     * @param mailE le mail de l'éditeur
     */
    public void setMailE(String mailE) {
        this.mailE = mailE;
    }
}
