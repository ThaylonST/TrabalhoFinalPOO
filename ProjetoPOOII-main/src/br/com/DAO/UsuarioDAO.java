package br.com.DAO;

import br.com.DTO.UsuarioDTO;
import br.com.views.TelaPrincipal;
import br.com.views.TelaUsuario;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eder
 */
public class UsuarioDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public boolean logar(UsuarioDTO objusuarioDTO, TelaUsuario telaUsuario) {
        String sql = "select * from tb_usuarios where login = ? and senha = ?";
    conexao = ConexaoDAO.conector();
    boolean sucesso = false;

    try {
        // Prepara a consulta no banco de dados
        pst = conexao.prepareStatement(sql);
        pst.setString(1, objusuarioDTO.getLogin_usuario());
        pst.setString(2, objusuarioDTO.getSenha_usuario());

        // Executa a query
        rs = pst.executeQuery();

        // Verifica se existe um usuário com o login e senha informados
        if (rs.next()) {
            String perfil = rs.getString(5);

            // Trata o perfil do usuário
            if (perfil.equals("admin")) {
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);
                TelaPrincipal.MenuRel.setEnabled(true);
                TelaPrincipal.subMenuUsuarios.setEnabled(true);
                TelaPrincipal.lblUsuarioPrincipal.setText(rs.getString(2));
                TelaPrincipal.lblUsuarioPrincipal.setForeground(Color.RED);
            } else {
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);
                TelaPrincipal.lblUsuarioPrincipal.setText(rs.getString(2));
                TelaPrincipal.lblUsuarioPrincipal.setForeground(Color.BLUE);
            }

            // Agora usamos a instância passada como parâmetro
            telaUsuario.setVisible(true);  // Abre a tela de usuários
            pesquisaAuto();  // Chama o método para preencher a tabela de usuários

            sucesso = true;
            conexao.close();  // Fecha a conexão
        } else {
            JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro no login: " + e);
    }

    return sucesso;
}
    
    public void limparCampos(TelaUsuario telaUsuario) {
    telaUsuario.txtIdUsu.setText(null);
    telaUsuario.txtLoginUsu.setText(null);
    telaUsuario.txtNomeUsu.setText(null);
    telaUsuario.txtSenhaUsu.setText(null);
    telaUsuario.cboPerfilUsu.setSelectedItem(1); // Ou o que for o valor padrão
}



    public void inserirUsuario(UsuarioDTO objUsuarioDTO, TelaUsuario telaUsuario) {
        String sql = "insert into tb_usuarios (id_usuario, usuario, login, senha, perfil)"
                + " values (?, ?, ?, ?, ?)";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objUsuarioDTO.getId_uauario());
            pst.setString(2, objUsuarioDTO.getNome_usuario());
            pst.setString(3, objUsuarioDTO.getLogin_usuario());
            pst.setString(4, objUsuarioDTO.getSenha_usuario());
            pst.setString(5, objUsuarioDTO.getPerfil_usuario());
            int add = pst.executeUpdate();
            if (add > 0) {
                pesquisaAuto();
                pst.close();
                limparCampos(telaUsuario);
                JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso! ");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " Método Inserir " + e);
        }
    }

    public void pesquisar(UsuarioDTO objUsuarioDTO, TelaUsuario telaUsuario) {
        String sql = "select * from tb_usuarios where id_usuario = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objUsuarioDTO.getId_uauario());
            rs = pst.executeQuery();

            if (rs.next()) {
                // Usando a instância da tela passada como parâmetro
                telaUsuario.txtNomeUsu.setText(rs.getString(2));
                telaUsuario.txtLoginUsu.setText(rs.getString(3));
                telaUsuario.txtSenhaUsu.setText(rs.getString(4)); // Agora usando a instância
                telaUsuario.cboPerfilUsu.setSelectedItem(rs.getString(5));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
                limparCampos(telaUsuario); // Chamando o método limparCampos com a instância da tela
            }

            conexao.close(); // Fechando a conexão após uso
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método Pesquisar: " + e);
        }
    }

    public void pesquisaAuto() {
        String sql = "select * from tb_usuarios";
        conexao = ConexaoDAO.conector();

        // Verificar se a conexão foi estabelecida corretamente
        if (conexao == null) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco de dados.");
            return;
        }

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) TelaUsuario.TbUsuarios.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nome = rs.getString("usuario");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                String perfil = rs.getString("perfil");
                model.addRow(new Object[]{id, nome, login, senha, perfil});
            }
            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar pesquisa automática: " + e.getMessage());
        }
    }

    //Método editar
    public void editar(UsuarioDTO objUsuarioDTO, TelaUsuario telaUsuario) {
        String sql = "update tb_usuarios set usuario = ?, login = ?, senha = ?, perfil = ? where id_usuario = ?";
        conexao = ConexaoDAO.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(5, objUsuarioDTO.getId_uauario());
            pst.setString(4, objUsuarioDTO.getPerfil_usuario());
            pst.setString(3, objUsuarioDTO.getSenha_usuario());
            pst.setString(2, objUsuarioDTO.getLogin_usuario());
            pst.setString(1, objUsuarioDTO.getNome_usuario());
            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!");
                pesquisaAuto();
                conexao.close();
                limparCampos(telaUsuario);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método editar " + e);
        }
    }

    //Método deletar
    public void deletar(UsuarioDTO objUsuarioDTO, TelaUsuario telaUsuario) {
        String sql = "delete from tb_usuarios where id_usuario = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objUsuarioDTO.getId_uauario());
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, " Usuário deletado com sucesso!");
                pesquisaAuto();
                conexao.close();
                limparCampos(telaUsuario);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método deletar " + e);
        }
    }

    
}
