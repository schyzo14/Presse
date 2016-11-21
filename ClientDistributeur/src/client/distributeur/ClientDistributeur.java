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
import presse.distributeur;

/**
 *
 * @author Aurore
 */
public class ClientDistributeur {

    public static distributeur monDistributeur;
    
    public static DistributeurEditeurWS_Service  service = new DistributeurEditeurWS_ServiceLocator();
    public static DistributeurEditeurWS_PortType  port;
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ServiceException, RemoteException {
        // WS
        port = service.getDistributeurEditeurWSPort();
        
        // Afficher la fenetre
        MenuAvantConnexion menuAvantConnexion = new MenuAvantConnexion();
        menuAvantConnexion.setVisible(true);
        
    }
    
}
