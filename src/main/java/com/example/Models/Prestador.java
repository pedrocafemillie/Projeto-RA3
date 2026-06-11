package com.example.Models;

public class Prestador {

    private String nome;
    private String telefone;
    private String especialidade;
    private int valor;

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