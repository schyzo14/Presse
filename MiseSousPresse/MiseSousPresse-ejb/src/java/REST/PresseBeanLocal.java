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
import presse.publicite;
import presse.volume;

/**
 *
 * @author manou
 */
@Local
public interface PresseBeanLocal {
    public article getArticles(int numA);
    public HashMap<Integer, article> getListeArticles();
    
    public auteur getAuteurs(int numA);
    public HashMap<Integer, auteur> getListeAuteurs();
    
    public motsCles getMotsCles(int numMC);
    public HashMap<Integer, motsCles> getListeMotsCles();
    
    public volume getVolume(int numVol);
    public HashMap<Integer, volume> getListeVolume();
    
    public publicite getPublicite(int numPub);
    public HashMap<Integer, publicite> getListePublicite();
    
}
