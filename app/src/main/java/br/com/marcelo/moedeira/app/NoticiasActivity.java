package br.com.marcelo.moedeira.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.marcelo.moedeira.API.MoedeiroService;
import br.com.marcelo.moedeira.R;
import br.com.marcelo.moedeira.adapters.NoticiasAdapter;
import br.com.marcelo.moedeira.infra.APIService;
import br.com.marcelo.moedeira.model.Noticia;
import br.com.marcelo.moedeira.model.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoticiasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Noticia> listNoticia = new ArrayList<>();
    APIService apiService;
    MoedeiroService moedeiroService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        setupViews();

        apiService = new APIService();
        moedeiroService = apiService.getMoedaService();

        for(int i = 0; i < 5; i++){
            Noticia p = new Noticia();
            p.setTitulo("Titulo " + i);
            p.setResumo("Descrição " + i);
            listNoticia.add(p);
        }

        NoticiasAdapter adapter = new NoticiasAdapter(listNoticia, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


         Call<Service> noticias = moedeiroService.getNoticias();
         noticias.enqueue(new Callback<Service>() {
             @Override
             public void onResponse(Call<Service> call, Response<Service> response) {
                 List<Noticia> data = response.body().data;
                 Toast.makeText(NoticiasActivity.this,"Tamanho: " + data.size() , Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onFailure(Call<Service> call, Throwable t) {
                 Toast.makeText(NoticiasActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
             }
         });

    }

    private void setupViews() {
        recyclerView = findViewById(R.id.rv_noticias);
    }
}
