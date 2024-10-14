
# ProjetoPOOII

## Participantes

<div align="center">
  <table>
    <tr>
      <td align="center">
        <a href="https://github.com/ThaylonST">
          <img src="https://avatars.githubusercontent.com/u/136936975?v=4" width="75px;" alt="Foto de Thaylon"/>
          <br />
          <sub><b>Thaylon</b></sub>
        </a>
      </td>
      <td align="center">
        <a href="https://github.com/1GabrielC">
          <img src="https://avatars.githubusercontent.com/u/130706226?v=4" width="75px;" alt="Foto de gabriel"/>
          <br />
          <sub><b>Gabriel</b></sub>
        </a>
      </td>
    </tr>
  </table>
</div>




## CODIGO MYSQL:

```sql
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

