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
        publicite p1 = new publicite(1, "Pub Colgate", "Colgate", "Fraicheur et machage");
        this.listePubs.put(p1.getNumP(), p1);
        publicite p2 = new publicite(2, "Pub Playstation", "Playstation", "This is the future");
        this.listePubs.put(p2.getNumP(), p2);
        publicite p3 = new publicite(3, "Pub Air France", "Air France", "A vol d'oiseau");
        this.listePubs.put(p3.getNumP(), p3);
        publicite p4 = new publicite(4, "Pub Doliprane", "Doliprane", "Bye bye maux de tête");
        this.listePubs.put(p4.getNumP(), p4);
        publicite p5 = new publicite(5, "Pub MIAGE", "MIAGE", "L'école qui marche");
        this.listePubs.put(p5.getNumP(), p5);
    }
    
    //Récupérer les pubs
    @Override
    public publicite getPublicites(int num) {
        return this.listePubs.get(num);
    }

    @Override
    public HashMap<Integer, publicite> getListePubs() {
        return listePubs;
    }

    public void setListePubs(HashMap<Integer, publicite> listePubs) {
        this.listePubs = listePubs;
    }
}
