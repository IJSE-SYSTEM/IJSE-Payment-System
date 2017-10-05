/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom;

import java.util.ArrayList;
import lk.ijse.paymentsystem.dao.SuperDAO;
import lk.ijse.paymentsystem.dto.SuperDTO;

/**
 *
 * @author simo-ds
 */
public interface SchoolDAO{
    ArrayList<String> getAll() throws Exception;
}
