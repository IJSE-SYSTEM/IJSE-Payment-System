/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import lk.ijse.paymentsystem.controller.ControllerFactory;
import lk.ijse.paymentsystem.controller.custom.SchoolController;
import lk.ijse.paymentsystem.controller.custom.StudentController;
import lk.ijse.paymentsystem.dto.GuardianDTO;
import lk.ijse.paymentsystem.dto.StudentDTO;
import lk.ijse.paymentsystem.view.utils.DSTextComponents;

/**
 *
 * @author simo-ds
 */
public class StudentRegistrationForm extends javax.swing.JFrame {

    private StudentDTO studentDTO;
    private StudentController sc;
    private final double regFee = 5000;
    private StudentRegistrationFormController controller;

    String[] elements;
    /**
     * Creates new form StudentRegistrationForm
     */
    private DSTextComponents textComponent;
//    private DSButton button;

    public StudentRegistrationForm() {
        loadSchool();
        initComponents();
        setDefaultCloseOperation(2);
        setLocationRelativeTo(null);
        
        controller = new StudentRegistrationFormController(studentDTO);

//        button = new DSButton(this);
//        button.convertAllJButtonsToDSButtons();
        getContentPane().setBackground(new Color(0xFFFFFF));

        for (Component cmp : this.getContentPane().getComponents()) {
            if (cmp instanceof JButton) {
                JButton btn = (JButton) cmp;
                btn.setFocusPainted(false);
                btn.addFocusListener(new FocusAdapter() {

                    @Override
                    public void focusGained(FocusEvent e) {
                        super.focusGained(e);
                        btn.setFont(btn.getFont().deriveFont(Font.PLAIN));
                        btn.setForeground(new Color(0x0000FF));
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        super.focusLost(e);
                        btn.setFont(btn.getFont().deriveFont(Font.PLAIN));
                        btn.setForeground(new Color(0x000000));
                    }

                });
            }
        }

        this.getContentPane().setBackground(Color.WHITE);

        textComponent = new DSTextComponents(this.getContentPane());
//        cmbSchool.addItem("");
        cmbSchool.setSelectedIndex(-1);

    }

    ////////////////////////////////////
    class AutoCompleteComboBox extends JComboBox {

        private int count = 0;
        public int caretPos = 0;
        public JTextField inputField = null;

        public AutoCompleteComboBox(final Object elements[]) {
            super(elements);
            setEditor(new BasicComboBoxEditor());
            setEditable(true);
        }

        public void setSelectedIndex(int index) {
            super.setSelectedIndex(index);
            if (count >= 1) {
                inputField.setText(getItemAt(index).toString());
            }
            count++;

      inputField.setSelectionEnd(caretPos + inputField.getText().length());
            inputField.moveCaretPosition(caretPos);
        }

        public void setEditor(ComboBoxEditor editor) {
            super.setEditor(editor);
            if (editor.getEditorComponent() instanceof JTextField) {
                inputField = (JTextField) editor.getEditorComponent();

                inputField.addKeyListener(new KeyAdapter() {
                    public void keyReleased(KeyEvent ev) {
                        char key = ev.getKeyChar();
                        if (!(Character.isLetterOrDigit(key) || Character.isSpaceChar(key))) {
                            return;
                        }

                        caretPos = inputField.getCaretPosition();
                        String text = "";
                        try {
                            text = inputField.getText(0, caretPos);
                        } catch (javax.swing.text.BadLocationException e) {
                            e.printStackTrace();
                        }

                        for (int i = 0; i < getItemCount(); i++) {
                            String element = (String) getItemAt(i);
                            if (element.startsWith(text)) {
                                setSelectedIndex(i);
                                return;
                            }
                        }
                    }
                    
                });
                
                inputField.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        inputField.setSelectionEnd(caretPos + inputField.getText().length());
                        inputField.setCaretPosition(inputField.getText().length());
                        txtUniversityOrOther.requestFocus();
                    }
                    
                });
                
                inputField.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        cmbSchool.setPopupVisible(true);
                        cmbSchool.showPopup();
                    }
                    
                });
            }
        }
    }
