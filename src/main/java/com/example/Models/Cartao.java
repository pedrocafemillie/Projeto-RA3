package com.example.Models;

public class Cartao{

    private String numero;
    private String cvv;
    private String validade;
    private String tipo;
    private String titular;

    public Cartao(String numero, String cvv, String validade, String tipo, String titular) {
        this.numero = numero;
        this.cvv = cvv;
        this.validade = validade;
        this.tipo = tipo;
        this.titular = titular;
    }


    public String getNumero(){
        return numero;
    }

    public String getCvv() {
        return cvv;
    }

    public String getValidade() {
        return validade;
    }

    public String getTipo() {
        return tipo;
    }
    public String getTitular(){
        return titular;
    }
}