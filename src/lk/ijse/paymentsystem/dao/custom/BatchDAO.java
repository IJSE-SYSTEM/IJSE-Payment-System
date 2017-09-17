/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.custom;

import java.util.ArrayList;
import lk.ijse.paymentsystem.dao.SuperDAO;
import lk.ijse.paymentsystem.dto.BatchDTO;

/**
 *
 * @author midda
 */
public interface BatchDAO extends SuperDAO<BatchDTO>{

    @Override
    public default ArrayList<BatchDTO> getSearched(BatchDTO dto) throws Exception {
        return null;
    }

    @Override
    public default boolean add(BatchDTO dto) throws Exception {
        return false;
    }

    @Override
    public default boolean update(BatchDTO dto) throws Exception {
        return false;
    }

    @Override
    public default boolean delete(BatchDTO dto) throws Exception {
        return false;
    }

    @Override
    public default BatchDTO search(BatchDTO dto) throws Exception {
        return null;
    }

    @Override
    public default ArrayList<BatchDTO> getAll() throws Exception {
        return null;
    }
    
}
