/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom.impl;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dto.PaymentDTO;
import lk.ijse.paymentsystem.dao.custom.PaymentDAO;


public class PaymentDAOImpl implements PaymentDAO {
    private Connection conn;

    public PaymentDAOImpl() {
        conn = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(PaymentDTO dto) throws Exception {
        String SQL = "INSERT INTO payment VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(SQL);
        
        stm.setObject(1, dto.getPayID());
        stm.setObject(2, dto.getRegID());
        stm.setObject(3, dto.getSemester());
        stm.setObject(4, dto.getSem_half());
        stm.setObject(5, dto.getNextPayID());
        stm.setObject(6, dto.getDate());
        stm.setObject(7, dto.getAmount());
        stm.setObject(8, dto.getDiscount());
        stm.setObject(9, dto.getAmount_recieved());
        
        int rst = stm.executeUpdate();
        return rst>0;
    }
    
    
    
}
