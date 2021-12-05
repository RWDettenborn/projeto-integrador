/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.integrador;

/**
 *
 * @author robert.dettenborn
 */
public class ProjetoIntegrador {

  /*create database NEXTLEVELBD;

    use NEXTLEVELBD;

    create table tb_clientes (
      id int auto_increment primary key,
      nome varchar(100),
      email varchar(200),
      cpf varchar (20),
      telefone varchar(30)

    );

    create table tb_enderecos(
      id int auto_increment primary key,
      cep varchar(100),
      rua varchar (255),
      numero int,
      complemento varchar (200),
      bairro varchar (100),
      cidade varchar (100),
      uf varchar (2),
      id_cliente int,

      FOREIGN KEY (id_cliente) REFERENCES tb_clientes(id)
    );

    create table tb_categorias(
      id int auto_increment primary key,
      nome varchar(255)
    );

    create table tb_formapagamento(
      id int auto_increment primary key,
      nome varchar(255)
    );

    CREATE TABLE tb_produtos (
      id int auto_increment primary key,
      nome varchar(100),
      descricao varchar(500),
      peso double,
      id_categoria int,
      valor double,
      qtd_estoque int,

      FOREIGN KEY (id_categoria) REFERENCES tb_categorias(id)
    );

    create table tb_pedidos (
      id int auto_increment primary key,
      id_cliente int,
      id_produto int,
      id_formapagamento int,
      valor_pedido double,
      id_endereco int,

      FOREIGN KEY (id_cliente) REFERENCES tb_clientes(id),
      FOREIGN KEY (id_produto) REFERENCES tb_produtos(id),
      FOREIGN KEY (id_formapagamento) REFERENCES tb_formapagamento(id),
      FOREIGN KEY (id_endereco) REFERENCES tb_enderecos(id)
    );*/

    
    
}
