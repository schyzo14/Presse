/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presse;

import java.util.HashMap;

/**
 *
 * @author Schyzo
 */
public class distributeur {
    private int numD;
    private String nomD;
    private String mailD;
    private String mdpD;


    public distributeur(int numD, String nomD, String mailD) {
        this.numD = numD;
        this.nomD = nomD;
        this.mailD = mailD;
        this.mdpD = Integer.toString(1 + (int)(Math.random() * ((1000 - 1) + 1)));
    }
    
    public distributeur(int numD, String nomD, String mailD, String mdp) {
        this.numD = numD;
        this.nomD = nomD;
        this.mailD = mailD;
        this.mdpD = mdp;
    }

    public int getNumD() {
        return numD;
    }

    public void setNumD(int numD) {
        this.numD = numD;
    }

    public String getNomD() {
        return nomD;
    }

    public void setNomD(String nomD) {
        this.nomD = nomD;
    }

    public String getMailD() {
        return mailD;
    }

    public void setMailD(String mailD) {
        this.mailD = mailD;
    }

    public String getMdpD() {
        return mdpD;
    }

    public void setMdpD(String mdpD) {
        this.mdpD = mdpD;
    }

}
