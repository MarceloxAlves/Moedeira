package br.com.marcelo.moedeira.model;

/**
 * Created by jesus on 27/03/2018.
 */

public class Jogo {
    private int id;
    private double arrecadacao;
    private String nome;
    private String imagem;
    private String autor;
    private int avaliacao;
    private String descricao;
    private boolean like;

    public Jogo(int id, double arrecadacao, String nome, String imagem, String autor, int avaliacao, String descricao, boolean like) {
        this.id = id;
        this.arrecadacao = arrecadacao;
        this.nome = nome;
        this.imagem = imagem;
        this.autor = autor;
        this.avaliacao = avaliacao;
        this.descricao = descricao;
        this.like = like;
    }

    public Jogo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getArrecadacao() {
        return arrecadacao;
    }

    public void setArrecadacao(double arrecadacao) {
        this.arrecadacao = arrecadacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
