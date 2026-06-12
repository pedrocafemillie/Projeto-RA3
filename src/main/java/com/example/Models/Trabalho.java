package com.example.Models;

public class Trabalho {

    private String titulo;
    private String descricao;
    private int valor;
    private String atuacao;

    public Trabalho(String titulo, String descricao, int valor, String atuacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.valor = valor;
        this.atuacao = atuacao;
    }


    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getValor() {
        return valor;
    }

    public String getAtuacao() {
        return atuacao;
    }
}