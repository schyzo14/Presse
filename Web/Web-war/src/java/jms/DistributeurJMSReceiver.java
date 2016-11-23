/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import presse.distributeur;
import presse.publicite;

/**
 *
 * @author Khadija
 */
public class DistributeurJMSReceiver {
    private InitialContext context;
    private ConnectionFactory factory;
    private Connection connection;
    private String factoryName;
    private String destName;
    private Destination dest;
    private Session session;
    private MessageConsumer receiver;
    BufferedReader waiter;
    
    public DistributeurJMSReceiver() {
        factory = null;
        connection = null;
        factoryName = "jms/__defaultConnectionFactory";
        destName = null;
        dest = null;
        session = null;
        receiver = null;

        destName = "jms/DistributeurRetour";
        
        try {
            System.setProperty("java.naming.factory.initial",
                    "com.sun.enterprise.naming.SerialInitContextFactory");
            System.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
            System.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            context = new InitialContext();
            // look up the ConnectionFactory
            factory = (ConnectionFactory) context.lookup(factoryName);

            // look up the Destination
            dest = (Destination) context.lookup(destName);

            // create the connection
            connection = factory.createConnection();

            // create the session
            session = connection.createSession(
                    false, Session.AUTO_ACKNOWLEDGE);

            // create the receiver
            receiver = session.createConsumer(dest);

            // start the connection, to enable message sends
            connection.start();
        } catch (JMSException | NamingException exception) {
            exception.printStackTrace();
        }
    }
    
    public distributeur reception() {
        distributeur reponse = null;
        try {
            Gson gson = new Gson();
            
            //Récupération de la réponse
            String rep = ((StreamMessage) receiver.receive()).readString();
            System.out.println("Message reçu : GestDist -> Web");
            java.lang.reflect.Type typeDistributeur = new TypeToken<distributeur>(){}.getType();
            reponse = gson.fromJson(rep, typeDistributeur);
        } catch (JMSException ex) {
            Logger.getLogger(DistributeurJMSReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reponse;
    }
    
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