//////////////////////////

    private void loadSchool() {
        SchoolController schoolController = ControllerFactory.getInstance().getSchool();
        ArrayList<String> schoolList = null;
        try {
            schoolList = schoolController.getAll();
        } catch (Exception ex) {
            Logger.getLogger(StudentRegistrationForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        elements = new String[schoolList.size()];

        for (int i = 0; i < schoolList.size(); i++) {
            elements[i] = schoolList.get(i);
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

        btnGrpGender = new javax.swing.ButtonGroup();
        lblLogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblSubTitle = new javax.swing.JLabel();
        lblFullName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtNameWithInitials = new javax.swing.JTextField();
        txtFullName = new javax.swing.JTextField();
        txtAddress1 = new javax.swing.JTextField();
        txtAddress2 = new javax.swing.JTextField();
        txtAddress3 = new javax.swing.JTextField();
        lblTelephone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblNic = new javax.swing.JLabel();
        lblDateOfBirth = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblSchool = new javax.swing.JLabel();
        lblUniversityOrOther = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        txtHome = new javax.swing.JTextField();
        lblMobile = new javax.swing.JLabel();
        txtMobile = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNic = new javax.swing.JTextField();
        lblYear = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        lblMonth = new javax.swing.JLabel();
        txtMonth = new javax.swing.JTextField();
        lblDay = new javax.swing.JLabel();
        txtDay = new javax.swing.JTextField();
        txtUniversityOrOther = new javax.swing.JTextField();
        lblNameWithInitials = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        chkBoxMale = new javax.swing.JCheckBox();
        chkBoxFemale = new javax.swing.JCheckBox();
        cmbSchool = new AutoCompleteComboBox(elements);
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        lblSubTitle1 = new javax.swing.JLabel();
        lblNameWithInitials1 = new javax.swing.JLabel();
        txtNameOfPatentOrGuardian = new javax.swing.JTextField();
        lblNameWithInitials3 = new javax.swing.JLabel();
        lblIqTest = new javax.swing.JLabel();
        lblHome1 = new javax.swing.JLabel();
        txtMobile1 = new javax.swing.JTextField();
        lblMobile1 = new javax.swing.JLabel();
        txtMobile2 = new javax.swing.JTextField();
        lblEmail1 = new javax.swing.JLabel();
        txtParentEmail = new javax.swing.JTextField();
        txtDesignation = new javax.swing.JTextField();
        lblDesignation = new javax.swing.JLabel();
        lblWorkingPlace = new javax.swing.JLabel();
        txtWorkingPlace = new javax.swing.JTextField();
        txtIqTest = new javax.swing.JTextField();
        txtParentAddress2 = new javax.swing.JTextField();
        txtParentAddress1 = new javax.swing.JTextField();
        lblAddress1 = new javax.swing.JLabel();
        lblSubTitle2 = new javax.swing.JLabel();
        txtParentAddress4 = new javax.swing.JTextField();
        lblTelephone2 = new javax.swing.JLabel();
        btnGoBack = new javax.swing.JButton();
        btnAddCourse = new javax.swing.JButton();
        btnRegisterStudent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/paymentsystem/images/ijse-logo.gif"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSubTitle.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblSubTitle.setText("PERSONAL DETAILS");
        jPanel1.add(lblSubTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblFullName.setDisplayedMnemonic('N');
        lblFullName.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblFullName.setLabelFor(txtFullName);
        lblFullName.setText("Full Name:");
        jPanel1.add(lblFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        lblAddress.setDisplayedMnemonic('o');
        lblAddress.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblAddress.setLabelFor(txtAddress1);
        lblAddress.setText("Personal Address:");
        jPanel1.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));
        jPanel1.add(txtNameWithInitials, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 436, -1));
        jPanel1.add(txtFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 436, -1));
        jPanel1.add(txtAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 436, -1));
        jPanel1.add(txtAddress2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 436, -1));

        txtAddress3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddress3ActionPerformed(evt);
            }
        });
        jPanel1.add(txtAddress3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 436, -1));

        lblTelephone.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblTelephone.setText("Telephone:");
        jPanel1.add(lblTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        lblEmail.setDisplayedMnemonic('E');
        lblEmail.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblEmail.setLabelFor(txtEmail);
        lblEmail.setText("E-mail:");
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        lblNic.setDisplayedMnemonic('c');
        lblNic.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblNic.setLabelFor(txtNic);
        lblNic.setText("NIC:");
        jPanel1.add(lblNic, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        lblDateOfBirth.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblDateOfBirth.setText("Date of Birth:");
        jPanel1.add(lblDateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        lblGender.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblGender.setText("Gender:");
        jPanel1.add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));

        lblSchool.setDisplayedMnemonic('S');
        lblSchool.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblSchool.setText("School:");
        jPanel1.add(lblSchool, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, -1));

        lblUniversityOrOther.setDisplayedMnemonic('U');
        lblUniversityOrOther.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblUniversityOrOther.setLabelFor(txtUniversityOrOther);
        lblUniversityOrOther.setText("University or Other:");
        jPanel1.add(lblUniversityOrOther, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, -1, -1));

        lblHome.setDisplayedMnemonic('H');
        lblHome.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblHome.setLabelFor(txtHome);
        lblHome.setText("Home:");
        jPanel1.add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, -1, -1));
        jPanel1.add(txtHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 141, -1));

        lblMobile.setDisplayedMnemonic('b');
        lblMobile.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblMobile.setLabelFor(txtMobile);
        lblMobile.setText("Mobile:");
        jPanel1.add(lblMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, -1));
        jPanel1.add(txtMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 141, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 440, -1));

        txtNic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNicKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNicKeyReleased(evt);
            }
        });
        jPanel1.add(txtNic, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 440, -1));

        lblYear.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblYear.setLabelFor(txtYear);
        lblYear.setText("Year:");
        jPanel1.add(lblYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, -1, -1));
        jPanel1.add(txtYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 76, -1));

        lblMonth.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblMonth.setLabelFor(txtMonth);
        lblMonth.setText("Month:");
        jPanel1.add(lblMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, -1, -1));
        jPanel1.add(txtMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 76, -1));

        lblDay.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblDay.setLabelFor(txtDay);
        lblDay.setText("Day:");
        jPanel1.add(lblDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, -1, -1));
        jPanel1.add(txtDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 68, -1));
        jPanel1.add(txtUniversityOrOther, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 500, 440, -1));

        lblNameWithInitials.setDisplayedMnemonic('t');
        lblNameWithInitials.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblNameWithInitials.setLabelFor(txtNameWithInitials);
        lblNameWithInitials.setText("Name with Initials:");
        lblNameWithInitials.setToolTipText("");
        jPanel1.add(lblNameWithInitials, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel1.setForeground(new java.awt.Color(158, 158, 158));
        jLabel1.setText("(only for CMJD students)");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 140, -1));

        chkBoxMale.setText("Male");
        jPanel1.add(chkBoxMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, -1, -1));

        chkBoxFemale.setText("Female");
        jPanel1.add(chkBoxFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, -1, -1));

        cmbSchool.setEditable(true);
        cmbSchool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSchoolActionPerformed(evt);
            }
        });
        cmbSchool.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbSchoolKeyPressed(evt);
            }
        });
        jPanel1.add(cmbSchool, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 440, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSubTitle1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblSubTitle1.setText("ADDITIONAL INFORMATIONS");
        jPanel2.add(lblSubTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        lblNameWithInitials1.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblNameWithInitials1.setText("or Guardian:");
        jPanel2.add(lblNameWithInitials1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 130, -1));
        jPanel2.add(txtNameOfPatentOrGuardian, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 370, -1));

        lblNameWithInitials3.setDisplayedMnemonic('P');
        lblNameWithInitials3.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblNameWithInitials3.setText("Name of Parent");
        jPanel2.add(lblNameWithInitials3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 130, -1));

        lblIqTest.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblIqTest.setText("IQ Test:");
        jPanel2.add(lblIqTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, -1));

        lblHome1.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblHome1.setText("Mobile 01 :");
        jPanel2.add(lblHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));
        jPanel2.add(txtMobile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 141, -1));

        lblMobile1.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblMobile1.setText("Mobile 02:");
        jPanel2.add(lblMobile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));
        jPanel2.add(txtMobile2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 141, -1));

        lblEmail1.setDisplayedMnemonic('i');
        lblEmail1.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblEmail1.setLabelFor(txtParentEmail);
        lblEmail1.setText("E-mail:");
        jPanel2.add(lblEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 130, -1));

        txtParentEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtParentEmailActionPerformed(evt);
            }
        });
        jPanel2.add(txtParentEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 370, -1));
        jPanel2.add(txtDesignation, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 370, -1));

        lblDesignation.setDisplayedMnemonic('D');
        lblDesignation.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblDesignation.setLabelFor(txtDesignation);
        lblDesignation.setText("Designation:");
        jPanel2.add(lblDesignation, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 130, -1));

        lblWorkingPlace.setDisplayedMnemonic('W');
        lblWorkingPlace.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblWorkingPlace.setLabelFor(txtWorkingPlace);
        lblWorkingPlace.setText("Workign Place:");
        jPanel2.add(lblWorkingPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 130, -1));
        jPanel2.add(txtWorkingPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 370, -1));

        txtIqTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIqTestActionPerformed(evt);
            }
        });
        jPanel2.add(txtIqTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 370, -1));
        jPanel2.add(txtParentAddress2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 370, -1));
        jPanel2.add(txtParentAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 370, -1));

        lblAddress1.setDisplayedMnemonic('r');
        lblAddress1.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblAddress1.setLabelFor(txtParentAddress1);
        lblAddress1.setText("Parent Address:");
        jPanel2.add(lblAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        lblSubTitle2.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblSubTitle2.setText("PARENT/GUARDIAN DETAILS");
        jPanel2.add(lblSubTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtParentAddress4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtParentAddress4ActionPerformed(evt);
            }
        });
        jPanel2.add(txtParentAddress4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 370, -1));

        lblTelephone2.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        lblTelephone2.setText("Telephone:");
        jPanel2.add(lblTelephone2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegisterStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRegisterStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAddress3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddress3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddress3ActionPerformed

    private void txtIqTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIqTestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIqTestActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnGoBackKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGoBackKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
//            btnAddStudent.requestFocusInWindow();
        } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
