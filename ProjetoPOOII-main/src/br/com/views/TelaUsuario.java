/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.views;

/**
 *
 * @author Eder
 */
import java.sql.*;
import br.com.DAO.ConexaoDAO;
import br.com.DAO.UsuarioDAO;
import br.com.DTO.UsuarioDTO;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private TelaPrincipal telaPrincipal; 

    // Construtor que aceita TelaPrincipal
    public TelaUsuario(TelaPrincipal telaPrincipal) {
        initComponents();
        this.telaPrincipal = telaPrincipal; // Armazena a referência
        conexao = ConexaoDAO.conector();
        UsuarioDAO ojbUsuarioDAO = new UsuarioDAO();
        ojbUsuarioDAO.pesquisaAuto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdUsu = new javax.swing.JTextField();
        txtNomeUsu = new javax.swing.JTextField();
        txtLoginUsu = new javax.swing.JTextField();
        cboPerfilUsu = new javax.swing.JComboBox<>();
        btnUsuCreate = new javax.swing.JButton();
        btnUsuread = new javax.swing.JButton();
        btnUsuUpdate = new javax.swing.JButton();
        btnUsuDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbUsuarios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSenhaUsu = new javax.swing.JPasswordField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(102, 0, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setPreferredSize(new java.awt.Dimension(604, 500));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 110, 50, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Login:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 180, 50, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Senha:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 250, 50, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Perfil:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 320, 48, 22);

        txtIdUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdUsuActionPerformed(evt);
            }
        });
        getContentPane().add(txtIdUsu);
        txtIdUsu.setBounds(10, 60, 250, 35);
        getContentPane().add(txtNomeUsu);
        txtNomeUsu.setBounds(10, 130, 250, 35);

        txtLoginUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginUsuActionPerformed(evt);
            }
        });
        getContentPane().add(txtLoginUsu);
        txtLoginUsu.setBounds(10, 200, 250, 35);

        cboPerfilUsu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cboPerfilUsu.setForeground(new java.awt.Color(0, 0, 0));
        cboPerfilUsu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));
        cboPerfilUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPerfilUsuActionPerformed(evt);
            }
        });
        getContentPane().add(cboPerfilUsu);
        cboPerfilUsu.setBounds(10, 340, 250, 40);

        btnUsuCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/person_add.png"))); // NOI18N
        btnUsuCreate.setToolTipText("Adicionar");
        btnUsuCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUsuCreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuCreateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuCreate);
        btnUsuCreate.setBounds(410, 380, 80, 70);

        btnUsuread.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/search.png"))); // NOI18N
        btnUsuread.setToolTipText("Pesquisar");
        btnUsuread.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUsuread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsureadActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuread);
        btnUsuread.setBounds(520, 380, 80, 70);

        btnUsuUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/update.png"))); // NOI18N
        btnUsuUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUsuUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuUpdate);
        btnUsuUpdate.setBounds(630, 380, 80, 70);

        btnUsuDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/delete_.png"))); // NOI18N
        btnUsuDelete.setToolTipText("Excluir");
        btnUsuDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUsuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuDelete);
        btnUsuDelete.setBounds(740, 380, 80, 70);

        TbUsuarios.setForeground(new java.awt.Color(0, 0, 0));
        TbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Login", "Senha", "Perfil"
            }
        ));
        TbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbUsuariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbUsuarios);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(270, 20, 560, 350);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(280, 400, 100, 29);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Tela Usuarios");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(80, 10, 130, 22);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Id:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 40, 21, 17);
        getContentPane().add(txtSenhaUsu);
        txtSenhaUsu.setBounds(10, 270, 250, 35);

        setBounds(0, 0, 846, 494);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdUsuActionPerformed

    private void txtLoginUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginUsuActionPerformed

    private void btnUsuCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuCreateActionPerformed
        int id_usuario = Integer.parseInt(txtIdUsu.getText());
        String nome_usuario = txtNomeUsu.getText();
        String login_usuario = txtLoginUsu.getText();
        String senha_usuario = txtSenhaUsu.getText();
        String perfil_usuario = cboPerfilUsu.getSelectedItem().toString();

        UsuarioDTO objusuarioDTO = new UsuarioDTO();
        objusuarioDTO.setId_uauario(id_usuario);
        objusuarioDTO.setNome_usuario(nome_usuario);
        objusuarioDTO.setLogin_usuario(login_usuario);
        objusuarioDTO.setSenha_usuario(senha_usuario);
        objusuarioDTO.setPerfil_usuario(perfil_usuario);

        UsuarioDAO objUsuarioDAO = new UsuarioDAO();
        objUsuarioDAO.inserirUsuario(objusuarioDTO, this);
    }//GEN-LAST:event_btnUsuCreateActionPerformed

    private void btnUsuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuDeleteActionPerformed
        //Botão Deletar
        int id_usuario = Integer.parseInt(txtIdUsu.getText());
        UsuarioDTO objusuarioDTO = new UsuarioDTO();
        objusuarioDTO.setId_uauario(id_usuario);
        
        UsuarioDAO objUsuarioDAO = new UsuarioDAO();
        objUsuarioDAO.deletar(objusuarioDTO, this);
    }//GEN-LAST:event_btnUsuDeleteActionPerformed

    private void btnUsureadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsureadActionPerformed
        //Botão Pesquisar
        int id_usuario = Integer.parseInt(txtIdUsu.getText());
        String nome_usuario = txtNomeUsu.getText();
        String login_usuario = txtLoginUsu.getText();
        String senha_usuario = txtSenhaUsu.getText();
        String perfil_usuario = cboPerfilUsu.getSelectedItem().toString();

        UsuarioDTO objusuarioDTO = new UsuarioDTO();
        objusuarioDTO.setId_uauario(id_usuario);
        objusuarioDTO.setNome_usuario(nome_usuario);
        objusuarioDTO.setLogin_usuario(login_usuario);
        objusuarioDTO.setSenha_usuario(senha_usuario);
        objusuarioDTO.setPerfil_usuario(perfil_usuario);

        UsuarioDAO objUsuarioDAO = new UsuarioDAO();
        objUsuarioDAO.pesquisar(objusuarioDTO, this);
    }//GEN-LAST:event_btnUsureadActionPerformed

    private void btnUsuUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuUpdateActionPerformed
        // Botão Editar
        int id_usuario = Integer.parseInt(txtIdUsu.getText());
        String nome_usuario = txtNomeUsu.getText();
        String login_usuario = txtLoginUsu.getText();
        String senha_usuario = txtSenhaUsu.getText();
        String perfil_usuario = cboPerfilUsu.getSelectedItem().toString();

        UsuarioDTO objusuarioDTO = new UsuarioDTO();
        objusuarioDTO.setId_uauario(id_usuario);
        objusuarioDTO.setNome_usuario(nome_usuario);
        objusuarioDTO.setLogin_usuario(login_usuario);
        objusuarioDTO.setSenha_usuario(senha_usuario);
        objusuarioDTO.setPerfil_usuario(perfil_usuario);

        UsuarioDAO objUsuarioDAO = new UsuarioDAO();
        objUsuarioDAO.editar(objusuarioDTO, this);
    }//GEN-LAST:event_btnUsuUpdateActionPerformed

    private void TbUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbUsuariosMouseClicked
        //Busca itens da tabela para os campos do formulário
        int linhaSel = TbUsuarios.getSelectedRow();
        if(linhaSel != -1 ){
            String id_usuario = TbUsuarios.getValueAt(linhaSel, 0).toString();
            String nome_usuario = TbUsuarios.getValueAt(linhaSel, 1).toString();
            String login_usuario = TbUsuarios.getValueAt(linhaSel, 2).toString();
            String senha_usuario = TbUsuarios.getValueAt(linhaSel, 3).toString();
            String perfil_usuario = TbUsuarios.getValueAt(linhaSel, 4).toString();
            
            txtIdUsu.setText(id_usuario);
            txtNomeUsu.setText(nome_usuario);
            txtLoginUsu.setText(login_usuario);
            txtSenhaUsu.setText(senha_usuario);
            cboPerfilUsu.setSelectedItem(perfil_usuario);
        }
    }//GEN-LAST:event_TbUsuariosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Botão limpar campos
        UsuarioDAO objusuarioDAO = new UsuarioDAO();
        objusuarioDAO.limparCampos(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboPerfilUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPerfilUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPerfilUsuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TbUsuarios;
    private javax.swing.JButton btnUsuCreate;
    private javax.swing.JButton btnUsuDelete;
    private javax.swing.JButton btnUsuUpdate;
    private javax.swing.JButton btnUsuread;
    public static javax.swing.JComboBox<String> cboPerfilUsu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTextField txtIdUsu;
    public static javax.swing.JTextField txtLoginUsu;
    public static javax.swing.JTextField txtNomeUsu;
    public javax.swing.JPasswordField txtSenhaUsu;
    // End of variables declaration//GEN-END:variables
}
