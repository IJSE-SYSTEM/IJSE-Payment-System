/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom.impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;

/**
 *
 * @author midda
 */
public class IDGeneratorDAOImpl {
    public static String getLastPayID(String branch) throws SQLException, ClassNotFoundException{
        String SQL="SELECT payID FROM payment WHERE payID LIKE '"+branch+"/%' ORDER BY payID DESC LIMIT 1";
        Connection conn=ConnectionFactory.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(SQL);
        if(rst.next())
            return rst.getString(1);
        return null;
    }
}
