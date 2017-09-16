    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.other;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.paymentsystem.dao.custom.impl.IDGeneratorDAOImpl;

/**
 *
 * @author midda
 */
public class IDGenarator {
    public static String getNewPayID(String branch) {
        try {
            String lastId = IDGeneratorDAOImpl.getLastPayID(branch);
            String newId;
            String prefix=(branch+"/");
            if (lastId != null) {
                String Id="";
                char[] reg=lastId.toCharArray();
                for(int i=2;i<reg.length;i++){
                    Id+=reg[i];
                }
                int r=Integer.parseInt(Id);
                if(r<9){
                    newId= prefix+"0000"+(r+1);
                }else if(r<99){
                    newId= prefix+"000"+(r+1);
                }else if(r<999){
                    newId= prefix+"00"+(r+1);
                }else if(r<9999){
                    newId= prefix+"0"+(r+1);
                }else
                    newId= prefix+(r+1);
            }else{
                newId = prefix+"00001";
            }
            return newId;
        } catch (SQLException ex) {
            Logger.getLogger(IDGenarator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IDGenarator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String getNewID(String lastId, String prefix){
        String Id="";
        int len=prefix.length();
        char[] reg=lastId.toCharArray();
        for(int i=len;i<reg.length;i++){
            Id+=reg[i];
        }
        int r=Integer.parseInt(Id);
        if(r<9){
            return prefix+"000"+(r+1);
        }else if(r<99){
            return prefix+"00"+(r+1);
        }else if(r<999){
            return prefix+"0"+(r+1);
        }
        return prefix+(r+1);
    }
}
