/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.ijse.paymentsystem.dao.custom.GuardianDAO;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dto.GuardianDTO;


public class GuardianDAOImpl implements GuardianDAO {
    private Connection conn;

    public GuardianDAOImpl() {
        conn = ConnectionFactory.getInstance().getConnection();
    }
    
    
    
    @Override
    public boolean add(GuardianDTO dto) throws Exception {
        String SQL = "INSERT INTO stu_guardian VALUES(?,?,?,?,?,?,?,?,?,?)";  
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getSID()); // should get SID from addStudent Procedure *************************
        stm.setObject(2, dto.getGuardianName());
        stm.setObject(3, dto.getTelNo1());
        stm.setObject(4, dto.getTelNo2());
        stm.setObject(5, dto.getEmail());
        stm.setObject(6, dto.getDesignation());
        stm.setObject(7, dto.getWorkPlace());
        stm.setObject(8, dto.getAddressLine1());
        stm.setObject(9, dto.getAddressLine2());
        stm.setObject(10, dto.getAddressLine3());
        
        return stm.executeUpdate() > 0;
    }
}
