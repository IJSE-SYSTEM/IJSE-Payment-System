/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lk.ijse.paymentsystem.dao.custom.StudentDAO;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dto.StudentDTO;

/**
 *
 * @author simo-ds
 */
public class StudentDAOImpl implements StudentDAO{
    private Connection conn;

    public StudentDAOImpl() {
        conn = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public String addCall(StudentDTO dto) throws Exception {
        String SQL = "call add_student(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /* send data to the database without SID*/
        PreparedStatement stm = conn.prepareStatement(SQL);
        
        System.out.println(dto);
        stm.setObject(1, dto.getInitialStudentName());
        stm.setObject(2, dto.getStudentName());
        stm.setObject(3, dto.getAddressLine1());
        stm.setObject(4, dto.getAddressLine2());
        stm.setObject(5, dto.getAddressLine3());
        stm.setObject(6, dto.getTelHome());
        stm.setObject(7, dto.getMobile());
        stm.setObject(8, dto.getEmail());
        stm.setObject(9, dto.getDob());
        stm.setBoolean(10, dto.getGender());
        stm.setObject(11, dto.getNic());
        stm.setObject(12, dto.getRegFee());
        stm.setObject(13, dto.getSchool());
        stm.setObject(14, dto.getGrade());
        stm.setObject(15, dto.getUniversity());
        
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            return rst.getString(1);
        }        
        return null;
    }
}
