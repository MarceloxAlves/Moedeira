package br.com.marcelo.moedeira.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.marcelo.moedeira.R;
import br.com.marcelo.moedeira.adapters.ProjetosAdapter;
import br.com.marcelo.moedeira.model.Projeto;

public class ProjetosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Context context = this;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProjetosAdapter projetosAdapter;
    private List<Projeto> projetos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projetos_rv);
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

        projetosAdapter = new ProjetosAdapter(context,projetos);
        recyclerView.setAdapter(projetosAdapter);
    }

    private void setupViews() {
        recyclerView = findViewById(R.id.rv_projetos);
        swipeRefreshLayout = findViewById(R.id.swipe_projetos_layout);
    }

    private void updateNews() {
        /*moedeiroService = apiService.getMoedaService();
        Call<Service> noticias = moedeiroService.getNoticias();
        noticias.enqueue(new Callback<Service>() {
            @Override
            public void onResponse(Call<Service> call, Response<Service> response) {
                List<Noticia> data = response.body().data;
                adapterNoticias = new NoticiasAdapter(data, context);
                recyclerView.setAdapter(adapterNoticias);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<Service> call, Throwable t) {
                Toast.makeText(NoticiasActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }


}
