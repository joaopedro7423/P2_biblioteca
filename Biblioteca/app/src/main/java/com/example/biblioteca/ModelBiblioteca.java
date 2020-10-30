package com.example.biblioteca;

public class ModelBiblioteca {

    String autores,titulo;
    int p_lido,qtd_p,status;

           ModelBiblioteca(){
               
           }
   
   

    public ModelBiblioteca(String autores, String titulo, int p_lido, int qtd_p, int status) {
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

    public int getP_lido() {
        return p_lido;
    }

    public void setP_lido(int p_lido) {
        this.p_lido = p_lido;
    }

    public int getQtd_p() {
        return qtd_p;
    }

    public void setQtd_p(int qtd_p) {
        this.qtd_p = qtd_p;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }




}
