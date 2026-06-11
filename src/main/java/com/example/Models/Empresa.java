package com.example.Models;

public class Empresa {

    private String nome;
    private String cnpj;
    private String razaoSocial;
    private String areaAtuacao;

    public Cliente(String nome, String email, String cpf, String telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
    }


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }
    public String getSenha(){
        return senha;
    }
}