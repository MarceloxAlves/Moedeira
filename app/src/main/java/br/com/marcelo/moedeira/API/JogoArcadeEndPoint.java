package br.com.marcelo.moedeira.API;
    import retrofit2.Call;
    import retrofit2.http.GET;

    /**
     * Created by Marcelo on 22/03/2018.
     */

    public interface JogoArcadeEndPoint {
        @GET("rest.php?class=JogosArcadeService&method=subtotal")
        Call<String> getTotal();

    }
