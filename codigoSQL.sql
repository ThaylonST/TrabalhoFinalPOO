

create database bdaulaprojeto;
use bdaulaprojeto;

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
idcli int primary key auto_increment,
nomecli varchar(50) not null,
enderecocli varchar(30) not null,
telefonecli varchar(30) not null unique,
emailcli varchar(30),
cpfOUcnpjcli varchar(50) not null unique
);

describe tb_clientes;

select * from tb_clientes;

insert into tb_clientes(nomecli,enderecocli,telefonecli,emailcli,cpfOUcnpjcli)
values("rafael","los santos", 13123, "rafael@gmail", 4123);

CREATE TABLE tb_agenda(
  id INT AUTO_INCREMENT PRIMARY KEY,
  data DATE NOT NULL,
  hora TIME NOT NULL, 
  descricao VARCHAR(255),               
  cliente_id INT,                      
  FOREIGN KEY (cliente_id) REFERENCES tb_clientes(idcli) 
);

INSERT INTO tb_agenda (data, hora, descricao, cliente_id) 
VALUES ('2024-10-18', '09:00:00', 'projeto', 1);

select * from tb_agenda;