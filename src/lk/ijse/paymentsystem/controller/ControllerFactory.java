/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.controller;

import lk.ijse.paymentsystem.controller.custom.impl.CourseControllerImpl;
import lk.ijse.paymentsystem.dao.*;

/**
 *
 * @author midda
 */
public class ControllerFactory {
    private static ControllerFactory factory;
    
    public enum ControllerTypes{
        STUDENT, COURSE, REGISTRATION, PAYMENT, SEMESTER, BATCH
    }

    private ControllerFactory() {
        
    }

    /**
     * @return the factory
     */
    public static ControllerFactory getInstance() {
        if (factory==null){
            factory=new ControllerFactory();
        }
        return factory;
    }
    
    public SuperController getController(ControllerTypes controller){
        switch (controller){
            case BATCH:
            
            case COURSE:
                return new CourseControllerImpl();
            case PAYMENT:
                
            case REGISTRATION:
                
            case SEMESTER:
                
            case STUDENT:
                
        }
        return null;
    }
    
    
    
    
    
    
}
