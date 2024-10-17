/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DTO;

/**
 *
 * @author aluno.saolucas
 */
public class ClienteDTO {
    
    private int id_cliente;
    private String nome_cli, endereco_cli, telefone_cli, email_cli, cpfOUcnpj_cli;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_cli() {
        return nome_cli;
    }

    public void setNome_cli(String nome_cli) {
        this.nome_cli = nome_cli;
    }

    public String getEndereco_cli() {
        return endereco_cli;
    }

    public void setEndereco_cli(String endereco_cli) {
        this.endereco_cli = endereco_cli;
    }

    public String getTelefone_cli() {
        return telefone_cli;
    }

    public void setTelefone_cli(String telefone_cli) {
        this.telefone_cli = telefone_cli;
    }

    public String getEmail_cli() {
        return email_cli;
    }

    public void setEmail_cli(String email_cli) {
        this.email_cli = email_cli;
    }

    public String getCpfOUcnpj_cli() {
        return cpfOUcnpj_cli;
    }

    public void setCpfOUcnpj_cli(String cpfOUcnpj_cli) {
        this.cpfOUcnpj_cli = cpfOUcnpj_cli;
    }
    
    

    
}
