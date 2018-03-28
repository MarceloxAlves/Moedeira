package br.com.marcelo.moedeira.API;

import br.com.marcelo.moedeira.model.Moeda;
import retrofit2.Call;
import retrofit2.http.GET;

@EndPoint
public interface MoedeiroService {

    @GET("rest.php?class=JogosArcadeService&method=subtotal")
    Call<Moeda> listMoeda();
}
