/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

    @Override
    public StudentDTO search(String nic) throws Exception {
        String SQL="select * from student where nic=?";
        PreparedStatement stm=conn.prepareStatement(SQL);
        stm.setObject(1, nic);
        ResultSet rst=stm.executeQuery();
        if (rst.next()){
            return new StudentDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), 
                    rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getBoolean(11), 
                    rst.getString(12), rst.getDouble(13), rst.getString(14), rst.getString(15), rst.getString(16));
        }
        return null;
    }
    
    @Override
    public ArrayList<StudentDTO> searchName(String name)throws Exception{
        String SQL = "Select * from student where name = ?";
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, name);
        ResultSet rst = stm.executeQuery();
        ArrayList<StudentDTO> studentList = new ArrayList<>();
        while (rst.next()) {
            StudentDTO student = new StudentDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), 
                    rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getBoolean(11), 
                    rst.getString(12), rst.getDouble(13), rst.getString(14), rst.getString(15), rst.getString(16));
            
            studentList.add(student);
        }
        return studentList;
    }
    
    @Override
    public StudentDTO search(String studentId, String batchId) throws Exception{
        String SQL = "select sid from registration, student where registration.sid = student.sid and registration.batchId = ?;";
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, studentId);
        stm.setObject(2, batchId);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return new StudentDTO(rst.getString(1));
        }
       return null;
    }
    
    @Override
    public StudentDTO search(StudentDTO dto) throws Exception{
     String SQL="select * from student where sid=?";
        PreparedStatement stm=conn.prepareStatement(SQL);
        stm.setObject(1, dto.getSID());
        ResultSet rst=stm.executeQuery();
        if (rst.next()){
            return new StudentDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), 
                    rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getBoolean(11), 
                    rst.getString(12), rst.getDouble(13), rst.getString(14), rst.getString(15), rst.getString(16));
        }
        return null;
        
    }
    
}
