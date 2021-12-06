/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restauranteBD;

/**
 *
 * @author Usuario
 */
/*
//modelo do Banco de Dados
creat database Sabor_do_Momento;

use Sabor_do_Momento;

create table Cadastro_cl (
id int auto_increment primary key,
nome varchar(100),
email varchar(200),
cpf varchar (20),
telefone varchar(30)
  
);

create table Enderecos_cl(
id int auto_increment primary key,
cep varchar(100),
rua varchar (255),
numero int,
complemento varchar (200),
bairro varchar (100),
cidade varchar (100),
uf varchar (2),
id_cliente int,
    
FOREIGN KEY (id_cliente) REFERENCES Cadastro_cl(id)
);

create table Setor(
cod_setor integer(11) not null auto_increment,
nome_setor varchar(200) not null,
primary key(cod_setor));

create table funcionario(
cod_funcionario integer(20) auto_increment,
nome varchar(255) not null,
CPF_funci varchar(20) not null,
num_setor integer(11) not null,
salario float(6,2) not null,
fone_fc varchar(12) not null,
num_PIS varchar(20) not null,
data_nasc varchar(20) not null,
primary key(cod_funcionario),
foreign key(num_setor) references Setor(cod_setor));

create table Enderecos_fc(
id int auto_increment primary key,
cep varchar(100),
rua varchar (255),
numero int,
complemento varchar (200),
bairro varchar (100),
cidade varchar (100),
uf varchar (2),
id_funcionario int,
    
FOREIGN KEY (id_funcionario) REFERENCES funcionario(cod_funcionario)
);

create table atendimento(
cod_func integer(20) not null,
CPF_cl integer(11) not null,
primary key(cod_func),
foreign key(CPF_cl) references Cadastro_cl(cliente_CPF),
foreign key(cod_func) references funcionario(cod_funcionario));


create table tipoCardapio(
idTipoCardapio integer(11) not null auto_increment,
nome_cardapio varchar(200) not null,
primary key(idTipoCardapio));


create table cardapio(
num_prato integer(20) not null auto_increment,
cod_cardapio integer(20) not null,
nome_prato varchar(200) not null,
descrisao_Qtd_Kg varchar(4) not null,
preco float(3,2) not null,
tempo_preparo time not null,
primary key(num_prato),
foreign key(cod_cardapio) references tipoCardapio(idTipoCardapio));


create table sugestao(
num_sugestao integer(11) not null auto_increment,
nome_prato varchar(200) not null,
primary key(num_sugestao));


create table pedido(
num_pedido integer(11) not null auto_increment,
CPF_cl integer(11) not null,
primary key(num_pedido),
foreign key(CPF_cl) references cadastro_cliente(cliente_CPF));


create table preparo(
cod_func integer(20) not null,
num_ped integer(11) not null,
primary key(cod_func),
foreign key(num_ped) references pedido(num_pedido),
foreign key(CPF_cl) references cadastro_cliente(cliente_CPF),
foreign key(cod_func) references funcionario(cod_funcionario));


create table montagem(
cod_func integer(20) not null,
num_ped integer(11) not null,
primary key(cod_func),
foreign key(num_ped) references pedido(num_pedido),
foreign key(CPF_cl) references cadastro_cliente(cliente_CPF),
foreign key(cod_func) references funcionario(cod_funcionario));


create table notaFiscal(
cod_notaFiscal integer(20) not null auto_increment,
num_ped integer(20) not null,
preco_total float(10,2) not null,
CPF_cl integer(11) not null,
primary key(cod_notaFiscal),
foreign key(num_ped) references pedido(num_pedido),
foreign key(CPF_cl) references cadastro_cliente(cliente_CPF));


create table entrega(
cod_func integer(20) not null,
num_ped integer(11) not null,
cod_nf integer(20) not null,
primary key(cod_func),
foreign key(cod_nf) references notaFiscal(cod_notaFiscal),
foreign key(num_ped) references pedido(num_pedido),
foreign key(CPF_cl) references cadastro_cliente(cliente_CPF),
foreign key(cod_func) references funcionario(cod_funcionario));


create table formaDePagamento(
idFormatoPagamento integer(11) not null unique,
tipoDePagamento varchar(200) not null,
primary key(idFormatoPagamento));


create table pagamento(
cpf_cl integer(11) not null,
cod_nf integer(20) not null,
tipoPago varchar(200) not null,
primary key(cpf_cl),
foreign key(tipoPago) references formaDePagamento(idFormatoPagament),
foreign key(cpf_cl) references cadastro_cliente(cliente_CPF),
foreign key(cod_nf) references nota_fiscal(cod_notaFiscal));

*/