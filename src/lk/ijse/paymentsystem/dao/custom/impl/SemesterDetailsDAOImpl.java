/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.ijse.paymentsystem.dao.custom.SemesterDetailsDAO;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dto.SemesterDetailsDTO;


public class SemesterDetailsDAOImpl implements SemesterDetailsDAO {
    private Connection conn;

    public SemesterDetailsDAOImpl() {
        conn = ConnectionFactory.getInstance().getConnection();
    }
    
    
    @Override
    public boolean add(SemesterDetailsDTO dto) throws Exception {
        String SQL = "INSERT INTO semester_details VALUES(?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getCode());
        stm.setObject(2, dto.getSemester());
        stm.setObject(3, dto.getModuleInfo());
        stm.setObject(4, dto.getCertificationLevel());
        return stm.executeUpdate()>0;
    }
}
