CREATE TABLE funcionario (
id int auto_increment primary key,
cpf varchar (14) not null,
nome varchar (100) not null,
senha varchar (20) not null,
email varchar (50) not null,
telefone varchar(15) not null,
funcao  varchar(20) not null

);

CREATE TABLE  produto(
id int auto_increment primary key,
codigo int not null,
nome varchar(100) not null,
descricao  varchar(500) not null,
preco real not null,
fabricante varchar(50) not null,
qtdestoque int not null,
imagem  varchar(50) not null,
especificacao varchar(15000) not null,
categoriaprodutofk int not null,
foreign key (categoriaprodutofk) references categoriaproduto(id)
);	

create table categoriaproduto(

id int auto_increment primary key,
descricao varchar(50) not null
);

Create table contato(
id int auto_increment primary key,
nome varchar(100) not null,
email varchar(100) not null,
mensagem varchar(500) not null
);
