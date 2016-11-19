/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.distributeur;

import client.distributeur.Vue.Menu.MenuAvantConnexion;
import presse.distributeur;

/**
 *
 * @author Aurore
 */
public class ClientDistributeur {

    public static distributeur monDistributeur;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Afficher la fenetre
        MenuAvantConnexion menuAvantConnexion = new MenuAvantConnexion();
        menuAvantConnexion.setVisible(true);
    }
    
}
