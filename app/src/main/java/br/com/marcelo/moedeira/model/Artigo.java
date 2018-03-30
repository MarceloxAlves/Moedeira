package br.com.marcelo.moedeira.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by vinic on 29/03/2018.
 */

public class Artigo {

    @SerializedName("idartigo_(Primária)")
    private int idArtigo;
    @SerializedName("titulo")
    private String titulo;
    @SerializedName("resumo")
    private String resumo;
    @SerializedName("abstract")
    private String abstrato;
    @SerializedName("arquivo")
    private String arquivo;
    @SerializedName("autor")
    private String autor;
    @SerializedName("ano")
    private int ano;
    @SerializedName("data_create")
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
