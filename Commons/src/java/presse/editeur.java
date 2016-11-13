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
public class editeur {
    private int numE;
    private String nomE;
    private String mailE;
    private HashMap<Integer,contrat> listeContrats;

    public editeur(int numE, String nomE, String mailE) {
        this.numE = numE;
        this.nomE = nomE;
        this.mailE = mailE;
    }

    public int getNumE() {
        return numE;
    }

    public void setNumE(int numE) {
        this.numE = numE;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getMailE() {
        return mailE;
    }

    public void setMailE(String mailE) {
        this.mailE = mailE;
    }

    public HashMap<Integer, contrat> getListeContrats() {
        return listeContrats;
    }

    public void setListeContrats(HashMap<Integer, contrat> listeContrats) {
        this.listeContrats = listeContrats;
    }
}
