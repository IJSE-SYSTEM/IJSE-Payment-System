/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.controller.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.paymentsystem.controller.ControllerFactory;
import lk.ijse.paymentsystem.controller.custom.PaymentController;
import lk.ijse.paymentsystem.controller.custom.RegistrationController;
import lk.ijse.paymentsystem.dao.DAOFactory;
import lk.ijse.paymentsystem.dao.custom.RegistrationDAO;
import lk.ijse.paymentsystem.dao.db.ConnectionFactory;
import lk.ijse.paymentsystem.dto.PaymentDTO;
import lk.ijse.paymentsystem.dto.RegistrationDTO;


public class RegistrationControllerImpl implements RegistrationController {

    private RegistrationDAO dao;
    private PaymentController pc;
    private Connection c;
    public RegistrationControllerImpl() {
        dao=(RegistrationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGISTRATION);
        pc=(PaymentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.PAYMENT);
        c=ConnectionFactory.getInstance().getConnection();
    }
    
    @Override
    public String addCall(RegistrationDTO dto) throws Exception {
        return dao.addCall(dto);
    }

    @Override
    public boolean update(RegistrationDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(RegistrationDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RegistrationDTO search(RegistrationDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<RegistrationDTO> getSearched(RegistrationDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<RegistrationDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] addCall(RegistrationDTO dto, ArrayList<PaymentDTO> paymentDTOs) throws Exception {
        String rid=null,payID=null;
        try{
            c.setAutoCommit(false);
            rid=dao.addCall(dto);
            System.out.println(rid);
            if (rid!=null){
                if (rid!=null){
                    for (PaymentDTO paymentDTO : paymentDTOs) {
                        paymentDTO.setRegID(rid);
                    }
                    payID=pc.add(paymentDTOs);
                    if (payID!=null){
                        c.commit();
                        return new String[]{rid,payID};
                    }
                }
            }
            c.rollback();
        }finally{
            c.setAutoCommit(true);
        }
        return null;
    }
    
}
