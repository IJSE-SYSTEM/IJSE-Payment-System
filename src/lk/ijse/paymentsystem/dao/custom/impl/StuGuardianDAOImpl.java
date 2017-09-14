/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import lk.ijse.paymentsystem.dao.custom.StuGuardianDAO;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dto.GuardianDTO;


public class StuGuardianDAOImpl implements StuGuardianDAO {

    Connection c;
    public StuGuardianDAOImpl() {
        c=ConnectionFactory.getInstance().getConnection();
    }
    
    

    @Override
    public boolean add(GuardianDTO dto) throws Exception {
        String SQL="insert into stu_guardian values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm=c.prepareStatement(SQL);
        stm.setObject(1, dto.getSID());
        stm.setObject(2, dto.getGuardianName());
//        stm
        return false;
    }
    
}
