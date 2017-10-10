/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import lk.ijse.paymentsystem.controller.ControllerFactory;
import lk.ijse.paymentsystem.controller.custom.CourseController;
import lk.ijse.paymentsystem.dto.CourseDetailsDTO;
import lk.ijse.paymentsystem.dto.RegistrationDTO;
import lk.ijse.paymentsystem.dto.StudentDTO;
import lk.ijse.paymentsystem.view.utils.DSTextComponents;

/**
 *
 * @author simo-ds
 */
public class PaymentForRegistrationCourse1 extends javax.swing.JFrame {

    /**
     * Creates new form PaymentForRegistrationCourse
     */
    
    private PaymentForRegistrationCourseController1 controller;
    private DSTextComponents textComponents;
    private StudentDTO studentDTO;
   
    
    public PaymentForRegistrationCourse1() {
        initComponents();
        setDefaultCloseOperation(2);
        this.getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        textComponents = new DSTextComponents(this.getContentPane());
    }
    
    public PaymentForRegistrationCourse1(StudentDTO studentDTO,CourseDetailsDTO cdto, RegistrationDTO rdto){
        this();
        controller=new PaymentForRegistrationCourseController1(studentDTO, cdto, rdto);
        this.studentDTO=studentDTO;
        initComponents2();
    }
    
    public PaymentForRegistrationCourse1(String sid,CourseDetailsDTO cdto, RegistrationDTO rdto){
        this();
        controller=new PaymentForRegistrationCourseController1(sid, cdto, rdto);
//        this.studentDTO=studentDTO;
        initComponents2();
    }
    
    public class MissakaListSelectionModel extends DefaultListSelectionModel{
        private int fromIndex;
        private int toIndex;
        public void setSelectionRange(int from, int to){
            fromIndex=from;
            toIndex=to;
        }
        
        public void setSelectedRange(int index0, int index1){
            super.setSelectionInterval(index0, index1);
        }
        
        @Override
        public void setSelectionInterval(int index0, int index1) {
            if (index0<=index1 && index0>=fromIndex && index1<=toIndex)
                super.setSelectionInterval(index0, index1); //To change body of generated methods, choose Tools | Templates.
            else if (fromIndex==0 && toIndex==0)
                super.setSelectionInterval(index0, index1);
        }
        
    }
    
    public MissakaListSelectionModel mlsmPay1=new MissakaListSelectionModel();
    public MissakaListSelectionModel mlsmPay2=new MissakaListSelectionModel();
    
