/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import java.util.HashMap;
import javax.ejb.Local;
import presse.article;
import presse.auteur;
import presse.motsCles;

/**
 *
 * ArticlesBeanLocal
 */
@Local
public interface ArticlesBeanLocal {
    public article getArticles(int numA);
    public HashMap<Integer, article> getListeArticles();
    
    public auteur getAuteurs(int numA);
    public HashMap<Integer, auteur> getListeAuteurs();
    
    public motsCles getMotsCles(int numMC);
    public HashMap<Integer, motsCles> getListeMotsCles();

    public article addArticles(String nomA, String nomAut, String contenu, String motcles);
    public auteur addAuteurs(String nomA, String nomAut, String contenu, String motcles);
    public motsCles addMotsCles(String nomA, String nomAut, String contenu, String motcles);
}
