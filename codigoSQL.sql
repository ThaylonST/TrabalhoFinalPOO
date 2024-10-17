


create table tb_usuarios(
id_usuario int primary key,
usuario varchar(50) not null,
login varchar(50) not null unique,
senha varchar(15)not null

);

ALTER TABLE tb_usuarios MODIFY id_usuario INT AUTO_INCREMENT;

describe tb_usuarios;

insert into tb_usuarios(id_usuario, usuario, login, senha, perfil)
values(1, 'administrador', 'root', 'root', 'admin');



ALTER TABLE tb_usuarios 	
ADD COLUMN perfil varchar(30);


select * from tb_usuarios;

create table tb_clientes(
 idcli INT PRIMARY KEY AUTO_INCREMENT,
nomecli varchar(50) not null,
enderecocli varchar(30) not null,
telefonecli varchar(30) not null unique,
emailcli varchar(30) not null unique,
cpfOUcnpjcli varchar(50) not null unique
);

select * from tb_clientes;







