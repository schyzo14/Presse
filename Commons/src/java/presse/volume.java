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
public class volume {
    private int numV;
    private HashMap<Integer,article> listeArticles;
    private int numT;

    public volume(int numV) {
        this.numV = numV;
        this.listeArticles = new HashMap<>();
    }

    public int getNumV() {
        return numV;
    }

    public void setNumV(int numV) {
        this.numV = numV;
    }

    public HashMap<Integer, article> getListeArticles() {
        return listeArticles;
    }

    public void setListeArticles(HashMap<Integer, article> listeArticles) {
        this.listeArticles = listeArticles;
    }

    public int getNumT() {
        return numT;
    }

    public void setNumT(int numT) {
        this.numT = numT;
    }
}
