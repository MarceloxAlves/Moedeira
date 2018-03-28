package br.com.marcelo.moedeira.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.com.marcelo.moedeira.R;
import br.com.marcelo.moedeira.adapters.ProjetosRVAdapter;

public class ProjetosRVActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Context context = this;
    private ProjetosRVAdapter adapter;

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

        recyclerView.setAdapter(adapter);
    }


}
