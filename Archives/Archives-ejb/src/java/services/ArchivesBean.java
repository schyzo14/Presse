package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import javax.ejb.Singleton;
import presse.Article;
import presse.MotsCles;
import presse.Volume;
import presse.Titre;

/**
 * Serveur Archives, implémente archivesBeanLocal
 */
@Singleton
public class ArchivesBean implements ArchivesBeanLocal {
    //Liste des volumes de la "BD"
    private HashMap<Integer, Volume> listeVolumes;
    
    //Liste des titres de la "BD"
    private HashMap<Integer, Titre> listeTitres;
    
    /**
     * Constructeur
     */
    public ArchivesBean() {
        //init
        listeVolumes = new HashMap<>();
        listeTitres = new HashMap<>();
        
        //Création des titres
        Titre t1 = new Titre(1, "Square Enix");
        Titre t2 = new Titre(2, "Microsoft");
        
        //Création des volumes
        Volume v1 = new Volume(1);
        Volume v2 = new Volume(2);
        Volume v3 = new Volume(3);
        Volume v4 = new Volume(4);
        
        //Création d'un article
        Article a = new Article(1, "Final Fantasy XV", "C'est trop bien !");
        
        //Création des mots-clés
        MotsCles mc1 = new MotsCles(1, "Microsoft");
        MotsCles mc2 = new MotsCles(2, "Xbox");
        MotsCles mc3 = new MotsCles(3, "Kinect");
        
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
    public Volume addVolume(String vol) {
        Gson gson = new Gson();
        java.lang.reflect.Type typeVolume = new TypeToken<Volume>(){}.getType();
        Volume v = gson.fromJson(vol, typeVolume);
        
        return v;
    }
    
    /**
     * Récupération de tous les titres
     * @return ArrayList liste de titres
     */
    @Override
    public ArrayList<Titre> getTitres() {
        ArrayList<Titre> titresTrouves = new ArrayList<>();
        
        for(Titre t : listeTitres.values()) {
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
    public ArrayList<Titre> getTitreParNom(String nomT) {
        ArrayList<Titre> titresTrouves = new ArrayList<>();
        
        for(Titre t : listeTitres.values()) {
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
    public ArrayList<Titre> getTitreParMC(String motsCles) {
        ArrayList<Titre> titresTrouves = new ArrayList<>();
        
        ArrayList<MotsCles> listeMC = new ArrayList<MotsCles>();
        StringTokenizer st = new StringTokenizer(motsCles, " ");
        int i = 0;
        while(st.hasMoreTokens()) {
            MotsCles m = new MotsCles(i, st.nextToken());
            listeMC.add(m);
            i++;
        }

        for(Titre t : listeTitres.values()) {
            for(MotsCles m : listeMC) {
                ArrayList<MotsCles> listeMCT = new ArrayList<MotsCles>(t.getListeMotsCles().values());
                for(MotsCles m2 : listeMCT) {
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
    public Volume getVolume(String numV, String nomT) {
        Volume v = null;
        for(Titre t : this.listeTitres.values()) {
            if(t.getNomT().equalsIgnoreCase(nomT)) {
                v = t.getListeVolumes().get(Integer.parseInt(numV));
            }
        }
        
        return v;
    }
}
