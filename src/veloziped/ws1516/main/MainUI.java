/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.main;

import java.util.ResourceBundle;
import veloziped.ws1516.util.Utils;

/**
 *
 * @author Mihai Sava
 */
public class MainUI extends javax.swing.JFrame {

    /**
     * Creates new form MainUI
     */
    public MainUI() {
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuSettings = new javax.swing.JMenu();
        jMenuLanguage = new javax.swing.JMenu();
        jCheckBoxMenuItemDeutsch = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemEnglish = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("veloziped/ws1516/i18n/i18n"); // NOI18N
        jMenuFile.setText(bundle.getString("File")); // NOI18N
        jMenuBar1.add(jMenuFile);

        jMenuSettings.setText(bundle.getString("Settings")); // NOI18N

        jMenuLanguage.setText(bundle.getString("Language")); // NOI18N

        jCheckBoxMenuItemDeutsch.setText(bundle.getString("Deutsch")); // NOI18N
        jCheckBoxMenuItemDeutsch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemDeutschActionPerformed(evt);
            }
        });
        jMenuLanguage.add(jCheckBoxMenuItemDeutsch);

        jCheckBoxMenuItemEnglish.setSelected(true);
        jCheckBoxMenuItemEnglish.setText(bundle.getString("English")); // NOI18N
        jCheckBoxMenuItemEnglish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemEnglishActionPerformed(evt);
            }
        });
        jMenuLanguage.add(jCheckBoxMenuItemEnglish);

        jMenuSettings.add(jMenuLanguage);

        jMenuBar1.add(jMenuSettings);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1111, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxMenuItemEnglishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemEnglishActionPerformed
        this.changeLanguage("en", "US");
        jCheckBoxMenuItemDeutsch.setSelected(false);
    }//GEN-LAST:event_jCheckBoxMenuItemEnglishActionPerformed

    private void jCheckBoxMenuItemDeutschActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemDeutschActionPerformed
        this.changeLanguage("de", "DE");
        jCheckBoxMenuItemEnglish.setSelected(false);
    }//GEN-LAST:event_jCheckBoxMenuItemDeutschActionPerformed

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
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemDeutsch;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemEnglish;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuLanguage;
    private javax.swing.JMenu jMenuSettings;
    // End of variables declaration//GEN-END:variables

    //util methods
    public void changeLanguage(String lang, String country){
        ResourceBundle i18n = Utils.getResourceBundle(lang, country);
        
        jMenuFile.setText(i18n.getString("File"));
        jMenuSettings.setText(i18n.getString("Settings"));
        jMenuLanguage.setText(i18n.getString("Language"));
        jCheckBoxMenuItemDeutsch.setText(i18n.getString("Deutsch"));
        jCheckBoxMenuItemEnglish.setText(i18n.getString("English"));
    }
}