//            btnAddStudent.requestFocusInWindow();
        }
    }//GEN-LAST:event_btnGoBackKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        KeyboardFocusManager focusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        focusManager.addKeyEventPostProcessor(new KeyEventPostProcessor() {
            @Override
            public boolean postProcessKeyEvent(java.awt.event.KeyEvent e) {
                if (e.getID() == java.awt.event.KeyEvent.KEY_RELEASED) {
                    if (e.getKeyCode() == com.sun.glass.events.KeyEvent.VK_ESCAPE) {
                        Window windowForComponent = SwingUtilities.windowForComponent((Component) e.getSource());
                        if (windowForComponent == null) {
                            return false;
                        }
                        windowForComponent.dispose();
                    }
                }
                return false;
            }
        });
    }//GEN-LAST:event_formWindowOpened

    private void txtNicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNicKeyReleased

        if (txtNic.getText().matches("^(\\d{9}|\\d{12})[VvXx]?$")) {
            if (txtNic.getText().toCharArray().length == 10) {
                String nic = txtNic.getText();
                int yy = Integer.parseInt(19 + nic.substring(0, 2));
                int doy = Integer.parseInt(nic.substring(2, 5));
                if (doy > 500) {
                    chkBoxFemale.setSelected(true);
                    doy -= 500;
                } else {
                    chkBoxMale.setSelected(true);
                }
                txtYear.setText("" + yy);

                LocalDate dob = LocalDate.ofYearDay(yy, doy);

                if (dob.isLeapYear()) {
                    txtMonth.setText("" + dob.getMonthValue());
                    txtDay.setText("" + dob.getDayOfMonth());
                } else {
                    if (dob.getMonthValue() < 3) {
                        txtMonth.setText("" + dob.getMonthValue());
                        txtDay.setText("" + (dob.getDayOfMonth()));
                    } else {
                        txtMonth.setText("" + dob.getMonthValue());
                        txtDay.setText("" + (dob.getDayOfMonth() - 1));
                    }
                }
                cmbSchool.requestFocus();

            } else if (txtNic.getText().toCharArray().length == 12) {
                String nic = txtNic.getText();
                int yy = Integer.parseInt(nic.substring(0, 4));
                int doy = Integer.parseInt(nic.substring(4, 7));
                if (doy > 500) {
                    chkBoxFemale.setSelected(true);
                    doy -= 500;
                } else {
                    chkBoxMale.setSelected(true);
                }
                txtYear.setText("" + yy);

                LocalDate dob = LocalDate.ofYearDay(yy, doy);

                if (dob.isLeapYear()) {
                    txtMonth.setText("" + dob.getMonthValue());
                    txtDay.setText("" + dob.getDayOfMonth());
                } else {
                    if (dob.getMonthValue() < 3) {
                        txtMonth.setText("" + dob.getMonthValue());
                        txtDay.setText("" + (dob.getDayOfMonth()));
                    } else {
                        txtMonth.setText("" + dob.getMonthValue());
                        txtDay.setText("" + (dob.getDayOfMonth() - 1));
                    }
                }
                cmbSchool.requestFocus();
            }
        }
    }//GEN-LAST:event_txtNicKeyReleased

    private void txtNicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNicKeyPressed
        if (txtNic.getText().equals("")) {
            txtYear.setText("");
            txtMonth.setText("");
            txtDay.setText("");
            if (chkBoxMale.isSelected()) {
                chkBoxMale.setSelected(false);
            } else if (chkBoxFemale.isSelected()) {
                chkBoxFemale.setSelected(false);
            }
        }
    }//GEN-LAST:event_txtNicKeyPressed

    private void txtParentEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtParentEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtParentEmailActionPerformed

    private void txtParentAddress4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtParentAddress4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtParentAddress4ActionPerformed

    private void btnRegisterStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterStudentActionPerformed

        /* take data from the qualification table*/

 /*show confirm message to confirm that the student has paid the registration fee*/
        int res = JOptionPane.showConfirmDialog(null, "Do you want to add this Student to the IJSE adminstration System? \n (Make sure this Student has paid the registration fee)", "Warning", JOptionPane.YES_NO_OPTION);

        /* if the student has paid registration fee, he will be added to the database*/
        if (res == 0) {
            getValue();
            String sid = controller.doRegistration(studentDTO);
            if (sid != null) {
                JOptionPane.showMessageDialog(null, "Student added successfully.\nYour student's ID is " + sid);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Student addidtion failed");
            }
            this.dispose();
        }

    }//GEN-LAST:event_btnRegisterStudentActionPerformed

    private void btnAddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCourseActionPerformed
        getValue();
        new CourseDetails(studentDTO, this).setVisible(true);

    }//GEN-LAST:event_btnAddCourseActionPerformed

    private void cmbSchoolKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbSchoolKeyPressed
