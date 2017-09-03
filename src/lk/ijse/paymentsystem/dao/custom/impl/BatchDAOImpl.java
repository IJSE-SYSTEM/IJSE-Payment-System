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
import lk.ijse.paymentsystem.dao.custom.BatchDAO;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dto.BatchDTO;


public class BatchDAOImpl implements BatchDAO {

    private Connection c;
    public BatchDAOImpl() {
        c=ConnectionFactory.getInstance().getConnection();
    }
    
    

    @Override
    public ArrayList<BatchDTO> getSearched(BatchDTO dto) throws Exception {
        String SQL="select * from batch where code=? order by batchNo Desc limit 4";
        PreparedStatement stm=c.prepareStatement(SQL);
        stm.setString(1, dto.getCourseCode());
        ResultSet rst=stm.executeQuery();
        ArrayList<BatchDTO> batchDTOs=new ArrayList<>();
        while (rst.next()){
            BatchDTO bdto=new BatchDTO(rst.getString(1), rst.getString(2), rst.getString(3), LocalDate.parse(rst.getString(4)), rst.getString(5));
            batchDTOs.add(bdto);
        }
        return batchDTOs;
    }
    
}
