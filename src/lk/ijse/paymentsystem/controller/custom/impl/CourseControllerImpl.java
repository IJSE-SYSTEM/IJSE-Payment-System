/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.paymentsystem.dao.DAOFactory;
import lk.ijse.paymentsystem.dao.custom.CourseDAO;
import lk.ijse.paymentsystem.dto.CourseDTO;
import lk.ijse.paymentsystem.controller.custom.CourseController;
import lk.ijse.paymentsystem.dao.custom.CourseDetailsDAO;
import lk.ijse.paymentsystem.dto.CourseDetailsDTO;


public class CourseControllerImpl implements CourseController {

    CourseDAO courseDAO;
    CourseDetailsDAO courseDetailsDAO;
    public CourseControllerImpl() {
        courseDAO=(CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COURSE);
        courseDetailsDAO=(CourseDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COURSE_DETAILS);
    }

    
    
    @Override
    public ArrayList<CourseDTO> getAll() throws Exception {
        return courseDAO.getAll();
    }

    @Override
    public CourseDetailsDTO getCourseDetails(String courseID) throws Exception {
        CourseDetailsDTO cddto=new CourseDetailsDTO();
        cddto.setCourseID(courseID);
        CourseDetailsDTO courseDetailsDTO = courseDetailsDAO.search(cddto);
        return courseDetailsDTO;
    }
    
}
