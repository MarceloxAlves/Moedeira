package br.com.marcelo.moedeira.app;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.marcelo.moedeira.R;
import br.com.marcelo.moedeira.adapters.JogosAdapter;
import br.com.marcelo.moedeira.adapters.NoticiasAdapter;
import br.com.marcelo.moedeira.model.Jogo;


public class JogosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<Jogo> jogoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogos);
        setupViews();

        swipeRefreshLayout.setOnRefreshListener(()->{
            updateNews();
            swipeRefreshLayout.setRefreshing(false);
        });

        for(int i = 0; i < 5; i++){
            Jogo p = new Jogo();
            p.setNome("Titulo " + i);
            p.setDescricao("Descrição " + i);
            jogoList.add(p);
        }

        JogosAdapter adapter = new JogosAdapter(jogoList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    private void setupViews() {
        recyclerView = findViewById(R.id.rv_jogos);
        swipeRefreshLayout = findViewById(R.id.swipe_jogos_layout);
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
}
