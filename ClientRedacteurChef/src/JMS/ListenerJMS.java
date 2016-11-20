/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JMS;

import Vues.NotificationNouveauVolume;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.StreamMessage;

/**
 *
 * @author Khadija
 */
public class ListenerJMS implements MessageListener {

    @Override
    public void onMessage(Message message) {
        if (message instanceof StreamMessage) {
            try {
                String text = ((StreamMessage) message).readString();
                System.out.println(text);
                NotificationNouveauVolume nnv = new NotificationNouveauVolume();
                nnv.setVisible(true);
            } catch (JMSException ex) {
                Logger.getLogger(ListenerJMS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
