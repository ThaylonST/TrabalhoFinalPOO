package br.com.DAO;

import br.com.DTO.ClienteDTO;
import br.com.views.TelaClientes;
import java.sql.*;
import javax.swing.JOptionPane;

public class ClienteDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // Método para inserir um cliente
    public void inserirCliente(ClienteDTO objClienteDTO) {
        String sql = "INSERT INTO tb_clientes (nome_cli, endereco_cli, telefone_cli, email_cli, cpfOUcnpj_cli)"
                   + " VALUES (?, ?, ?, ?, ?)";
        conexao = ConexaoDAO.conector();
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objClienteDTO.getNome_cli());
            pst.setString(2, objClienteDTO.getEndereco_cli());
            pst.setString(3, objClienteDTO.getTelefone_cli());
            pst.setString(4, objClienteDTO.getEmail_cli());
            pst.setString(5, objClienteDTO.getCpfOUcnpj_cli());
            
            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir cliente: " + e.getMessage());
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    // Método para pesquisar um cliente por ID
    public ClienteDTO pesquisarCliente(int idCliente) {
        String sql = "SELECT * FROM tb_clientes WHERE id_cliente = ?";
        conexao = ConexaoDAO.conector();
        ClienteDTO cliente = null;
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, idCliente);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                cliente = new ClienteDTO();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNome_cli(rs.getString("nome_cli"));
                cliente.setEndereco_cli(rs.getString("endereco_cli"));
                cliente.setTelefone_cli(rs.getString("telefone_cli"));
                cliente.setEmail_cli(rs.getString("email_cli"));
                cliente.setCpfOUcnpj_cli(rs.getString("cpfOUcnpj_cli"));
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar cliente: " + e.getMessage());
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
        
        return cliente;
    }

    // Método para atualizar um cliente
    public void atualizarCliente(ClienteDTO objClienteDTO) {
        String sql = "UPDATE tb_clientes SET nome_cli = ?, endereco_cli = ?, telefone_cli = ?, email_cli = ?, cpfOUcnpj_cli = ?"
                   + " WHERE id_cliente = ?";
        conexao = ConexaoDAO.conector();
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objClienteDTO.getNome_cli());
            pst.setString(2, objClienteDTO.getEndereco_cli());
            pst.setString(3, objClienteDTO.getTelefone_cli());
            pst.setString(4, objClienteDTO.getEmail_cli());
            pst.setString(5, objClienteDTO.getCpfOUcnpj_cli());
            pst.setInt(6, objClienteDTO.getId_cliente());
            
            int update = pst.executeUpdate();
            if (update > 0) {
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente: " + e.getMessage());
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    // Método para deletar um cliente
    public void deletarCliente(int idCliente) {
        String sql = "DELETE FROM tb_clientes WHERE id_cliente = ?";
        conexao = ConexaoDAO.conector();
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, idCliente);
            
            int delete = pst.executeUpdate();
            if (delete > 0) {
                JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar cliente: " + e.getMessage());
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
    public void limparCampos() {
        TelaClientes.txtIdCli.setText(null);
        TelaClientes.txtEmailCli.setText(null);
        TelaClientes.txtNomeCli.setText(null);
      
    }
}
