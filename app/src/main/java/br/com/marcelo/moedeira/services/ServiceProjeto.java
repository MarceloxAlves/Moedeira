package br.com.marcelo.moedeira.services;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import br.com.marcelo.moedeira.model.Noticia;
import br.com.marcelo.moedeira.model.Projeto;

public class ServiceProjeto {

    @SerializedName("status")
   public  String status;

    @SerializedName("data")
   public List<Projeto> data;

}
