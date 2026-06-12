package com.example.Models;

public class Servico {

    private String titulo;
    private String descricao;
    private String data;
    private int valor;
    private String rua;

    public Servico(String titulo, String descricao, String data, int valor, String rua) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.rua = rua;
    }


    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public int getValor() {
        return valor;
    }

    public String getRua() {
        return rua;
    }
}