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
 * @author Manon
 */
@Singleton
public class ArticlesBean implements ArticlesBeanLocal{
    private HashMap<Integer, article> listeArticles;
    private HashMap<Integer, auteur> listeAuteurs;
    private HashMap<Integer, motsCles> listeMotsCles;
    private int lastid;
    
    public ArticlesBean() {
        this.listeArticles = new HashMap<>();
        this.listeAuteurs = new HashMap<>();
        this.listeMotsCles = new HashMap<>();
        this.lastid = 0;
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
    public article addArticles(String nomA, String nomAut, String contenu, String motcles){
        System.out.println("nom : "+nomA+" nom Auteur : "+nomAut+" contenu : "+contenu+" motscles : "+motcles);
        article a = new article(lastid, nomA, contenu);
        this.listeArticles.put(a.getNumA(), a);
        
        auteur aut = new auteur(lastid, nomAut, "Prénom Auteurs");
        this.listeAuteurs.put(aut.getNumA(), aut);
        
        motsCles mc = new motsCles(lastid, motcles);
        this.listeMotsCles.put(mc.getNumMC(),mc);
        
        lastid++;
        return a;
    }
}
