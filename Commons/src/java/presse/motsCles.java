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
public class motsCles {
    private int numMC;
    private String motCle;
    private HashMap<Integer,article> listeArticles;
    private HashMap<Integer,titre> listeTitres;
    
    public motsCles(int n, String m) {
        this.numMC = n;
        this.motCle = m;
    }

    public int getNumMC() {
        return numMC;
    }

    public void setNumMC(int numMC) {
        this.numMC = numMC;
    }

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public HashMap<Integer, article> getListeArticles() {
        return listeArticles;
    }

    public void setListeArticles(HashMap<Integer, article> listeArticles) {
        this.listeArticles = listeArticles;
    }

    public HashMap<Integer, titre> getListeTitres() {
        return listeTitres;
    }

    public void setListeTitres(HashMap<Integer, titre> listeTitres) {
        this.listeTitres = listeTitres;
    }
}
