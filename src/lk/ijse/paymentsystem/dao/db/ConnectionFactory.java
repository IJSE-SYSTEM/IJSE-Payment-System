    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.paymentsystem.dao.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author midda
 */
public class ConnectionFactory {
    private Connection connection;
    private static ConnectionFactory cf;

    private ConnectionFactory(){

            
        FileReader reader = null;
        try {
            // (1)
            Properties myAppSettings = new Properties();
            // (2) Loading property file
            File myFile = new File("settings/myappsettings.properties");
            reader = new FileReader(myFile);
            myAppSettings.load(reader);
            
            // (3) Reading properties
            String ip = myAppSettings.getProperty("ip");
            String port = myAppSettings.getProperty("port");
            String username = myAppSettings.getProperty("username");
            String password = myAppSettings.getProperty("password");
            String database = myAppSettings.getProperty("database");

            
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/"+database,username,password);
//            connection=DriverManager.getConnection("jdbc:mysql://localhost/ijse/ijse");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (FileNotFoundException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @return the dBConnection
     */
    public static ConnectionFactory getInstance(){
        if (cf==null){
            cf=new ConnectionFactory();
        }
        return cf;
    }
    
    
}
