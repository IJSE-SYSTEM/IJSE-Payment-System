/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.view;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.paymentsystem.controller.ControllerFactory;
import lk.ijse.paymentsystem.controller.custom.CourseController;
import lk.ijse.paymentsystem.dto.CourseDTO;

/**
 *
 * @author midda
 */
public class CourseDetailsController {
    
    CourseController controller;
    ArrayList<CourseDTO> courseDTOs=new ArrayList<>();

    public CourseDetailsController() {
        controller = (CourseController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.COURSE);
        try {
            courseDTOs = controller.getAll();
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
}
