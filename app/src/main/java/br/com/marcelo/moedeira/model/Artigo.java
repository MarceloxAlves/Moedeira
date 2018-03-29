package br.com.marcelo.moedeira.model;

import java.util.Date;

/**
 * Created by vinic on 29/03/2018.
 */

public class Artigo {

    private int idArtigo;
    private String titulo;
    private String resumo;
    private String abstrato;
    private String arquivo;
    private String autor;
    private int ano;
    private Date dateCreate;

    public int getIdArtigo() {
        return idArtigo;
    }

    public void setIdArtigo(int idArtigo) {
        this.idArtigo = idArtigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getAbstrato() {
        return abstrato;
    }

    public void setAbstrato(String abstrato) {
        this.abstrato = abstrato;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}
