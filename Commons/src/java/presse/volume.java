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
    private String nomV;
    private HashMap<Integer,article> listeArticles;
    private HashMap<Integer,publicite> listePublicites;

    public volume(int numV, String nomV) {
        this.numV = numV;
        this.nomV = nomV;
    }

    public int getNumV() {
        return numV;
    }

    public void setNumV(int numV) {
        this.numV = numV;
    }

    public String getNomV() {
        return nomV;
    }

    public void setNomV(String nomV) {
        this.nomV = nomV;
    }

    public HashMap<Integer, article> getListeArticles() {
        return listeArticles;
    }

    public void setListeArticles(HashMap<Integer, article> listeArticles) {
        this.listeArticles = listeArticles;
    }

    public HashMap<Integer, publicite> getListePublicites() {
        return listePublicites;
    }

    public void setListePublicites(HashMap<Integer, publicite> listePublicites) {
        this.listePublicites = listePublicites;
    }
}
