package JMS;

import Vues.NotificationNouveauVolume;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.StreamMessage;

/**
 * Listener JMS de ReceptionJMSNotification
 */
public class ListenerJMS implements MessageListener {

    /**
     * À la réception d'un message JMS
     * @param message 
     */
    @Override
    public void onMessage(Message message) {
        if (message instanceof StreamMessage) {
            try {
                //Récupération du message au format String
                String text = ((StreamMessage) message).readString();
                
                //Ouverture de la fenêtre de notification
                NotificationNouveauVolume nnv = new NotificationNouveauVolume();
                nnv.setReceived(text);
                nnv.setVisible(true);
            } catch (JMSException ex) {
                Logger.getLogger(ListenerJMS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
