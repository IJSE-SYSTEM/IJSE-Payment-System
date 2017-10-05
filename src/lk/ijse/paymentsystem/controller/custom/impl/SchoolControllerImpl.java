/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.paymentsystem.controller.custom.SchoolController;
import lk.ijse.paymentsystem.dao.DAOFactory;
import lk.ijse.paymentsystem.dao.custom.SchoolDAO;


public class SchoolControllerImpl implements SchoolController {

    public SchoolDAO schoolDAO;

    public SchoolControllerImpl() {
        schoolDAO = DAOFactory.getInstance().getSchool();
    }
    
    @Override
    public ArrayList<String> getAll() throws Exception {
        return schoolDAO.getAll();
    }
    
}
