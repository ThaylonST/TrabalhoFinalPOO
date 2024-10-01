# TrabalhoFinalBD

## Participantes

<div align="center">
  <table>
    <tr>
      <td align="center">
        <a href="https://github.com/ThaylonST">
          <img src="https://avatars.githubusercontent.com/u/136936975?v=4" width="75px;" alt="Foto de Thaylon dos Santos"/>
          <br />
          <sub><b>Thaylon dos Santos</b></sub>
        </a>
      </td>
    </tr>
  </table>
</div>


## CODIGO MYSQL:

```sql

create database trabalhofinalbd;
use trabalhofinalbd;

create table tb_usuarios(
id_usuario int primary key,
usuario varchar(50) not null,
login varchar(50) not null unique,
senha varchar(15)not null
);

insert into tb_usuarios(id_usuario, usuario, login, senha)
values(0, 'administrador', 'admin', 'admin');

select * from tb_usuarios;
```
