package br.com.marcelo.moedeira.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by jesus on 27/03/2018.
 */

public class Noticia {

    @SerializedName("titulo")
    private String titulo;
    @SerializedName("resumo")
    private String resumo;
    @SerializedName("autor")
    private String autor;
    @SerializedName("data_inc")
    private Date dateInc;

    private String imagem;

    @SerializedName("data")
    private List<Noticia> data;

    public Noticia(String titulo, String resumo, String imagem, String autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.imagem = imagem;
        this.autor = autor;
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

}
