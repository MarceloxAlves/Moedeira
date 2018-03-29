package br.com.marcelo.moedeira.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by jesus on 29/03/2018.
 */

public class Curso {

    @SerializedName("idcurso")
    private int idCurso;
    @SerializedName("projeto_idprojeto")
    private int idProjeto;
    @SerializedName("descricao")
    private String descricao;
    @SerializedName("nome")
    private String nome;
    @SerializedName("inicio")
    private Date inicio;
    @SerializedName("fim")
    private Date fim;
    @SerializedName("date_create")
    private Date dateCreate;
    @SerializedName("imagem")
    private String imagem;
    @SerializedName("local")
    private String local;

    public Curso(int idCurso, int idProjeto, String descricao, String nome, Date inicio, Date fim, Date dateCreate, String imagem, String local) {
        this.idCurso = idCurso;
        this.idProjeto = idProjeto;
        this.descricao = descricao;
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
        this.dateCreate = dateCreate;
        this.imagem = imagem;
        this.local = local;
    }

    public Curso() {
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
