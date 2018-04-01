package br.com.marcelo.moedeira.app;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.marcelo.moedeira.R;
import br.com.marcelo.moedeira.adapters.CursosAdapter;
import br.com.marcelo.moedeira.model.Curso;

public class CursoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    List<Curso> cursoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);
        setupViews();

        swipeRefreshLayout.setOnRefreshListener(()->{
            updateNews();
            swipeRefreshLayout.setRefreshing(false);
        });

        for(int i = 0; i < 5; i++){
            Curso curso = new Curso();
            curso.setNome("Titulo " + i);
            curso.setDescricao("Descrição " + i);
            cursoList.add(curso);
        }


        CursosAdapter adapter = new CursosAdapter(cursoList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    private void setupViews() {
        recyclerView = findViewById(R.id.rv_cursos);
        swipeRefreshLayout = findViewById(R.id.swipe_curso_layout);
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
