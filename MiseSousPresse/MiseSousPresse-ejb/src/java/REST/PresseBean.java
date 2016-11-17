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
        this.listeArticles = new HashMap<>();
        this.listeAuteurs = new HashMap<>();
        this.listeMotsCles = new HashMap<>();
        this.listePublicite = new HashMap<>();
        this.listeVolume = new HashMap<>();
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
