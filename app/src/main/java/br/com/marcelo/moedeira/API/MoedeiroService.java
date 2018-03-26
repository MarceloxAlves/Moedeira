package br.com.marcelo.moedeira.API;

import java.util.List;

import br.com.marcelo.moedeira.Moeda;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MoedeiroService {

    @GET("rest.php?class=JogosArcadeService&method=subtotal")
    Call<Moeda> listMoeda();
}