//        System.out.println("NIKJNKJBm");
    }//GEN-LAST:event_cmbSchoolKeyPressed

    private void cmbSchoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSchoolActionPerformed
//            JTextField textField = (JTextField) cmbSchool.getEditor().getEditorComponent();
//            textField.setSelectionStart(cmbSchool.getSelectedItem().toString().length());
    }//GEN-LAST:event_cmbSchoolActionPerformed

    private void getValue() {

        String nameWithInitials = txtNameWithInitials.getText();
        String studentName = txtFullName.getText();
        String addressLine1 = txtAddress1.getText();
        String addressLine2 = txtAddress2.getText();
        String addressLine3 = txtAddress3.getText();
        String telHome = null;
        if (txtHome.getText().equals("")) {
            telHome = "0000000000";
        } else {
            telHome = txtHome.getText();
        }

        String mobile = null;

        if (txtMobile.getText().equals("")) {
            mobile = "0000000000";
        } else {
            mobile = txtMobile.getText();
        }

        String email = txtEmail.getText();

        String dob = null;
        if (txtYear.getText().equals("") || txtMonth.getText().equals("") || txtDay.getText().equals("")) {
            dob = "2000-01-01";
        } else {
            dob = txtYear.getText() + "-" + txtMonth.getText() + "-" + txtDay.getText();
        }

        boolean gender = chkBoxMale.isSelected();
        String nic = txtNic.getText();
        String school = null;
        if (cmbSchool.getSelectedItem() != null) {
             school = cmbSchool.getSelectedItem().toString();
        }
            

        String university = txtUniversityOrOther.getText();
        int iq_test = txtIqTest.getText().equals("") ? 0 : Integer.parseInt(txtIqTest.getText());

        StudentDTO student = new StudentDTO(nameWithInitials, studentName, addressLine1, addressLine2, addressLine3, telHome, mobile, email, dob, gender, nic, school, university, iq_test);

        String guardianName = txtNameOfPatentOrGuardian.getText();
        String telNo1 = txtMobile1.getText();
        String telNo2 = txtMobile2.getText();
        String guardianEmail = txtParentEmail.getText();
        String designation = txtDesignation.getText();
        String workPlace = txtWorkingPlace.getText();
        String parentAddressLine1 = txtParentAddress1.getText();
        String parentAddressLine2 = txtParentAddress2.getText();
        String parentAddressLine3 = txtIqTest.getText();

        GuardianDTO guardian = new GuardianDTO(guardianName, telNo1, telNo2, email, designation, workPlace, addressLine1, addressLine2, addressLine3);

        student.setGuardian(guardian);

        int iq = txtIqTest.getText().equals("")? 0:Integer.parseInt(txtIqTest.getText());

        this.studentDTO = student;

//        StudentRegistrationCourseDetailForm studentRegistrationCourseDetailForm = new StudentRegistrationCourseDetailForm(this, student);
//        studentRegistrationCourseDetailForm.setVisible(true);
//        this.dispose();
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
            java.util.logging.Logger.getLogger(StudentRegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentRegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentRegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentRegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentRegistrationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCourse;
    private javax.swing.JButton btnGoBack;
    private javax.swing.ButtonGroup btnGrpGender;
    private javax.swing.JButton btnRegisterStudent;
    private javax.swing.JCheckBox chkBoxFemale;
    private javax.swing.JCheckBox chkBoxMale;
    private javax.swing.JComboBox<String> cmbSchool;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddress1;
    private javax.swing.JLabel lblDateOfBirth;
    private javax.swing.JLabel lblDay;
    private javax.swing.JLabel lblDesignation;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmail1;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblHome1;
    private javax.swing.JLabel lblIqTest;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMobile;
    private javax.swing.JLabel lblMobile1;
    private javax.swing.JLabel lblMonth;
    private javax.swing.JLabel lblNameWithInitials;
    private javax.swing.JLabel lblNameWithInitials1;
    private javax.swing.JLabel lblNameWithInitials3;
    private javax.swing.JLabel lblNic;
    private javax.swing.JLabel lblSchool;
    private javax.swing.JLabel lblSubTitle;
    private javax.swing.JLabel lblSubTitle1;
    private javax.swing.JLabel lblSubTitle2;
    private javax.swing.JLabel lblTelephone;
    private javax.swing.JLabel lblTelephone2;
    private javax.swing.JLabel lblUniversityOrOther;
    private javax.swing.JLabel lblWorkingPlace;
    private javax.swing.JLabel lblYear;
    private javax.swing.JTextField txtAddress1;
    private javax.swing.JTextField txtAddress2;
    private javax.swing.JTextField txtAddress3;
    private javax.swing.JTextField txtDay;
    private javax.swing.JTextField txtDesignation;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtHome;
    private javax.swing.JTextField txtIqTest;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtMobile1;
    private javax.swing.JTextField txtMobile2;
    private javax.swing.JTextField txtMonth;
    private javax.swing.JTextField txtNameOfPatentOrGuardian;
    private javax.swing.JTextField txtNameWithInitials;
    private javax.swing.JTextField txtNic;
    private javax.swing.JTextField txtParentAddress1;
    private javax.swing.JTextField txtParentAddress2;
    private javax.swing.JTextField txtParentAddress4;
    private javax.swing.JTextField txtParentEmail;
    private javax.swing.JTextField txtUniversityOrOther;
    private javax.swing.JTextField txtWorkingPlace;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
