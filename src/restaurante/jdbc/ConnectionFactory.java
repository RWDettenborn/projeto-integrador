/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author robert.dettenborn
 */
public class ConnectionFactory {
    public static Connection getConnection() {
    try {    
        final String url = "jdbc:mysql://localhost/NEXTLEVELBD?verifyServerCertificate-false&useSSL-true";
        final String user = "definitivo2";
        final String password = ")Lut02k[07_XucB7";
        
        
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
