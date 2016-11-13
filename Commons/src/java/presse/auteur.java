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
public class auteur {
    private int numA;
    private String nomA;
    private String prenomA;
    private HashMap<Integer,article> listeArticles;
    
    public auteur(int n, String no, String p) {
        this.numA = n;
        this.nomA = no;
        this.prenomA = p;
    }
    
    public int getNumA() {
        return this.numA;
    }
    
    public void setNumA(int n) {
        this.numA = n;
    }
    
    public String getNomA() {
        return this.nomA;
    }
    
    public void setNomA(String n) {
        this.nomA = n;
    }
    
    public String getPrenomA() {
        return this.prenomA;
    }
    
    public void setPrenomA(String p) {
        this.prenomA = p;
    }

    public HashMap<Integer, article> getListeArticles() {
        return listeArticles;
    }

    public void setListeArticles(HashMap<Integer, article> listeArticles) {
        this.listeArticles = listeArticles;
    }
}
