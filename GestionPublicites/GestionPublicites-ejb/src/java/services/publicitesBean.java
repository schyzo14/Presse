package services;

import java.util.HashMap;
import javax.ejb.Singleton;
import presse.publicite;

/**
 * Bean publicites
 */
@Singleton
public class publicitesBean implements publicitesBeanLocal {
    //Liste des publicités de la "BD"
    private HashMap<Integer, publicite> listePubs;

    /**
     * Constructeur
     */
    public publicitesBean() {
        //Initialisation de la "BD"
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
    
    /**
     * Récupérer la publicité
     * @param num numéro de la publicité
     * @return publicite la publicité trouvée
     */
    @Override
    public publicite getPublicites(int num) {
        return this.listePubs.get(num);
    }

    /**
     * Récupérer toutes les publicités
     * @return listePubs la liste des publicités
     */
    @Override
    public HashMap<Integer, publicite> getListePubs() {
        return listePubs;
    }

    /**
     * Saisir la nouvelle liste de publicités
     * @param listePubs la liste des publicités
     */
    @Override
    public void setListePubs(HashMap<Integer, publicite> listePubs) {
        this.listePubs = listePubs;
    }
}
