package br.com.marcelo.moedeira.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.marcelo.moedeira.R;
import br.com.marcelo.moedeira.adapters.ProjetosRVAdapter;
import br.com.marcelo.moedeira.model.Projeto;

public class ProjetosRVActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Context context = this;
    private ProjetosRVAdapter adapter;
    private List<Projeto> projetos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projetos_rv);
        recyclerView = findViewById(R.id.rv_projetos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();

        for(int i = 0; i < 5; i++){
            Projeto p = new Projeto();
            p.setNome("Titulo " + i);
            p.setDescricao("Descrição " + i);
            projetos.add(p);
        }

        adapter = new ProjetosRVAdapter(context,projetos);

        recyclerView.setAdapter(adapter);
    }


}
