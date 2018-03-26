package br.com.marcelo.moedeira.infra;

import java.util.List;

public interface Retrofitable {

    public void onRetrofitResponse(int status, List dados);

    public void onRetrofitFailure(Throwable t);
}
