/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import lk.ijse.paymentsystem.controller.ControllerFactory;
import lk.ijse.paymentsystem.controller.custom.PaymentController;
import lk.ijse.paymentsystem.controller.custom.RegistrationController;
import lk.ijse.paymentsystem.controller.custom.StudentController;
import lk.ijse.paymentsystem.dto.CourseDetailsDTO;
import lk.ijse.paymentsystem.dto.PaymentDTO;
import lk.ijse.paymentsystem.dto.RegistrationDTO;
import lk.ijse.paymentsystem.dto.StudentDTO;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author midda
 */
public class PaymentForRegistrationCourseController {
    private CourseDetailsDTO course;
    private ArrayList<PaymentDTO> paymentDTOs=new ArrayList<>();
//    private Connection c;
    private StudentController sc;
    private PaymentController pc;
    private String batchID;
    private StudentDTO studentDTO;
    RegistrationDTO rdto;
    String sid;
    private RegistrationController rc;
    private final double REGFEE=5000;
    
    public PaymentForRegistrationCourseController(StudentDTO studentDTO,CourseDetailsDTO cdto,RegistrationDTO rdto) {
         this.course = cdto;
         this.studentDTO=studentDTO;
         this.batchID=rdto.getBatchId();
         this.rdto = rdto;
//         c=ConnectionFactory.getInstance().getConnection();
        sc=(StudentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.STUDENT);
        pc=(PaymentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.PAYMENT);
         
    }
    
    public PaymentForRegistrationCourseController(String sid,CourseDetailsDTO cdto,RegistrationDTO rdto) {
         this.course = cdto;
         this.batchID=rdto.getBatchId();
         this.rdto = rdto;
         this.sid=sid;
//         c=ConnectionFactory.getInstance().getConnection();
        sc=(StudentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.STUDENT);
        System.out.println("why null="+sc);
        pc=(PaymentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.PAYMENT);
        rc=(RegistrationController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.REGISTRATION);
        
        getStudent();
    }
    
