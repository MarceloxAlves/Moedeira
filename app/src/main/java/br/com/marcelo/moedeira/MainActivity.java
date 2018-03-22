package br.com.marcelo.moedeira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import br.com.marcelo.moedeira.API.APIService;
import br.com.marcelo.moedeira.API.Retrofitable;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements Retrofitable {

    APIService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service = new APIService();

    }

    @Override
    public void onRetrofitResponse(int status, String dados) {
        if(status == 200){
            Toast.makeText(this, "Deu bom: " + dados, Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(this, "Status: " + status, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRetrofitFailure(Throwable t) {
        Toast.makeText(this, t.getMessage()+" Te liga:"  + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
    }

    public void testarAPI(View view) {

        service.getContador(this);
    }
}
