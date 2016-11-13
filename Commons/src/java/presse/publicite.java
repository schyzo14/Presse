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
public class publicite {
    private int numP;
    private String nomP;
    private String compagnie;
    private String contenuP;
    private HashMap<Integer,volume> listeVolumes;

    public publicite(int numP, String nomP, String compagnie, String contenuP) {
        this.numP = numP;
        this.nomP = nomP;
        this.compagnie = compagnie;
        this.contenuP = contenuP;
    }

    public int getNumP() {
        return numP;
    }

    public void setNumP(int numP) {
        this.numP = numP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }

    public String getContenuP() {
        return contenuP;
    }

    public void setContenuP(String contenuP) {
        this.contenuP = contenuP;
    }

    public HashMap<Integer, volume> getListeVolumes() {
        return listeVolumes;
    }

    public void setListeVolumes(HashMap<Integer, volume> listeVolumes) {
        this.listeVolumes = listeVolumes;
    }
}
