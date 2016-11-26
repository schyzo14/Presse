package REST;

import java.util.HashMap;
import javax.ejb.Local;
import presse.article;
import presse.auteur;
import presse.motsCles;
import presse.publicite;
import presse.volume;

/**
 * Interface du serveur MiseSousPresse
 * Implémentée par PresseBean
 */
@Local
public interface PresseBeanLocal {
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
     * Récupérer un volume
     * @param numVol
     * @return volume
     */
    public volume getVolume(int numVol);
    
    /**
     * Liste des volumes
     * @return HashMap de volume
     */
    public HashMap<Integer, volume> getListeVolume();
    
    /**
     * Récupérer une publicité
     * @param numPub
     * @return publicité
     */
    public publicite getPublicite(int numPub);
    
    /**
     * Liste de publicité
     * @return HashMap de publicité
     */
    public HashMap<Integer, publicite> getListePublicite();
    
    /**
     * Liste des articles sélectionnés
     * @return HashMap d'article
     */
    public HashMap<Integer, article> listeArticleSelect();
    
    /**
     * Ajouter la liste des articles sélectionnés par le rédacteur chef
     * @param unArtSel
     * @return String
     */
    public String addArticleSelect(String unArtSel);
    
}
