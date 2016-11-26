package jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Classe JMS Distributeur - Sender
 */
public class DistributeurJMSSender {
    private InitialContext context;
    private ConnectionFactory factory;
    private Connection connection;
    private String factoryName;
    private String destName;
    private Destination dest;
    private Session session;
    private MessageProducer sender;
    
    /**
     * Constructeur du Sender
     */
    public DistributeurJMSSender() {
        factory = null;
        connection = null;
        factoryName = "jms/__defaultConnectionFactory";
        destName = null;
        dest = null;
        session = null;
        sender = null;

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

            //Créatin du Sender
            sender = session.createProducer(dest);

            //Démarrage de la Connection
            connection.start();
        } catch (JMSException | NamingException exception) {
            exception.printStackTrace();
        }
    }
    
    /**
     * Vérification des informations du distributeur
     * @param s les paramètres du distributeur au format json
     */
    public void checkParams(String s) {
        try {
            StreamMessage sm = session.createStreamMessage();
            sm.writeString(s);
            sender.send(sm);
            System.out.println("Message envoyé : Web -> GestDist");
            System.out.println(sm.readString());
        } catch (JMSException ex) {
            Logger.getLogger(DistributeurJMSSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Fermeture de la Connection
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
