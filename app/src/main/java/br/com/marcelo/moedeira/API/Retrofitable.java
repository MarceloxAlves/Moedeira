package br.com.marcelo.moedeira.API;

import java.util.List;

/**
 * Created by Marcelo on 22/03/2018.
 */

public interface Retrofitable {
    public void onRetrofitResponse(int status, String dados);

    public void onRetrofitFailure(Throwable t);
}
