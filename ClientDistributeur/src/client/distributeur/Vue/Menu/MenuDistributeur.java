/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.distributeur.Vue.Menu;

import client.distributeur.Vue.EnvoyerRecepisse.ListContratAttenteRecepisse;
import client.distributeur.Vue.PasserContrat.PasserContrat;
import client.distributeur.Vue.ValiderContrat.ListContratAValider;
import client.distributeur.Vue.VirementBancaire.VirementBancaire;

/**
 *
 * @author Aurore
 */
public class MenuDistributeur extends javax.swing.JFrame {

    /**
     * Creates new form MenuDistributeur
     */
    public MenuDistributeur() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonPasserContrat = new javax.swing.JButton();
        javax.swing.JButton jButtonValiderContrat = new javax.swing.JButton();
        javax.swing.JButton jButtonRealiserVirement = new javax.swing.JButton();
        javax.swing.JButton jButtonEnvoyerRecepisse = new javax.swing.JButton();
        javax.swing.JButton jButtonQuitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu distributeur");

        jButtonPasserContrat.setText("Passer un contrat avec un éditeur");
        jButtonPasserContrat.setToolTipText("");
        jButtonPasserContrat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPasserContratActionPerformed(evt);
            }
        });

        jButtonValiderContrat.setText("Valider un contrat");
        jButtonValiderContrat.setToolTipText("");
        jButtonValiderContrat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderContratActionPerformed(evt);
            }
        });

        jButtonRealiserVirement.setText("Réaliser un virement bancaire");
        jButtonRealiserVirement.setToolTipText("");
        jButtonRealiserVirement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRealiserVirementActionPerformed(evt);
            }
        });

        jButtonEnvoyerRecepisse.setText("Envoyer un récépissé");
        jButtonEnvoyerRecepisse.setToolTipText("");
        jButtonEnvoyerRecepisse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnvoyerRecepisseActionPerformed(evt);
            }
        });

        jButtonQuitter.setText("Quitter");
        jButtonQuitter.setToolTipText("");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPasserContrat, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonValiderContrat, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRealiserVirement, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEnvoyerRecepisse, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonPasserContrat)
                .addGap(18, 18, 18)
                .addComponent(jButtonValiderContrat)
                .addGap(18, 18, 18)
                .addComponent(jButtonRealiserVirement)
                .addGap(18, 18, 18)
                .addComponent(jButtonEnvoyerRecepisse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jButtonQuitter)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPasserContratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPasserContratActionPerformed
        PasserContrat passerContrat = new PasserContrat();
        passerContrat.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonPasserContratActionPerformed

    private void jButtonValiderContratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderContratActionPerformed
        ListContratAValider listContratAValider = new ListContratAValider();
        listContratAValider.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonValiderContratActionPerformed

    private void jButtonRealiserVirementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRealiserVirementActionPerformed
        VirementBancaire virementBancaire = new VirementBancaire();
        virementBancaire.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonRealiserVirementActionPerformed

    private void jButtonEnvoyerRecepisseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnvoyerRecepisseActionPerformed
        ListContratAttenteRecepisse listContratAttenteRecepisse = new ListContratAttenteRecepisse();
        listContratAttenteRecepisse.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonEnvoyerRecepisseActionPerformed

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_jButtonQuitterActionPerformed

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
            java.util.logging.Logger.getLogger(MenuDistributeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuDistributeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuDistributeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDistributeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuDistributeur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPasserContrat;
    // End of variables declaration//GEN-END:variables
}
