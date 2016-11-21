/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.editeur;

import client.editeur.Vue.Menu.Menu;
import client.editeur.ws.DistributeurEditeurWS_PortType;
import client.editeur.ws.DistributeurEditeurWS_Service;
import client.editeur.ws.DistributeurEditeurWS_ServiceLocator;
import javax.xml.rpc.ServiceException;
import presse.distributeur;
import presse.editeur;

/**
 *
 * @author Aurore
 */
public class ClientEditeur {
    
    public static editeur monEditeur;
    
    public static DistributeurEditeurWS_Service  service = new DistributeurEditeurWS_ServiceLocator();
    public static DistributeurEditeurWS_PortType  port;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ServiceException {
        // WS
        port = service.getDistributeurEditeurWSPort();
        
        // Menu
        Menu menu = new Menu();
        menu.setVisible(true);
        
    }
    
}
