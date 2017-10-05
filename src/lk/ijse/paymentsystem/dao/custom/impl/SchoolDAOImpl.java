/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.paymentsystem.dao.custom.SchoolDAO;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;


public class SchoolDAOImpl implements SchoolDAO {

     private Connection conn;
    public SchoolDAOImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    @Override
    public ArrayList<String> getAll() throws Exception {
        String SQL = "SELECT * FROM school";
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<String> schoolList = new ArrayList<>();
        while(rst.next()){
            String school = rst.getString(1);
            schoolList.add(school);
        }
        return schoolList;
    }
    
}
