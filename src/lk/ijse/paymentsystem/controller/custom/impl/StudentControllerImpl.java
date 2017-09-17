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
import lk.ijse.paymentsystem.dao.custom.RegistrationDAO;
import lk.ijse.paymentsystem.dao.custom.StuGuardianDAO;
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
    private StuGuardianDAO sgdao;
    private StudentOtherInfoDAO soidao;
    
    Connection c;

    public StudentControllerImpl() {
        sdao=(StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
        rdao=(RegistrationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGISTRATION);
        spqdao=(StudentProQualiDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STU_PRO_QUALIFICATIONS);
        sgdao=(StuGuardianDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STU_GUARDIAN);
        soidao=(StudentOtherInfoDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STU_OTHER);
        
        c=ConnectionFactory.getInstance().getConnection();
    }
    
    
    private String sid;
    @Override
    public String addStudent(StudentDTO sdto, RegistrationDTO rdto) throws Exception {
        try {
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
                    rdto.setSID(sid);
                    String rid=rdao.addCall(rdto);
                    if (rid!=null){
                        c.commit();
                        return rid;
                    }
                }
            }
            c.rollback();
        }finally{
            sid=null;
            c.setAutoCommit(true);
        }
        return null;
    }
    
    public boolean addQualifications(ArrayList<QualificationDTO> qdtos) throws Exception{
        boolean isSuccessful=false;
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
                    c.commit();
                    return true;
                }
            }
        }finally{
            c.setAutoCommit(true);
        }
        return false;
    }
    
}
