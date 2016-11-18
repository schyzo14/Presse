/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.HashMap;
import javax.ejb.Local;
import presse.editeur;

/**
 *
 * @author Aurore
 */
@Local
public interface EditeurBeanLocal {
    public HashMap<Integer, editeur> getListeEditeur();
}
