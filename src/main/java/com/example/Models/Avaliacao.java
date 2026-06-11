package com.example.Models;

public class Avaliacao {

    private int nota;
    private String comentario;
    private boolean recomendaria;

    public Avaliacao(int nota, String comentario, boolean recomendaria) {
        this.nota = nota;
        this.comentario = comentario;
        this.recomendaria = recomendaria;
    }


    public int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public boolean getRecomendaria() {
        return recomendaria;
    }

}