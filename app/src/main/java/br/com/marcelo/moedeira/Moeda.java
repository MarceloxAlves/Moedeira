package br.com.marcelo.moedeira;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class Moeda {

    @SerializedName("status")
    String status;

    @SerializedName("data")
    Map<Object,Object> data;

}
