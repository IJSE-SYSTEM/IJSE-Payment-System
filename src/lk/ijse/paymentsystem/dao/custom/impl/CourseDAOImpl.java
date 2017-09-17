/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.paymentsystem.dao.custom.CourseDAO;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dto.CourseDTO;


public class CourseDAOImpl implements CourseDAO {

    Connection c;
    public CourseDAOImpl() {
        c=ConnectionFactory.getInstance().getConnection();
    }
    
    

    @Override
    public ArrayList<CourseDTO> getAll() throws Exception {
        String SQL="select * from course";
        Statement stm=c.createStatement();
        ResultSet rst=stm.executeQuery(SQL);
        ArrayList<CourseDTO> courseDTOs=new ArrayList<>();
        while(rst.next()){
           CourseDTO cdto=new CourseDTO(rst.getString(1), rst.getString(2));
           courseDTOs.add(cdto);
        }
        return courseDTOs;
    }//...
    
//    , rst.getInt(3), rst.getDouble(4), rst.getDouble(5), rst.getDouble(6), rst.getDouble(7)
}
