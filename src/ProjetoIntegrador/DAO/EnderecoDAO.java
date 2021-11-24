/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoIntegrador.DAO;

import java.sql.*;
import java.sql.Connection;
import ProjetoIntegrador.jdbc.ConnectionFactory;
import ProjetoIntegrador.model.Enderecos;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author robert.dettenborn
 */
public class EnderecoDAO {
    //ATRIBUTO
    private Connection conexao; 
    
    //CONSTRUTOR
     public EnderecoDAO() {
         this.conexao = ConnectionFactory.getConnection();
         
    }
    public void cadastrarEnderecos(Enderecos obj){
         try {
             String sql = "insert into tb_enderecos(cep,rua,numero,complemento,bairro,cidade,uf,id_cliente)"
                     + " values(?,?,?,?,?,?,?,?)";
             
             PreparedStatement comando = conexao.prepareStatement(sql);
             
             comando.setString(1, obj.getCep());
             comando.setString(2, obj.getRua());
             comando.setInt(3, obj.getNumero());
             comando.setString(4, obj.getComplemento());
             comando.setString(5, obj.getBairro());
             comando.setString(6, obj.getCidade());
             comando.setString(7, obj.getUF());
             comando.setInt(8, obj.getCliente().getId());
             
             comando.execute();
             comando.close();
             
             JOptionPane.showMessageDialog(null, "endereço cadastrado com sucesso!");
             
         } catch (SQLException e){
             JOptionPane.showMessageDialog(null, e);
    }
    }
    public List<Enderecos> listarEnderecos(){
        try {
            List<Enderecos> listaEnderecos = new ArrayList<>();
            
            String sql = "select * from tb_enderecos";
            
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Enderecos obj = new Enderecos();
                
                obj.setId(rs.getInt("id"));
                obj.setCep(rs.getString("cep"));
                obj.setRua(rs.getString("rua"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUF(rs.getString("uf"));
                
                
                listaEnderecos.add(obj);
            }
            return listaEnderecos;
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
           return null;
        }
    }
    
}
    

