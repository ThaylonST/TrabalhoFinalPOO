


create table tb_usuarios(
id_usuario int primary key,
usuario varchar(50) not null,
login varchar(50) not null unique,
senha varchar(15)not null

);

insert into tb_usuarios(id_usuario, usuario, login, senha, perfil)
values(1, 'administrador', 'root', 'root', 'admin');

ALTER TABLE tb_usuarios 	
ADD COLUMN perfil varchar(30);


select * from tb_usuarios;


create table tb_clientes(
nome varchar(50) not null,
endereco varchar(30) not null,
telefone varchar(30) not null unique,
email varchar(30) not null unique,
cpfOUcnpj varchar(50) not null unique
);
