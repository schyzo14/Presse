/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presse;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Schyzo
 */
public class article {
    private int numA;
    private String nomA;
    private String contenuA;
    private int numV;
    private HashMap<Integer,auteur> listeAuteurs;
    private HashMap<Integer,motsCles> listeMotsCles;
    private ArrayList<publicite> listePublicites;
    
    public article(int n, String no, String c) {
        this.numA = n;
        this.nomA = no;
        this.contenuA = c;
        listeAuteurs = new HashMap<>();
        listeMotsCles = new HashMap<>();
        listePublicites = new ArrayList<>();
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
    
    public String getContenuA() {
        return this.contenuA;
    }
    
    public void setContenuA(String c) {
        this.contenuA = c;
    }

    public HashMap<Integer, auteur> getListeAuteurs() {
        return listeAuteurs;
    }

    public void setListeAuteurs(HashMap<Integer, auteur> listeAuteurs) {
        this.listeAuteurs = listeAuteurs;
    }

    public HashMap<Integer, motsCles> getListeMotsCles() {
        return listeMotsCles;
    }

    public void setListeMotsCles(HashMap<Integer, motsCles> listeMotsCles) {
        this.listeMotsCles = listeMotsCles;
    }

    public ArrayList<publicite> getListePublicites() {
        return listePublicites;
    }

    public void setListePublicites(ArrayList<publicite> listePublicites) {
        this.listePublicites = listePublicites;
    }

    public int getNumV() {
        return numV;
    }

    public void setNumV(int numV) {
        this.numV = numV;
    }
}
