package br.com.marcelo.moedeira.app;

import android.content.Context;
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
    private Context context = this;
    private ArtigosAdapter artigosAdapter;
    private List<Artigo> artigos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artigos);
        recyclerView = findViewById(R.id.rv_artigos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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

        artigosAdapter = new ArtigosAdapter(context,artigos);

        recyclerView.setAdapter(artigosAdapter);
    }
}
