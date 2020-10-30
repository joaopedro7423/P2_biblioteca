package com.example.biblioteca;

public class ModelBiblioteca {

    String autores,titulo,p_lido,qtd_p,status;


           ModelBiblioteca(){
               
           }

    public ModelBiblioteca(String autores, String titulo, String p_lido, String qtd_p, String status) {
        this.autores = autores;
        this.titulo = titulo;
        this.p_lido = p_lido;
        this.qtd_p = qtd_p;
        this.status = status;
    }


    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getP_lido() {
        return p_lido;
    }

    public void setP_lido(String p_lido) {
        this.p_lido = p_lido;
    }

    public String getQtd_p() {
        return qtd_p;
    }

    public void setQtd_p(String qtd_p) {
        this.qtd_p = qtd_p;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
























