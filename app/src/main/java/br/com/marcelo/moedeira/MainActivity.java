package br.com.marcelo.moedeira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.marcelo.moedeira.API.MoedeiroService;
import br.com.marcelo.moedeira.infra.APIService;
import br.com.marcelo.moedeira.infra.Retrofitable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements Retrofitable {
    TextView result;
    MoedeiroService services;
    APIService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        apiService = new APIService();

    }


    @Override
    protected void onResume() {
        super.onResume();

        services = apiService.getMoedaService();
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Call<Moeda> listCall = services.listMoeda();
                        listCall.enqueue(
                                new Callback<Moeda>() {
                                    @Override
                                    public void onResponse(Call<Moeda> call, Response<Moeda> response) {
                                        Moeda moeda = response.body();
                                        result.setText(moeda.data.get("subtotal").toString());
                                        try {
                                            onResume();
                                        }catch (Exception ex){
                                            finish();
                                        }

                                    }

                                    @Override
                                    public void onFailure(Call<Moeda> call, Throwable t) {
                                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                        );
                    }
                },
                3000);

    }


    @Override
    public void onRetrofitResponse(int status, List dados) {

    }

    @Override
    public void onRetrofitFailure(Throwable t) {

    }
}
