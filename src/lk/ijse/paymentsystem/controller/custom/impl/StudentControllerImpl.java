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
import lk.ijse.paymentsystem.dao.custom.StudentDAO;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dto.QualificationDTO;
import lk.ijse.paymentsystem.dto.RegistrationDTO;
import lk.ijse.paymentsystem.dto.StudentDTO;
import lk.ijse.paymentsystem.dao.custom.StudentProQualiDAO;


public class StudentControllerImpl implements StudentController {
    
    private StudentDAO sdao;
    private RegistrationDAO rdao;
    private StudentProQualiDAO spqdao;
    
    Connection c;

    public StudentControllerImpl() {
        sdao=(StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
        rdao=(RegistrationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGISTRATION);
        
        c=ConnectionFactory.getInstance().getConnection();
    }
    
    

    @Override
    public String addStudent(StudentDTO sdto, RegistrationDTO rdto) throws Exception {
        try {
            c.setAutoCommit(false);
            String sid=sdao.addCall(sdto); 
            if (sid!=null){
                
                
                rdto.setSID(sid);
                String rid=rdao.addCall(rdto);
                if (rid!=null){
                    c.commit();
                    return rid;
                }
            }
            c.rollback();
        }finally{
            c.setAutoCommit(true);
        }
        return null;
    }
    
    public boolean addQualifications(ArrayList<QualificationDTO> qdtos){
        
    } 
    
}
