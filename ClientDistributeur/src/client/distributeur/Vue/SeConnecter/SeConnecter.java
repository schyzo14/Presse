/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.distributeur.Vue.SeConnecter;
import client.distributeur.ClientDistributeur;
import client.distributeur.Vue.Menu.MenuDistributeur;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;
import presse.distributeur;

/**
 *
 * @author Aurore
 */
public class SeConnecter extends javax.swing.JFrame {

    /**
     * Creates new form CreerCompte
     */
    public SeConnecter() {
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

        jTextFieldMail = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        jLabelMdp = new javax.swing.JLabel();
        jTextFieldMdp = new javax.swing.JTextField();
        javax.swing.JButton jButtonValider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Se connecter");

        jTextFieldMail.setToolTipText("");
        jTextFieldMail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabelMail.setText("Mail :");

        jLabelMdp.setText("Mdp :");

        jTextFieldMdp.setToolTipText("");

        jButtonValider.setText("Valider");
        jButtonValider.setToolTipText("");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelMail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelMdp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMdp)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMail))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMdp)
                    .addComponent(jTextFieldMdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(135, 135, 135)
                    .addComponent(jButtonValider)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        // On récupère le contenu des champs
        String mail = jTextFieldMail.getText();
        String mdp = jTextFieldMdp.getText();
        
        // On vérifie que les champs sont complétés
        if (mail.equals("") || mdp.equals("")) {
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, "Tous les champs doivent être complétés !", "Erreur de saisie", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                // On récupère avec le WS le distributeur qui veut se connecter
                String s = ClientDistributeur.port.connection(mail, mdp);
                System.out.println(s);
                
                // On transforme le retour en distributeur
                Gson gson = new Gson();
                java.lang.reflect.Type type = new TypeToken<distributeur>(){}.getType();
                distributeur distri = gson.fromJson(s, type);
                
                // Le distributeur n'a pas été renvoyé
                if (distri.getNumD() == 0) {
                    String detailMessage = "Oups... Une erreur est survenue...";
                    try {
                        // On récupère la cause de l'erreur
                        JSONObject obj;
                        obj = new JSONObject(s);
                        detailMessage = obj.getString("detailMessage");
                        
                        // On affiche l'erreur à l'utilisateur
                        JOptionPane jop = new JOptionPane();
                        jop.showMessageDialog(null, detailMessage, "Erreur de création", JOptionPane.WARNING_MESSAGE);
                    } catch (JSONException ex) {
                        Logger.getLogger(SeConnecter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {                
                    // Garder le compte distributeur
                    ClientDistributeur.monDistributeur = distri;
                    
                    // Fenetre menu
                    MenuDistributeur menuDistributeur = new MenuDistributeur();
                    menuDistributeur.setVisible(true);
                    this.setVisible(false);
                }
            } catch (RemoteException ex) {
                Logger.getLogger(SeConnecter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButtonValiderActionPerformed

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
            java.util.logging.Logger.getLogger(SeConnecter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeConnecter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeConnecter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeConnecter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeConnecter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelMdp;
    private javax.swing.JTextField jTextFieldMail;
    private javax.swing.JTextField jTextFieldMdp;
    // End of variables declaration//GEN-END:variables
}
