/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import lk.ijse.paymentsystem.dao.custom.CourseDetailsDAO;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dto.CourseDetailsDTO;


public class CourseDetailsDAOImpl implements CourseDetailsDAO {
    
    Connection c;
    public CourseDetailsDAOImpl() {
        c=ConnectionFactory.getInstance().getConnection();
    }

    
    
    @Override
    public CourseDetailsDTO search(CourseDetailsDTO dto) throws Exception {
        String SQL="select * from course_details where courseID=?";
        PreparedStatement stm=c.prepareStatement(SQL);
        stm.setString(1, dto.getCourseID());
        ResultSet rst=stm.executeQuery();
        CourseDetailsDTO cddto=new CourseDetailsDTO();
        if (rst.next()){
            cddto=new CourseDetailsDTO(rst.getString(1), rst.getInt(2), rst.getDouble(3), rst.getDouble(4), rst.getDouble(5), rst.getDouble(6), LocalDate.parse(rst.getString(7)));
        }
        return cddto;
    }
    
}
