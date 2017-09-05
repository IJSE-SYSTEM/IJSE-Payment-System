/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import lk.ijse.paymentsystem.dao.custom.RegistrationDAO;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dto.RegistrationDTO;


public class RegistrationDAOImpl implements RegistrationDAO {
    private Connection conn;

    public RegistrationDAOImpl() {
        conn = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(RegistrationDTO dto) throws Exception {
        String SQL = "INSERT INTO registration VALUES(?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getRID());
        stm.setObject(2, dto.getSID());
        stm.setObject(3, dto.getBatchId());
        stm.setObject(4, dto.getRegistrationDate());
        stm.setObject(5, dto.getTransferredToBatch());
        stm.setObject(6, dto.getNewRegistrationID());
        
        int rst = stm.executeUpdate();
        return rst>0;
    }
    
    
    //.........
    
    
}
