package br.com.marcelo.moedeira.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import br.com.marcelo.moedeira.infra.TDate;

/**
 * Created by jesus on 27/03/2018.
 */

public class Noticia {

    @SerializedName("idnoticia")
    private long Id;
    @SerializedName("titulo")
    private String titulo;
    @SerializedName("resumo")
    private String resumo;
    @SerializedName("autor")
    private String autor;
    @SerializedName("data_inc")
    private Date dateInc;
    @SerializedName("imagem")
    private String imagem;

    private boolean favorito;

    public Noticia(String titulo, String resumo, String autor, Date dateInc, String imagem, boolean favorito) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.autor = autor;
        this.dateInc = dateInc;
        this.imagem = imagem;
        this.favorito = favorito;
    }

    public Noticia() {
        this.setFavorito(false);
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public Date getDateInc() {
        return dateInc;
    }

    public void setDateInc(Date dateInc) {
        this.dateInc = dateInc;
    }
}
