/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.controller.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.paymentsystem.controller.ControllerFactory;
import lk.ijse.paymentsystem.controller.custom.PaymentController;
import lk.ijse.paymentsystem.controller.custom.StudentController;
import lk.ijse.paymentsystem.dao.DAOFactory;
import lk.ijse.paymentsystem.dao.custom.GuardianDAO;
import lk.ijse.paymentsystem.dao.custom.RegistrationDAO;
//import lk.ijse.paymentsystem.dao.custom.StuGuardianDAO;
import lk.ijse.paymentsystem.dao.custom.StudentDAO;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dto.PaymentDTO;
import lk.ijse.paymentsystem.dto.RegistrationDTO;
import lk.ijse.paymentsystem.dto.StudentDTO;


public class StudentControllerImpl implements StudentController {
    
    private StudentDAO sdao;
    private RegistrationDAO rdao;
//    private StudentProQualiDAO spqdao;
    private GuardianDAO sgdao;
    private PaymentController pc;

//    private StudentOtherInfoDAO soidao;
    
    Connection c;

    public StudentControllerImpl() {
        sdao=(StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
        rdao=(RegistrationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGISTRATION);
//        spqdao=(StudentProQualiDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STU_PRO_QUALIFICATIONS);
        sgdao= (GuardianDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STU_GUARDIAN);
//        soidao=(StudentOtherInfoDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STU_OTHER);
        pc=(PaymentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.PAYMENT);
        c=ConnectionFactory.getInstance().getConnection();
    }
    
    
    private String sid;
    private boolean doNotCommit=false;
    @Override
    public String[] addStudent(StudentDTO sdto, RegistrationDTO rdto, ArrayList<PaymentDTO> paymentDTOs) throws Exception {
        String rid=null;
        String payID=null;
        try {
            c.setAutoCommit(false);
            doNotCommit=true;
            sid=sdao.addCall(sdto); 
            System.out.println(sid);
            if (sid!=null){
                boolean detailsAdded=false;
                sdto.getGuardian().setSID(sid);
                detailsAdded=sgdao.add(sdto.getGuardian());
                if (detailsAdded){
                    rdto.setSID(sid);
                    rid=rdao.addCall(rdto);
                    System.out.println(rid);
                    if (rid!=null){
                        if (rid!=null){
                            for (PaymentDTO paymentDTO : paymentDTOs) {
                                paymentDTO.setRegID(rid);
                            }
                            payID=pc.add(paymentDTOs);
                            if (payID!=null){
                                c.commit();
                                return new String[]{rid,payID};
                            }
                        }
                    }
                }
            }
            c.rollback();
        }finally{
            sid=null;
            doNotCommit=false;
            c.setAutoCommit(true);
        }
        return null;
    }
    
//    public boolean addQualifications(ArrayList<QualificationDTO> qdtos) throws Exception{
//        boolean isSuccessful=true;
//        for (QualificationDTO qdto : qdtos) {
//            qdto.setSid(sid);
//            isSuccessful=spqdao.add(qdto);
//            if (!isSuccessful)
//                break;
//        }
//        return isSuccessful;
//    } 

    @Override
    public String addStudent(StudentDTO sdto) throws Exception {
        try{    
            c.setAutoCommit(false);
            sid=sdao.addCall(sdto); 
            if (sid!=null){
                boolean detailsAdded=false;
                sdto.getGuardian().setSID(sid);
                detailsAdded=sgdao.add(sdto.getGuardian());
                if (detailsAdded){
                    if(!doNotCommit)
                        c.commit();
                    return sid;
                }
            }
        }finally{
            if(!doNotCommit)
                c.setAutoCommit(true);
        }
        return sid;
    }

    @Override
    public StudentDTO search(StudentDTO dto) throws Exception {
        return sdao.search(dto);
    }
    
    
    
}
