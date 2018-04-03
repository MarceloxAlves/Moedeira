package br.com.marcelo.moedeira.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.marcelo.moedeira.API.MoedeiroService;
import br.com.marcelo.moedeira.R;
import br.com.marcelo.moedeira.adapters.ProjetosAdapter;
import br.com.marcelo.moedeira.infra.APIService;
import br.com.marcelo.moedeira.infra.TDialog;
import br.com.marcelo.moedeira.model.Projeto;
import br.com.marcelo.moedeira.services.ServiceProjeto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjetosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Context context = this;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProjetosAdapter projetosAdapter;
    private List<Projeto> projetos = new ArrayList<>();
    APIService apiService;
    MoedeiroService moedeiroService;
    TDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projetos_rv);
        setupViews();
        apiService = new APIService();
        dialog = new TDialog(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        dialog.show();
        updateNews();
        dialog.dismiss();



        swipeRefreshLayout.setOnRefreshListener(()->{
            updateNews();
            swipeRefreshLayout.setRefreshing(false);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void setupViews() {
        recyclerView = findViewById(R.id.rv_projetos);
        swipeRefreshLayout = findViewById(R.id.swipe_projetos_layout);
    }

    private void updateNews() {
        moedeiroService = apiService.getMoedaService();
        Call<ServiceProjeto> projetos = moedeiroService.getProjetos();
        projetos.enqueue(new Callback<ServiceProjeto>() {
            @Override
            public void onResponse(Call<ServiceProjeto> call, Response<ServiceProjeto> response) {
                List<Projeto> data = response.body().data;
                projetosAdapter = new ProjetosAdapter(data, context);
                recyclerView.setAdapter(projetosAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<ServiceProjeto> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}
