/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.paymentsystem.controller.ControllerFactory;
import lk.ijse.paymentsystem.controller.custom.StudentController;
import lk.ijse.paymentsystem.dto.PaymentDTO;
import lk.ijse.paymentsystem.dto.StudentDTO;
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
public class StudentRegistrationCourseDetailFormController {

    private StudentDTO studentDTO;
    private StudentController sc;
    private final double regFee=5000;
//    public StudentRegistrationCourseDetailFormController() {
//    }

    public StudentRegistrationCourseDetailFormController(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
        sc=(StudentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.STUDENT);
    }
    
    public void doRegistration(){
        studentDTO.setRegFee(5000);
        try {
            System.out.println();
            if(sc.add(studentDTO)){
//                JasperReport compiledReport=(JasperReport) JRLoader.loadObject(PaymentForRegistrationCourseController.class.getResourceAsStream("/lk/ijse/paymentsystem/reports/Invoice.jasper"));
                HashMap<String, Object> parameters=new HashMap<>();

//                    parameters.put("invoiceId", payID);
                parameters.put("invoiceDate", LocalDate.now().toString());
                parameters.put("studentName", studentDTO.getInitialStudentName());
                parameters.put("studentAddress", studentDTO.getAddressLine1()+", "+studentDTO.getAddressLine2()+", "+studentDTO.getAddressLine3());
//                    parameters.put("course", course.getCode()+"-"+course.getName());
//                    parameters.put("batchNo", course.getBatchDTO().getBatchNo());
//                    parameters.put("batchCommencingDate",course.getBatchDTO().getStartDate().toString());
                parameters.put("registrationFee",regFee);
//                    parameters.put("amount", calculatedAmounts.get(0));
//                    parameters.put("discount", calculatedAmounts.get(1));
//                    parameters.put("amountRecieved", calculatedAmounts.get(2));
                parameters.put("total", regFee);
//                    String description = "Full Payment";
                LocalDate nextPay=LocalDate.now().plusDays(14);
                parameters.put("dueDate", nextPay.toString());
                JasperPrint jasperPrint = JasperFillManager.fillReport("/lk/ijse/paymentsystem/reports/Invoice 2.jasper",parameters);
                JasperPrintManager.printReport(jasperPrint, true);
//                JasperPrint filledReport=JasperFillManager.fillReport(compiledReport, parameters);
            }            
        } catch (JRException ex) {
            Logger.getLogger(PaymentForRegistrationCourseController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(StudentRegistrationCourseDetailFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