    private void getStudent(){
        StudentDTO s=new StudentDTO();
        s.setSID(sid);
        System.out.println(sid);
        try {
            System.out.println(sc);
            this.studentDTO=sc.search(s);
        } catch (Exception ex) {
            Logger.getLogger(PaymentForRegistrationCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DefaultTreeModel setPaymentScheme(){
        int semester=course.getNo_of_Semesters();
        DefaultMutableTreeNode trNde=new DefaultMutableTreeNode(new String("Full Payment"));
        for (int i=0; i<semester; i++) {
            DefaultMutableTreeNode trNdeSemester=new DefaultMutableTreeNode(new String("Semester "+(i+1)));
//            DefaultMutableTreeNode trNdeHalf1=
//            DefaultMutableTreeNode trNdeHalf2=
            trNdeSemester.add(new DefaultMutableTreeNode(new String("1st Half")));
            trNdeSemester.add(new DefaultMutableTreeNode(new String("2nd Half")));
            trNde.add(trNdeSemester);
        }
        return new DefaultTreeModel(trNde);
    }
    
    private static int[] row_semMap;
    static {
        row_semMap=new int[PaymentForRegistrationCourse.rows.length];
        int sem=1;
        for (int i = 1; i < row_semMap.length; i+=3,sem++) {
            Arrays.fill(row_semMap, i, i+3, sem);;
        }
    }
    
    private ArrayList<Double> calculatedAmounts=new ArrayList<>();
    public ArrayList<Double> calculateAmounts(int[] selectedRows){
        Arrays.sort(selectedRows);
        double discount=0,amount=0,payable=0;
        int skip=0,semesters[]={};
        paymentDTOs.clear();
        calculatedAmounts.clear();
            for (int selectedRow : selectedRows) {
                if(skip>0){
                    skip--;
                }else if(selectedRow ==0){
                    amount=course.getCourseFee();
                    discount=BigDecimal.valueOf(amount).multiply(BigDecimal.valueOf(course.getDiscount())).doubleValue();
                    payable=BigDecimal.valueOf(amount).subtract(BigDecimal.valueOf(discount)).doubleValue();
                    
                    if(!course.getCode().equals("CMJD")){
                        paymentDTOs.add(new PaymentDTO("", "", 0, 0, LocalDate.now(), amount, discount, payable));
                    }else{
                        amount=BigDecimal.valueOf(amount).subtract(BigDecimal.valueOf(REGFEE)).doubleValue();
                        payable=BigDecimal.valueOf(amount).subtract(BigDecimal.valueOf(discount)).doubleValue();
                        paymentDTOs.add(new PaymentDTO("", "", 0, 0, LocalDate.now(), amount, discount, payable));
                    }
                    calculatedAmounts.add(amount);
                    calculatedAmounts.add(discount);
                    calculatedAmounts.add(payable);
                    return calculatedAmounts;
                }else if(PaymentForRegistrationCourse.semesterRows.contains(selectedRow)) {
                    System.out.println("2");
                    semesters=Arrays.copyOf(semesters, semesters.length+1);
                    semesters[semesters.length-1]=row_semMap[selectedRow];
                    amount=BigDecimal.valueOf(course.getCourseFee()).divide(BigDecimal.valueOf(course.getNo_of_Semesters())).multiply(BigDecimal.valueOf(semesters.length)).doubleValue();
                    if (semesters.length==1){
                        discount=BigDecimal.valueOf(amount).multiply(BigDecimal.valueOf(course.getDiscount1Sem())).doubleValue();
                    }else if (semesters.length==2){
                        discount=BigDecimal.valueOf(amount).multiply(BigDecimal.valueOf(course.getDiscount2Sem())).doubleValue();
                    }else{
                        discount=BigDecimal.valueOf(amount).multiply(BigDecimal.valueOf(course.getDiscount())).doubleValue();
                    }
                    payable=BigDecimal.valueOf(amount).subtract(BigDecimal.valueOf(discount)).doubleValue();
                    skip=2;
                }else if(PaymentForRegistrationCourse.semesterRows.contains(selectedRow-1)){
                    System.out.println("3-");
                    amount=BigDecimal.valueOf(course.getCourseFee()).divide(BigDecimal.valueOf(course.getNo_of_Semesters()*2)).doubleValue();
                    if (course.getCode().equals("CMJD") && row_semMap[selectedRow]==1){
                        amount=BigDecimal.valueOf(course.getCourseFee()).divide(BigDecimal.valueOf(course.getNo_of_Semesters()*2)).subtract(BigDecimal.valueOf(REGFEE)).doubleValue();
                    }
                    payable=amount;
                    paymentDTOs.add(new PaymentDTO("", "", row_semMap[selectedRow], 1, LocalDate.now(), amount, discount, payable));
                }else{
                    amount=BigDecimal.valueOf(course.getCourseFee()).divide(BigDecimal.valueOf(course.getNo_of_Semesters()*2)).doubleValue();
                    payable=amount;
                    paymentDTOs.add(new PaymentDTO("", "", row_semMap[selectedRow], 2, LocalDate.now(), amount, discount, payable));
                }
            }
            if (semesters.length>0){
                for (int semester : semesters) {
                    paymentDTOs.add(new PaymentDTO("", "", semester, 0, LocalDate.now(), 
                            BigDecimal.valueOf(amount).divide(BigDecimal.valueOf(semesters.length)).doubleValue(), 
                            BigDecimal.valueOf(discount).divide(BigDecimal.valueOf(semesters.length)).doubleValue(), 
                            BigDecimal.valueOf(payable).divide(BigDecimal.valueOf(semesters.length)).doubleValue()));
                }
            }
        calculatedAmounts.add(amount);
        calculatedAmounts.add(discount);
        calculatedAmounts.add(payable);
        for (PaymentDTO paymentDTO : paymentDTOs) {
            System.out.println(paymentDTO);
        }
        System.out.println();
        return calculatedAmounts;
    }
    
    public void doRegistration(){
        if(completeRegistration()){
            try {
                System.out.println("Jasper");
//                JasperReport compiledReport=(JasperReport) JRLoader.loadObject(PaymentForRegistrationCourseController.class.getResourceAsStream("/lk/ijse/paymentsystem/reports/Invoice.jasper"));
                HashMap<String, Object> parameters=new HashMap<>();
                
                parameters.put("invoiceId", returns[1]);
                parameters.put("invoiceDate", LocalDate.now().toString());
                parameters.put("studentName", studentDTO.getInitialStudentName()+" - "+returns[0]);
                parameters.put("studentAddress", studentDTO.getAddressLine1()+", "+studentDTO.getAddressLine2()+", "+studentDTO.getAddressLine3());
                parameters.put("course", course.getCode()+"-"+course.getName());
                parameters.put("batchNo", course.getBatchDTO().getBatchNo());
                parameters.put("batchCommencingDate",course.getBatchDTO().getStartDate().toString());
                
                parameters.put("amount", calculatedAmounts.get(0));
                parameters.put("discount", calculatedAmounts.get(1));
                parameters.put("amountRecieved", calculatedAmounts.get(2));
                
                if (sid!=null){
                    parameters.put("total", calculatedAmounts.get(2));
                }else{
                    parameters.put("registrationFee",new Double(5000.00));
                    parameters.put("total", BigDecimal.valueOf(5000).add(BigDecimal.valueOf(calculatedAmounts.get(2))).doubleValue());
                }
                String description = "Full Payment";
                LocalDate nextPay=null;
                if(paymentDTOs.size()>0){
                    
                    if(paymentDTOs.size()==1 && paymentDTOs.get(0).getSemester()!=0 && paymentDTOs.get(0).getSem_half()!=0){
                        if(paymentDTOs.get(0).getSem_half()==1)
                            description = String.format("Payment for Semester %s 1st Half", ""+paymentDTOs.get(0).getSemester());
                        else
                            description = String.format("Payment for Semester %s 2nd Half", ""+paymentDTOs.get(0).getSemester());
                    }else if(paymentDTOs.size()==1 && paymentDTOs.get(0).getSemester()==0){
                        
                    }else{
                        description = "Payment for Semesters : ";
                        for (PaymentDTO paymentDTO : paymentDTOs) {
                            description+=paymentDTO.getSemester()+" ";
                        }
//                        description+="\b\b";
                    }
                    parameters.put("description", description);
                    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/lk/ijse/paymentsystem/reports/Invoice_2.jasper"));
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, new JREmptyDataSource());
                    JasperPrintManager.printReport(jasperPrint, true);
                    
//                    JasperPrint filledReport=JasperFillManager.fillReport(compiledReport, parameters);
                
                }
            } catch (JRException ex) {
                Logger.getLogger(PaymentForRegistrationCourseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    String[] returns;
    public boolean completeRegistration(){
        boolean isSuccessful=false;
        int state=0;
        
        try {
            String rid=null;
            if (sid==null){
                studentDTO.setRegFee(REGFEE);
                studentDTO.setJoinDate(LocalDate.now());
                returns=sc.addStudent(studentDTO, rdto, paymentDTOs);
            }else{
                rdto.setSID(sid);
                returns=rc.addCall(rdto, paymentDTOs);
            }
            if (returns!=null){
                isSuccessful=true;
            }
        } catch (Exception ex) {
            Logger.getLogger(PaymentForRegistrationCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(isSuccessful+"2");
        return isSuccessful;
    }
    
    private String payID;
}
