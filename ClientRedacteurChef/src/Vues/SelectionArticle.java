/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import javax.swing.JOptionPane;

/**
 *
 * @author manou
 */
public class SelectionArticle extends javax.swing.JFrame {

    /**
     * Creates new form SelectionArticle
     */
    public SelectionArticle() {
        initComponents();
        
        //Récupérer la notification et afficher s'il y a
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_SelectionArticle = new javax.swing.JPanel();
        jScrollPane_SelectionArticle = new javax.swing.JScrollPane();
        jTable_SelectionArticle = new javax.swing.JTable();
        jButton_QuitterSelection = new javax.swing.JButton();
        jButton_DetailSelection = new javax.swing.JButton();
        jButton_MettrePresse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_SelectionArticle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nom", "Contenu", "Auteur", "Ajouter au volume"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_SelectionArticle.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane_SelectionArticle.setViewportView(jTable_SelectionArticle);

        jButton_QuitterSelection.setText("Quitter");
        jButton_QuitterSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_QuitterSelectionActionPerformed(evt);
            }
        });

        jButton_DetailSelection.setText("Détail");
        jButton_DetailSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DetailSelectionActionPerformed(evt);
            }
        });

        jButton_MettrePresse.setText("Mettre sous presse");
        jButton_MettrePresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MettrePresseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_SelectionArticleLayout = new javax.swing.GroupLayout(jPanel_SelectionArticle);
        jPanel_SelectionArticle.setLayout(jPanel_SelectionArticleLayout);
        jPanel_SelectionArticleLayout.setHorizontalGroup(
            jPanel_SelectionArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_SelectionArticleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_SelectionArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane_SelectionArticle)
                    .addGroup(jPanel_SelectionArticleLayout.createSequentialGroup()
                        .addComponent(jButton_QuitterSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(jButton_DetailSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jButton_MettrePresse, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel_SelectionArticleLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton_DetailSelection, jButton_MettrePresse, jButton_QuitterSelection});

        jPanel_SelectionArticleLayout.setVerticalGroup(
            jPanel_SelectionArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_SelectionArticleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_SelectionArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel_SelectionArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_QuitterSelection)
                    .addComponent(jButton_DetailSelection)
                    .addComponent(jButton_MettrePresse))
                .addGap(20, 20, 20))
        );

        jPanel_SelectionArticleLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton_DetailSelection, jButton_MettrePresse, jButton_QuitterSelection});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_SelectionArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_SelectionArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_QuitterSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_QuitterSelectionActionPerformed
        // TODO add your handling code here:
        //Fermeture des connexion réseau
        
        //Fermeture fenêtre
        System.exit(0);
    }//GEN-LAST:event_jButton_QuitterSelectionActionPerformed

    private void jButton_DetailSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DetailSelectionActionPerformed
        // TODO add your handling code here:
        //Vérification qu'une ligne est bien sélectionné sinon message d'erreur
        if(jTable_SelectionArticle.getSelectedRow()!=-1)
        {
            //Récupérer les éléments liés à l'article sélectionné et afficher DetailArticle
            Detail detail = new Detail();
            detail.setVisible(true);
            
        }else{
            //Popup erreur
            JOptionPane erreurMess = new JOptionPane();
            erreurMess.showMessageDialog(null, "Vous devez sélectionner une ligne pour afficher son détail!", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_DetailSelectionActionPerformed

    private void jButton_MettrePresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MettrePresseActionPerformed
        // TODO add your handling code here:
        //Partie Réseau
        
    }//GEN-LAST:event_jButton_MettrePresseActionPerformed

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
            java.util.logging.Logger.getLogger(SelectionArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectionArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectionArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectionArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectionArticle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_DetailSelection;
    private javax.swing.JButton jButton_MettrePresse;
    private javax.swing.JButton jButton_QuitterSelection;
    private javax.swing.JPanel jPanel_SelectionArticle;
    private javax.swing.JScrollPane jScrollPane_SelectionArticle;
    private javax.swing.JTable jTable_SelectionArticle;
    // End of variables declaration//GEN-END:variables
}