    private void initComponents2(){
        ArrayList<DefaultTableModel> tblMdls=controller.setPaymentScheme();
        tblPay1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblPay2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblPay1.setModel(tblMdls.get(0));
        tblPay2.setModel(tblMdls.get(1));
        tblPay1.setSelectionModel(mlsmPay1);
        tblPay2.setSelectionModel(mlsmPay2);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblProfessionalQualification = new javax.swing.JLabel();
        lblQualificationn = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        lblQualificationn1 = new javax.swing.JLabel();
        lblQualificationn2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblQualificationn3 = new javax.swing.JLabel();
        txtCheque = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lblQualificationn4 = new javax.swing.JLabel();
        lblQualificationn5 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        txtDiscount = new javax.swing.JTextField();
        lblQualificationn6 = new javax.swing.JLabel();
        txtPayable = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPay1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPay2 = new javax.swing.JTable();
        btnAddStudent = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/paymentsystem/images/ijse-logo.gif"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/paymentsystem/images/payment gateway.png"))); // NOI18N

        jPanel1.setBackground(java.awt.Color.white);

        lblProfessionalQualification.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblProfessionalQualification.setText("PAYMENT DETAILS");

        lblQualificationn.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblQualificationn.setText("Payment Method :");

        jRadioButton1.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        jRadioButton1.setText("Cheque");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        jRadioButton2.setText("Cash");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        jRadioButton3.setText("Credit or Debit Card");

        jRadioButton4.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        jRadioButton4.setText("Bank");

        lblQualificationn1.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblQualificationn1.setText("Payment For :");

        lblQualificationn2.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        lblQualificationn2.setText("Cheque No:");

        lblQualificationn3.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        lblQualificationn3.setText("Slip No:");

        lblQualificationn4.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblQualificationn4.setText("Total Amount :");

        lblQualificationn5.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblQualificationn5.setText("Discount :");

        lblQualificationn6.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblQualificationn6.setText("Amount Payable:");

        tblPay1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semesters"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblPay1);

        tblPay2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Portions"
            }
        ));
        jScrollPane3.setViewportView(tblPay2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblProfessionalQualification))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblQualificationn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblQualificationn5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblQualificationn4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtDiscount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAmount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblQualificationn2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCheque))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblQualificationn3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblQualificationn)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(115, 115, 115)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton4)
                                        .addComponent(jRadioButton3)))
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblQualificationn6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPayable, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProfessionalQualification)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQualificationn)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton4))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQualificationn2)
                    .addComponent(txtCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQualificationn3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQualificationn1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblQualificationn4)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblQualificationn5)
                            .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblQualificationn6)
                            .addComponent(txtPayable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        btnAddStudent.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnAddStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/paymentsystem/icons/add.png"))); // NOI18N
        btnAddStudent.setMnemonic('A');
        btnAddStudent.setText("Do Payment");
        btnAddStudent.setToolTipText("Click to add a new student");
        btnAddStudent.setPreferredSize(new java.awt.Dimension(127, 39));
        btnAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudentActionPerformed(evt);
            }
        });
        btnAddStudent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnAddStudentKeyReleased(evt);
            }
        });

        btnGoBack.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnGoBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/paymentsystem/icons/back1600 edit.png"))); // NOI18N
        btnGoBack.setMnemonic('G');
        btnGoBack.setText("Go Back");
        btnGoBack.setToolTipText("Click to add a new student");
        btnGoBack.setPreferredSize(new java.awt.Dimension(127, 39));
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });
        btnGoBack.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnGoBackKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(279, 279, 279)
                                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(btnAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(549, 549, 549)
                        .addComponent(btnAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void btnAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStudentActionPerformed
        try{
            controller.doRegistration();
//        JOptionPane.showMessageDialog(null,"Student Successfully Registered");
        }catch(NullPointerException e){
            e.printStackTrace();
        }
//        this.dispose();//        PaymentForRegistrationCourse paymentForm = new PaymentForRegistrationCourse();
//        new PaymentForRegistrationCourse().setVisible(true);
//        studentRFC.dispose();
//        this.dispose();
    }//GEN-LAST:event_btnAddStudentActionPerformed

    private void btnAddStudentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddStudentKeyReleased
        //        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            //            btnGoBack.requestFocusInWindow();
            //        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            //            btnGoBack.requestFocusInWindow();
            //        }
    }//GEN-LAST:event_btnAddStudentKeyReleased

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
//        StudentRegistrationCourseDetailForm studentRegistrationCourseDetailsForm = new StudentRegistrationCourseDetailForm();
//        studentRegistrationCourseDetailsForm.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnGoBackKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGoBackKeyReleased
        
    }//GEN-LAST:event_btnGoBackKeyReleased

