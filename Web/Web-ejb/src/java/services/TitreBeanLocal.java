/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.HashMap;
import javax.ejb.Local;
import presse.titre;

/**
 *
 * @author Aurore
 */
@Local
public interface TitreBeanLocal {
    
    public HashMap<Integer, titre> getListeTitre();
}
