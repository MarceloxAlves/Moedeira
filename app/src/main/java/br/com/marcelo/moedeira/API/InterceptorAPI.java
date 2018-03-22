package br.com.marcelo.moedeira.API;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Marcelo on 22/03/2018.
 */

public class InterceptorAPI implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder().build();
        return  chain.proceed(request);
    }
}
