/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.HashMap;
import javax.ejb.Singleton;
import presse.titre;

/**
 *
 * @author Aurore
 */
@Singleton
public class TitreBean implements TitreBeanLocal{
    
    public static HashMap<Integer, titre> lesTitres = new HashMap<Integer, titre>();

    public TitreBean() {

    }
    

    @Override
    public HashMap<Integer, titre> getListeTitre() {
        return lesTitres;
    }

    @Override
    public void setListeTitre(HashMap<Integer, titre> listTitres) {
        lesTitres = listTitres;
    }
    
}
