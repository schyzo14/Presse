package services;

import java.util.ArrayList;
import javax.ejb.Local;
import presse.titre;
import presse.volume;


/**
 * Interface du serveur Archives
 * Implémentée par archivesBean
 */
@Local
public interface archivesBeanLocal {
    
    /**
     * Ajout d'un nouveau volume
     * @param vol numéro de volume
     * @return volume v
     */
    public volume addVolume(String vol);
    
    /**
     * Récupération de tous les titres
     * @return ArrayList liste de titres
     */
    public ArrayList<titre> getTitres();
    
    /**
     * Recherche de titres par nom
     * @param nomT
     * @return ArrayList liste des titres trouvés
     */
    public ArrayList<titre> getTitreParNom(String nomT);
    
    /**
     * Recherche de titres par mots-clés
     * @param motsCles
     * @return ArrayList liste des titres trouvés
     */
    public ArrayList<titre> getTitreParMC(String motsCles);
    
    /**
     * Recherche d'un volume dans un titre
     * @param numV
     * @param nomT
     * @return volume v
     */
    public volume getVolume(String numV, String nomT);
}
