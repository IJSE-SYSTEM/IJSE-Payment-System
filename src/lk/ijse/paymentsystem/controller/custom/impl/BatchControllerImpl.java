/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.paymentsystem.controller.custom.BatchController;
import lk.ijse.paymentsystem.dao.DAOFactory;
import lk.ijse.paymentsystem.dao.custom.BatchDAO;
import lk.ijse.paymentsystem.dao.custom.QueryDAO;
import lk.ijse.paymentsystem.dto.BatchDTO;


public class BatchControllerImpl implements BatchController {

    BatchDAO batchDAO;
    QueryDAO queryDAO;
    public BatchControllerImpl() {
        batchDAO=(BatchDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BATCH);
        queryDAO=(QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    }

    @Override
    public ArrayList<BatchDTO> getBatches(String code) throws Exception {
        return queryDAO.getBatches(code);
    }
    
    
}
