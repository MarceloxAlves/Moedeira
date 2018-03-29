package br.com.marcelo.moedeira.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vinic on 28/03/2018.
 */

public class Projeto {

    @SerializedName("idprojeto")
    private int id;
    @SerializedName("nome")
    private String nome;
    @SerializedName("descricao")
    private String descricao;
    @SerializedName("slogan")
    private String slogan;
    @SerializedName("imagem")
    private String imagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
