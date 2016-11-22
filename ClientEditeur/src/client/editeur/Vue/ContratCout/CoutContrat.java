/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.editeur.Vue.ContratCout;

import client.editeur.ClientEditeur;
import client.editeur.Vue.Menu.Menu;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import presse.contrat;
import presse.editeur;

/**
 *
 * @author Aurore
 */
public class CoutContrat extends javax.swing.JFrame {

    private static contrat con;
    
    /**
     * Creates new form ValiderContrat
     */
    public CoutContrat(contrat con) {
        
        this.con = con;
        initComponents();
        
        // remplir les champs
        jLabelChampDistributeur.setText(con.getDistributeurC().getNomD());
        jLabelChampDuree.setText(con.getDureeC() + " mois");
        jLabelChampNombreCopies.setText(con.getNbCopieC() + " copie(s)");
        jLabelChampTitre.setText(con.getTitreC().getNomT());
        
        jTextFieldCout.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDistributeur = new javax.swing.JLabel();
        jLabelChampDistributeur = new javax.swing.JLabel();
        jLabelContrat = new javax.swing.JLabel();
        jLabelTitre = new javax.swing.JLabel();
        jLabelNombreCopies = new javax.swing.JLabel();
        jLabelDuree = new javax.swing.JLabel();
        jLabelChampTitre = new javax.swing.JLabel();
        jLabelChampNombreCopies = new javax.swing.JLabel();
        jLabelChampDuree = new javax.swing.JLabel();
        jLabelCoutDuContrat = new javax.swing.JLabel();
        jButtonEnvoyerCout = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();
        jTextFieldCout = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Valider un contrat");

        jLabelDistributeur.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDistributeur.setText("Distributeur");

        jLabelChampDistributeur.setText(" ");

        jLabelContrat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelContrat.setText("Contrat");

        jLabelTitre.setText("Titre :");

        jLabelNombreCopies.setText("Nombre de copies :");

        jLabelDuree.setText("Durée :");

        jLabelChampTitre.setText(" ");

        jLabelChampNombreCopies.setText(" ");

        jLabelChampDuree.setText(" ");

        jLabelCoutDuContrat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelCoutDuContrat.setText("Coût du contrat");

        jButtonEnvoyerCout.setText("Envoyer le coût");
        jButtonEnvoyerCout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnvoyerCoutActionPerformed(evt);
            }
        });

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNombreCopies)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelChampNombreCopies, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelDuree)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelChampDuree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTitre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelChampTitre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(40, Short.MAX_VALUE)
                        .addComponent(jLabelChampDistributeur, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonEnvoyerCout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAnnuler))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDistributeur)
                                    .addComponent(jLabelContrat)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelCoutDuContrat)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextFieldCout, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDistributeur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelChampDistributeur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelContrat)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitre)
                    .addComponent(jLabelChampTitre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreCopies)
                    .addComponent(jLabelChampNombreCopies))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDuree)
                    .addComponent(jLabelChampDuree))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCoutDuContrat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEnvoyerCout)
                    .addComponent(jButtonAnnuler))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEnvoyerCoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnvoyerCoutActionPerformed
        try {
            // on récupère le cout
            float cout = Float.parseFloat(jTextFieldCout.getText());
        
            try {
                // on enregistre le cout
                String s = ClientEditeur.port.coutContrat(con.getNumC(), cout);
                // On récupère le contrat
                System.out.println(s);
                Gson gson = new Gson();
                java.lang.reflect.Type type = new TypeToken<contrat>(){}.getType();
                contrat con = gson.fromJson(s, type);
                // SI le contrat est vide, il y a eu une erreur
                if (con.getNumC() <= 0) {
                    String detailMessage = "Oups... Une erreur est survenue...";
                    // On affiche l'erreur
                    JOptionPane jop = new JOptionPane();
                    jop.showMessageDialog(null, detailMessage, "Erreur de validation", JOptionPane.WARNING_MESSAGE);
                } else {
                    // on ferme la fenetre
                    this.dispose();
                    // On confirme que le cout est envoyé
                    JOptionPane jop = new JOptionPane();
                    jop.showMessageDialog(null, "Le cout est envoyé !", "Cout envoyé", JOptionPane.WARNING_MESSAGE);
                    // On passe a la fenetre de la liste de contrat en attente de cout
                    ListContratAttenteCout listContratAttenteCout = new ListContratAttenteCout();
                    listContratAttenteCout.setVisible(true);
                }
            } catch (RemoteException ex) {
                Logger.getLogger(CoutContrat.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        } catch (NumberFormatException  e) { // Les informations des champs ne sont pas saisies au bon format
            // On affiche une pop-up pour le signaler
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, "<html>Le cout est de la forme 123.45 !</html>", "Erreur de saisie", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEnvoyerCoutActionPerformed

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        // On passe a la fenetre de la liste de contrat en attente de cout
        ListContratAttenteCout listContratAttenteCout = new ListContratAttenteCout();
        listContratAttenteCout.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

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
            java.util.logging.Logger.getLogger(CoutContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoutContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoutContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoutContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoutContrat(con).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonEnvoyerCout;
    private javax.swing.JLabel jLabelChampDistributeur;
    private javax.swing.JLabel jLabelChampDuree;
    private javax.swing.JLabel jLabelChampNombreCopies;
    private javax.swing.JLabel jLabelChampTitre;
    private javax.swing.JLabel jLabelContrat;
    private javax.swing.JLabel jLabelCoutDuContrat;
    private javax.swing.JLabel jLabelDistributeur;
    private javax.swing.JLabel jLabelDuree;
    private javax.swing.JLabel jLabelNombreCopies;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JTextField jTextFieldCout;
    // End of variables declaration//GEN-END:variables
}
