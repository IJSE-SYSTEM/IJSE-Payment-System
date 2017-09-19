/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.controller.custom.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.paymentsystem.controller.custom.StudentController;
import lk.ijse.paymentsystem.dao.DAOFactory;
import lk.ijse.paymentsystem.dao.custom.GuardianDAO;
import lk.ijse.paymentsystem.dao.custom.RegistrationDAO;
//import lk.ijse.paymentsystem.dao.custom.StuGuardianDAO;
import lk.ijse.paymentsystem.dao.custom.StudentDAO;
import lk.ijse.paymentsystem.dao.custom.StudentOtherInfoDAO;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dto.QualificationDTO;
import lk.ijse.paymentsystem.dto.RegistrationDTO;
import lk.ijse.paymentsystem.dto.StudentDTO;
import lk.ijse.paymentsystem.dao.custom.StudentProQualiDAO;


public class StudentControllerImpl implements StudentController {
    
    private StudentDAO sdao;
    private RegistrationDAO rdao;
    private StudentProQualiDAO spqdao;
    private GuardianDAO sgdao;
    private StudentOtherInfoDAO soidao;
    
    Connection c;

    public StudentControllerImpl() {
        sdao=(StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
        rdao=(RegistrationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGISTRATION);
        spqdao=(StudentProQualiDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STU_PRO_QUALIFICATIONS);
        sgdao= (GuardianDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STU_GUARDIAN);
        soidao=(StudentOtherInfoDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STU_OTHER);
        
        c=ConnectionFactory.getInstance().getConnection();
    }
    
    
    private String sid;
    private boolean doNotCommit=false;
    @Override
    public String addStudent(StudentDTO sdto, RegistrationDTO rdto) throws Exception {
        try {
            c.setAutoCommit(false);
            doNotCommit=true;
            sid=sdao.addCall(sdto); 
            System.out.println(sid);
            if (sid!=null){
                boolean detailsAdded=false;
                sdto.getGuardian().setSID(sid);
                sdto.getInfoDTO().setSid(sid);
                detailsAdded=sgdao.add(sdto.getGuardian());
//                System.out.println(detailsAdded);
                detailsAdded=soidao.add(sdto.getInfoDTO());
//                System.out.println(detailsAdded);
                detailsAdded=addQualifications(sdto.getQualifications());
//                System.out.println(detailsAdded);
                if (detailsAdded){
                    rdto.setSID(sid);
                    String rid=rdao.addCall(rdto);
                    System.out.println(rid);
                    if (rid!=null){
                        c.commit();
                        return rid;
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
    
    public boolean addQualifications(ArrayList<QualificationDTO> qdtos) throws Exception{
        boolean isSuccessful=true;
        for (QualificationDTO qdto : qdtos) {
            qdto.setSid(sid);
            isSuccessful=spqdao.add(qdto);
            if (!isSuccessful)
                break;
        }
        return isSuccessful;
    } 

    @Override
    public boolean add(StudentDTO sdto) throws Exception {
        try{    
            c.setAutoCommit(false);
            sid=sdao.addCall(sdto); 
            if (sid!=null){
                boolean detailsAdded=false;
                sdto.getGuardian().setSID(sid);
                sdto.getInfoDTO().setSid(sid);
                detailsAdded=sgdao.add(sdto.getGuardian());
                detailsAdded=soidao.add(sdto.getInfoDTO());
                detailsAdded=addQualifications(sdto.getQualifications());
                if (detailsAdded){
                    if(!doNotCommit)
                        c.commit();
                    return true;
                }
            }
        }finally{
            if(!doNotCommit)
                c.setAutoCommit(true);
        }
        return false;
    }
    
}
