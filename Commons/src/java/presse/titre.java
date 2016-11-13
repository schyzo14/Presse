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
public class titre {
    private int numT;
    private String nomT;
    private HashMap<Integer,motsCles> listeMotsCles;
    private HashMap<Integer,volume> listeVolumes;

    public titre(int numT, String nomT) {
        this.numT = numT;
        this.nomT = nomT;
    }

    public int getNumT() {
        return numT;
    }

    public void setNumT(int numT) {
        this.numT = numT;
    }

    public String getNomT() {
        return nomT;
    }

    public void setNomT(String nomT) {
        this.nomT = nomT;
    }

    public HashMap<Integer, motsCles> getListeMotsCles() {
        return listeMotsCles;
    }

    public void setListeMotsCles(HashMap<Integer, motsCles> listeMotsCles) {
        this.listeMotsCles = listeMotsCles;
    }

    public HashMap<Integer, volume> getListeVolumes() {
        return listeVolumes;
    }

    public void setListeVolumes(HashMap<Integer, volume> listeVolumes) {
        this.listeVolumes = listeVolumes;
    }
}
