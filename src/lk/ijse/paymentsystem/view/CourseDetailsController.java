/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.paymentsystem.controller.ControllerFactory;
import lk.ijse.paymentsystem.controller.custom.BatchController;
import lk.ijse.paymentsystem.controller.custom.CourseController;
import lk.ijse.paymentsystem.dto.BatchDTO;
import lk.ijse.paymentsystem.dto.CourseDTO;
import lk.ijse.paymentsystem.dto.CourseDetailsDTO;

/**
 *
 * @author midda
 */
public class CourseDetailsController {
    
    private CourseController courseController;
    private BatchController batchController;
    private ArrayList<CourseDTO> courseDTOs=new ArrayList<>();
    public ArrayList<BatchDTO> batchDTOs=new ArrayList<>();
    private CourseDTO courseDTO;
    

    public CourseDetailsController() {
        courseController = (CourseController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.COURSE);
        batchController=(BatchController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.BATCH);
        try {
            courseDTOs = courseController.getAll();
        } catch (Exception ex) {
            Logger.getLogger(CourseDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String> getCourseNames(){
        ArrayList<String> courseNames=new ArrayList<>();
        for (CourseDTO courseDTO : courseDTOs) {
            courseNames.add(courseDTO.toString());
        }
        return courseNames;
    }
    
    public CourseDetailsDTO getCourseDetails(int selectedIndex){
        CourseDetailsDTO cddto=null;
        try {
            cddto=courseController.getCourseDetails(batchDTOs.get(selectedIndex).getCourseID());
            
        } catch (Exception ex) {
            Logger.getLogger(CourseDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cddto.setName(courseDTO.getName());
        cddto.setCode(courseDTO.getCode());
        return cddto;
    }
    
    public ArrayList<String> getBatchDetails(int selectedIndex){
        ArrayList<String> batches=new ArrayList<>();
        courseDTO=courseDTOs.get(selectedIndex);
        System.out.println("A");
        try {
            batchDTOs=batchController.getBatches(courseDTO.getCode());
        } catch (Exception ex) {
            Logger.getLogger(CourseDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (BatchDTO batchDTO : batchDTOs) {
            batches.add(batchDTO.getBatchID()+" - "+batchDTO.getBranch());
        }
        return batches;
    }
    
    public LocalDate getBatchStartDate(int selectedIndex){
        return batchDTOs.get(selectedIndex).getStartDate();
    }
    
    public String getBatchID(int selectedIndex){
        return batchDTOs.get(selectedIndex).getBatchID();
    }
    
}
