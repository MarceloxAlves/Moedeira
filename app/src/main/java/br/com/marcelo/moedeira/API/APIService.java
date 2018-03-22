package br.com.marcelo.moedeira.API;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Marcelo on 22/03/2018.
 */

public class APIService {
    public static String TAG = APIService.class.getSimpleName();

    public static final String BASE_URL = "http://192.168.0.101/formcidadaos/";

    private Retrofit retrofit;

    private Interceptor interceptor;

    //Endpoint
    JogoArcadeEndPoint jogoArcadeEndPoint;

    public APIService(){

        this.interceptor = new InterceptorAPI();

        OkHttpClient.Builder builderCliente = new OkHttpClient.Builder();
        builderCliente.interceptors().add(this.interceptor);

        OkHttpClient cliente = builderCliente.build();

        Retrofit.Builder builder = new Retrofit.Builder();

        retrofit = builder.baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(cliente)
                .build();

        jogoArcadeEndPoint = retrofit.create(JogoArcadeEndPoint.class);
    }


    public double getContador(final Retrofitable retrofitable){
        Call<String> call  = jogoArcadeEndPoint.getTotal();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                retrofitable.onRetrofitResponse(response.code(),response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                retrofitable.onRetrofitFailure(t);
            }
        });
        return 0;
    }

}
