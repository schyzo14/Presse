/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presse;

import java.util.Date;

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
}