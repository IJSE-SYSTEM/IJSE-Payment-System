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
import java.util.ArrayList;
import lk.ijse.paymentsystem.dao.custom.QueryDAO;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dto.BatchDTO;

/**
 *
 * @author midda
 */
public class QueryDAOImpl implements QueryDAO{
    
    private Connection c;
    public QueryDAOImpl() {
        c=ConnectionFactory.getInstance().getConnection();
    }
    
    public ArrayList<BatchDTO> getBatches(String code) throws Exception {
        String SQL="select * from batch where courseID in ( select courseID from course_details where code=? ) order by batchNo desc limit 4";
        PreparedStatement stm=c.prepareStatement(SQL);
        stm.setString(1, code);
        ResultSet rst=stm.executeQuery();
        ArrayList<BatchDTO> batchDTOs=new ArrayList<>();
        while (rst.next()){
            BatchDTO bdto=new BatchDTO(rst.getString(1), rst.getString(2), rst.getInt(3), LocalDate.parse(rst.getString(4)), rst.getString(5));
            batchDTOs.add(bdto);
        }
        return batchDTOs;
    }
    
}