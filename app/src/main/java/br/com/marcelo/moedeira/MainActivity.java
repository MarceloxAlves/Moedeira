package br.com.marcelo.moedeira;

import android.support.v7.app.AppCompatActivity;
import android.os Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://localhost/formcidadaos/rest.php?class=JogosArcadeService&method=subtotal")
        .build();.Bundle;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
