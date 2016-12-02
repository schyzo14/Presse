package services;

import java.util.HashMap;
import javax.ejb.Singleton;
import presse.Publicite;

/**
 * Bean publicites
 */
@Singleton
public class PublicitesBean implements PublicitesBeanLocal {
    //Liste des publicités de la "BD"
    private HashMap<Integer, Publicite> listePubs;

    /**
     * Constructeur
     */
    public PublicitesBean() {
        //Initialisation de la "BD"
        this.listePubs = new HashMap<>();
        Publicite p1 = new Publicite(1, "Pub Colgate", "Colgate", "Fraicheur et machage");
        this.listePubs.put(p1.getNumP(), p1);
        Publicite p2 = new Publicite(2, "Pub Playstation", "Playstation", "This is the future");
        this.listePubs.put(p2.getNumP(), p2);
        Publicite p3 = new Publicite(3, "Pub Air France", "Air France", "A vol d'oiseau");
        this.listePubs.put(p3.getNumP(), p3);
        Publicite p4 = new Publicite(4, "Pub Doliprane", "Doliprane", "Bye bye maux de tête");
        this.listePubs.put(p4.getNumP(), p4);
        Publicite p5 = new Publicite(5, "Pub MIAGE", "MIAGE", "L'école qui marche");
        this.listePubs.put(p5.getNumP(), p5);
    }
    
    /**
     * Récupérer la publicité
     * @param num numéro de la publicité
     * @return publicite la publicité trouvée
     */
    @Override
    public Publicite getPublicites(int num) {
        return this.listePubs.get(num);
    }

    /**
     * Récupérer toutes les publicités
     * @return listePubs la liste des publicités
     */
    @Override
    public HashMap<Integer, Publicite> getListePubs() {
        return listePubs;
    }

    /**
     * Saisir la nouvelle liste de publicités
     * @param listePubs la liste des publicités
     */
    @Override
    public void setListePubs(HashMap<Integer, Publicite> listePubs) {
        this.listePubs = listePubs;
    }
}
