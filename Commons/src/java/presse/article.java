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
public class article {
    private int numA;
    private String nomA;
    private String contenuA;
    
    public article(int n, String no, String c) {
        this.numA = n;
        this.nomA = no;
        this.contenuA = c;
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
}
