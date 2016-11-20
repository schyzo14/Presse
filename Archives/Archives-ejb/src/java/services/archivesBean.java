/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import javax.ejb.Singleton;
import presse.volume;

/**
 *
 * @author Khadija
 */
@Singleton
public class archivesBean implements archivesBeanLocal {
    private int lastid;
    private HashMap<Integer, volume> listeVolumes;
    
    public archivesBean() {
        listeVolumes = new HashMap<>();
        lastid = 0;
    }

    @Override
    public volume addVolume(String vol) {
        Gson gson = new Gson();
        java.lang.reflect.Type typeVolume = new TypeToken<volume>(){}.getType();
        volume v = gson.fromJson(vol, typeVolume);
        
        return v;
    }
}
