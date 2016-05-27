
package dev.cameron2134.nmp.display;

import dev.cameron2134.nmp.utilities.IO;
import dev.cameron2134.nmp.PingChecker;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.ImageIcon;


public class GUI extends javax.swing.JFrame {
 
    private final File anchorFile = new File("resources/data/settings.cfg");
    private final File addressFile = new File("resources/data/address.cfg");
    
    private Point anchorPosition;
    private Point oldPos;

    private PingChecker pinger;
    
    
    
    public GUI() {

        feel();
        initComponents();
        
        pinger = new PingChecker(this);
        
        setup();
        createListeners();

        this.setBackground(new Color(0, 0, 0, 0.05f));

        createIcons();
        
        
        new Thread(pinger).start();
    }

    
    

    private void setup() {
        // Receive array from load file method, set location to the x and y stored in positions 0 and 1
        
        int[] anchorPos;

        
        // Default address
        if (!addressFile.exists()) 
            pinger.setAddress("www.ebay.co.uk");
        
        else
            pinger.setAddress(IO.loadDefaultAddress(addressFile));
            
            
            
        
        // Anchor position
        if (!anchorFile.exists()) // if running for first time, do not load anchored position
            return;
        
        else {
        
            anchorPos = IO.loadWindowPos(anchorFile);

            this.setLocation(anchorPos[0], anchorPos[1]);
        
        }
        
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
    
    
    
    

    private void createIcons() {
        
            ImageIcon frameIcon = new ImageIcon("resources/frameIcon.png");
            ImageIcon settingsIcon = new ImageIcon("resources/settings.png");
            ImageIcon closeIcon = new ImageIcon("resources/close.png");
            
            this.setIconImage(frameIcon.getImage());
            btn_settings.setIcon(settingsIcon);
            btn_close.setIcon(closeIcon);
        
    }
    
    
    
    
    
    private void createListeners() {
        
        this.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent e) {
                oldPos = e.getPoint();
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                oldPos = null;
            }
            
        });
        
        
        
        this.addMouseMotionListener(new MouseAdapter() {
            
            @Override
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                GUI.this.setLocation(currCoords.x - oldPos.x, currCoords.y - oldPos.y);
                anchorPosition = GUI.this.getLocation();
            }
            
        });
        
    }
    
    
    
    
    
    /**
     * Displays the current latency value and applies a colour depending on that value.
     * If the value is not an integer, it is an error message.
     * 
     * @param text The latency value/error to display.
     */
    public void setDisplayLbl(String text) {
        
        int latency;
        
        // If text can be parsed it is latency value, otherwise it is text
        
        if (IO.isInt(text)) {
            
            latency = Integer.parseInt(text);
            
            if (latency <= 60) 
                setColour(Color.green);
            else if (latency <= 149)
                setColour(Color.yellow);
            else
                setColour(Color.red);
            
            lbl_displayPing.setText(text + "ms");
        }
        
        else {
            lbl_displayPing.setText(text);
        }

        
        System.out.println(text);
        System.out.println(pinger.getAddress());
        
        
    }
    
    
    
    
    public void setColour(Color color) {
        lbl_displayPing.setForeground(color);
    }
    
    
    
    public Point getAnchorPos() {
        return this.anchorPosition;
    }
    
    public File getAnchorFile() {
        return this.anchorFile;
    }
    
    public File getAddressFile() {
        return this.addressFile;
    }
    
    
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_mainPanel = new javax.swing.JPanel();
        btn_close = new javax.swing.JButton();
        btn_settings = new javax.swing.JButton();
        lbl_displayPing = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Need My Ping (v1.0.0)");
        setUndecorated(true);
        setResizable(false);

        panel_mainPanel.setOpaque(false);

        btn_close.setFont(new java.awt.Font("Myanmar Text", 0, 12)); // NOI18N
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });

        btn_settings.setFont(new java.awt.Font("Myanmar Text", 0, 12)); // NOI18N
        btn_settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_settingsActionPerformed(evt);
            }
        });

        lbl_displayPing.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        lbl_displayPing.setForeground(new java.awt.Color(0, 190, 0));

        javax.swing.GroupLayout panel_mainPanelLayout = new javax.swing.GroupLayout(panel_mainPanel);
        panel_mainPanel.setLayout(panel_mainPanelLayout);
        panel_mainPanelLayout.setHorizontalGroup(
            panel_mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_mainPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_close))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_mainPanelLayout.createSequentialGroup()
                        .addComponent(lbl_displayPing, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_settings)))
                .addContainerGap())
        );
        panel_mainPanelLayout.setVerticalGroup(
            panel_mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_settings)
                    .addComponent(lbl_displayPing, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_close)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        pinger.getProcess().destroy(); 
        System.exit(0);
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_settingsActionPerformed
        
       new OptionsGUI(pinger, this).setVisible(true);

    }//GEN-LAST:event_btn_settingsActionPerformed

    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_settings;
    private javax.swing.JLabel lbl_displayPing;
    private javax.swing.JPanel panel_mainPanel;
    // End of variables declaration//GEN-END:variables

    

    
    
    
}
