package br.com.marcelo.moedeira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.com.marcelo.moedeira.adapters.NoticiasAdapter;
import br.com.marcelo.moedeira.model.Noticia;

public class NoticiasActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Noticia> listNoticia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        setupViews();
        NoticiasAdapter adapter = new NoticiasAdapter(listNoticia, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    private void setupViews() {
        recyclerView = findViewById(R.id.rv_noticias);
    }
}
