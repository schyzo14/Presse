/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presse;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Schyzo
 */
public class contrat {
    private int numC;
    private int nbCopieC;
    private int dureeC;
    private float coutC;
    private Date dateValC;
    private Date datePaieC;
    private HashMap<Integer,distributeur> listeDistributeurs;
    private HashMap<Integer,editeur> listeEditeurs;
    private HashMap<Integer,titre> listeTitres;

    public contrat(int numC, int nbCopieC, int dureeC, float coutC, Date dateValC, Date datePaieC) {
        this.numC = numC;
        this.nbCopieC = nbCopieC;
        this.dureeC = dureeC;
        this.coutC = coutC;
        this.dateValC = dateValC;
        this.datePaieC = datePaieC;
    }

    public int getNumC() {
        return numC;
    }

    public void setNumC(int numC) {
        this.numC = numC;
    }

    public int getNbCopieC() {
        return nbCopieC;
    }

    public void setNbCopieC(int nbCopieC) {
        this.nbCopieC = nbCopieC;
    }

    public int getDureeC() {
        return dureeC;
    }

    public void setDureeC(int dureeC) {
        this.dureeC = dureeC;
    }

    public float getCoutC() {
        return coutC;
    }

    public void setCoutC(float coutC) {
        this.coutC = coutC;
    }

    public Date getDateValC() {
        return dateValC;
    }

    public void setDateValC(Date dateValC) {
        this.dateValC = dateValC;
    }

    public Date getDatePaieC() {
        return datePaieC;
    }

    public void setDatePaieC(Date datePaieC) {
        this.datePaieC = datePaieC;
    }

    public HashMap<Integer, distributeur> getListeDistributeurs() {
        return listeDistributeurs;
    }

    public void setListeDistributeurs(HashMap<Integer, distributeur> listeDistributeurs) {
        this.listeDistributeurs = listeDistributeurs;
    }

    public HashMap<Integer, editeur> getListeEditeurs() {
        return listeEditeurs;
    }

    public void setListeEditeurs(HashMap<Integer, editeur> listeEditeurs) {
        this.listeEditeurs = listeEditeurs;
    }

    public HashMap<Integer, titre> getListeTitres() {
        return listeTitres;
    }

    public void setListeTitres(HashMap<Integer, titre> listeTitres) {
        this.listeTitres = listeTitres;
    }
}
