/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.distributeur.Vue.VirementBancaire;

import client.distributeur.ClientRESTDistributeur;
import client.distributeur.Payement;
import client.distributeur.Vue.Menu.MenuDistributeur;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aurore
 */
public class VirementBancaire extends javax.swing.JFrame {

    /**
     * Creates new form VirementBancaire
     */
    public VirementBancaire() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCrediteur = new javax.swing.JPanel();
        jLabelCompteCrediteur = new javax.swing.JLabel();
        jTextFieldNumCompteCrediteur = new javax.swing.JTextField();
        jPanelDebiteur = new javax.swing.JPanel();
        jLabelCompteDebiteur = new javax.swing.JLabel();
        jTextFieldNumCompteDebiteur = new javax.swing.JTextField();
        jLabelNomCompteDebiteur = new javax.swing.JLabel();
        jTextFieldNomCompteDebiteur = new javax.swing.JTextField();
        jLabelMontant = new javax.swing.JLabel();
        jTextFieldMontant = new javax.swing.JTextField();
        jButtonValider = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Virement Bancaire");

        jPanelCrediteur.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Créditeur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabelCompteCrediteur.setText("N° de compte");
        jLabelCompteCrediteur.setToolTipText("");

        javax.swing.GroupLayout jPanelCrediteurLayout = new javax.swing.GroupLayout(jPanelCrediteur);
        jPanelCrediteur.setLayout(jPanelCrediteurLayout);
        jPanelCrediteurLayout.setHorizontalGroup(
            jPanelCrediteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCrediteurLayout.createSequentialGroup()
                .addGroup(jPanelCrediteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCrediteurLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jTextFieldNumCompteCrediteur))
                    .addGroup(jPanelCrediteurLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelCompteCrediteur)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelCrediteurLayout.setVerticalGroup(
            jPanelCrediteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCrediteurLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCompteCrediteur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNumCompteCrediteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDebiteur.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Débiteur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabelCompteDebiteur.setText("Mon n° de compte");
        jLabelCompteDebiteur.setToolTipText("");

        jLabelNomCompteDebiteur.setText("Nom de compte");
        jLabelNomCompteDebiteur.setToolTipText("");

        javax.swing.GroupLayout jPanelDebiteurLayout = new javax.swing.GroupLayout(jPanelDebiteur);
        jPanelDebiteur.setLayout(jPanelDebiteurLayout);
        jPanelDebiteurLayout.setHorizontalGroup(
            jPanelDebiteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDebiteurLayout.createSequentialGroup()
                .addGroup(jPanelDebiteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDebiteurLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jTextFieldNumCompteDebiteur))
                    .addGroup(jPanelDebiteurLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelDebiteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCompteDebiteur)
                            .addComponent(jLabelNomCompteDebiteur))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDebiteurLayout.createSequentialGroup()
                        .addContainerGap(39, Short.MAX_VALUE)
                        .addComponent(jTextFieldNomCompteDebiteur, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelDebiteurLayout.setVerticalGroup(
            jPanelDebiteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDebiteurLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCompteDebiteur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNumCompteDebiteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNomCompteDebiteur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNomCompteDebiteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelMontant.setText("Montant");
        jLabelMontant.setToolTipText("");

        jButtonValider.setText("Valider");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCrediteur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextFieldMontant, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelMontant)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonValider)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAnnuler))
                    .addComponent(jPanelDebiteur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelDebiteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelCrediteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelMontant)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMontant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonValider)
                    .addComponent(jButtonAnnuler))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        String numCompte = jTextFieldNumCompteDebiteur.getText();
        String nomPayeur = jTextFieldNomCompteDebiteur.getText();
        int numCompteReception = Integer.parseInt(jTextFieldNumCompteCrediteur.getText());
        double montant = Double.parseDouble(jTextFieldMontant.getText());
                
        ClientRESTDistributeur c = new ClientRESTDistributeur(numCompte);
        Gson gson = new Gson();
        String s = c.virement(numCompte, nomPayeur, numCompteReception, montant);
        
        java.lang.reflect.Type type = new TypeToken<Payement>(){}.getType();
        Payement payement = gson.fromJson(s, type);
        
        if (payement.getNumComptePayeur() == 0) {
            JOptionPane erreurMess3 = new JOptionPane();
            erreurMess3.showMessageDialog(null, "Erreur : ", "Réponse", JOptionPane.OK_CANCEL_OPTION);
        } else {
            JOptionPane erreurMess = new JOptionPane();
            erreurMess.showMessageDialog(null, payement.getNumPayement()+" - "+payement.getNumComptePayeur()+" - "+payement.getNumCompteReception()+" - "+payement.getMontant()+" - "+payement.getDate(), "Réponse", JOptionPane.OK_CANCEL_OPTION);
        }
        
    }//GEN-LAST:event_jButtonValiderActionPerformed

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        MenuDistributeur menuDistributeur = new MenuDistributeur();
        menuDistributeur.setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(VirementBancaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VirementBancaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VirementBancaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VirementBancaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VirementBancaire().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JLabel jLabelCompteCrediteur;
    private javax.swing.JLabel jLabelCompteDebiteur;
    private javax.swing.JLabel jLabelMontant;
    private javax.swing.JLabel jLabelNomCompteDebiteur;
    private javax.swing.JPanel jPanelCrediteur;
    private javax.swing.JPanel jPanelDebiteur;
    private javax.swing.JTextField jTextFieldMontant;
    private javax.swing.JTextField jTextFieldNomCompteDebiteur;
    private javax.swing.JTextField jTextFieldNumCompteCrediteur;
    private javax.swing.JTextField jTextFieldNumCompteDebiteur;
    // End of variables declaration//GEN-END:variables
}
