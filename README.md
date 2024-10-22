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
          <img src="https://avatars.githubusercontent.com/u/130706226?v=4" width="75px;" alt="Foto de Gabriel"/>
          <br />
          <sub><b>Gabriel</b></sub>
        </a>
      </td>
    </tr>
  </table>
</div>

<h1>Documentação da Pasta <code>br.com.DAO</code></h1>

<h2>Visão Geral</h2>
<p>A pasta <code>br.com.DAO</code> contém classes que interagem diretamente com o banco de dados, sendo responsáveis pela execução de operações de CRUD (Create, Read, Update, Delete) para diferentes entidades do sistema. Ela inclui a conexão com o banco de dados e métodos que manipulam os dados de clientes, usuários e agendas.</p>

<h2>Estrutura de Classes:</h2>
<ul>
    <li><code>ConexaoDAO</code>: Responsável por estabelecer a conexão com o banco de dados.</li>
    <li><code>UsuarioDAO</code>: Gerencia as operações relacionadas à tabela de usuários.</li>
    <li><code>ClienteDAO</code>: Controla as operações relacionadas à tabela de clientes.</li>
    <li><code>AgendaDAO</code>: (Em desenvolvimento) Será responsável pelas operações de agendamento.</li>
</ul>

<h2>Classes e Métodos</h2>

<h3>1. <code>ConexaoDAO</code></h3>
<p>Esta classe é responsável por estabelecer a conexão com o banco de dados MySQL.</p>

<h4>Métodos:</h4>
<ul>
    <li><code>conector()</code>: Estabelece e retorna uma conexão com o banco de dados MySQL. Utiliza o driver JDBC <code>com.mysql.cj.jdbc.Driver</code>, com parâmetros para fuso horário e timezone. Caso ocorra um erro, ele exibe uma mensagem e retorna <code>null</code>.</li>
</ul>

<h4>Exemplo de Conexão:</h4>
<pre><code>Connection conexao = ConexaoDAO.conector();
if (conexao != null) {
    System.out.println("Conexão estabelecida com sucesso!");
} else {
    System.out.println("Erro ao conectar ao banco de dados.");
}
</code></pre>

<h3>2. <code>UsuarioDAO</code></h3>
<p>Esta classe contém métodos para gerenciar os dados de usuários, como login, inserção, edição, exclusão e pesquisa de usuários.</p>

<h4>Métodos Principais:</h4>
<ul>
    <li><code>logar(UsuarioDTO objusuarioDTO, TelaUsuario telaUsuario)</code>: Valida o login do usuário com base no login e senha fornecidos. Abre a interface <code>TelaPrincipal</code> dependendo do perfil do usuário (admin ou comum) e permite o acesso a funcionalidades específicas.</li>
    <li><code>inserirUsuario(UsuarioDTO objUsuarioDTO, TelaUsuario telaUsuario)</code>: Insere um novo usuário no banco de dados e atualiza a tabela de usuários na interface.</li>
    <li><code>pesquisar(UsuarioDTO objUsuarioDTO, TelaUsuario telaUsuario)</code>: Pesquisa um usuário pelo ID e preenche os campos de entrada na <code>TelaUsuario</code>.</li>
    <li><code>editar(UsuarioDTO objUsuarioDTO, TelaUsuario telaUsuario)</code>: Edita as informações de um usuário existente no banco de dados.</li>
    <li><code>deletar(UsuarioDTO objUsuarioDTO, TelaUsuario telaUsuario)</code>: Exclui um usuário da tabela com base no ID fornecido.</li>
    <li><code>pesquisaAuto()</code>: Preenche automaticamente a tabela de usuários na interface <code>TelaUsuario</code>.</li>
</ul>

<h3>3. <code>ClienteDAO</code></h3>
<p>Responsável pelas operações CRUD para a tabela de clientes.</p>

