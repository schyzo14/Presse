package client.distributeur;

import client.distributeur.Vue.Menu.MenuAvantConnexion;
import client.distributeur.ws.DistributeurEditeurWS_PortType;
import client.distributeur.ws.DistributeurEditeurWS_Service;
import client.distributeur.ws.DistributeurEditeurWS_ServiceLocator;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import presse.distributeur;

/**
 * ClientDistributeur
 */
public class ClientDistributeur {

    // Distributeur identifié
    public static distributeur monDistributeur;
    
    // WS
    public static DistributeurEditeurWS_Service  service = new DistributeurEditeurWS_ServiceLocator();
    public static DistributeurEditeurWS_PortType  port;
    
    /**
     * Main qui lance la première fenêtre
     * 
     * @param args the command line arguments
     * @throws ServiceException
     * @throws RemoteException 
     */
    public static void main(String[] args) throws ServiceException, RemoteException {
        // WS
        port = service.getDistributeurEditeurWSPort();
        
        // Afficher la fenetre : menu pour se connecter ou créer un compte
        MenuAvantConnexion menuAvantConnexion = new MenuAvantConnexion();
        menuAvantConnexion.setVisible(true);
    }
}
