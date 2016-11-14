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

/**
 *
 * @author manou
 */
@Local
public interface ArticlesBeanLocal {
    public article getArticles(int numA);
    public HashMap<Integer, article> getListeArticles();
    
    public auteur getAuteurs(int numA);
    public HashMap<Integer, auteur> getListeAuteurs();

    public article addArticles(String nomA, String nomAut, String contenu, String motcles);
}
