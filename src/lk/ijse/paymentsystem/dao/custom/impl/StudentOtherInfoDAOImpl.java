/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.ijse.paymentsystem.dao.custom.StudentOtherInfoDAO;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dto.StudentOtherInfoDTO;


public class StudentOtherInfoDAOImpl implements StudentOtherInfoDAO {

    private Connection conn;

    public StudentOtherInfoDAOImpl() {
        conn = ConnectionFactory.getInstance().getConnection();
    }
    
    
    
    @Override
    public boolean add(StudentOtherInfoDTO dto) throws Exception {
        String SQL = "INSERT INTO stu_other_info VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(SQL);
        
        stm.setObject(1, dto.getSid()); // should get SID from addStudent Procedure *************************
        stm.setObject(2, dto.getDataEntryBy());
        stm.setObject(3, dto.getIqTest());
        stm.setObject(4, dto.getComments());
        stm.setObject(5, dto.isBirthCertificate());
        stm.setObject(6, dto.isPhotos());
        stm.setObject(7, dto.isNic());
        stm.setObject(8, dto.isAcademicCertificates());
        stm.setObject(9, dto.isSportsCertificates());
        stm.setObject(10, dto.isProfessionalCertificates());
        return stm.executeUpdate()>0;
    }
    
}