<h4>Métodos Principais:</h4>
<ul>
    <li><code>inserirCliente(ClienteDTO objClienteDTO)</code>: Insere um novo cliente no banco de dados. Recebe os dados através de um objeto <code>ClienteDTO</code>.</li>
    <li><code>pesquisarCliente(int idCliente)</code>: Pesquisa um cliente pelo ID e retorna os dados em um objeto <code>ClienteDTO</code>.</li>
    <li><code>atualizarCliente(ClienteDTO objClienteDTO)</code>: Atualiza os dados de um cliente no banco de dados.</li>
    <li><code>deletarCliente(int idCliente)</code>: Exclui um cliente da tabela <code>tb_clientes</code> com base no ID fornecido.</li>
    <li><code>listarClientes()</code>: Retorna todos os clientes cadastrados no banco de dados através de um <code>ResultSet</code>.</li>
    <li><code>atualizarTabelaClientes(DefaultTableModel model)</code>: Atualiza a tabela de clientes na interface <code>TelaClientes</code> com os dados atuais do banco.</li>
</ul>

<h2>Como Executar e Conectar ao Banco de Dados</h2>

<h3>1. Configuração da Conexão</h3>
<p>As classes utilizam o <code>ConexaoDAO</code> para se conectar ao banco de dados MySQL. Certifique-se de que as configurações de URL, usuário e senha estão corretas.</p>

<ul>
    <li><strong>Driver</strong>: <code>com.mysql.cj.jdbc.Driver</code></li>
    <li><strong>URL de Conexão</strong>: <code>jdbc:mysql://localhost:3306/bdaulaprojeto?useTimezone=true&serverTimezone=UTC</code></li>
    <li><strong>Usuário</strong>: <code>root</code></li>
    <li><strong>Senha</strong>: <code>root</code></li>
</ul>

<h3>2. Criação do Banco de Dados</h3>
<p>Use o seguinte script para criar e popular o banco de dados.</p>

<pre><code>create database bdaulaprojeto;
use bdaulaprojeto;

create table tb_usuarios(
id_usuario int primary key,
usuario varchar(50) not null,
login varchar(50) not null unique,
senha varchar(15) not null,
perfil varchar(30)
);

insert into tb_usuarios(id_usuario, usuario, login, senha, perfil)
values(1, 'administrador', 'root', 'root', 'admin');

create table tb_clientes(
idcli int primary key auto_increment,
nomecli varchar(50) not null,
enderecocli varchar(30) not null,
telefonecli varchar(30) not null unique,
emailcli varchar(30),
cpfOUcnpjcli varchar(50) not null unique
);

insert into tb_clientes(nomecli, enderecocli, telefonecli, emailcli, cpfOUcnpjcli)
values("rafael", "los santos", 13123, "rafael@gmail.com", 4123);
</code></pre>

<h3>3. Execução</h3>
<p>Após garantir que o banco de dados está configurado corretamente, basta executar a aplicação através da interface gráfica (GUI). A aplicação se conectará automaticamente ao banco de dados e permitirá o gerenciamento de usuários e clientes.</p>

<h1>Documentação da Pasta <code>br.com.DTO</code></h1>

<h2>Classe <code>AgendaDTO</code></h2>
<p>A classe <code>AgendaDTO</code> representa os dados de uma agenda, incluindo a data, horário, descrição e o cliente associado.</p>
<h3>Atributos:</h3>
<ul>
    <li><strong>data</strong>: Representa a data do agendamento (tipo <code>Date</code>).</li>
    <li><strong>horario</strong>: Representa o horário do agendamento (tipo <code>String</code>).</li>
    <li><strong>descricao</strong>: Descreve o motivo ou detalhes do agendamento (tipo <code>String</code>).</li>
    <li><strong>cliente</strong>: Referência ao cliente associado a esse agendamento (tipo <code>ClienteDTO</code>).</li>
</ul>

