/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

/**
 *
 * @author manou
 */
public class DetailArticle extends javax.swing.JPanel {

    /**
     * Creates new form DetailArticle
     */
    public DetailArticle() {
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

        jTextField_NomDetailArticle = new javax.swing.JTextField();
        jLabel_NomDetailArticle = new javax.swing.JLabel();
        jLabel_AuteurDetailArticle = new javax.swing.JLabel();
        jTextField_AuteurDetailArticle = new javax.swing.JTextField();
        jScrollPane_ContenuDetailArticle = new javax.swing.JScrollPane();
        jTextArea_ContenuDetailArticle = new javax.swing.JTextArea();
        jLabel_ContenuDetailArticle = new javax.swing.JLabel();
        jLabel_MotsClesDetailArticle = new javax.swing.JLabel();
        jScrollPane_MotsClesDetailArticle = new javax.swing.JScrollPane();
        jList_MotsClesDetailArticle = new javax.swing.JList<>();
        jButton_FermerDetailArticle = new javax.swing.JButton();

        jTextField_NomDetailArticle.setEditable(false);

        jLabel_NomDetailArticle.setText("Nom : ");

        jLabel_AuteurDetailArticle.setText("Auteur :");

        jTextField_AuteurDetailArticle.setEditable(false);

        jTextArea_ContenuDetailArticle.setEditable(false);
        jTextArea_ContenuDetailArticle.setColumns(20);
        jTextArea_ContenuDetailArticle.setRows(5);
        jScrollPane_ContenuDetailArticle.setViewportView(jTextArea_ContenuDetailArticle);

        jLabel_ContenuDetailArticle.setText("Contenu :");

        jLabel_MotsClesDetailArticle.setText("Mots-clés :");

        jList_MotsClesDetailArticle.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane_MotsClesDetailArticle.setViewportView(jList_MotsClesDetailArticle);

        jButton_FermerDetailArticle.setText("Fermer");
        jButton_FermerDetailArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FermerDetailArticleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_NomDetailArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_AuteurDetailArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(347, 347, 347))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_ContenuDetailArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_MotsClesDetailArticle))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane_ContenuDetailArticle)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane_MotsClesDetailArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_NomDetailArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_AuteurDetailArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jButton_FermerDetailArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_NomDetailArticle)
                    .addComponent(jTextField_NomDetailArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_AuteurDetailArticle)
                    .addComponent(jTextField_AuteurDetailArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_ContenuDetailArticle)
                    .addComponent(jScrollPane_ContenuDetailArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_MotsClesDetailArticle)
                    .addComponent(jScrollPane_MotsClesDetailArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_FermerDetailArticle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_FermerDetailArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FermerDetailArticleActionPerformed
        // TODO add your handling code here:
        //Fermer toutes les connexion je suppose
        //Fermeture de la fenêtre
        this.setVisible(false);
    }//GEN-LAST:event_jButton_FermerDetailArticleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_FermerDetailArticle;
    private javax.swing.JLabel jLabel_AuteurDetailArticle;
    private javax.swing.JLabel jLabel_ContenuDetailArticle;
    private javax.swing.JLabel jLabel_MotsClesDetailArticle;
    private javax.swing.JLabel jLabel_NomDetailArticle;
    private javax.swing.JList<String> jList_MotsClesDetailArticle;
    private javax.swing.JScrollPane jScrollPane_ContenuDetailArticle;
    private javax.swing.JScrollPane jScrollPane_MotsClesDetailArticle;
    private javax.swing.JTextArea jTextArea_ContenuDetailArticle;
    private javax.swing.JTextField jTextField_AuteurDetailArticle;
    private javax.swing.JTextField jTextField_NomDetailArticle;
    // End of variables declaration//GEN-END:variables
}