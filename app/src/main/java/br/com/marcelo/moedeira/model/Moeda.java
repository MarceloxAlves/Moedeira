package br.com.marcelo.moedeira.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class Moeda {

    @SerializedName("status")
   public  String status;

    @SerializedName("data")
   public  Map<Object,Object> data;

}
