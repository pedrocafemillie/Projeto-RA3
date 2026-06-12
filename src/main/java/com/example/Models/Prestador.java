package com.example.Models;

public class Prestador {

    private String nome;
    private String email;
    private String cpf;
    private String senha;
    private String especialidade;
    private String tipo;


    public Prestador(String nome, String email, String cpf, String senha, String especialidade, String tipo) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.especialidade = especialidade;
        this.tipo = tipo;
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

    public String getSenha(){
        return senha;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getTipo() {
        return tipo;
    }

}