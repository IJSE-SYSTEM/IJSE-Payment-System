/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dao.custom.StudentProQualiDAO;
import lk.ijse.paymentsystem.dto.QualificationDTO;


public class StudentProQualiDAOImpl implements StudentProQualiDAO {

    private Connection conn;

    public StudentProQualiDAOImpl() {
        conn = ConnectionFactory.getInstance().getConnection();
    }
    
    
    @Override
    public boolean add(QualificationDTO dto) throws Exception {
        String SQL = "INSERT INTO stu_pro_qualification VALUES(?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getSid());
        stm.setObject(2, dto.getQualification());
        stm.setObject(3, dto.getAwardingInstitute());
        stm.setObject(4, dto.getDateOfAward());
        stm.setObject(5, dto.getSpecialization());
        
        return stm.executeUpdate()>0;
    }
    
}
