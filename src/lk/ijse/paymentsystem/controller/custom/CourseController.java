/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.controller.custom;

import java.util.ArrayList;
import lk.ijse.paymentsystem.dto.CourseDTO;
import lk.ijse.paymentsystem.controller.SuperController;

/**
 *
 * @author midda
 */
public interface CourseController extends SuperController<CourseDTO>{

    @Override
    public default boolean add(CourseDTO dto) throws Exception {
        return false;
    }

    @Override
    public default boolean update(CourseDTO dto) throws Exception {
        return false;
    }

    @Override
    public default boolean delete(CourseDTO dto) throws Exception {
        return false;
    }

    @Override
    public default CourseDTO search(CourseDTO dto) throws Exception {
        return null;
    }

    @Override
    public default ArrayList<CourseDTO> getSearched(CourseDTO dto) throws Exception {
        return null;
    }
    
}
