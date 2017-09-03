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
    
}
