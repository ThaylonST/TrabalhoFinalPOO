package br.com.DAO;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexaoDAO {

    public static Connection conector() {
        Connection conexao = null;

        // Mude para o novo driver
        String driver = "com.mysql.cj.jdbc.Driver";
        
        // URL de conexão
        String url = "jdbc:mysql://localhost:3306/bdaulaprojeto?useTimezone=true&serverTimezone=UTC"; // Adicione parâmetros para o fuso horário
        String user = "root";
        String password = "root";

        try {
            // Carrega o novo driver
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Conexão: " + e.getMessage());
            return null;
        }
    }
}
