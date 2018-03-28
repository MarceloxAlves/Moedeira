package br.com.marcelo.moedeira.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class Service {

    @SerializedName("status")
   public  String status;

    @SerializedName("data")
   public List<Noticia> data;

}
