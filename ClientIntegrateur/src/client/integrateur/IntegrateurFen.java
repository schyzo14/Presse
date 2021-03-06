package client.integrateur;

import client.jms.NotificationJMS;
import client.rest.ClientRESTVolume;
import client.rest.ClientRESTPublicites;
import client.rest.ClientRESTArticlesSelectionnes;
import client.rest.ClientRESTTitre;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import presse.Article;
import presse.Publicite;
import presse.Titre;
import presse.Volume;

/**
 * Fenêtre du Client Integrateur
 */
public class IntegrateurFen extends javax.swing.JFrame {
    //Liste de publicités
    private final HashMap<Integer,Publicite> listePub;
    
    //Liste des articles sélectionnés récupérés
    private final HashMap<Integer,Article> listeArticlesSelectionnes;
    
    //Liste d'articles sélectionnés utilisés
    public ArrayList<Article> listeArticlesSel;
    
    //Liste des titres
    private final ArrayList<Titre> listeTitres;
    
    //Convertisseur json
    Gson gson;
    
    //Client JMS
    NotificationJMS notif;
    
    private int i;
    
    /**
     * Création d'une nouvelle fenêtre IntegrateurFen
     */
    public IntegrateurFen() {
        gson = new Gson();
        
        //Init clients REST
        ClientRESTPublicites clientPublicites = new ClientRESTPublicites();
        ClientRESTArticlesSelectionnes clientArticles = new ClientRESTArticlesSelectionnes();
        ClientRESTTitre clientTitres = new ClientRESTTitre();
        
        //Récupération de toutes les publicités au format json
        String publicites = clientPublicites.getListePubs();
        //Récupération de tous les articlesSelectionnes au format json
        String articlesSelectionnes = clientArticles.getListeArticlesSelectionnes();
        //Récupération de tous les titres au format json
        String titres = clientTitres.getTitres();
        
        //Transformation du json à HashMap Pub
        java.lang.reflect.Type typePublicites = new TypeToken<HashMap<Integer,Publicite>>(){}.getType();
        listePub = gson.fromJson(publicites, typePublicites);
        //Transformation du json à HashMap Articles
        java.lang.reflect.Type typeArticles = new TypeToken<HashMap<Integer,Article>>(){}.getType();
        listeArticlesSelectionnes = gson.fromJson(articlesSelectionnes, typeArticles);
        //Transformation du json à HashMap Titres
        java.lang.reflect.Type typeTitres = new TypeToken<ArrayList<Titre>>(){}.getType();
        listeTitres = gson.fromJson(titres, typeTitres);
        
        //Récupération sous forme de liste des pubs
        DefaultListModel<String> lesPubs = new DefaultListModel<>();
        listePub.values().forEach((p) -> {
            lesPubs.addElement("#" + p.getNumP() + " : " + p.getCompagnie() + " - " + p.getContenuP());
        });
        //Récupération sous forme de liste des titres
        DefaultComboBoxModel<String> lesTitres = new DefaultComboBoxModel<>();
        listeTitres.forEach((t) -> {
            lesTitres.addElement("#" + t.getNumT() + " - " + t.getNomT());
        });
        
        //Affichage
        initComponents();
        //Mettre la fenêtre au millieu
        this.setLocationRelativeTo(null);
        listeArticlesSel = new ArrayList<>(listeArticlesSelectionnes.values());
        i = 0;
        jLabelArticle.setText("#" + (i+1) + "/" + listeArticlesSelectionnes.size() + " : " + listeArticlesSel.get(i).getNomA());
        jTextAreaArticle.setText(listeArticlesSel.get(i).getContenuA());
        notif = new NotificationJMS();
        jListPubZone1.setModel(lesPubs);
        jListPubZone2.setModel(lesPubs);
        jComboBoxTitres.setModel(lesTitres);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNumVolume = new javax.swing.JLabel();
        jTextFieldNumVolume = new javax.swing.JTextField();
        jLabelPubZone1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPubZone1 = new javax.swing.JList<>();
        jLabelPubZone2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListPubZone2 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaArticle = new javax.swing.JTextArea();
        jButtonAnnuler = new javax.swing.JButton();
        jButtonValider = new javax.swing.JButton();
        jLabelArticle = new javax.swing.JLabel();
        jButtonSuivant = new javax.swing.JButton();
        jButtonPrecedent = new javax.swing.JButton();
        jComboBoxTitres = new javax.swing.JComboBox<>();
        jLabelTitre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nouveau Volume");

        jLabelNumVolume.setText("Numéro du Volume :");

        jLabelPubZone1.setText("Publicité de la zone 1 :");

        jListPubZone1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListPubZone1.setMinimumSize(new java.awt.Dimension(258, 0));
        jScrollPane1.setViewportView(jListPubZone1);

        jLabelPubZone2.setText("Publicité de la zone 2 :");

        jListPubZone2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListPubZone2.setMinimumSize(new java.awt.Dimension(258, 0));
        jScrollPane2.setViewportView(jListPubZone2);

        jTextAreaArticle.setEditable(false);
        jTextAreaArticle.setColumns(20);
        jTextAreaArticle.setLineWrap(true);
        jTextAreaArticle.setRows(5);
        jScrollPane3.setViewportView(jTextAreaArticle);

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        jButtonValider.setText("Valider");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        jButtonSuivant.setText("Suivant");
        jButtonSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuivantActionPerformed(evt);
            }
        });

        jButtonPrecedent.setText("Précédent");
        jButtonPrecedent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrecedentActionPerformed(evt);
            }
        });

        jLabelTitre.setText("Titre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonPrecedent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelArticle)
                        .addGap(118, 118, 118)
                        .addComponent(jButtonSuivant)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabelPubZone1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabelPubZone2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1))))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabelNumVolume)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNumVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxTitres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNumVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumVolume)
                    .addComponent(jComboBoxTitres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTitre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelArticle)
                    .addComponent(jButtonSuivant)
                    .addComponent(jButtonPrecedent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPubZone1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabelPubZone2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Bouton Annuler
     * @param evt 
     */
    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    /**
     * Bouton Valider
     * @param evt 
     */
    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        //Enregistrement du dernier article et de ses pubs
        int numA = getNumArticleCourant()-1;
        if(this.jListPubZone1.isSelectionEmpty() || this.jListPubZone2.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Il faut choisir deux pubs par article",
                    "Mauvaise sélection",
                    JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            enregistrerArticlePubs(numA);
        }
        
        //Vérification du numéro de volume
        try {
            Integer.parseInt(this.jTextFieldNumVolume.getText());    
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Erreur sur le numéro de volume",
                    "Erreur",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //Vérification que tous les articlesSelectionnes ont été traités
        for(Article a : this.listeArticlesSelectionnes.values()) {
            if(a.getListePublicites().size() != 2) {
                JOptionPane.showMessageDialog(this,
                "Vous n'avez pas traité tous les articles",
                "Erreur",
                JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        //Envoyer le volume sur le serveur 
        Volume v = new Volume(Integer.parseInt(this.jTextFieldNumVolume.getText()));
            v.setListeArticles(this.listeArticlesSelectionnes);
            //Récupération de l'id Titre
            Pattern pattern = Pattern.compile("#(.*) -");
            Matcher matcher = pattern.matcher((String) this.jComboBoxTitres.getSelectedItem());
            if(matcher.find()) {
                v.setNumT(Integer.parseInt(matcher.group(1)));
            }
        ClientRESTVolume clientVolume = new ClientRESTVolume();
        String rep = clientVolume.addVolume(this.gson.toJson(v));
        
        //Envoyer notification au rédacteur chef
        notif.sendNotification(this.gson.toJson(v));
        
        //Dialog Box Quitter
        Object[] options = {"Créer un nouveau volume",
            "Quitter"};
        int reponse = JOptionPane.showOptionDialog(this,
                "Que voulez-vous faire ?",
                "Continuer ?",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

        if(options[reponse].equals("Quitter")){
            notif.closeConnexion();
            this.dispose();
        } else if(options[reponse].equals("Créer un nouveau volume")) {
            //Remettre tous les champs à vide
            this.jTextFieldNumVolume.setText("");
            this.listeArticlesSelectionnes.values().forEach((a) -> {
                a.getListePublicites().clear();
            });
            this.jListPubZone1.clearSelection();
            this.jListPubZone2.clearSelection();
            jLabelArticle.setText("#1/" + listeArticlesSelectionnes.size() + " : " + listeArticlesSelectionnes.get(1).getNomA());
            jTextAreaArticle.setText(listeArticlesSelectionnes.get(1).getContenuA());
        }
    }//GEN-LAST:event_jButtonValiderActionPerformed

    /**
     * Bouton Suivant
     * @param evt 
     */
    private void jButtonSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuivantActionPerformed
        //Récupérer le numéro d'article courant
        int numA = getNumArticleCourant()-1;
        if(this.jListPubZone1.isSelectionEmpty() || this.jListPubZone2.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Il faut choisir deux pubs par article",
                    "Mauvaise sélection",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            enregistrerArticlePubs(numA);

            //Affichage de l'article suivant
            if((i+1) < this.listeArticlesSelectionnes.size()) {
                //Déselection des JList
                this.jListPubZone1.clearSelection();
                this.jListPubZone2.clearSelection();

                i++;
                //Actualisation jLabel et jText
                jLabelArticle.setText("#" + (i+1) + "/" + listeArticlesSelectionnes.size() + " : " + listeArticlesSel.get(i).getNomA());
                jTextAreaArticle.setText(listeArticlesSel.get(i).getContenuA());

                //Sélection des pubs liées
                numA = getNumArticleCourant()-1;
                ArrayList<Publicite> pubs = this.listeArticlesSelectionnes.get(numA).getListePublicites();
                if(!pubs.isEmpty()) {
                    this.jListPubZone1.setSelectedIndex(pubs.get(0).getNumP()-1);
                    this.jListPubZone2.setSelectedIndex(pubs.get(1).getNumP()-1);
                }
            }
        }
    }//GEN-LAST:event_jButtonSuivantActionPerformed

    /**
     * Bouton Précédent
     * @param evt 
     */
    private void jButtonPrecedentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrecedentActionPerformed
        //Récupérer le numéro d'article courant
        int numA = getNumArticleCourant()-1;
        if(this.jListPubZone1.isSelectionEmpty() || this.jListPubZone2.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Il faut choisir deux pubs par article",
                    "Mauvaise sélection",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            enregistrerArticlePubs(numA);
            
            //Affichage de l'article suivant
            if((i+1) > 1) {
                //Déselection des JList
                this.jListPubZone1.clearSelection();
                this.jListPubZone2.clearSelection();

                i--;
                //Actualisation jLabel et jText
                jLabelArticle.setText("#" + (i+1) + "/" + listeArticlesSelectionnes.size() + " : " + listeArticlesSel.get(i).getNomA());
                jTextAreaArticle.setText(listeArticlesSel.get(i).getContenuA());

                //Sélection des pubs liées
                numA = getNumArticleCourant()-1;
                ArrayList<Publicite> pubs = this.listeArticlesSelectionnes.get(numA).getListePublicites();
                if(!pubs.isEmpty()) {
                    this.jListPubZone1.setSelectedIndex(pubs.get(0).getNumP()-1);
                    this.jListPubZone2.setSelectedIndex(pubs.get(1).getNumP()-1);
                }
            }
        }
    }//GEN-LAST:event_jButtonPrecedentActionPerformed

    /**
     * Récupération du numéro d'article courant
     * @return Numéro d'Article
     */
    public int getNumArticleCourant() {
        return this.listeArticlesSel.get(i).getNumA();
    }
    
    /**
     * Récupération de la pub courante dans la zone 1
     * @return numPub1 numéro de la publicité
     */
    public int getNumPub1Courante() {
        int numPub1 = 0;
        Pattern pattern = Pattern.compile("#(.*) :");
        Matcher matcher = pattern.matcher(this.jListPubZone1.getSelectedValue());
        if(matcher.find()) {
            numPub1 = Integer.parseInt(matcher.group(1));
        }
        
        return numPub1;
    }
    
    /**
     * Récupération de la pub courante dans la zone 2
     * @return numPub2 numéro de la publicité
     */
    public int getNumPub2Courante() {
        int numPub2 = 0;
        Pattern pattern = Pattern.compile("#(.*) :");
        Matcher matcher = pattern.matcher(this.jListPubZone2.getSelectedValue());
        if(matcher.find()) {
            numPub2 = Integer.parseInt(matcher.group(1));
        }
        
        return numPub2;
    }
    
    /**
     * Ajout des publicites à l'article
     * @param numA 
     */
    public void enregistrerArticlePubs(int numA) {
        int numPub1 = getNumPub1Courante();
        int numPub2 = getNumPub2Courante();
        ArrayList<Publicite> pubs = new ArrayList<>();
        
        pubs.add(this.listePub.get(numPub1));
        pubs.add(this.listePub.get(numPub2));
        
        this.listeArticlesSelectionnes.get(numA).setListePublicites(pubs);
    }
    
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
            java.util.logging.Logger.getLogger(IntegrateurFen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntegrateurFen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntegrateurFen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntegrateurFen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntegrateurFen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonPrecedent;
    private javax.swing.JButton jButtonSuivant;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JComboBox<String> jComboBoxTitres;
    private javax.swing.JLabel jLabelArticle;
    private javax.swing.JLabel jLabelNumVolume;
    private javax.swing.JLabel jLabelPubZone1;
    private javax.swing.JLabel jLabelPubZone2;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JList<String> jListPubZone1;
    private javax.swing.JList<String> jListPubZone2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaArticle;
    private javax.swing.JTextField jTextFieldNumVolume;
    // End of variables declaration//GEN-END:variables
}
