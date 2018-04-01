package br.com.marcelo.moedeira.app;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
    APIService apiService;
    private SwipeRefreshLayout swipeRefreshLayout;
    MoedeiroService moedeiroService;
    NoticiasAdapter adapterNoticias;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        setupViews();

        apiService = new APIService();

         updateNews();

        swipeRefreshLayout.setOnRefreshListener(() -> {
               updateNews();
                swipeRefreshLayout.setRefreshing(false);

        });

    }


    private void updateNews() {
        moedeiroService = apiService.getMoedaService();
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
        });
    }

    private void setupViews() {
        recyclerView = findViewById(R.id.rv_noticias);
        swipeRefreshLayout = findViewById(R.id.swipe_noticia_layout);
    }
}
