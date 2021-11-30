/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoIntegrador.DAO;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import ProjetoIntegrador.jdbc.ConnectionFactory;
import ProjetoIntegrador.model.Clientes;
/**
 *
 * @author robert.dettenborn
 */
public class ClientesDAO {
    private Connection conexao;
    
    //CONSTRUTOR
public ClientesDAO(){
    this.conexao = ConnectionFactory.getConnection();
}
    public void cadastrarCliente(Clientes obj){
         try {
             String sql = "insert into tb_clientes(nome,email,cpf,telefone)"
                     + " values(?,?,?,?)";
             
             PreparedStatement comando = conexao.prepareStatement(sql);
             
             comando.setString(1, obj.getNome());
             comando.setString(2, obj.getEmail());
             comando.setString(3, obj.getCpf());
             comando.setString(4, obj.getTelefone());
             
             comando.execute();
             comando.close();
             
             sql = "select id from tb_clientes where cpf=?";
             comando = conexao.prepareStatement(sql);
             comando.setString(1, obj.getCpf());
             
             ResultSet resultado = comando.executeQuery();
             while(resultado.next()){
                 obj.setId(resultado.getInt("id"));
             }
             JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
             } catch (SQLException e){
                 JOptionPane.showMessageDialog(null, e);
             }
    }
    public List<Clientes> listarClientes(){
        try {
             List<Clientes> lista = new ArrayList<>();
             
             String sql = "select * from tb_clientes";
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet rs = comando.executeQuery();
             
             while(rs.next()){
                 Clientes obj = new Clientes();
                 obj.setId(rs.getInt("id"));
                 obj.setNome(rs.getString("nome"));
                 obj.setCpf(rs.getString("cpf"));
                 obj.setEmail(rs.getString("email"));
                 obj.setTelefone(rs.getString("telefone"));
                 lista.add(obj);
             }
             return lista;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    public void deletarCliente(Clientes obj){
        try {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o cliente?", "CONFIRMAÇÃO DE EXCLUSÃO", JOptionPane.OK_CANCEL_OPTION);
            if (opcao == 0) {
                String sql = "delete from tb_clientes where id=?";

                PreparedStatement comando = conexao.prepareStatement(sql);
                comando.setInt(1, obj.getId());

                comando.execute();
                comando.close();

                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
            }
        } catch (SQLException e) {
        }
    }
    public void atualizarCliente (Clientes obj){
        try {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente atualizar o cliente?", "CONFIRMAÇÃO DE ATUALIZAÇÃO", JOptionPane.OK_CANCEL_OPTION);
            if (opcao == 0) {
                String sql = "update tb_clientes set nome=?, email=?, cpf=?, telefone=? where id=?";

                PreparedStatement comando = conexao.prepareStatement(sql);
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getEmail());
                comando.setString(3, obj.getCpf());
                comando.setString(4, obj.getTelefone());
                comando.setInt(5, obj.getId());

                comando.execute();
                comando.close();

                JOptionPane.showMessageDialog(null, "Cadastro de cliente atualizado com sucesso!");
            }
        } catch (SQLException e) {
        }
    }
    public List<Clientes> buscarClientes(String valorDeBusca) {
        try {
            List<Clientes> lista = new ArrayList<>();
            String sql = "select * from tb_clientes where concat_ws(id,nome,cpf,email,telefone) like ?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, "%"+ valorDeBusca+ "%");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) { 

                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));

                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
