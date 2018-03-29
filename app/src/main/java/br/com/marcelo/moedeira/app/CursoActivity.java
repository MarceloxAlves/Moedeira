package br.com.marcelo.moedeira.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.com.marcelo.moedeira.R;
import br.com.marcelo.moedeira.model.Curso;

public class CursoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Curso> cursoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);
    }
}
