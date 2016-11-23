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

/**
 *
 * ArticlesBean implements ArticlesBeanLocal
 */
@Singleton
public class ArticlesBean implements ArticlesBeanLocal{
    private HashMap<Integer, article> listeArticles;
    private HashMap<Integer, auteur> listeAuteurs;
    private HashMap<Integer, motsCles> listeMotsCles;
    private int lastid;
    
    /**
     * Constructeur 
     * Initialise les objets
     */
    public ArticlesBean() {
        this.listeArticles = new HashMap<>();
        this.listeAuteurs = new HashMap<>();
        this.listeMotsCles = new HashMap<>();
        this.lastid = 4;
        
        //Alimentation des articles
        article a1 = new article(1, "Final Fantasy XV", "Final Fantasy XV, annoncé originellement sous le titre Final Fantasy Versus XIII, est un jeu vidéo développé et édité par Square-Enix, prévu pour le 29 novembre 2016 sur PlayStation 4 et Xbox One.");
        this.listeArticles.put(a1.getNumA(), a1);
        auteur aut1 = new auteur(1, "Nom Test", "Prenom Test");
        a1.getListeAuteurs().put(1, aut1);
        motsCles mc1 = new motsCles(1, "mc1");
        a1.getListeMotsCles().put(1, mc1);
        
        article a2 = new article(2, "Naruto - The Last", "Naruto the Last, le film est le dixième film japonais basé sur le manga Naruto et le septième film tiré de l'anime Naruto Shippûden, sorti le 6 décembre 2014 au Japon");
        this.listeArticles.put(a2.getNumA(), a2);
        auteur aut2 = new auteur(2, "Nom Test", "Prenom Test");
        a2.getListeAuteurs().put(2, aut2);
        motsCles mc2 = new motsCles(2, "mc2");
        a2.getListeMotsCles().put(1, mc1);
        a2.getListeMotsCles().put(2, mc2);
        
        article a3 = new article(3, "Coupe du Monde", "La Coupe du monde de football ou Coupe du monde de la FIFA est une compétition internationale de football qui se déroule ordinairement tous les quatre ans.");
        this.listeArticles.put(a3.getNumA(), a3);
        auteur aut3 = new auteur(3, "Nom Test", "Prenom Test");
        a3.getListeAuteurs().put(3, aut3);
        motsCles mc3 = new motsCles(3, "mc3");
        a3.getListeMotsCles().put(1, mc1);
        a3.getListeMotsCles().put(2, mc2);
        a3.getListeMotsCles().put(3, mc3);
    }
    
    //Gérer les articles
    /**
     * Récupérer un article
     * @param numA
     * @return article
     */
    @Override
    public article getArticles(int numA) {
        return this.listeArticles.get(numA);
    }

    /**
     * Récupérer la liste des articles
     * @return HashMap d'article
     */
    @Override
    public HashMap<Integer, article> getListeArticles() {
        return listeArticles;
    }

    /**
     * Modifier la liste d'articles
     * @param listeArticles 
     */
    public void setListeArticles(HashMap<Integer, article> listeArticles) {
        this.listeArticles = listeArticles;
    }
    
    //Gérer les auteurs
    /**
     * Récupérer un auteur
     * @param numA
     * @return auteur
     */
    @Override
    public auteur getAuteurs(int numA) {
        return this.listeAuteurs.get(numA);
    }

    /**
     * Récupérer la liste des auteurs
     * @return HashMap d'auteur
     */
    @Override
    public HashMap<Integer, auteur> getListeAuteurs() {
        return listeAuteurs;
    }

    /**
     * Modifier la liste des auteurs
     * @param listeAuteurs 
     */
    public void setListeAuteurs(HashMap<Integer, auteur> listeAuteurs) {
        this.listeAuteurs = listeAuteurs;
    }
    
    //Gérer les mots cles
    /**
     * Récupérer un mot clé
     * @param numMC
     * @return motsCles
     */
    @Override
    public motsCles getMotsCles(int numMC) {
        return this.listeMotsCles.get(numMC);
    }

    /**
     * Liste des mots clés
     * @return HashMap de motsclés
     */
    @Override
    public HashMap<Integer, motsCles> getListeMotsCles() {
        return listeMotsCles;
    }

    /**
     * Modifier la liste des mots clés
     * @param listeMC 
     */
    public void setListeMotsCles(HashMap<Integer, motsCles> listeMC) {
        this.listeMotsCles = listeMC;
    }
    
    /**
     * Ajouter l'article saisie par le Journaliste
     * @param unArtSel
     * @return String
     */
    @Override
    public article addArticles(String nomA, String nomAut, String contenu, String motcles){
        System.out.println("nom : "+nomA+" nom Auteur : "+nomAut+" contenu : "+contenu+" motscles : "+motcles);
        article a = new article(lastid, nomA, contenu);
        this.listeArticles.put(a.getNumA(), a);
        
        String[] auteurCast = nomAut.split(" ");
        if(auteurCast.length==1){
            auteur aut = new auteur(lastid, auteurCast[0], auteurCast[0]);
            a.getListeAuteurs().put(lastid, aut);
        }
        else if(auteurCast.length==2){
            auteur aut = new auteur(lastid, auteurCast[1], auteurCast[0]);
            a.getListeAuteurs().put(lastid, aut);
        }else{
            auteur aut = new auteur(lastid, auteurCast[2], auteurCast[0]+" "+auteurCast[1]);
            a.getListeAuteurs().put(lastid, aut);
        }

        String[] motsClesCast = motcles.split(",");
        for(int i=0; i<motsClesCast.length; i++)
        {
            motsCles mc = new motsCles(lastid, motsClesCast[i]);
            a.getListeMotsCles().put(i, mc);
        }
        
        lastid++;
        return a;
    }
    
    @Override
    public auteur addAuteurs(String nomA, String nomAut, String contenu, String motcles){
        System.out.println("nom : "+nomA+" nom Auteur : "+nomAut+" contenu : "+contenu+" motscles : "+motcles);
       
        auteur aut = new auteur(lastid, nomAut, "Prénom Auteurs");
        this.listeAuteurs.put(aut.getNumA(), aut);
        
        lastid++;
        return aut;
    }
    
    @Override
    public motsCles addMotsCles(String nomA, String nomAut, String contenu, String motcles){
        System.out.println("nom : "+nomA+" nom Auteur : "+nomAut+" contenu : "+contenu+" motscles : "+motcles);
        
        motsCles mc = new motsCles(lastid, motcles);
        this.listeMotsCles.put(mc.getNumMC(),mc);
        
        lastid++;
        return mc;
    }
}
