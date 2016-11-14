/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.HashMap;
import javax.ejb.Singleton;
import presse.publicite;

/**
 *
 * @author Schyzo
 */
@Singleton
public class publicitesBean implements publicitesBeanLocal {
    private HashMap<Integer, publicite> listePubs;

    public publicitesBean() {
        this.listePubs = new HashMap<>();
        publicite p = new publicite(1, "Pub Colgate", "Colgate", "Fraicheur et machage");
        this.listePubs.put(p.getNumP(), p);
    }
    
    //Récupérer les pubs
    @Override
    public HashMap<Integer, publicite> getPublicites() {
        return this.listePubs;
    }

    public HashMap<Integer, publicite> getListePubs() {
        return listePubs;
    }

    public void setListePubs(HashMap<Integer, publicite> listePubs) {
        this.listePubs = listePubs;
    }
}
