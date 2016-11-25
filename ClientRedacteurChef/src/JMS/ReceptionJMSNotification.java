package JMS;

import java.io.BufferedReader;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Client JMS
 */
public class ReceptionJMSNotification {
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
    public ReceptionJMSNotification() {
        factory = null;
        connection = null;
        factoryName = "jms/__defaultConnectionFactory";
        destName = null;
        dest = null;
        session = null;
        receiver = null;

        destName = "jms/VolumeTermine";
        
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
            receiver.setMessageListener(new ListenerJMS());

            //Démarrage de la Connection
            connection.start();
            
            System.out.println("En écoute...");
        } catch (JMSException | NamingException exception) {
            exception.printStackTrace();
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
