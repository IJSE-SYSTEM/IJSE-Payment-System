/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lk.ijse.paymentsystem.dao.custom.RegistrationDAO;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dto.RegistrationDTO;


public class RegistrationDAOImpl implements RegistrationDAO {
    private Connection conn;

    public RegistrationDAOImpl() {
        conn = ConnectionFactory.getInstance().getConnection();
    }
    
    
    //.........

    @Override
    public String addCall(RegistrationDTO dto) throws Exception {
        String SQL = "add_registration(?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getSID());
        stm.setObject(2, dto.getBatchId());
        stm.setObject(3, dto.getRegistrationDate());
        stm.setObject(4, dto.getTransferredToBatch());
        stm.setObject(5, dto.getNewRegistrationID());
        
        ResultSet rst = stm.executeQuery();
        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }
}
