/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.distributeur.Vue.ValiderContrat;

import client.distributeur.ClientDistributeur;
import client.distributeur.Vue.Menu.MenuDistributeur;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import presse.contrat;

/**
 *
 * @author Aurore
 */
public class ValiderContrat extends javax.swing.JFrame {

    private static contrat con;
    
    /**
     * Creates new form ValiderContrat
     */
    public ValiderContrat(contrat con) {
        this.con = con;
        initComponents();
        this.setLocationRelativeTo(null);
        
        jLabelChampCout.setText(con.getCoutC() + " €");
        jLabelChampDuree.setText(con.getDureeC() + " mois");
        jLabelChampEditeur.setText(con.getEditeurC().getNomE());
        jLabelChampNombreCopies.setText(con.getNbCopieC() + " copie(s)");
        jLabelChampTitre.setText(con.getTitreC().getNomT());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelEditeur = new javax.swing.JLabel();
        jLabelChampEditeur = new javax.swing.JLabel();
        jLabelContrat = new javax.swing.JLabel();
        jLabelTitre = new javax.swing.JLabel();
        jLabelNombreCopies = new javax.swing.JLabel();
        jLabelDuree = new javax.swing.JLabel();
        jLabelChampTitre = new javax.swing.JLabel();
        jLabelChampNombreCopies = new javax.swing.JLabel();
        jLabelChampDuree = new javax.swing.JLabel();
        jLabelCoutDuContrat = new javax.swing.JLabel();
        jLabelChampCout = new javax.swing.JLabel();
        jButtonValider = new javax.swing.JButton();
        jButtonRefuser = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Valider un contrat");

        jLabelEditeur.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelEditeur.setText("Editeur");

        jLabelChampEditeur.setText(" ");

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

        jLabelChampCout.setText(" ");

        jButtonValider.setText("Valider le contrat");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        jButtonRefuser.setText("Refuser le contrat");
        jButtonRefuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefuserActionPerformed(evt);
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
                        .addComponent(jLabelChampEditeur, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelEditeur))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelContrat)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCoutDuContrat)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelChampCout, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonValider)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRefuser))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAnnuler)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEditeur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelChampEditeur)
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
                .addComponent(jLabelChampCout)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonValider)
                    .addComponent(jButtonRefuser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAnnuler)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        try {
            // on enregistre le cout
            String s = ClientDistributeur.port.validerContrat(con.getNumC());
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
                // fermer la fenetre
                this.dispose();
                // corfirmation validation
                ConfirmationValidationContrat confirmationValidationContrat = new ConfirmationValidationContrat(con);
                confirmationValidationContrat.setVisible(true);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ValiderContrat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonValiderActionPerformed

    private void jButtonRefuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefuserActionPerformed
        try {
            // on enregistre le cout
            String s = ClientDistributeur.port.validerContrat(con.getNumC());
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
                // fermer la fenetre
                this.dispose();
                // Fenetre de confirmation
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Votre refus de contrat a été envoyé !", "Refus de contrat", JOptionPane.WARNING_MESSAGE);
                // Menu
                MenuDistributeur menuDistributeur = new MenuDistributeur();
                menuDistributeur.setVisible(true);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ValiderContrat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRefuserActionPerformed

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        // Menu
        ListContratAValider listContratAValider = new ListContratAValider();
        listContratAValider.setVisible(true);
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
            java.util.logging.Logger.getLogger(ValiderContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ValiderContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ValiderContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ValiderContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ValiderContrat(con).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonRefuser;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JLabel jLabelChampCout;
    private javax.swing.JLabel jLabelChampDuree;
    private javax.swing.JLabel jLabelChampEditeur;
    private javax.swing.JLabel jLabelChampNombreCopies;
    private javax.swing.JLabel jLabelChampTitre;
    private javax.swing.JLabel jLabelContrat;
    private javax.swing.JLabel jLabelCoutDuContrat;
    private javax.swing.JLabel jLabelDuree;
    private javax.swing.JLabel jLabelEditeur;
    private javax.swing.JLabel jLabelNombreCopies;
    private javax.swing.JLabel jLabelTitre;
    // End of variables declaration//GEN-END:variables
}
