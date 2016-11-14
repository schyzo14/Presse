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
        article a = new article(1, "Nom article", "Contenu Article");
        this.listeArticles.put(a.getNumA(), a);
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
}
