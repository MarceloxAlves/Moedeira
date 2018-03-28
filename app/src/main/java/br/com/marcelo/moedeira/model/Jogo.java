package br.com.marcelo.moedeira.model;

/**
 * Created by jesus on 27/03/2018.
 */

public class Jogo {
    int id;
    double arrecadacao;
    String nome, imagem, autor;

    public Jogo(int id, double arrecadacao, String nome, String imagem) {
        this.id = id;
        this.arrecadacao = arrecadacao;
        this.nome = nome;
        this.imagem = imagem;
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
}
