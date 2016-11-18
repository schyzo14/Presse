/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import java.util.HashMap;
import javax.ejb.Singleton;
import presse.article;
import presse.auteur;
import presse.motsCles;
import presse.publicite;
import presse.volume;

/**
 *
 * @author manou
 */
@Singleton
public class PresseBean implements PresseBeanLocal{
    private HashMap<Integer, article> listeArticles;
    private HashMap<Integer, auteur> listeAuteurs;
    private HashMap<Integer, motsCles> listeMotsCles;
    private HashMap<Integer, publicite> listePublicite;
    private HashMap<Integer, volume> listeVolume;
    private int lastid;
    
    public PresseBean() {
               
        //Initialisation de la table Articles
        this.listeArticles = new HashMap<>();
        this.listeAuteurs = new HashMap<>();
        this.listeMotsCles = new HashMap<>();
        this.listePublicite = new HashMap<>();
        this.listeVolume = new HashMap<>();
        this.lastid = 0;
        
        //Alimentation des articles
        article a1 = new article(1, "Final Fantasy XV", "Final Fantasy XV, annoncé originellement sous le titre Final Fantasy Versus XIII, est un jeu vidéo développé et édité par Square-Enix, prévu pour le 29 novembre 2016 sur PlayStation 4 et Xbox One.");
        this.listeArticles.put(a1.getNumA(), a1);
        auteur aut1 = new auteur(99, "Nom Test", "Prenom Test");
        a1.getListeAuteurs().put(99, aut1);
        
        article a2 = new article(2, "Naruto - The Last", "Naruto the Last, le film est le dixième film japonais basé sur le manga Naruto et le septième film tiré de l'anime Naruto Shippûden, sorti le 6 décembre 2014 au Japon");
        this.listeArticles.put(a2.getNumA(), a2);
        auteur aut2 = new auteur(98, "Nom Test", "Prenom Test");
        a2.getListeAuteurs().put(98, aut2);
        
        article a3 = new article(3, "Coupe du Monde", "La Coupe du monde de football ou Coupe du monde de la FIFA est une compétition internationale de football qui se déroule ordinairement tous les quatre ans.");
        this.listeArticles.put(a3.getNumA(), a3);
        auteur aut3 = new auteur(97, "Nom Test", "Prenom Test");
        a3.getListeAuteurs().put(97, aut3);
        

    }
    
    //Récupérer les articles
    @Override
    public article getArticles(int numA) {
        return this.listeArticles.get(numA);
    }

    @Override
    public HashMap<Integer, article> getListeArticles() {
        return listeArticles;
    }

    public void setListeArticles(HashMap<Integer, article> listeArticles) {
        this.listeArticles = listeArticles;
    }
    
    //Récupérer les auteurs
    @Override
    public auteur getAuteurs(int numA) {
        return this.listeAuteurs.get(numA);
    }

    @Override
    public HashMap<Integer, auteur> getListeAuteurs() {
        return listeAuteurs;
    }

    public void setListeAuteurs(HashMap<Integer, auteur> listeAuteurs) {
        this.listeAuteurs = listeAuteurs;
    }
    
    //Récupérer les mots cles
    @Override
    public motsCles getMotsCles(int numMC) {
        return this.listeMotsCles.get(numMC);
    }

    @Override
    public HashMap<Integer, motsCles> getListeMotsCles() {
        return listeMotsCles;
    }

    public void setListeMotsCles(HashMap<Integer, motsCles> listeMC) {
        this.listeMotsCles = listeMC;
    }

    @Override
    public volume getVolume(int numVol) {
        return this.listeVolume.get(numVol);
    }

    @Override
    public HashMap<Integer, volume> getListeVolume() {
        return this.listeVolume;
    }

    @Override
    public publicite getPublicite(int numPub) {
        return this.listePublicite.get(numPub);
    }

    @Override
    public HashMap<Integer, publicite> getListePublicite() {
        return this.listePublicite;
    }
   
}
