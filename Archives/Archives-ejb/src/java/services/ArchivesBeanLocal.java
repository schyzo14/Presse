package services;

import java.util.ArrayList;
import javax.ejb.Local;
import presse.Titre;
import presse.Volume;


/**
 * Interface du serveur Archives
 * Implémentée par archivesBean
 */
@Local
public interface ArchivesBeanLocal {
    
    /**
     * Ajout d'un nouveau volume
     * @param vol numéro de volume
     * @return volume v
     */
    public Volume addVolume(String vol);
    
    /**
     * Récupération de tous les titres
     * @return ArrayList liste de titres
     */
    public ArrayList<Titre> getTitres();
    
    /**
     * Recherche de titres par nom
     * @param nomT
     * @return ArrayList liste des titres trouvés
     */
    public ArrayList<Titre> getTitreParNom(String nomT);
    
    /**
     * Recherche de titres par mots-clés
     * @param motsCles
     * @return ArrayList liste des titres trouvés
     */
    public ArrayList<Titre> getTitreParMC(String motsCles);
    
    /**
     * Recherche d'un volume dans un titre
     * @param numV
     * @param nomT
     * @return volume v
     */
    public Volume getVolume(String numV, String nomT);
}
