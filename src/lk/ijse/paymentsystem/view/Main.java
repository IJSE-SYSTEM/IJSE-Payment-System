/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Ranjith Suranga
 */
public class Main extends javax.swing.JFrame {

    private boolean playTitle = false;
    
    /**
     * Creates new form Main
     */
    public Main() {
        
        initComponents();
        
        // Setting size
        setSize(1366, 730);

        // Centering the form
        setLocationRelativeTo(null);

        // Setting background color to white
        this.getContentPane().setBackground(Color.WHITE);
        
        initMenuItems(this);
        
        
        KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();

        kfm.addKeyEventPostProcessor(new KeyEventPostProcessor() {

            @Override
            public boolean postProcessKeyEvent(KeyEvent e) {

                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_F1:
                            navigateMe(0);
                            break;
                    }
                }
                return true;
            }

        });
    }

    private void navigateMe(int index) {
        switch (index) {
            case 0:
                ManageStudents.showInstance(this, playTitle);
                break;
            default:
                break;
        }
    }

    
    
    
    private void initMenuItems(Container container) {

        for (Component cmp : container.getComponents()) {
            
            if (cmp.getName() != null && cmp.getName().equals("mnItem")) {
                

                initMenuEvents((Container) cmp);

                cmp.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        Container cnt = (Container) cmp;

                        for (Component lbl : cnt.getComponents()) {
                            if (lbl.getName() != null) {
                                JLabel lblIcon = (JLabel) lbl;
                                ImageIcon icon = new ImageIcon(this.getClass().getResource("/lk/ijse/paymentsystem/icons/" + lblIcon.getName() + "_2x.png"));
                                lblIcon.setIcon(icon);
                            } else {
                                JLabel lblIcon = (JLabel) lbl;
                                lblIcon.setForeground(new Color(0x0000FA));
                            }
                        }

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        Container cnt = (Container) cmp;
                        for (Component lbl : cnt.getComponents()) {
                            if (lbl.getName() != null) {
                                JLabel lblIcon = (JLabel) lbl;
                                ImageIcon icon = new ImageIcon(this.getClass().getResource("/lk/ijse/paymentsystem/icons/" + lblIcon.getName() + ".png"));
                                lblIcon.setIcon(icon);
                            } else {
                                JLabel lblIcon = (JLabel) lbl;
                                lblIcon.setForeground(Color.BLACK);
                            }
                        }
                    }

                });
            }

            if (cmp instanceof Container) {
                initMenuItems((Container) cmp);
            }
        }

    }

    private void initMenuEvents(Container container) {

        class DSMouseAdapter extends MouseAdapter {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                switch (getMenuItemIndex(e.getSource())) {
//                    case 1:
//                        new ManageSubjects(Main.this, true).setVisible(true);
//                        break;
//                    case 2:
//                        new ManageCourses(Main.this, true).setVisible(true);
//                        break;
//                    case 3:
//                        new ManageResults(Main.this, true).setVisible(true);
//                        break;
                    case 4:
                        ManageStudents.showInstance(Main.this, true);
                        break;
                    case 5:
                        new SystemSettings(Main.this, true).setVisible(true);break;
                }

            }

        }

        container.addMouseListener(new DSMouseAdapter());
    }

    private int getMenuItemIndex(Object source) {

        JLabel lbl = null;

        if (source instanceof JLabel && ((JLabel) source).getName() == null) {
            // This is probability what we are looking for
            lbl = (JLabel) source;

        } else {
            // If that is not the case, it should be the icon label or jpanel
            JPanel pnlContainer = (source instanceof JPanel) ? (JPanel) source : (JPanel) ((JLabel) source).getParent();

            for (Component cmp : pnlContainer.getComponents()) {
                if (cmp instanceof JLabel && ((JLabel) cmp).getIcon() == null) {
                    lbl = (JLabel) cmp;
                    break;
                }
            }
        }

        if (lbl != null) {

            switch (lbl.getText()) {
                case "Manage Subjects":
                    return 1;
                case "Manage Courses":
                    return 2;
                case "Manage Results":
                    return 3;
                case "Manage Students":
                    return 4;
                case "System Settings":
                    return 5;
                default:
                    return -1;
            }
        } else {
            return -1;
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

        lblLogo = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblCopyright = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblManageStudents = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTitle2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IJSE - Academic Results System");
        setResizable(false);
        getContentPane().setLayout(null);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/paymentsystem/images/ijse-logo.gif"))); // NOI18N
        getContentPane().add(lblLogo);
        lblLogo.setBounds(260, 90, 460, 100);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("<html><center>Administration System</center></html>");
        getContentPane().add(lblTitle);
        lblTitle.setBounds(810, 80, 260, 100);

        lblCopyright.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCopyright.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCopyright.setText("Copyright © 2017");
        getContentPane().add(lblCopyright);
        lblCopyright.setBounds(820, 230, 250, 26);

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setName("mnItem"); // NOI18N

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/paymentsystem/icons/manage_students.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.setName("manage_students"); // NOI18N

        lblManageStudents.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblManageStudents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblManageStudents.setText("Manage Students");
        lblManageStudents.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblManageStudents)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(lblManageStudents))
        );

        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.setName("mnItem"); // NOI18N
        jPanel4.setOpaque(false);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/paymentsystem/icons/system_settings.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.setName("system_settings"); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("System Settings");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/paymentsystem/icons/PaymentBtn.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 671, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(33, 33, 33))
        );

        getContentPane().add(pnlMenu);
        pnlMenu.setBounds(30, 280, 1300, 230);

        lblTitle2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle2.setText("Admin");
        getContentPane().add(lblTitle2);
        lblTitle2.setBounds(820, 190, 250, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        String sid = JOptionPane.showInputDialog("Enter Student ID:");
        if (sid != null) {
//            CourseDetails courseDetails = new CourseDetails(sid);
//            courseDetails.setVisible(true);
            StudentDetails studentDetails = new StudentDetails(sid);
            studentDetails.setVisible(true);
        }
        
        
    }//GEN-LAST:event_jLabel1MouseClicked

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
                if ("Windows".equals(info.getName()) || "GTK+".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    UIManager.put("ToolTip.background", new Color(0, 0, 0, 200));
                    UIManager.put("ToolTip.border", new EmptyBorder(5, 5, 5, 5));
                    UIManager.put("ToolTip.foreground", new Color(255, 255, 255));
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCopyright;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblManageStudents;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
