/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.editeur.Vue.ValiderContrat;

import client.editeur.ClientEditeur;
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
        
        // remplir les champs
        jLabelChampCout.setText(con.getCoutC() + " €");
        jLabelChampDuree.setText(con.getDureeC() + " mois");
        jLabelChampDistributeur.setText(con.getDistributeurC().getNomD());
        jLabelChampNombreCopies.setText(con.getNbCopieC() + " copie(s)");
        jLabelChampTitre.setText(con.getTitreC().getNomT());
        
        // récépissé : retour à la ligne
        String recepisse = "<html>" + con.getRecepisseC() + "</html>";
        jLabelRecepisse.setText(recepisse.replace("\n", "<br/>"));
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
        jLabelChampCout = new javax.swing.JLabel();
        jButtonValider = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();
        jLabelContratRecepisse = new javax.swing.JLabel();
        jLabelRecepisse = new javax.swing.JLabel();

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

        jLabelChampCout.setText(" ");

        jButtonValider.setText("Valider le contrat");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        jLabelContratRecepisse.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelContratRecepisse.setText("Récépissé");

        jLabelRecepisse.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

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
                        .addComponent(jButtonAnnuler))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDistributeur)
                            .addComponent(jLabelContrat)
                            .addComponent(jLabelContratRecepisse))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabelRecepisse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(jLabelChampCout)
                .addGap(18, 18, 18)
                .addComponent(jLabelContratRecepisse)
                .addGap(18, 18, 18)
                .addComponent(jLabelRecepisse, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnnuler)
                    .addComponent(jButtonValider))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
                try {
            // on enregistre la validation
            String s = ClientEditeur.port.validerContratEditeur(con.getNumC());
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
                this.dispose();
                // corfirmation validation
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Le contrat a été validé !", "Contrat validé", JOptionPane.WARNING_MESSAGE);
                // retour à la liste des contrats en attente de validation
                ListContratAValider listContratAValider = new ListContratAValider();
                listContratAValider.setVisible(true);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ValiderContrat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonValiderActionPerformed

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
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
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JButton jButtonValider;
    private javax.swing.JLabel jLabelChampCout;
    private javax.swing.JLabel jLabelChampDistributeur;
    private javax.swing.JLabel jLabelChampDuree;
    private javax.swing.JLabel jLabelChampNombreCopies;
    private javax.swing.JLabel jLabelChampTitre;
    private javax.swing.JLabel jLabelContrat;
    private javax.swing.JLabel jLabelContratRecepisse;
    private javax.swing.JLabel jLabelCoutDuContrat;
    private javax.swing.JLabel jLabelDistributeur;
    private javax.swing.JLabel jLabelDuree;
    private javax.swing.JLabel jLabelNombreCopies;
    private javax.swing.JLabel jLabelRecepisse;
    private javax.swing.JLabel jLabelTitre;
    // End of variables declaration//GEN-END:variables
}
