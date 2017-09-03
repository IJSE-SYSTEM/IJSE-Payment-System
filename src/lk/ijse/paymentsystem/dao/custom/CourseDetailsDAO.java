/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom;

import java.util.ArrayList;
import lk.ijse.paymentsystem.dao.SuperDAO;
import lk.ijse.paymentsystem.dto.CourseDetailsDTO;

/**
 *
 * @author midda
 */
public interface CourseDetailsDAO extends SuperDAO<CourseDetailsDTO>{

    @Override
    public default boolean add(CourseDetailsDTO dto) throws Exception {
        return false;
    }

    @Override
    public default boolean update(CourseDetailsDTO dto) throws Exception {
        return false;
    }

    @Override
    public default boolean delete(CourseDetailsDTO dto) throws Exception {
        return false;
    }

    @Override
    public default ArrayList<CourseDetailsDTO> getSearched(CourseDetailsDTO dto) throws Exception {
        return null;
    }

    @Override
    public default ArrayList<CourseDetailsDTO> getAll() throws Exception {
        return null;
    }
    
}
