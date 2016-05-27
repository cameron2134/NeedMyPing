
package dev.cameron2134.nmp.display;

import dev.cameron2134.nmp.utilities.IO;
import dev.cameron2134.nmp.PingChecker;
import javax.swing.ImageIcon;



public class OptionsGUI extends javax.swing.JFrame {


    private PingChecker pinger;
    private GUI gui;
    

    
    public OptionsGUI(PingChecker pinger, GUI gui) {
        feel();
        initComponents();
        
        this.pinger = pinger;
        this.gui = gui;
        
        lbl_currentServer.setText(pinger.getAddress()); // display when window is first opened
        

        this.setIconImage(new ImageIcon("resources/settings.png").getImage());
    }

    
    
    
    private void feel() {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }
    
    

    
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrp = new javax.swing.ButtonGroup();
        panel_settingsPanel = new javax.swing.JPanel();
        lbl_server = new javax.swing.JLabel();
        TF_server = new javax.swing.JTextField();
        lbl_status = new javax.swing.JLabel();
        btn_anchor = new javax.swing.JButton();
        btn_setDefault = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl_currentServer = new javax.swing.JLabel();
        combo_servers = new javax.swing.JComboBox();
        lbl_server1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Options");
        setResizable(false);

        panel_settingsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lbl_server.setFont(new java.awt.Font("Palatino Linotype", 1, 13)); // NOI18N
        lbl_server.setText("Default Servers");

        TF_server.setFont(new java.awt.Font("Palatino Linotype", 0, 11)); // NOI18N
        TF_server.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_serverActionPerformed(evt);
            }
        });

        btn_anchor.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        btn_anchor.setText("Anchor Widget");
        btn_anchor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anchorActionPerformed(evt);
            }
        });

        btn_setDefault.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        btn_setDefault.setText("Set  Default");
        btn_setDefault.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_setDefaultActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 13)); // NOI18N
        jLabel1.setText("Current:");

        lbl_currentServer.setFont(new java.awt.Font("Palatino Linotype", 0, 13)); // NOI18N

        combo_servers.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Google", "Yahoo", "Ebay", "Facebook" }));
        combo_servers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_serversActionPerformed(evt);
            }
        });

        lbl_server1.setFont(new java.awt.Font("Palatino Linotype", 1, 13)); // NOI18N
        lbl_server1.setText("Custom Server");

        javax.swing.GroupLayout panel_settingsPanelLayout = new javax.swing.GroupLayout(panel_settingsPanel);
        panel_settingsPanel.setLayout(panel_settingsPanelLayout);
        panel_settingsPanelLayout.setHorizontalGroup(
            panel_settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_settingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_settingsPanelLayout.createSequentialGroup()
                        .addGroup(panel_settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_settingsPanelLayout.createSequentialGroup()
                                .addComponent(lbl_server)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_servers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_settingsPanelLayout.createSequentialGroup()
                                .addComponent(lbl_server1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TF_server, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(panel_settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lbl_currentServer, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel_settingsPanelLayout.createSequentialGroup()
                        .addComponent(btn_setDefault)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_anchor)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_settingsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        panel_settingsPanelLayout.setVerticalGroup(
            panel_settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_settingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TF_server, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_server1))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_server)
                        .addComponent(combo_servers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_currentServer, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(panel_settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_setDefault)
                    .addComponent(btn_anchor))
                .addGap(42, 42, 42)
                .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_settingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_settingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TF_serverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_serverActionPerformed

        pinger.setAddress(TF_server.getText());
        pinger.setServer(true);

        TF_server.setText(null);

        lbl_status.setText("Server changed!");
        lbl_currentServer.setText(pinger.getAddress()); // update when the new server is entered
       
        

    }//GEN-LAST:event_TF_serverActionPerformed

    
    
    private void btn_anchorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anchorActionPerformed
        IO.saveWindowPos(gui.getAnchorPos(), gui.getAnchorFile());
        
        lbl_status.setText("Widget anchored!");
    }//GEN-LAST:event_btn_anchorActionPerformed

    
    
    private void btn_setDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_setDefaultActionPerformed
        IO.saveDefaultAddress(pinger.getAddress(), gui.getAddressFile());
        
        lbl_status.setText("Default server changed!");
    }//GEN-LAST:event_btn_setDefaultActionPerformed

    
    
    private void combo_serversActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_serversActionPerformed
        
        switch (combo_servers.getSelectedItem().toString()) {
            
            case "Google":
                pinger.setAddress("www.google.com");
                break;
                
            case "Yahoo":
                pinger.setAddress("www.yahoo.com");
                break;
                
            case "Ebay":
                pinger.setAddress("www.ebay.co.uk");
                break;
                
            case "Facebook":
                pinger.setAddress("www.facebook.com");
                break;
               
            
        }


        pinger.setServer(true);

        lbl_status.setText("Server changed!");
        lbl_currentServer.setText(pinger.getAddress());
    }//GEN-LAST:event_combo_serversActionPerformed

    
    
    
    
    

    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TF_server;
    public javax.swing.ButtonGroup btnGrp;
    private javax.swing.JButton btn_anchor;
    private javax.swing.JButton btn_setDefault;
    private javax.swing.JComboBox combo_servers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_currentServer;
    private javax.swing.JLabel lbl_server;
    private javax.swing.JLabel lbl_server1;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JPanel panel_settingsPanel;
    // End of variables declaration//GEN-END:variables
}
