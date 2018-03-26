package br.com.marcelo.moedeira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.marcelo.moedeira.API.MoedeiroService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView result;
    MoedeiroService services;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);

    }


    @Override
    protected void onResume() {
        super.onResume();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.106/formcidadaos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        services = retrofit.create(MoedeiroService.class);


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



}
