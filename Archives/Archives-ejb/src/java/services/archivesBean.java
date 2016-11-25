package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import javax.ejb.Singleton;
import presse.article;
import presse.motsCles;
import presse.volume;
import presse.titre;

/**
 * Serveur Archives, implémente archivesBeanLocal
 */
@Singleton
public class archivesBean implements archivesBeanLocal {
    //Liste des volumes de la "BD"
    private HashMap<Integer, volume> listeVolumes;
    
    //Liste des titres de la "BD"
    private HashMap<Integer, titre> listeTitres;
    
    /**
     * Constructeur
     */
    public archivesBean() {
        //init
        listeVolumes = new HashMap<>();
        listeTitres = new HashMap<>();
        
        //Création des titres
        titre t1 = new titre(1, "Square Enix");
        titre t2 = new titre(2, "Microsoft");
        
        //Création des volumes
        volume v1 = new volume(1);
        volume v2 = new volume(2);
        volume v3 = new volume(3);
        volume v4 = new volume(4);
        
        //Création d'un article
        article a = new article(1, "Final Fantasy XV", "C'est trop bien !");
        
        //Création des mots-clés
        motsCles mc1 = new motsCles(1, "Microsoft");
        motsCles mc2 = new motsCles(2, "Xbox");
        motsCles mc3 = new motsCles(3, "Kinect");
        
        //Ajout du volume à l'article
        a.setNumV(v3.getNumV());
        
        //Ajout des titres aux volumes
        v1.setNumT(t1.getNumT());
        v2.setNumT(t1.getNumT());
        v3.setNumT(t2.getNumT());
        v4.setNumT(t2.getNumT());
        
        //Ajout du titre aux MC
        mc1.getListeTitres().add(t2.getNumT());
        mc2.getListeTitres().add(t2.getNumT());
        mc3.getListeTitres().add(t2.getNumT());
        
        //Ajout de l'article au volume
        v3.getListeArticles().put(a.getNumA(), a);
        
        //Ajout des volumes aux titres
        t1.getListeVolumes().put(v1.getNumV(), v1);
        t1.getListeVolumes().put(v2.getNumV(), v2);
        t2.getListeVolumes().put(v3.getNumV(), v3);
        t2.getListeVolumes().put(v4.getNumV(), v4);
        
        //Ajout des MC au titre
        t2.getListeMotsCles().put(mc1.getNumMC(), mc1);
        t2.getListeMotsCles().put(mc2.getNumMC(), mc2);
        t2.getListeMotsCles().put(mc3.getNumMC(), mc3);
        
        //Ajout des volumes à la "BD"
        listeVolumes.put(v1.getNumV(), v1);
        listeVolumes.put(v2.getNumV(), v2);
        listeVolumes.put(v3.getNumV(), v3);
        listeVolumes.put(v4.getNumV(), v4);
        
        //Ajout des titres à la "BD"
        listeTitres.put(t1.getNumT(), t1);
        listeTitres.put(t2.getNumT(), t2);
    }
    
    /**
     * Ajout d'un nouveau volume
     * @param vol numéro de volume
     * @return volume v
     */
    @Override
    public volume addVolume(String vol) {
        Gson gson = new Gson();
        java.lang.reflect.Type typeVolume = new TypeToken<volume>(){}.getType();
        volume v = gson.fromJson(vol, typeVolume);
        
        return v;
    }
    
    /**
     * Récupération de tous les titres
     * @return ArrayList liste de titres
     */
    @Override
    public ArrayList<titre> getTitres() {
        ArrayList<titre> titresTrouves = new ArrayList<>();
        
        for(titre t : listeTitres.values()) {
            titresTrouves.add(t);
        }
        
        return titresTrouves;
    }

    /**
     * Recherche de titres par nom
     * @param nomT
     * @return ArrayList liste des titres trouvés
     */
    @Override
    public ArrayList<titre> getTitreParNom(String nomT) {
        ArrayList<titre> titresTrouves = new ArrayList<>();
        
        for(titre t : listeTitres.values()) {
            if(t.getNomT().equals(nomT)) {
                titresTrouves.add(t);
            }
        }
        
        return titresTrouves;
    }

    /**
     * Recherche de titres par mots-clés
     * @param motsCles
     * @return ArrayList liste des titres trouvés
     */
    @Override
    public ArrayList<titre> getTitreParMC(String motsCles) {
        ArrayList<titre> titresTrouves = new ArrayList<>();
        
        ArrayList<motsCles> listeMC = new ArrayList<motsCles>();
        StringTokenizer st = new StringTokenizer(motsCles, " ");
        int i = 0;
        while(st.hasMoreTokens()) {
            motsCles m = new motsCles(i, st.nextToken());
            listeMC.add(m);
            i++;
        }

        for(titre t : listeTitres.values()) {
            for(motsCles m : listeMC) {
                ArrayList<motsCles> listeMCT = new ArrayList<motsCles>(t.getListeMotsCles().values());
                for(motsCles m2 : listeMCT) {
                    if(m2.getMotCle().equalsIgnoreCase(m.getMotCle())) {
                        if(!titresTrouves.contains(t)) {
                            titresTrouves.add(t);
                        }
                    }
                }
            }
        }
        
        return titresTrouves;
    }
    
    /**
     * Recherche d'un volume dans un titre
     * @param numV
     * @param nomT
     * @return volume v
     */
    @Override
    public volume getVolume(String numV, String nomT) {
        volume v = null;
        for(titre t : this.listeTitres.values()) {
            if(t.getNomT().equalsIgnoreCase(nomT)) {
                v = t.getListeVolumes().get(Integer.parseInt(numV));
            }
        }
        
        return v;
    }
}
