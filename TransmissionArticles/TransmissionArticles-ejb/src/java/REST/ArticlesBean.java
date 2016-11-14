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
import presse.publicite;

/**
 *
 * @author Manon
 */
@Singleton
public class ArticlesBean implements ArticlesBeanLocal{
    private HashMap<Integer, article> listeArticles;
    private HashMap<Integer, auteur> listeAuteurs;
    
    public ArticlesBean() {
        this.listeArticles = new HashMap<>();
        //article a = new article(1, "Nom article", "Contenu Article");
        //this.listeArticles.put(a.getNumA(), a);
        
        this.listeAuteurs = new HashMap<>();
        //auteur aut = new auteur(1, "Nom Auteur", "Prénom Auteurs");
        //this.listeAuteurs.put(aut.getNumA(), aut);*/
    }
    
    //Récupérer les articles
    @Override
    public article getArticles(int numA) {
        return this.listeArticles.get(numA);
    }

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

    public HashMap<Integer, auteur> getListeAuteurs() {
        return listeAuteurs;
    }

    public void setListeAuteurs(HashMap<Integer, auteur> listeAuteurs) {
        this.listeAuteurs = listeAuteurs;
    }
    
    public article addArticles(String nomA, String nomAut, String contenu, String motcles){
        System.out.println("nom : "+nomA+" nom Auteur : "+nomAut+" contenu : "+contenu+" motscles : "+motcles);
        article a = new article(1, nomA, contenu);
        this.listeArticles.put(a.getNumA(), a);
        
        auteur aut = new auteur(1, nomAut, "Prénom Auteurs");
        this.listeAuteurs.put(aut.getNumA(), aut);
        
        return a;
    }
}
