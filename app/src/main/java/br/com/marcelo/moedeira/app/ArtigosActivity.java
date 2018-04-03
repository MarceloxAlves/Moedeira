package br.com.marcelo.moedeira.app;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.marcelo.moedeira.R;
import br.com.marcelo.moedeira.adapters.ArtigosAdapter;
import br.com.marcelo.moedeira.model.Artigo;

public class ArtigosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArtigosAdapter artigosAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<Artigo> artigos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artigos);
        setupViews();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        swipeRefreshLayout.setOnRefreshListener(()->{
            updateNews();
            swipeRefreshLayout.setRefreshing(false);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Teste para fazer uma lista para testar o adapter
        for(int i = 0; i < 5; i++){
            Artigo artigo = new Artigo();
            artigo.setTitulo("Titulo " + i);
            artigo.setResumo("Resumo " + i);
            artigo.setAutor("Autor " + i);
            artigos.add(artigo);
        }

        artigosAdapter = new ArtigosAdapter(this,artigos);

        recyclerView.setAdapter(artigosAdapter);
    }

    private void updateNews() {
        /*moedeiroService = apiService.getMoedaService();
        Call<ServiceNoticia> noticias = moedeiroService.getNoticias();
        noticias.enqueue(new Callback<ServiceNoticia>() {
            @Override
            public void onResponse(Call<ServiceNoticia> call, Response<ServiceNoticia> response) {
                List<Noticia> data = response.body().data;
                adapterNoticias = new NoticiasAdapter(data, context);
                recyclerView.setAdapter(adapterNoticias);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<ServiceNoticia> call, Throwable t) {
                Toast.makeText(NoticiasActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    private void setupViews() {
        recyclerView = findViewById(R.id.rv_artigos);
        swipeRefreshLayout = findViewById(R.id.swipe_artigo_layout);
    }
}
