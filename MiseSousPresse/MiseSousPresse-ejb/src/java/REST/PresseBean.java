package REST;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import javax.ejb.Singleton;
import presse.article;
import presse.auteur;
import presse.motsCles;
import presse.publicite;
import presse.volume;

/**
 * Bean Presse
 */
@Singleton
public class PresseBean implements PresseBeanLocal{
    //Liste des articles
    private HashMap<Integer, article> listeArticles;
    //Liste des auteurs
    private HashMap<Integer, auteur> listeAuteurs;
    //Liste des mots-clés
    private HashMap<Integer, motsCles> listeMotsCles;
    //Liste des publicités
    private HashMap<Integer, publicite> listePublicite;
    //Liste des volumes
    private HashMap<Integer, volume> listeVolume;
    //Dernier identifiant
    private int lastid;
    //Liste des articles sélectionnés
    private HashMap<Integer, article> listeArticlesSelect;
    
    /**
     * Constructeur
     */
    public PresseBean() {
        //Initialisation des tables
        this.listeArticles = new HashMap<>();
        this.listeAuteurs = new HashMap<>();
        this.listeMotsCles = new HashMap<>();
        this.listePublicite = new HashMap<>();
        this.listeVolume = new HashMap<>();
        this.listeArticlesSelect = new HashMap<>();
        this.lastid = 0;
        
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
        a2.getListeMotsCles().put(1, mc1);
        a2.getListeMotsCles().put(2, mc2);
        a3.getListeMotsCles().put(3, mc3);
        
        //Alimentation de listeArticleSelect
        this.listeArticlesSelect.put(lastid, a1);
        lastid++;
    }
    
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
    @Override
    public void setListeArticles(HashMap<Integer, article> listeArticles) {
        this.listeArticles = listeArticles;
    }
    
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
    @Override
    public void setListeAuteurs(HashMap<Integer, auteur> listeAuteurs) {
        this.listeAuteurs = listeAuteurs;
    }
    
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
    @Override
    public void setListeMotsCles(HashMap<Integer, motsCles> listeMC) {
        this.listeMotsCles = listeMC;
    }

    /**
     * Récupérer un volume
     * @param numVol
     * @return volume
     */
    @Override
    public volume getVolume(int numVol) {
        return this.listeVolume.get(numVol);
    }

    /**
     * Liste des volumes
     * @return HashMap de volume
     */
    @Override
    public HashMap<Integer, volume> getListeVolume() {
        return this.listeVolume;
    }

    /**
     * Récupérer une publicité
     * @param numPub
     * @return publicité
     */
    @Override
    public publicite getPublicite(int numPub) {
        return this.listePublicite.get(numPub);
    }

    /**
     * Liste de publicité
     * @return HashMap de publicité
     */
    @Override
    public HashMap<Integer, publicite> getListePublicite() {
        return this.listePublicite;
    }
    
    /**
     * Liste des articles sélectionnés
     * @return HashMap d'article
     */
    @Override
    public HashMap<Integer, article> listeArticleSelect() {
        return this.listeArticlesSelect;
    }

    /**
     * Ajouter la liste des articles sélectionnés par le rédacteur chef
     * @param unArtSel
     * @return String
     */
    @Override
    public String addArticleSelect(String unArtSel){
        System.out.println("unArtSel : "+unArtSel);
        Gson gson = new Gson();
        java.lang.reflect.Type typeArticles = new TypeToken<HashMap<Integer, article>>() {}.getType();
        listeArticlesSelect = gson.fromJson(unArtSel, typeArticles);
        
        return "ok";
    }
}
