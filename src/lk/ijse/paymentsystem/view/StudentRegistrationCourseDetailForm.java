/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.view;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import lk.ijse.paymentsystem.dto.GuardianDTO;
import lk.ijse.paymentsystem.dto.QualificationDTO;
import lk.ijse.paymentsystem.dto.StudentDTO;
import lk.ijse.paymentsystem.view.utils.DSButton;
import lk.ijse.paymentsystem.view.utils.DSTable;
import lk.ijse.paymentsystem.view.utils.DSTextComponents;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author simo-ds
 */
public class StudentRegistrationCourseDetailForm extends javax.swing.JFrame {

    /**
     * Creates new form StudentRegistrationCourseDetailForm
     */
    
    private DSTable table;
    private DSTextComponents textComponents;
//    private DSButton button;
    
    private StudentDTO student;
    private GuardianDTO guardian;
    private StudentRegistrationForm studentRegistrationForm;
            
    public StudentRegistrationCourseDetailForm() {        
        initComponents();
        
        setDefaultCloseOperation(2);
        setLocationRelativeTo(null);
        isAlwaysOnTop();
        
        table = new DSTable(tblQualification);
        textComponents = new DSTextComponents(this.getContentPane());
//        button = new DSButton(this);
//        button.convertAllJButtonsToDSButtons();
//        
        
        for (int i = 0; i < tblQualification.getColumnCount(); i++) {
            if (i==0) {
                table.setHeaderAlignment(i,SwingConstants.CENTER);
                table.setColumnAlignment(i, SwingConstants.LEFT);
            }
            table.setHeaderAlignment(i, SwingConstants.CENTER);
            table.setColumnAlignment(i, SwingConstants.CENTER);
        }
        tblQualification.setFillsViewportHeight(true);
        this.getContentPane().setBackground(Color.WHITE);
        
        
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
        jPanel1 = new javax.swing.JPanel();
        lblProfessionalQualification = new javax.swing.JLabel();
        lblQualificationn = new javax.swing.JLabel();
        lblDateOfAward = new javax.swing.JLabel();
        lblAwardingInstitute = new javax.swing.JLabel();
        lblSpecialization = new javax.swing.JLabel();
        txtQualification = new javax.swing.JTextField();
        txtAwardingInstitute = new javax.swing.JTextField();
        txtDateOfAward = new javax.swing.JTextField();
        txtSpecializtion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQualification = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        lblNecessaryDocuments = new javax.swing.JLabel();
        rdiBtnCopyOfBirthCertificate = new javax.swing.JCheckBox();
        rdiBtnPassportSizeColouredPhotographs = new javax.swing.JCheckBox();
        rdiBtnCopyOfNic = new javax.swing.JCheckBox();
        rdiBtnCopyOfAcademicCertificates = new javax.swing.JCheckBox();
        rdiBtnCopiesOfSportsCertificate = new javax.swing.JCheckBox();
        rdiBtnCopiesOfProfessionalQualificationCertificates = new javax.swing.JCheckBox();
        lblForOfficeUse = new javax.swing.JLabel();
        txtIqTestMarks = new javax.swing.JTextField();
        lblIqTestMarks = new javax.swing.JLabel();
        lblSpecialComments = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaSpecialComments = new javax.swing.JTextArea();
        btnRegisterStudent = new javax.swing.JButton();
        btnAddCourse = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/paymentsystem/images/ijse-logo.gif"))); // NOI18N

        jPanel1.setBackground(java.awt.Color.white);

        lblProfessionalQualification.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblProfessionalQualification.setText("PROFESSIONAL QUALIFICATIONS");

        lblQualificationn.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblQualificationn.setText("Qualification :");

        lblDateOfAward.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblDateOfAward.setText("Date of Award:");

        lblAwardingInstitute.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblAwardingInstitute.setText("Awarding Institute:");

        lblSpecialization.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblSpecialization.setText("Specialization (if any):");

        tblQualification.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        tblQualification.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Qualification", "Awarding Insitute", "Date of Award", "Specialization"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQualification.setRowHeight(30);
        jScrollPane1.setViewportView(tblQualification);
        if (tblQualification.getColumnModel().getColumnCount() > 0) {
            tblQualification.getColumnModel().getColumn(0).setResizable(false);
            tblQualification.getColumnModel().getColumn(1).setResizable(false);
            tblQualification.getColumnModel().getColumn(2).setResizable(false);
            tblQualification.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProfessionalQualification)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblQualificationn)
                                    .addComponent(lblAwardingInstitute)
                                    .addComponent(lblSpecialization)
                                    .addComponent(lblDateOfAward))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSpecializtion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtDateOfAward, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtAwardingInstitute, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtQualification, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProfessionalQualification)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQualificationn)
                    .addComponent(txtQualification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAwardingInstitute)
                    .addComponent(txtAwardingInstitute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDateOfAward)
                    .addComponent(txtDateOfAward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSpecializtion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSpecialization))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel2.setBackground(java.awt.Color.white);

        lblNecessaryDocuments.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblNecessaryDocuments.setText("NECESSARY DOCUMENTS");

        rdiBtnCopyOfBirthCertificate.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        rdiBtnCopyOfBirthCertificate.setText("Copy of Birth Certificate");
        rdiBtnCopyOfBirthCertificate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdiBtnCopyOfBirthCertificateActionPerformed(evt);
            }
        });

        rdiBtnPassportSizeColouredPhotographs.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        rdiBtnPassportSizeColouredPhotographs.setText("3 Passport Size Coloured Photographs");
        rdiBtnPassportSizeColouredPhotographs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdiBtnPassportSizeColouredPhotographsActionPerformed(evt);
            }
        });

        rdiBtnCopyOfNic.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        rdiBtnCopyOfNic.setText("2 Copies of NIC");
        rdiBtnCopyOfNic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdiBtnCopyOfNicActionPerformed(evt);
            }
        });

        rdiBtnCopyOfAcademicCertificates.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        rdiBtnCopyOfAcademicCertificates.setText("Copies of Academic Certificates (O/L & A/L)");
        rdiBtnCopyOfAcademicCertificates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdiBtnCopyOfAcademicCertificatesActionPerformed(evt);
            }
        });

        rdiBtnCopiesOfSportsCertificate.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        rdiBtnCopiesOfSportsCertificate.setText("Copies of Sports Certificate");
        rdiBtnCopiesOfSportsCertificate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdiBtnCopiesOfSportsCertificateActionPerformed(evt);
            }
        });

        rdiBtnCopiesOfProfessionalQualificationCertificates.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        rdiBtnCopiesOfProfessionalQualificationCertificates.setText("Copies of Professional Qaulification Certificates");
        rdiBtnCopiesOfProfessionalQualificationCertificates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdiBtnCopiesOfProfessionalQualificationCertificatesActionPerformed(evt);
            }
        });

        lblForOfficeUse.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblForOfficeUse.setText("FOR OFFICE USE");

        lblIqTestMarks.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblIqTestMarks.setText("IQ Test Marks:");

        lblSpecialComments.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblSpecialComments.setText("<html>Special Comments:<html>");

        txtAreaSpecialComments.setColumns(20);
        txtAreaSpecialComments.setRows(5);
        jScrollPane2.setViewportView(txtAreaSpecialComments);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNecessaryDocuments))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdiBtnPassportSizeColouredPhotographs, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdiBtnCopyOfBirthCertificate, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdiBtnCopyOfNic, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdiBtnCopyOfAcademicCertificates, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdiBtnCopiesOfSportsCertificate, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdiBtnCopiesOfProfessionalQualificationCertificates, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblForOfficeUse)))
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblSpecialComments, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblIqTestMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIqTestMarks)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNecessaryDocuments)
                .addGap(18, 18, 18)
                .addComponent(rdiBtnCopyOfBirthCertificate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdiBtnPassportSizeColouredPhotographs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdiBtnCopyOfNic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdiBtnCopyOfAcademicCertificates)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdiBtnCopiesOfSportsCertificate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdiBtnCopiesOfProfessionalQualificationCertificates)
                .addGap(18, 18, 18)
                .addComponent(lblForOfficeUse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIqTestMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIqTestMarks))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSpecialComments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        btnRegisterStudent.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnRegisterStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/paymentsystem/icons/add.png"))); // NOI18N
        btnRegisterStudent.setText("Register Student");
        btnRegisterStudent.setToolTipText("Click to add a new student");
        btnRegisterStudent.setPreferredSize(new java.awt.Dimension(127, 39));
        btnRegisterStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterStudentActionPerformed(evt);
            }
        });

        btnAddCourse.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnAddCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/paymentsystem/icons/add.png"))); // NOI18N
        btnAddCourse.setText("Add to Course");
        btnAddCourse.setToolTipText("Click to add a new student");
        btnAddCourse.setPreferredSize(new java.awt.Dimension(127, 39));
        btnAddCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCourseActionPerformed(evt);
            }
        });

        btnGoBack.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnGoBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/paymentsystem/icons/back1600 edit.png"))); // NOI18N
        btnGoBack.setText("Go Back");
        btnGoBack.setToolTipText("Click to add a new student");
        btnGoBack.setPreferredSize(new java.awt.Dimension(127, 39));
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRegisterStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegisterStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdiBtnCopyOfBirthCertificateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdiBtnCopyOfBirthCertificateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdiBtnCopyOfBirthCertificateActionPerformed

    private void rdiBtnPassportSizeColouredPhotographsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdiBtnPassportSizeColouredPhotographsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdiBtnPassportSizeColouredPhotographsActionPerformed

    private void rdiBtnCopyOfNicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdiBtnCopyOfNicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdiBtnCopyOfNicActionPerformed

    private void rdiBtnCopyOfAcademicCertificatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdiBtnCopyOfAcademicCertificatesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdiBtnCopyOfAcademicCertificatesActionPerformed

    private void rdiBtnCopiesOfSportsCertificateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdiBtnCopiesOfSportsCertificateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdiBtnCopiesOfSportsCertificateActionPerformed

    private void rdiBtnCopiesOfProfessionalQualificationCertificatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdiBtnCopiesOfProfessionalQualificationCertificatesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdiBtnCopiesOfProfessionalQualificationCertificatesActionPerformed

    private void btnRegisterStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterStudentActionPerformed
        
        ArrayList<QualificationDTO> qualificationList = new ArrayList<>();
        DefaultTableModel dtm = (DefaultTableModel) tblQualification.getModel();
        
        /* take data from the qualification table*/
        
        for (int i = 0; i < dtm.getRowCount(); i++) {
            QualificationDTO qualificationDTO = new QualificationDTO(dtm.getValueAt(i, 0).toString(), dtm.getValueAt(i, 1).toString(), dtm.getValueAt(i, 2).toString(), dtm.getValueAt(i, 3).toString());
            qualificationList.add(qualificationDTO);
        }
        
        /*show confirm message to confirm that the student has paid the registration fee*/
        
        int res = JOptionPane.showConfirmDialog(null,"Do you want to add this Student to the IJSE adminstration System? \n (Make sure this Student has paid the registration fee)","Warning",JOptionPane.YES_NO_OPTION);
        
        /* if the student has paid registration fee, he will be added to the database*/
        if(res==0){
            this.dispose();
        }
            
    }//GEN-LAST:event_btnRegisterStudentActionPerformed

    private void btnAddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCourseActionPerformed
        new CourseDetails(new StudentDTO(), this).setVisible(true);
        
    }//GEN-LAST:event_btnAddCourseActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoBackActionPerformed

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
            java.util.logging.Logger.getLogger(StudentRegistrationCourseDetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentRegistrationCourseDetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentRegistrationCourseDetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentRegistrationCourseDetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentRegistrationCourseDetailForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCourse;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnRegisterStudent;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAwardingInstitute;
    private javax.swing.JLabel lblDateOfAward;
    private javax.swing.JLabel lblForOfficeUse;
    private javax.swing.JLabel lblIqTestMarks;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNecessaryDocuments;
    private javax.swing.JLabel lblProfessionalQualification;
    private javax.swing.JLabel lblQualificationn;
    private javax.swing.JLabel lblSpecialComments;
    private javax.swing.JLabel lblSpecialization;
    private javax.swing.JCheckBox rdiBtnCopiesOfProfessionalQualificationCertificates;
    private javax.swing.JCheckBox rdiBtnCopiesOfSportsCertificate;
    private javax.swing.JCheckBox rdiBtnCopyOfAcademicCertificates;
    private javax.swing.JCheckBox rdiBtnCopyOfBirthCertificate;
    private javax.swing.JCheckBox rdiBtnCopyOfNic;
    private javax.swing.JCheckBox rdiBtnPassportSizeColouredPhotographs;
    private javax.swing.JTable tblQualification;
    private javax.swing.JTextArea txtAreaSpecialComments;
    private javax.swing.JTextField txtAwardingInstitute;
    private javax.swing.JTextField txtDateOfAward;
    private javax.swing.JTextField txtIqTestMarks;
    private javax.swing.JTextField txtQualification;
    private javax.swing.JTextField txtSpecializtion;
    // End of variables declaration//GEN-END:variables
}
