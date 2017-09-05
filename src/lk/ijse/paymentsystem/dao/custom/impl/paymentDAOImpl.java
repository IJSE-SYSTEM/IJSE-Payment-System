/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom.impl;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import lk.ijse.paymentsystem.dao.custom.paymentDAO;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dto.PaymentDTO;


public class paymentDAOImpl implements paymentDAO {
    private Connection conn;

    public paymentDAOImpl() {
        conn = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(PaymentDTO dto) throws Exception {
        String SQL = "INSERT INTO payment VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(SQL);
        
        stm.setObject(1, dto.getPaymentID());
        stm.setObject(2, dto.getRegID());
        stm.setObject(3, dto.getSemesters());
        stm.setObject(4, dto.getSemesterHalf());
        stm.setObject(5, dto.getPaymentDate());
        stm.setObject(6, dto.getAmount());
        stm.setObject(7, dto.getDiscount());
        stm.setObject(8, dto.getAmountRecieved());
        
        int rst = stm.executeUpdate();
        return rst>0;
    }
    
    
    
}
