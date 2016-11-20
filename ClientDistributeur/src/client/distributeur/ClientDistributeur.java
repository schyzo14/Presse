/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.distributeur;

import client.distributeur.Vue.Menu.MenuAvantConnexion;
import client.distributeur.ws.DistributeurEditeurWS_PortType;
import client.distributeur.ws.DistributeurEditeurWS_Service;
import client.distributeur.ws.DistributeurEditeurWS_ServiceLocator;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import javax.xml.ws.WebServiceRef;
import presse.distributeur;

/**
 *
 * @author Aurore
 */
public class ClientDistributeur {

    public static distributeur monDistributeur;
    
    static DistributeurEditeurWS_Service  service = new DistributeurEditeurWS_ServiceLocator();
    static DistributeurEditeurWS_PortType  port;
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ServiceException, RemoteException {
        // WS
        port = service.getDistributeurEditeurWSPort();
        
        String s = port.getListTitre();
        System.out.println("retour = " + s);
        String s1 = port.getListeEditeur();
        System.out.println("retour = " + s1);
        
        // Afficher la fenetre
//        MenuAvantConnexion menuAvantConnexion = new MenuAvantConnexion();
//        menuAvantConnexion.setVisible(true);
        
    }
    
}
