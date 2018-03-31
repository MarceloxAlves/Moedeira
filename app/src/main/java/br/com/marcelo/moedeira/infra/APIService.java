package br.com.marcelo.moedeira.infra;

import br.com.marcelo.moedeira.API.MoedeiroService;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {

    public static String TAG = APIService.class.getSimpleName();

    public static final String BASE_URL = "http://10.0.0.111/formcidadaos/";

    private Retrofit retrofit;

    private Interceptor interceptor;

    //Endpoint
    private MoedeiroService moedeiroService;

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

        moedeiroService = retrofit.create(MoedeiroService.class);

    }

    public static String getUrlBase(){return APIService.BASE_URL;}


    public MoedeiroService getMoedaService(){
       return moedeiroService;
    }



}













