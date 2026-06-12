package com.example.Models;

public class Empresa {

    private String nome;
    private String cnpj;
    private String razaoSocial;
    private String areaAtuacao;

    public Empresa(String nome, String cnpj, String razaoSocial, String areaAtuacao) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.areaAtuacao = areaAtuacao;
    }


    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

}
