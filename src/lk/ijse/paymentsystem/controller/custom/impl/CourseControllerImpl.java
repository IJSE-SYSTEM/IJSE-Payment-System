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


public class CourseControllerImpl implements CourseController {

    CourseDAO courseDAO;
    public CourseControllerImpl() {
        courseDAO=(CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COURSE);
    }

    
    
    @Override
    public ArrayList<CourseDTO> getAll() throws Exception {
        return courseDAO.getAll();
    }
    
}
