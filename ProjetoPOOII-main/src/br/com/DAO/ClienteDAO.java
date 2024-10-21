package br.com.DAO;

import br.com.DTO.ClienteDTO;
import br.com.views.TelaClientes;
import static br.com.views.TelaClientes.TbCliente;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // Método para inserir um cliente
    public void inserirCliente(ClienteDTO objClienteDTO) {
        String sql = "INSERT INTO tb_clientes (nomecli, enderecocli, telefonecli, emailcli, cpfOUcnpjcli)"
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
       String sql = "SELECT * FROM tb_clientes WHERE idcli = ?";  // Alterado para idcli
    conexao = ConexaoDAO.conector();
    ClienteDTO cliente = null;
    
    try {
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, idCliente);
        rs = pst.executeQuery();
        
        if (rs.next()) {
            cliente = new ClienteDTO();
            cliente.setId_cliente(rs.getInt("idcli"));  // Alterado para idcli
            cliente.setNome_cli(rs.getString("nomecli"));
            cliente.setEndereco_cli(rs.getString("enderecocli"));
            cliente.setTelefone_cli(rs.getString("telefonecli"));
            cliente.setEmail_cli(rs.getString("emailcli"));
            cliente.setCpfOUcnpj_cli(rs.getString("cpfOUcnpjcli"));
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
        String sql = "UPDATE tb_clientes SET nomecli = ?, enderecocli = ?, telefonecli = ?, emailcli = ?, cpfOUcnpjcli = ?"
                   + " WHERE idcli = ?";
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
        String sql = "DELETE FROM tb_clientes WHERE idcli = ?";
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
    
    // Método para listar todos os clientes
public ResultSet listarClientes() {
    String sql = "SELECT idcli, nomecli, enderecocli, telefonecli, emailcli FROM tb_clientes";
    conexao = ConexaoDAO.conector();
    
    try {
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + e.getMessage());
    }
    
    return rs;  // Retorna o ResultSet contendo os dados dos clientes
}

    
    
   public void atualizarTabelaClientes(DefaultTableModel model) {
    try {
        ResultSet rs = listarClientes(); // Método que retorna os clientes cadastrados

        // Limpa a tabela antes de atualizar
        model.setRowCount(0); 

        // Adiciona os clientes na tabela
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("idcli"), 
                rs.getString("nomecli"),
                rs.getString("emailcli"),
                rs.getString("enderecocli"),
                rs.getString("telefonecli")
            });
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar a tabela de clientes: " + e.getMessage());
    }
}
}
