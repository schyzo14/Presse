/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.integrateur;

import client.jms.NotificationJMS;
import client.rest.ClientRESTVolume;
import client.rest.ClientRESTPublicites;
import client.rest.ClientRESTArticles;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import presse.article;
import presse.publicite;
import presse.volume;

/**
 *
 * @author Schyzo
 */
public class IntegrateurFen extends javax.swing.JFrame {
    private HashMap<Integer,publicite> listePub;
    private HashMap<Integer,article> listeArticles;
    Gson gson;
    NotificationJMS notif;
    
    /**
     * Creates new form IntegrateurFen
     */
    public IntegrateurFen() {
        gson = new Gson();
        
        //Init clients REST
        ClientRESTPublicites clientPublicites = new ClientRESTPublicites();
        ClientRESTArticles clientArticles = new ClientRESTArticles();
        
        //Récupération de toutes les publicités au format json
        String publicites = clientPublicites.getListePubs();
        //Récupération de tous les articles au format json
        String articles = clientArticles.getListeArticles();
        
        //Transformation du json à HashMap Pub
        java.lang.reflect.Type typePublicites = new TypeToken<HashMap<Integer,publicite>>(){}.getType();
        listePub = gson.fromJson(publicites, typePublicites);
        //Transformation du json à HashMap Articles
        java.lang.reflect.Type typeArticles = new TypeToken<HashMap<Integer,article>>(){}.getType();
        listeArticles = gson.fromJson(articles, typeArticles);
        
        //Récupération sous forme de liste
        DefaultListModel<String> lesPubs = new DefaultListModel<>();
        for(publicite p : listePub.values()) {
            lesPubs.addElement("#" + p.getNumP() + " : " + p.getCompagnie() + " - " + p.getContenuP());
        }
        
        //Affichage
        initComponents();
        notif = new NotificationJMS();
        jListPubZone1.setModel(lesPubs);
        jListPubZone2.setModel(lesPubs);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNumVolume = new javax.swing.JLabel();
        jTextFieldNumVolume = new javax.swing.JTextField();
        jLabelPubZone1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPubZone1 = new javax.swing.JList<>();
        jLabelPubZone2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListPubZone2 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaArticle = new javax.swing.JTextArea();
        jButtonAnnuler = new javax.swing.JButton();
        jButtonValider = new javax.swing.JButton();
        jLabelArticle = new javax.swing.JLabel();
        jButtonSuivant = new javax.swing.JButton();
        jButtonPrecedent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nouveau Volume");

        jLabelNumVolume.setText("Numéro du Volume :");

        jLabelPubZone1.setText("Publicité de la zone 1 :");

        jListPubZone1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListPubZone1.setMinimumSize(new java.awt.Dimension(258, 0));
        jScrollPane1.setViewportView(jListPubZone1);

        jLabelPubZone2.setText("Publicité de la zone 2 :");

        jListPubZone2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListPubZone2.setMinimumSize(new java.awt.Dimension(258, 0));
        jScrollPane2.setViewportView(jListPubZone2);

        jTextAreaArticle.setEditable(false);
        jTextAreaArticle.setColumns(20);
        jTextAreaArticle.setLineWrap(true);
        jTextAreaArticle.setRows(5);
        jTextAreaArticle.setText(listeArticles.get(1).getContenuA());
        jScrollPane3.setViewportView(jTextAreaArticle);

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        jButtonValider.setText("Valider");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        jLabelArticle.setText("#1/" + listeArticles.size() + " : " + listeArticles.get(1).getNomA());

        jButtonSuivant.setText("Suivant");
        jButtonSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuivantActionPerformed(evt);
            }
        });

        jButtonPrecedent.setText("Précédent");
        jButtonPrecedent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrecedentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonPrecedent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelArticle)
                                .addGap(118, 118, 118)
                                .addComponent(jButtonSuivant)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(jLabelPubZone1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(jLabelPubZone2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2)
                                    .addComponent(jScrollPane1))))
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNumVolume)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNumVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(342, 342, 342))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNumVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumVolume))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelArticle)
                    .addComponent(jButtonSuivant)
                    .addComponent(jButtonPrecedent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPubZone1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabelPubZone2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        //Enregistrement du dernier article et de ses pubs
        int numA = getNumArticleCourant();
        if(this.jListPubZone1.isSelectionEmpty() || this.jListPubZone2.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Il faut choisir deux pubs par article",
                    "Mauvaise sélection",
                    JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            enregistrerArticlePubs(numA);
        }
        
        //Vérification du numéro de volume
        try {
            Integer.parseInt(this.jTextFieldNumVolume.getText());    
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Erreur sur le numéro de volume",
                    "Erreur",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //Vérification que tous les articles ont été traités
        for(article a : this.listeArticles.values()) {
            if(a.getListePublicites().size() != 2) {
                JOptionPane.showMessageDialog(this,
                "Vous n'avez pas traité tous les articles",
                "Erreur",
                JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        //Envoyer le volume sur le serveur 
        volume v = new volume(Integer.parseInt(this.jTextFieldNumVolume.getText()));
        v.setListeArticles(this.listeArticles);
        ClientRESTVolume clientVolume = new ClientRESTVolume();
        String rep = clientVolume.addVolume(this.gson.toJson(v));
        System.out.println("Reponse : \n"+rep);
        
        //Envoyer notification au rédacteur chef
        notif.sendNotification(this.gson.toJson(v));
        
        //Dialog Box Quitter
        Object[] options = {"Créer un nouveau volume",
            "Quitter"};
        int reponse = JOptionPane.showOptionDialog(this,
                "Que voulez-vous faire ?",
                "Continuer ?",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

        if(options[reponse].equals("Quitter")){
            notif.closeConnexion();
            this.dispose();
        } else if(options[reponse].equals("Créer un nouveau volume")) {
            //Remettre tous les champs à vide
            this.jTextFieldNumVolume.setText("");
            for(article a : this.listeArticles.values()) {
                a.getListePublicites().clear();
            }
            this.jListPubZone1.clearSelection();
            this.jListPubZone2.clearSelection();
            jLabelArticle.setText("#1/" + listeArticles.size() + " : " + listeArticles.get(1).getNomA());
            jTextAreaArticle.setText(listeArticles.get(1).getContenuA());
        }
    }//GEN-LAST:event_jButtonValiderActionPerformed

    private void jButtonSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuivantActionPerformed
        //Récupérer le numéro d'article courant
        int numA = getNumArticleCourant();
        if(this.jListPubZone1.isSelectionEmpty() || this.jListPubZone2.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Il faut choisir deux pubs par article",
                    "Mauvaise sélection",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            enregistrerArticlePubs(numA);

            //Affichage de l'article suivant
            if(numA < this.listeArticles.size()) {
                //Déselection des JList
                this.jListPubZone1.clearSelection();
                this.jListPubZone2.clearSelection();

                numA++;
                //Actualisation jLabel
                this.jLabelArticle.setText("#" + numA + "/" + listeArticles.size() + " : " + listeArticles.get(numA).getNomA());
                //Actualisation jText
                this.jTextAreaArticle.setText(listeArticles.get(numA).getContenuA());

                //Sélection des pubs liées
                ArrayList<publicite> pubs = this.listeArticles.get(numA).getListePublicites();
                if(!pubs.isEmpty()) {
                    this.jListPubZone1.setSelectedIndex(pubs.get(0).getNumP()-1);
                    this.jListPubZone2.setSelectedIndex(pubs.get(1).getNumP()-1);
                }
            }
        }
    }//GEN-LAST:event_jButtonSuivantActionPerformed

    private void jButtonPrecedentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrecedentActionPerformed
        //Récupérer le numéro d'article courant
        int numA = getNumArticleCourant();
        if(this.jListPubZone1.isSelectionEmpty() || this.jListPubZone2.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Il faut choisir deux pubs par article",
                    "Mauvaise sélection",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            enregistrerArticlePubs(numA);
            
            //Affichage de l'article suivant
            if(numA > 1) {
                //Déselection des JList
                this.jListPubZone1.clearSelection();
                this.jListPubZone2.clearSelection();

                numA--;
                //Actualisation jLabel
                this.jLabelArticle.setText("#" + numA + "/" + listeArticles.size() + " : " + listeArticles.get(numA).getNomA());
                //Actualisation jText
                this.jTextAreaArticle.setText(listeArticles.get(numA).getContenuA());

                //Sélection des pubs liées
                ArrayList<publicite> pubs = this.listeArticles.get(numA).getListePublicites();
                if(!pubs.isEmpty()) {
                    this.jListPubZone1.setSelectedIndex(pubs.get(0).getNumP()-1);
                    this.jListPubZone2.setSelectedIndex(pubs.get(1).getNumP()-1);
                }
            }
        }
    }//GEN-LAST:event_jButtonPrecedentActionPerformed

    public int getNumArticleCourant() {
        int numA = 0;
        Pattern pattern = Pattern.compile("#(.*)/");
        Matcher matcher = pattern.matcher(this.jLabelArticle.getText());
        if(matcher.find()) {
            numA = Integer.parseInt(matcher.group(1));
        }
        
        return numA;
    }
    
    public int getNumPub1Courante() {
        int numPub1 = 0;
        Pattern pattern = Pattern.compile("#(.*) :");
        Matcher matcher = pattern.matcher(this.jListPubZone1.getSelectedValue());
        if(matcher.find()) {
            numPub1 = Integer.parseInt(matcher.group(1));
        }
        
        return numPub1;
    }
    
    public int getNumPub2Courante() {
        int numPub2 = 0;
        Pattern pattern = Pattern.compile("#(.*) :");
        Matcher matcher = pattern.matcher(this.jListPubZone2.getSelectedValue());
        if(matcher.find()) {
            numPub2 = Integer.parseInt(matcher.group(1));
        }
        
        return numPub2;
    }
    
    public void enregistrerArticlePubs(int numA) {
        int numPub1 = getNumPub1Courante();
        int numPub2 = getNumPub2Courante();
        ArrayList<publicite> pubs = new ArrayList<>();
        
        pubs.add(this.listePub.get(numPub1));
        pubs.add(this.listePub.get(numPub2));
        
        this.listeArticles.get(numA).setListePublicites(pubs);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IntegrateurFen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntegrateurFen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntegrateurFen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntegrateurFen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntegrateurFen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonPrecedent;
    private javax.swing.JButton jButtonSuivant;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JLabel jLabelArticle;
    private javax.swing.JLabel jLabelNumVolume;
    private javax.swing.JLabel jLabelPubZone1;
    private javax.swing.JLabel jLabelPubZone2;
    private javax.swing.JList<String> jListPubZone1;
    private javax.swing.JList<String> jListPubZone2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaArticle;
    private javax.swing.JTextField jTextFieldNumVolume;
    // End of variables declaration//GEN-END:variables
}
