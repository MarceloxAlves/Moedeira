package br.com.marcelo.moedeira.app;

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

    RecyclerView recyclerView;
    List<Jogo> jogoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogos);
        setupViews();


        JogosAdapter adapter = new JogosAdapter(jogoList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    private void setupViews() {
        recyclerView = findViewById(R.id.rv_jogos);
    }
}
