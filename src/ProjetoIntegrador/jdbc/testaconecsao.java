/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoIntegrador.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author robert.dettenborn
 */
public class testaconecsao {
    public static void main(String[] args) {
        try {
            ConnectionFactory.getConnection();
            JOptionPane.showMessageDialog(null, "conecsao bem sucedida");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    }
    
}
