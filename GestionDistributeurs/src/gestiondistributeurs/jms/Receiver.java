package gestiondistributeurs.jms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Classe Receiver des messages JMS
 */
public class Receiver {
    private InitialContext context;
    private ConnectionFactory factory;
    private Connection connection;
    private String factoryName;
    private String destName;
    private Destination dest;
    private Session session;
    private MessageConsumer receiver;
    BufferedReader waiter;
    
    /**
     * Constructeur
     */
    public Receiver() {
        factory = null;
        connection = null;
        factoryName = "jms/__defaultConnectionFactory";
        destName = null;
        dest = null;
        session = null;
        receiver = null;

        destName = "jms/Distributeur";
        
        try {
            System.setProperty("java.naming.factory.initial",
                    "com.sun.enterprise.naming.SerialInitContextFactory");
            System.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
            System.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            context = new InitialContext();
            
            //Recherche de la ConnectionFactory
            factory = (ConnectionFactory) context.lookup(factoryName);

            //Recherche de la Destination
            dest = (Destination) context.lookup(destName);

            //Création de la Connection
            connection = factory.createConnection();

            //Création de la Session
            session = connection.createSession(
                    false, Session.AUTO_ACKNOWLEDGE);

            //Création du Receiver
            receiver = session.createConsumer(dest);
            
            //Enregistrement d'un Listener au Receiver
            receiver.setMessageListener(new Listener());

            //Démarrage de la Connection
            connection.start();
            
            System.out.println("Ecoute en cours...");
            System.out.println("Appuyez sur [entrée] pour quitter");

            waiter = new BufferedReader(new InputStreamReader(System.in));
            waiter.readLine();
        } catch (JMSException | NamingException exception) {
            exception.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Fermeture de la connexion
     */
    public void closeConnexion() {
        if (connection != null) {
            try {
                connection.close();
            } catch (JMSException exception) {
                exception.printStackTrace();
            }
        }
    }
}
