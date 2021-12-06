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
    
    //>CONSTRUTOR
public ClientesDAO(){
    //>disponibilizar uma conexão com o BD
    this.conexao = ConnectionFactory.getConnection();
}
    public void cadastrarCliente(Clientes obj){
         try {
             //>criar uma string de comando SQL
             String sql = "insert into tb_clientes(nome,email,cpf,telefone)"
                     + " values(?,?,?,?)";
             
             //>preparar o comando SQL para o driver
             PreparedStatement comando = conexao.prepareStatement(sql);
             comando.setString(1, obj.getNome());
             comando.setString(2, obj.getEmail());
             comando.setString(3, obj.getCpf());
             comando.setString(4, obj.getTelefone());
             
             //>executar o comando sql e fechar a conexão
             comando.execute();
             comando.close();
             
             //>pegar o id gerado pelo banco de dados através do CPF
             sql = "select id from tb_clientes where cpf=?";
             comando = conexao.prepareStatement(sql);
             comando.setString(1, obj.getCpf());
             
             //>Com o comando pronto, executo o comando
             //>Esse comando é de leitura do BD, logo ele retorna um ResultSet
             ResultSet resultado = comando.executeQuery();
             //>Percorro o resultado até achar o campo "id"
             while(resultado.next()){
                 obj.setId(resultado.getInt("id"));
             }
             //>se chegou aqui mostre a janela cadastro com sucesso
             JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
             } catch (SQLException e){
                 JOptionPane.showMessageDialog(null, e);
             }
    }
    public List<Clientes> listarClientes(){
        try {
            //>criar uma lista para armazenar os clientes
             List<Clientes> lista = new ArrayList<>();
             
             //>criar o comando sql que seleciona todos os itens da
             //>tabela de enderecos
             String sql = "select * from tb_clientes";
             //>preparar o comando colocando na conexao que será
             //>utilizada para executá-lo no BD
             PreparedStatement comando = conexao.prepareStatement(sql);
             //quando usamos JDBC, o resultado de um comando select 
             //precisa ser armazenado em um objeto do tipo ResultSet
             ResultSet rs = comando.executeQuery();
             
             //criar um laço de repetição para adicionar os itens do
             //ResultSet na lista criada no primeiro passo.
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
    //DELETA CLIENTE
    public void deletarCliente(Clientes obj){
        try {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente?", "CONFIRMAÇÃO DE EXCLUSÃO", JOptionPane.OK_CANCEL_OPTION);
            if (opcao == 0) {
                String sql = "delete from tb_clientes where id=?";

                PreparedStatement comando = conexao.prepareStatement(sql);
                comando.setInt(1, obj.getId());

                comando.execute();
                comando.close();

                JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            }
        } catch (SQLException e) {
        }
    }
    //ATUALIZA OS DADOS DE UM CLIENTE
    public void atualizarCliente (Clientes obj){
        try {
            //JANELA PARA CONFIRMAR ATUALIZAÇÃO
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja atualizar o cliente?", "CONFIRMAÇÃO DE ATUALIZAÇÃO", JOptionPane.OK_CANCEL_OPTION);
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

                JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
            }
        } catch (SQLException e) {
        }
    }
    public List<Clientes> buscarClientes(String valorDeBusca) {
        try {
            //USADO PARA BUSCAR DADOS DO CLIENTE
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
