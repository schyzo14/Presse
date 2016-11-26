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
 * Interface du serveur TransmissionArticles
 * Implémentée par ArticlesBean
 */
@Local
public interface ArticlesBeanLocal {
    /**
     * Récupérer un article
     * @param numA
     * @return article
     */
    public article getArticles(int numA);
    
    /**
     * Récupérer la liste des articles
     * @return HashMap d'article
     */
    public HashMap<Integer, article> getListeArticles();
    
    /**
     * Modifier la liste d'articles
     * @param listeArticles 
     */
    public void setListeArticles(HashMap<Integer, article> listeArticles);
    
    /**
     * Récupérer un auteur
     * @param numA
     * @return auteur
     */
    public auteur getAuteurs(int numA);
    
    /**
     * Récupérer la liste des auteurs
     * @return HashMap d'auteur
     */
    public HashMap<Integer, auteur> getListeAuteurs();
    
    /**
     * Modifier la liste des auteurs
     * @param listeAuteurs 
     */
    public void setListeAuteurs(HashMap<Integer, auteur> listeAuteurs);
    
    /**
     * Récupérer un mot clé
     * @param numMC
     * @return motsCles
     */
    public motsCles getMotsCles(int numMC);
    
    /**
     * Liste des mots clés
     * @return HashMap de motsclés
     */
    public HashMap<Integer, motsCles> getListeMotsCles();
    
    /**
     * Modifier la liste des mots clés
     * @param listeMC 
     */
    public void setListeMotsCles(HashMap<Integer, motsCles> listeMC);

    /**
     * Ajouter l'article saisie par le Journaliste
     * @param nomA
     * @param nomAut
     * @param contenu
     * @param motcles
     * @return article
     */
    public article addArticles(String nomA, String nomAut, String contenu, String motcles);
    
    /**
     * Ajouter un auteur
     * @param nomA
     * @param nomAut
     * @param contenu
     * @param motcles
     * @return auteur
     */
    public auteur addAuteurs(String nomA, String nomAut, String contenu, String motcles);
    
    /**
     * Ajouter un mot-clé
     * @param nomA
     * @param nomAut
     * @param contenu
     * @param motcles
     * @return mot-clé
     */
    public motsCles addMotsCles(String nomA, String nomAut, String contenu, String motcles);
}