<h3>Métodos:</h3>
<ul>
    <li><code>getData()</code>: Retorna a data do agendamento.</li>
    <li><code>setData(Date data)</code>: Define a data do agendamento.</li>
    <li><code>getHorario()</code>: Retorna o horário do agendamento.</li>
    <li><code>setHorario(String horario)</code>: Define o horário do agendamento.</li>
    <li><code>getDescricao()</code>: Retorna a descrição do agendamento.</li>
    <li><code>setDescricao(String descricao)</code>: Define a descrição do agendamento.</li>
    <li><code>getCliente()</code>: Retorna o cliente associado ao agendamento.</li>
    <li><code>setCliente(ClienteDTO cliente)</code>: Define o cliente associado ao agendamento.</li>
</ul>

<h2>Classe <code>ClienteDTO</code></h2>
<p>A classe <code>ClienteDTO</code> é utilizada para representar os dados de um cliente no sistema, incluindo informações como nome, endereço, telefone, e-mail, e CPF/CNPJ.</p>

<h3>Atributos:</h3>
<ul>
    <li><strong>nomecli</strong>: Nome do cliente (tipo <code>String</code>).</li>
    <li><strong>enderecocli</strong>: Endereço do cliente (tipo <code>String</code>).</li>
    <li><strong>telefonecli</strong>: Telefone do cliente (tipo <code>String</code>).</li>
    <li><strong>emailcli</strong>: E-mail do cliente (tipo <code>String</code>).</li>
    <li><strong>cpfOUcnpjcli</strong>: CPF ou CNPJ do cliente (tipo <code>String</code>).</li>
</ul>

<h3>Métodos:</h3>
<ul>
    <li><code>getNomecli()</code>: Retorna o nome do cliente.</li>
    <li><code>setNomecli(String nomecli)</code>: Define o nome do cliente.</li>
    <li><code>getEnderecocli()</code>: Retorna o endereço do cliente.</li>
    <li><code>setEnderecocli(String enderecocli)</code>: Define o endereço do cliente.</li>
    <li><code>getTelefonecli()</code>: Retorna o telefone do cliente.</li>
    <li><code>setTelefonecli(String telefonecli)</code>: Define o telefone do cliente.</li>
    <li><code>getEmailcli()</code>: Retorna o e-mail do cliente.</li>
    <li><code>setEmailcli(String emailcli)</code>: Define o e-mail do cliente.</li>
    <li><code>getCpfOUcnpjcli()</code>: Retorna o CPF ou CNPJ do cliente.</li>
    <li><code>setCpfOUcnpjcli(String cpfOUcnpjcli)</code>: Define o CPF ou CNPJ do cliente.</li>
</ul>

<h2>Classe <code>UsuarioDTO</code></h2>
<p>A classe <code>UsuarioDTO</code> é utilizada para armazenar as informações de um usuário no sistema.</p>

<h3>Atributos:</h3>
<ul>
    <li><strong>usuario</strong>: Nome do usuário (tipo <code>String</code>).</li>
    <li><strong>login</strong>: Login do usuário (tipo <code>String</code>).</li>
    <li><strong>senha</strong>: Senha do usuário (tipo <code>String</code>).</li>
    <li><strong>perfil</strong>: Perfil do usuário (tipo <code>String</code>).</li>
</ul>

<h3>Métodos:</h3>
<ul>
    <li><code>getUsuario()</code>: Retorna o nome do usuário.</li>
    <li><code>setUsuario(String usuario)</code>: Define o nome do usuário.</li>
    <li><code>getLogin()</code>: Retorna o login do usuário.</li>
    <li><code>setLogin(String login)</code>: Define o login do usuário.</li>
    <li><code>getSenha()</code>: Retorna a senha do usuário.</li>
    <li><code>setSenha(String senha)</code>: Define a senha do usuário.</li>
    <li><code>getPerfil()</code>: Retorna o perfil do usuário.</li>
    <li><code>setPerfil(String perfil)</code>: Define o perfil do usuário.</li>
</ul>

<h1>Conclusão</h1>
<p>O projeto visa facilitar o gerenciamento de usuários e clientes, integrando funcionalidades de CRUD em um sistema que interage com um banco de dados MySQL. A estrutura organizada em pacotes facilita a manutenção e a escalabilidade do sistema.</p>

<p>Para mais informações, consulte os comentários no código-fonte ou entre em contato com os desenvolvedores.</p>
