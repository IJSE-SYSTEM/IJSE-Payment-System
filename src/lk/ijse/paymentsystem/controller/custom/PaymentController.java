/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.controller.custom;

import java.util.ArrayList;
import lk.ijse.paymentsystem.controller.SuperController;
import lk.ijse.paymentsystem.dto.PaymentDTO;

/**
 *
 * @author midda
 */
public interface PaymentController extends SuperController<PaymentDTO>{

    @Override
    public default boolean add(PaymentDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default boolean update(PaymentDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default boolean delete(PaymentDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default PaymentDTO search(PaymentDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default ArrayList<PaymentDTO> getSearched(PaymentDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default ArrayList<PaymentDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    String add(ArrayList<PaymentDTO> dtos) throws Exception;
    
}