//    TreeSelectionListener tsl=(e) -> {
//        treeSelectionTriggered(e);
//    };
    
    
    
    
    //change this array to the maximum number of semesters in a course
    //use formulae no_of_semesters*3
    //currently it is set for a maximum 8 semsters
    static int[] rows={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
    static ArrayList<Integer> semesterRows;
    {
        semesterRows=new ArrayList<>();
        for (int i=1; i<rows.length; i+=3)
            semesterRows.add(i);
    }
    
//    private void treeSelectionTriggered(TreeSelectionEvent e){
//        //System.out.println(Arrays.toString(jtrPayment.getSelectionRows()));
//        int selectedRows[]=jtrPayment.getSelectionRows();
//        System.out.println("Selected Rows : "+Arrays.toString(selectedRows));
//        int selectRows[]={};
//        
//        LOOP1: for (boolean runLoop=true,isInital=true;runLoop==true;){
//            System.out.println("Loop 1");
//            LOOP2:for (int selectedRow : selectedRows) {
//                System.out.println("Selected Row : "+selectedRow);
//                if(selectedRow==0){
//                    System.out.println("1");
//                    selectRows=Arrays.copyOf(rows, jtrPayment.getRowCount());
//                    break LOOP1;
//
//                }else if(semesterRows.contains(selectedRow)){
////                    System.out.println("2");
//
//                    int temp[]=Arrays.copyOfRange(rows, selectedRow,selectedRow+3);
//                    selectRows=Arrays.copyOf(selectRows, selectRows.length+temp.length);
//                    for (int i=selectRows.length-temp.length,j=0; j<temp.length; j++,i++){
//                        selectRows[i]=temp[j];
//                    }
//
//                }else if(semesterRows.contains(selectedRow-1)){
////                    System.out.println("3");
//                    
//                    if(isInital==true){
//                        if (selectedRows.length==1 || selectedRows.length==2 && ((selectedRow+1)==selectedRows[1])){
//                            selectRows=Arrays.copyOf(selectRows, selectRows.length+selectedRows.length);
//                            for (int i=selectRows.length-selectedRows.length,j=0; j<selectedRows.length; j++,i++){
//                                selectRows[i]=selectedRows[j];
//                            }
//                        }
//                    }
//
//                    if (jtrPayment.isRowSelected(selectedRow+1)){
////                        System.out.println("3.1");
//                        selectRows=Arrays.copyOf(selectRows, selectRows.length+1);
//                        selectRows[selectRows.length-1]=selectedRow-1;
//                        System.out.println("Select Rows : "+Arrays.toString(selectRows));
//                    }
//                }
//                else if(semesterRows.contains(selectedRow-2)){
////                    System.out.println("4");
//                    
//                    if(isInital==true){
//                        if (selectedRows.length==1 || selectedRows.length==2 && ((selectedRow-1)==selectedRows[1])){
//                            selectRows=Arrays.copyOf(selectRows, selectRows.length+selectedRows.length);
//                            for (int i=selectRows.length-selectedRows.length,j=0; j<selectedRows.length; j++,i++){
//                                selectRows[i]=selectedRows[j];
//                            }
//                        }
//                    }
//                }
//            }
//            break LOOP1;
//        }
////        System.out.println("Select Rows : "+Arrays.toString(selectRows));
//
//        Arrays.sort(selectRows);
//        int[] temp={selectRows[0]};
//        for (int i1 = 1; i1 < selectRows.length; i1++) {
//            if (selectRows[i1]!=selectRows[i1-1]){
//                temp=Arrays.copyOf(temp, temp.length+1);
//                temp[temp.length-1]=selectRows[i1];
//            }
//        }
//        selectRows=temp;
//        
//        if (Arrays.equals(Arrays.copyOfRange(rows, 1, jtrPayment.getRowCount()),selectRows)){
//            selectRows=Arrays.copyOf(rows, jtrPayment.getRowCount());
//        }
//        
//        jtrPayment.removeTreeSelectionListener(tsl);
//        jtrPayment.setSelectionRows(selectRows);
//        jtrPayment.addTreeSelectionListener(tsl);
//
//        ArrayList<Double> calculatedAmounts=controller.calculateAmounts(selectRows);
//        txtAmount.setText(calculatedAmounts.get(0).toString());
//        txtDiscount.setText(calculatedAmounts.get(1).toString());
//        txtPayable.setText(calculatedAmounts.get(2).toString());
//        System.out.println("loop over\n");
//    }
    
        
//    TreeModel tm1=new DefaultTreeModel
    
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
            java.util.logging.Logger.getLogger(PaymentForRegistrationCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentForRegistrationCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentForRegistrationCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentForRegistrationCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CourseDetailsDTO cdto=new CourseDetailsDTO();
                CourseController cc = (CourseController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.COURSE);
                try {
                    cdto=cc.getCourseDetails("C001");
                } catch (Exception ex) {
                    Logger.getLogger(PaymentForRegistrationCourse1.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(cdto.getCourseID()+" "+cdto.getNo_of_Semesters());
                new PaymentForRegistrationCourse1(new StudentDTO(), cdto, new RegistrationDTO()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddStudent;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblProfessionalQualification;
    private javax.swing.JLabel lblQualificationn;
    private javax.swing.JLabel lblQualificationn1;
    private javax.swing.JLabel lblQualificationn2;
    private javax.swing.JLabel lblQualificationn3;
    private javax.swing.JLabel lblQualificationn4;
    private javax.swing.JLabel lblQualificationn5;
    private javax.swing.JLabel lblQualificationn6;
    private javax.swing.JTable tblPay1;
    private javax.swing.JTable tblPay2;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtCheque;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtPayable;
    // End of variables declaration//GEN-END:variables
}