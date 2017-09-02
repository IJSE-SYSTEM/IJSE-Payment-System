/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao;

import lk.ijse.paymentsystem.dao.custom.impl.CourseDAOImpl;

/**
 *
 * @author midda
 */
public class DAOFactory {
    private static DAOFactory factory;
    
    public enum DAOTypes{
        STUDENT, COURSE, STU_GUARDIAN, STU_PRO_QUALIFICATIONS, STU_OTHER, REGISTRATION, PAYMENT, SEMESTER, BATCH
    }

    private DAOFactory() {
        
    }

    /**
     * @return the factory
     */
    public static DAOFactory getInstance() {
        if (factory==null){
            factory=new DAOFactory();
        }
        return factory;
    }
    
    public SuperDAO getDAO(DAOTypes dao){
        switch (dao){
            case BATCH:
            
            case COURSE:
                return new CourseDAOImpl();
            case PAYMENT:
                
            case REGISTRATION:
                
            case SEMESTER:
                
            case STUDENT:
                
            case STU_GUARDIAN:
                
            case STU_OTHER:
                
            case STU_PRO_QUALIFICATIONS:
                
        }
        return null;
    }
    
    
    
    
    
    
}
