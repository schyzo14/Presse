
package services;

import java.util.HashMap;
import javax.ejb.Local;
import presse.contrat;

/**
 * Interface ContratBeanLocal
 */
@Local
public interface ContratBeanLocal {
    
    /**
     * Créer un contrat
     * 
     * @param distributeurId    Id du distributeur
     * @param editeurId         Id de l'éditeur
     * @param titreId           Id du titre
     * @param nbCopies          nombre de copie
     * @param duree             durée
     * @return                  contrat créé
     */
    public contrat créerContrat(int distributeurId, int editeurId, int titreId, int nbCopies, int duree);
    
    /**
     * Liste des contrats à valider par le distributeur
     * 
     * @param distributeurId    Id du distributeur
     * @return                  liste des contrats à valider
     */
    public HashMap<Integer, contrat> listContratAValider(int distributeurId);
    
    /**
     * Le distributeur valide un contrat
     * 
     * @param contratId Id du contrat
     * @return          Contrat
     */
    public contrat validerContrat(int contratId);
    
    /**
     * Le distributeur refuse un contrat
     * 
     * @param contratId
     * @return 
     */
    public contrat refuserContrat(int contratId);
    
    /**
     * Liste des contrats en attente de récépissés
     * 
     * @param distributeurId    Id du distributeur
     * @return                  Liste des contrats en attente de récépissé
     */
    public HashMap<Integer, contrat> listeContratRecepisse(int distributeurId);
    
    /**
     * Le distributeur envoie un récépissé
     * 
     * @param contratId     Id du contrat
     * @param recepisse     récépissé
     * @return              le contrat
     */
    public contrat setRecepisse(int contratId, String recepisse);
    
    /**
     * Liste des contrats en attente de cout
     * 
     * @param editeurId     Id de l'éditeur
     * @return              liste des contrats
     */
    public HashMap<Integer, contrat> listeContratAttenteCout(int editeurId);
    
    /**
     * L'éditeur met un cout à un contrat
     * 
     * @param contratId     Id du contrat
     * @param cout          le cout
     * @return              le contrat
     */
    public contrat setCout(int contratId, float cout);
    
    /**
     * Liste des contrats en attente de validation de l'éditeur
     * 
     * @param editeurId     Id de l'éditeur
     * @return              Liste de contrats
     */
    public HashMap<Integer, contrat> listeContratAValiderEditeur(int editeurId);
    
    /**
     * L'éditeur valide un contrat
     * 
     * @param contratId     Id du contrat
     * @return              le contrat
     */
    public contrat validerContratEditeur(int contratId);
    
}
