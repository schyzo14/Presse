
package client.editeur;

import client.editeur.Vue.Menu.Menu;
import client.editeur.ws.DistributeurEditeurWS_PortType;
import client.editeur.ws.DistributeurEditeurWS_Service;
import client.editeur.ws.DistributeurEditeurWS_ServiceLocator;
import javax.xml.rpc.ServiceException;
import presse.Editeur;

/**
 * ClientEditeur : main
 */
public class ClientEditeur {
    
    // éditeur connecté
    public static Editeur monEditeur;
    
    // WS
    public static DistributeurEditeurWS_Service  service = new DistributeurEditeurWS_ServiceLocator();
    public static DistributeurEditeurWS_PortType  port;

    /**
     * Main pour lancer le menu de l'éditeur
     * 
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
