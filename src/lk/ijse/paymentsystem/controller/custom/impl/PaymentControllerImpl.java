/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.paymentsystem.controller.custom.PaymentController;
import lk.ijse.paymentsystem.dao.DAOFactory;
import lk.ijse.paymentsystem.dao.custom.PaymentDAO;
import lk.ijse.paymentsystem.dto.PaymentDTO;
import lk.ijse.paymentsystem.other.IDGenarator;


public class PaymentControllerImpl implements PaymentController {

    private PaymentDAO paymentDAO;

    public PaymentControllerImpl() {
        paymentDAO = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);
    }

    
    @Override
    public String add(ArrayList<PaymentDTO> dtos) throws Exception {
        boolean isSuccessful = true;
        String payID;
        payID=IDGenarator.getNewPayID(dtos.get(0).getRegID().substring(5, 6));
        for (PaymentDTO paymentDTO : dtos) {
            paymentDTO.setPayID(payID);
            if (!paymentDAO.add(paymentDTO)){
                isSuccessful=false;
                break;
            }
        }
        return isSuccessful?payID:null;
    }
    
}
