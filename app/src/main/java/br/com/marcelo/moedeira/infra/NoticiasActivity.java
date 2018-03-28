package br.com.marcelo.moedeira.infra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import br.com.marcelo.moedeira.R;

public class NoticiasActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        setupView();
    }

    private void setupView() {
        recyclerView = findViewById(R.id.rv_noticias);
    }
}
