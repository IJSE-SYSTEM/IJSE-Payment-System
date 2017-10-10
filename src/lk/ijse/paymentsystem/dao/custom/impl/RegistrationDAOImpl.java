/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
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
        String SQL = "call add_registration(?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getSID());
        stm.setObject(2, dto.getBatchId());
        stm.setObject(3, dto.getRegistrationDate().toString());
        stm.setObject(4, dto.isBcs());
        
        
        ResultSet rst = stm.executeQuery();
        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }
    
    
    @Override
    public RegistrationDTO search(RegistrationDTO dto) throws Exception {
        String SQL = "select * from registration where (sid = (Select sid from registration where regid=?) || sid = ?) && transferred_to_batch IS NULL order by registration_date desc, regID desc limit 1";
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getRID());
        stm.setObject(2, dto.getRID());
        ResultSet rst = stm.executeQuery();
        RegistrationDTO registrationDTO = null;
        if (rst.next()) {
            registrationDTO = new RegistrationDTO(rst.getString(1),rst.getString(2), rst.getString(3), LocalDate.parse(rst.getString(4)), rst.getBoolean(5), rst.getString(6), rst.getString(7));
        }
        return registrationDTO;
    }
}

//select * from registration where sid in (Select sid from registration where regid='GDSE/P/45/010') && transferred_to_batch IS NULL order by registration_date desc, regID desc;
//select * from registration where (sid = (Select sid from registration where regid="") || sid = '2017003') && transferred_to_batch IS NULL order by registration_date desc, regID desc;
//"Select * from registration where sid=?