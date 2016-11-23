/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondistributeurs.jms;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import gestiondistributeurs.GestionDistributeurs;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.StreamMessage;
import presse.distributeur;
import presse.titre;

/**
 *
 * @author Khadija
 */
public class Listener implements MessageListener {
    Gson gson;
    Sender send;
    
    @Override
    public void onMessage(Message message) {
        if (message instanceof StreamMessage) {
            try {
                //g = new GestionDistributeurs();
                gson = new Gson();
                send = new Sender();
                 
                System.out.println("Message reçu : Web -> GestDist");
                //Récupération des paramètres du distributeur
                String parametres = ((StreamMessage) message).readString();
                java.lang.reflect.Type typeParams = new TypeToken<ArrayList<String>>(){}.getType();
                ArrayList<String> params = gson.fromJson(parametres, typeParams);
                String mail = params.get(1);
                String nom, mdp;
                distributeur d = null;
                
                if(params.get(0).equals("inscription")) {
                    nom = params.get(2);
                    //Inscription
                    d = GestionDistributeurs.inscription(mail, nom);
                } else {
                    mdp = params.get(2);
                    d = GestionDistributeurs.connecter(mail, mdp);
                }
                
                //Envoi du résultat de l'inscription
                send.sendResponse(gson.toJson(d));
                
                //Fermeture de la connection
                send.closeConnexion();
            } catch (JMSException ex) {
                Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
