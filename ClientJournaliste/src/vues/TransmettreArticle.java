/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import com.google.gson.Gson;
import rest.ClientREST_TransmissionArticle;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * Client Journaliste permettant à un journaliste de saisir un article
 */
public class TransmettreArticle extends javax.swing.JFrame {
    //Création d'un objet Client REST
    ClientREST_TransmissionArticle restArticle = new ClientREST_TransmissionArticle();

    /**
     * Creates new form TransmettreArticle
     */
    public TransmettreArticle() {
        initComponents();
        
        //Dimensionnement Fenetre
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_TransmettreArticle = new javax.swing.JPanel();
        jLabel_NomArticle = new javax.swing.JLabel();
        jTextField_NomArticle = new javax.swing.JTextField();
        jLabel_AuteurArticle = new javax.swing.JLabel();
        jTextField_AuteurArticle = new javax.swing.JTextField();
        jLabel_ContenuArticle = new javax.swing.JLabel();
        jScrollPane_ContenuArticle = new javax.swing.JScrollPane();
        jTextArea_ContenuArticle = new javax.swing.JTextArea();
        jScrollPane_MotsClesArticle = new javax.swing.JScrollPane();
        jList_MotsClesArticle = new javax.swing.JList<>();
        jLabel_MotsClesArticle = new javax.swing.JLabel();
        jLabel_MotsClesAjoutArticle = new javax.swing.JLabel();
        jTextField_MotsClesAjoutArticle = new javax.swing.JTextField();
        jButton_AjouterMotCléArticle = new javax.swing.JButton();
        jButton_QuitterArticle = new javax.swing.JButton();
        jButton_TransmettreArticle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Journaliste - Transmettre un article");

        jLabel_NomArticle.setText("Nom : ");

        jLabel_AuteurArticle.setText("Auteur :");

        jLabel_ContenuArticle.setText("Contenu :");

        jTextArea_ContenuArticle.setColumns(20);
        jTextArea_ContenuArticle.setLineWrap(true);
        jTextArea_ContenuArticle.setRows(5);
        jScrollPane_ContenuArticle.setViewportView(jTextArea_ContenuArticle);

        jList_MotsClesArticle.setModel(new DefaultListModel ());
        jList_MotsClesArticle.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList_MotsClesArticle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList_MotsClesArticleKeyPressed(evt);
            }
        });
        jScrollPane_MotsClesArticle.setViewportView(jList_MotsClesArticle);

        jLabel_MotsClesArticle.setText("Mots-clés :");

        jLabel_MotsClesAjoutArticle.setText("Mots-clés à ajouter : ");

        jTextField_MotsClesAjoutArticle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_MotsClesAjoutArticleKeyPressed(evt);
            }
        });

        jButton_AjouterMotCléArticle.setText("Ajouter un mot-clé");
        jButton_AjouterMotCléArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AjouterMotCléArticleActionPerformed(evt);
            }
        });

        jButton_QuitterArticle.setText("Quitter");
        jButton_QuitterArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_QuitterArticleActionPerformed(evt);
            }
        });

        jButton_TransmettreArticle.setText("Transmettre l'article");
        jButton_TransmettreArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TransmettreArticleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_TransmettreArticleLayout = new javax.swing.GroupLayout(jPanel_TransmettreArticle);
        jPanel_TransmettreArticle.setLayout(jPanel_TransmettreArticleLayout);
        jPanel_TransmettreArticleLayout.setHorizontalGroup(
            jPanel_TransmettreArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TransmettreArticleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_TransmettreArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_TransmettreArticleLayout.createSequentialGroup()
                        .addGroup(jPanel_TransmettreArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_NomArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_AuteurArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_QuitterArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(240, 240, 240))
                    .addGroup(jPanel_TransmettreArticleLayout.createSequentialGroup()
                        .addGroup(jPanel_TransmettreArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_ContenuArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_MotsClesArticle))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_TransmettreArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_TransmettreArticleLayout.createSequentialGroup()
                                .addComponent(jScrollPane_MotsClesArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addGroup(jPanel_TransmettreArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_TransmettreArticleLayout.createSequentialGroup()
                                        .addGap(0, 101, Short.MAX_VALUE)
                                        .addComponent(jButton_TransmettreArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel_TransmettreArticleLayout.createSequentialGroup()
                                        .addGroup(jPanel_TransmettreArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField_MotsClesAjoutArticle)
                                            .addComponent(jLabel_MotsClesAjoutArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton_AjouterMotCléArticle, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jScrollPane_ContenuArticle)
                            .addGroup(jPanel_TransmettreArticleLayout.createSequentialGroup()
                                .addGroup(jPanel_TransmettreArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_NomArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_AuteurArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        jPanel_TransmettreArticleLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton_QuitterArticle, jButton_TransmettreArticle});

        jPanel_TransmettreArticleLayout.setVerticalGroup(
            jPanel_TransmettreArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TransmettreArticleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_TransmettreArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_NomArticle)
                    .addComponent(jTextField_NomArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_TransmettreArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_AuteurArticle)
                    .addComponent(jTextField_AuteurArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_TransmettreArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_ContenuArticle)
                    .addComponent(jScrollPane_ContenuArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_TransmettreArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_TransmettreArticleLayout.createSequentialGroup()
                        .addComponent(jLabel_MotsClesAjoutArticle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_MotsClesAjoutArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_AjouterMotCléArticle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_TransmettreArticleLayout.createSequentialGroup()
                        .addGroup(jPanel_TransmettreArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_MotsClesArticle)
                            .addComponent(jScrollPane_MotsClesArticle, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel_TransmettreArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_QuitterArticle)
                            .addComponent(jButton_TransmettreArticle))))
                .addContainerGap())
        );

        jPanel_TransmettreArticleLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton_QuitterArticle, jButton_TransmettreArticle});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_TransmettreArticle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_TransmettreArticle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Ajouter les mots-clés à la liste 
     * @param evt 
     */
    private void jButton_AjouterMotCléArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AjouterMotCléArticleActionPerformed
        // TODO add your handling code here:
        //Ajout du mot-clé dans la liste
        if (jTextField_MotsClesAjoutArticle.getText() != null) {
            DefaultListModel modele = (DefaultListModel) jList_MotsClesArticle.getModel();
            modele.addElement(jTextField_MotsClesAjoutArticle.getText());
            jTextField_MotsClesAjoutArticle.setText("");
        }

    }//GEN-LAST:event_jButton_AjouterMotCléArticleActionPerformed

    /**
     * Quitter l'application
     * @param evt 
     */
    private void jButton_QuitterArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_QuitterArticleActionPerformed
        // TODO add your handling code here:
        //Fermer toutes les connexion je suppose
        restArticle.close();
        
        //Fermeture de la fenêtre
        this.dispose();
    }//GEN-LAST:event_jButton_QuitterArticleActionPerformed

    /**
     * Transmettre l'article rédigé 
     * @param evt 
     */
    private void jButton_TransmettreArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TransmettreArticleActionPerformed
        // TODO add your handling code here:
        //On vérifie que tout les champs ont été saisi (sauf les mots-clés)
        if(!jTextField_NomArticle.getText().isEmpty() && !jTextField_AuteurArticle.getText().isEmpty() && !jTextArea_ContenuArticle.getText().isEmpty())
        {
            //On récupère les élements saisis
            String nomArticle = jTextField_NomArticle.getText();
            String nomAuteur = jTextField_AuteurArticle.getText();
            String contenu = jTextArea_ContenuArticle.getText();
            DefaultListModel modele = (DefaultListModel) jList_MotsClesArticle.getModel();
            String motscles = modele.toString();
                        
            //Transmettre les éléments à TransmissionArticles via REST (RESEAU)
            restArticle.postJsonArticleJournaliste(nomArticle, nomAuteur, contenu, motscles);
            
            //Affichage de la pop up 
            popUpArticle();
        }else{
            //Affichage message d'erreur
            JOptionPane erreurMess = new JOptionPane();
            erreurMess.showMessageDialog(null, "Tout les champs sont obligatoires!", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton_TransmettreArticleActionPerformed

    /**
     * Pop up s'affichant après la transmission de l'article
     */
    private void popUpArticle() {
        //Custom button text
        //Bouton Quitter ou Ecrire un autre article une fois que les éléments ont été envoyés à TransmettreArticle
        Object[] options = {"Quitter",
            "Ecrire un autre article"};
        int reponse = JOptionPane.showOptionDialog(this,
                "Que voulez-vous faire ?",
                "Continuer ?",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        
        //Clic sur le bouton Quitter
        if(options[reponse].equals("Quitter")){
            //Fermer toutes les connexion réseaux
            restArticle.close();
            
            //Quitter
            this.dispose();
            
        //Clic sur le bouton Ecrire un autre article
        }else if(options[reponse].equals("Ecrire un autre article"))
        {
            //Remettre tous les champs à vide et vider la liste des mots-cles
            jTextField_NomArticle.setText("");
            jTextField_AuteurArticle.setText("");
            jTextArea_ContenuArticle.setText("");
            DefaultListModel modele = (DefaultListModel) jList_MotsClesArticle.getModel();
            modele.removeAllElements();
            JOptionPane.getRootFrame().dispose(); 
        }
        
    }
    
    /**
     * Suppression d'un mots-clés de la liste
     * @param evt 
     */
    private void jList_MotsClesArticleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList_MotsClesArticleKeyPressed
        // TODO add your handling code here:
        //Possibilité de supprimer un mot-clé de la liste par appui sur la touche Suppr
        if (evt.getKeyChar() == Event.DELETE) {
            DefaultListModel modele = (DefaultListModel) jList_MotsClesArticle.getModel();
            modele.remove(jList_MotsClesArticle.getSelectedIndex());
        }
    }//GEN-LAST:event_jList_MotsClesArticleKeyPressed

    /**
     * Ajout des mots-clés
     * @param evt 
     */
    private void jTextField_MotsClesAjoutArticleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_MotsClesAjoutArticleKeyPressed
        // TODO add your handling code here:
        //Possibilité d'ajouter un mot-clé par appui sur la touche Entrée du clavier
        if (evt.getKeyChar() == Event.ENTER) {
            //Appel de la méthode pour ajouter un mot-clé dans la liste
            jButton_AjouterMotCléArticle.doClick();
        }
    }//GEN-LAST:event_jTextField_MotsClesAjoutArticleKeyPressed

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
            java.util.logging.Logger.getLogger(TransmettreArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransmettreArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransmettreArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransmettreArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransmettreArticle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AjouterMotCléArticle;
    private javax.swing.JButton jButton_QuitterArticle;
    private javax.swing.JButton jButton_TransmettreArticle;
    private javax.swing.JLabel jLabel_AuteurArticle;
    private javax.swing.JLabel jLabel_ContenuArticle;
    private javax.swing.JLabel jLabel_MotsClesAjoutArticle;
    private javax.swing.JLabel jLabel_MotsClesArticle;
    private javax.swing.JLabel jLabel_NomArticle;
    private javax.swing.JList<String> jList_MotsClesArticle;
    private javax.swing.JPanel jPanel_TransmettreArticle;
    private javax.swing.JScrollPane jScrollPane_ContenuArticle;
    private javax.swing.JScrollPane jScrollPane_MotsClesArticle;
    private javax.swing.JTextArea jTextArea_ContenuArticle;
    private javax.swing.JTextField jTextField_AuteurArticle;
    private javax.swing.JTextField jTextField_MotsClesAjoutArticle;
    private javax.swing.JTextField jTextField_NomArticle;
    // End of variables declaration//GEN-END:variables
}
