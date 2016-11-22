/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.distributeur.Vue.PasserContrat;

import client.distributeur.ClientDistributeur;
import client.distributeur.Vue.Menu.MenuDistributeur;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import presse.contrat;
import presse.editeur;
import presse.titre;

/**
 *
 * @author Aurore
 */
public class PasserContrat extends javax.swing.JFrame {

    public HashMap<Integer, editeur> listeEditeur = new HashMap<Integer, editeur>();
    public HashMap<Integer, titre> listeTitre = new HashMap<Integer, titre>();
    /**
     * Creates new form PasserContrat
     */
    public PasserContrat() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        try {
            // Liste des éditeur
            String s = ClientDistributeur.port.getListeEditeur();
            System.out.println(s);
            Gson gson = new Gson();
            java.lang.reflect.Type type = new TypeToken<HashMap<Integer, editeur>>(){}.getType();
            listeEditeur = gson.fromJson(s, type);
            Iterator ie = listeEditeur.keySet().iterator();
            while (ie.hasNext()) {
                int editL = (int) ie.next();
                jComboBoxEditeur.addItem(listeEditeur.get(editL).getNomE());
            }
            
            // Liste des titres
            String st = ClientDistributeur.port.getListTitre();
            java.lang.reflect.Type typet = new TypeToken<HashMap<Integer, titre>>(){}.getType();
            listeTitre = gson.fromJson(st, typet);
            Iterator it = listeTitre.keySet().iterator();
            while (it.hasNext()) {
                int titr = (int) it.next();
                jComboBoxTitre.addItem(listeTitre.get(titr).getNomT());
            }
            
        } catch (RemoteException ex) {
            Logger.getLogger(PasserContrat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Nombre de copie
        jTextFieldNombreCopies.setText("0");
        
        // Durée en mois
        jComboBoxDuree.addItem("3");
        jComboBoxDuree.addItem("6");
        jComboBoxDuree.addItem("12");
        jComboBoxDuree.addItem("18");
        jComboBoxDuree.addItem("24");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabelEditeur = new javax.swing.JLabel();
        jComboBoxEditeur = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabelTitre = new javax.swing.JLabel();
        jComboBoxTitre = new javax.swing.JComboBox<>();
        jLabelNombreCopie = new javax.swing.JLabel();
        jTextFieldNombreCopies = new javax.swing.JTextField();
        javax.swing.JLabel jLabelTitreDuree = new javax.swing.JLabel();
        jComboBoxDuree = new javax.swing.JComboBox<>();
        jButtonEnvoyer = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Passer un contrat");

        jLabelEditeur.setText("Editeur");

        jLabelTitre.setText("Titre");

        jLabelNombreCopie.setText("Nombre de copies");

        jLabelTitreDuree.setText("Durée (en mois)");

        jButtonEnvoyer.setText("Envoyer");
        jButtonEnvoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnvoyerActionPerformed(evt);
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
                    .addComponent(jLabelEditeur)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldNombreCopies, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelNombreCopie, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabelTitreDuree)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxDuree, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonEnvoyer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAnnuler)
                                .addGap(36, 36, 36))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jComboBoxEditeur, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitre)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jComboBoxTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEditeur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxEditeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelTitre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTitre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelNombreCopie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNombreCopies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelTitreDuree)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxDuree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEnvoyer)
                    .addComponent(jButtonAnnuler))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        MenuDistributeur menuDistributeur = new MenuDistributeur();
        menuDistributeur.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jButtonEnvoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnvoyerActionPerformed
        try {
            // nbCopie
            int nbCopie = Integer.parseInt(jTextFieldNombreCopies.getText());
            // nbCopie positif
            if (nbCopie > 0) {
                // On récupère les champs
                // editeur
                String edChoix = (String) jComboBoxEditeur.getSelectedItem();
                Iterator ie = listeEditeur.keySet().iterator();
                int editId = -1;
                while (ie.hasNext()) {
                    int editL =  (int) ie.next();
                    editeur editLL = listeEditeur.get(editL);
                    if (editLL.getNomE().equals(edChoix)) {
                        editId = editLL.getNumE();
                    }
                }
                // titre
                String titreChoix = (String) jComboBoxTitre.getSelectedItem();
                Iterator it = listeTitre.keySet().iterator();
                int titrId = -1;
                while (it.hasNext()) {
                    int titrL = (int) it.next();
                    titre titrLL = listeTitre.get(titrL);
                    if (titrLL.getNomT().equals(titreChoix)) {
                        titrId = titrLL.getNumT();
                    }
                }
                // mois
                int mois = Integer.parseInt(jComboBoxDuree.getSelectedItem().toString());
                
                try {
                    // Avec le WS on passe le contrat
                    String s = ClientDistributeur.port.demandeContrat(ClientDistributeur.monDistributeur.getNumD(), editId, titrId, nbCopie, mois);

                    // On transforme le retour en contrat
                    Gson gson = new Gson();
                    java.lang.reflect.Type type = new TypeToken<contrat>(){}.getType();
                    contrat con = gson.fromJson(s, type);
                    
                    if (con.getNumC() == 0) {
                        String detailMessage = "Oups... Une erreur est survenue...";
                        // On affiche l'erreur
                        JOptionPane jop = new JOptionPane();
                        jop.showMessageDialog(null, detailMessage, "Erreur de création", JOptionPane.WARNING_MESSAGE);
                    } else {
                        this.dispose();
                        // validation contrat envoyé
                        JOptionPane d = new JOptionPane();
                        String lesTextes[]={"OK"}; 
                        int retour = d.showOptionDialog(this, "Votre contrat a été envoyé avec succés !", "Contrat demandé", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, lesTextes, lesTextes[0]);
                        if (lesTextes[retour].equals("OK")) {
                            MenuDistributeur menuDistributeur = new MenuDistributeur();
                            menuDistributeur.setVisible(true);
                            
                        }
                    }

                } catch (RemoteException ex) {
                    Logger.getLogger(PasserContrat.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
                // nb de copie <= 0    
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "<html>Le nombre de copie doit être positif !</html>", "Erreur de saisie", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (NumberFormatException  e) { // Les informations des champs ne sont pas saisies au bon format
            // On affiche une pop-up pour le signaler
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, "<html>Le nombre de copie est un nombre entier !</html>", "Erreur de saisie", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEnvoyerActionPerformed

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
            java.util.logging.Logger.getLogger(PasserContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasserContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasserContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasserContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasserContrat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonEnvoyer;
    private javax.swing.JComboBox<String> jComboBoxDuree;
    private javax.swing.JComboBox<String> jComboBoxEditeur;
    private javax.swing.JComboBox<String> jComboBoxTitre;
    private javax.swing.JLabel jLabelNombreCopie;
    private javax.swing.JTextField jTextFieldNombreCopies;
    // End of variables declaration//GEN-END:variables
}
