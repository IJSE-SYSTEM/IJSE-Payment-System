/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao;

import lk.ijse.paymentsystem.dao.custom.RegistrationDAO;
import lk.ijse.paymentsystem.dao.custom.SchoolDAO;
import lk.ijse.paymentsystem.dao.custom.StudentProQualiDAO;
import lk.ijse.paymentsystem.dao.custom.impl.BatchDAOImpl;
import lk.ijse.paymentsystem.dao.custom.impl.CourseDAOImpl;
import lk.ijse.paymentsystem.dao.custom.impl.CourseDetailsDAOImpl;
import lk.ijse.paymentsystem.dao.custom.impl.GuardianDAOImpl;
import lk.ijse.paymentsystem.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.paymentsystem.dao.custom.impl.QueryDAOImpl;
import lk.ijse.paymentsystem.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.paymentsystem.dao.custom.impl.SchoolDAOImpl;
import lk.ijse.paymentsystem.dao.custom.impl.StudentDAOImpl;
import lk.ijse.paymentsystem.dao.custom.impl.StudentOtherInfoDAOImpl;
import lk.ijse.paymentsystem.dao.custom.impl.StudentProQualiDAOImpl;

/**
 *
 * @author midda
 */
public class DAOFactory {
    private static DAOFactory factory;
    
    public enum DAOTypes{
        STUDENT, COURSE, STU_GUARDIAN, STU_PRO_QUALIFICATIONS, STU_OTHER, REGISTRATION, PAYMENT, SEMESTER, BATCH, QUERY, COURSE_DETAILS
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
                return new BatchDAOImpl();
            case COURSE:
                return new CourseDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case REGISTRATION:
                return new RegistrationDAOImpl();
            case SEMESTER:
                
            case STUDENT:
                return new StudentDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            case STU_GUARDIAN:
                return new GuardianDAOImpl();
            case STU_OTHER:
                return new StudentOtherInfoDAOImpl();
            case STU_PRO_QUALIFICATIONS:
                return new StudentProQualiDAOImpl();
            case COURSE_DETAILS:
                return new CourseDetailsDAOImpl();
                
        }
        return null;
    }
    
    public SchoolDAO getSchool(){
        return new SchoolDAOImpl();
    }
}
