/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presse;

/**
 *
 * @author Schyzo
 */
public class motsCles {
    private int numMC;
    private String motCle;
    
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
}
