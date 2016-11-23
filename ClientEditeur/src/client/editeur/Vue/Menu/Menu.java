
package client.editeur.Vue.Menu;

import client.editeur.ClientEditeur;
import client.editeur.Vue.ContratCout.ListContratAttenteCout;
import client.editeur.Vue.ValiderContrat.ListContratAValider;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import presse.editeur;

/**
 * Fenetre avec le menu de l'éditeur
 */
public class Menu extends javax.swing.JFrame {

    // liste des éditeurs
    public HashMap<Integer, editeur> listeEditeur = new HashMap<Integer, editeur>();
    
    /**
     * Constructeur
     */
    public Menu() {
        initComponents();
        // centrer la fenetre
        this.setLocationRelativeTo(null);
        
        // si l'éditeur identifié
        int idE = -1;
        if (ClientEditeur.monEditeur != null) {
            idE = ClientEditeur.monEditeur.getNumE();
        }
        
        // La liste des éditeurs
        try {
            // on récupère la liste des éditeurs en WS
            String s = ClientEditeur.port.getListeEditeur();
            System.out.println(s);
            
            // on transforme le retour en liste d'éditeurs
            Gson gson = new Gson();
            java.lang.reflect.Type type = new TypeToken<HashMap<Integer, editeur>>(){}.getType();
            listeEditeur = gson.fromJson(s, type);
            Iterator ie = listeEditeur.keySet().iterator();
            
            // on parcours la liste pour remplir la jComboBox
            while (ie.hasNext()) {
                int editL = (int) ie.next();
                jComboBoxEditeur.addItem(listeEditeur.get(editL).getNomE());
                // Si l'éditeur est identifié, on le sélectione dans la liste déroulante
                if (idE == editL) {
                    jComboBoxEditeur.setSelectedItem(listeEditeur.get(editL).getNomE());
                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonRepondreDemandes = new javax.swing.JButton();
        jButtonValiderContrat = new javax.swing.JButton();
        jButtonQuitter = new javax.swing.JButton();
        jComboBoxEditeur = new javax.swing.JComboBox<>();
        jLabelEditeur = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        jButtonRepondreDemandes.setText("Répondre aux demandes de coût des contrats");
        jButtonRepondreDemandes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRepondreDemandesActionPerformed(evt);
            }
        });

        jButtonValiderContrat.setText("Valider les contrats en attentes");
        jButtonValiderContrat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderContratActionPerformed(evt);
            }
        });

        jButtonQuitter.setText("Quitter");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        jLabelEditeur.setText("Editeur :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRepondreDemandes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonValiderContrat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelEditeur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEditeur, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEditeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEditeur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButtonRepondreDemandes)
                .addGap(18, 18, 18)
                .addComponent(jButtonValiderContrat)
                .addGap(35, 35, 35)
                .addComponent(jButtonQuitter)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Bouton "répondre aux contrats en attente de cout"
     * @param evt 
     */
    private void jButtonRepondreDemandesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRepondreDemandesActionPerformed
        // Editeur choisi
        String edChoix = (String) jComboBoxEditeur.getSelectedItem();
        // On garde l'éditeur
        Iterator ie = listeEditeur.keySet().iterator();
        while (ie.hasNext()) {
            int editL =  (int) ie.next();
            editeur editLL = listeEditeur.get(editL);
            if (editLL.getNomE().equals(edChoix)) {
                ClientEditeur.monEditeur = editLL;
            }
        }
        
        // Ouvrir la liste des contrats en attente d'un cout
        ListContratAttenteCout listContratAttenteCout = new ListContratAttenteCout();
        listContratAttenteCout.setVisible(true);
        // fermer la fenetre courante
        this.dispose();
    }//GEN-LAST:event_jButtonRepondreDemandesActionPerformed

    /**
     * Bouton "valider les contrats en attente de validation"
     * @param evt 
     */
    private void jButtonValiderContratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderContratActionPerformed
        // Editeur choisi
        String edChoix = (String) jComboBoxEditeur.getSelectedItem();
        // On garde l'éditeur
        Iterator ie = listeEditeur.keySet().iterator();
        while (ie.hasNext()) {
            int editL =  (int) ie.next();
            editeur editLL = listeEditeur.get(editL);
            if (editLL.getNomE().equals(edChoix)) {
                ClientEditeur.monEditeur = editLL;
            }
        }
        
        // Ouvrir la liste des contrats en attente de validation
        ListContratAValider listContratAValider = new ListContratAValider();
        listContratAValider.setVisible(true);
        // fermer la fenetre courante
        this.dispose();
    }//GEN-LAST:event_jButtonValiderContratActionPerformed

    /**
     * outon "Quitter"
     * @param evt 
     */
    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        // fermer la fenetre courante
        this.dispose();
        // Quitter l'application
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonRepondreDemandes;
    private javax.swing.JButton jButtonValiderContrat;
    private javax.swing.JComboBox<String> jComboBoxEditeur;
    private javax.swing.JLabel jLabelEditeur;
    // End of variables declaration//GEN-END:variables
}
