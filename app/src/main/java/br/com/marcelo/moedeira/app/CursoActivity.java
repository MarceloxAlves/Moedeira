package br.com.marcelo.moedeira.app;

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
    List<Curso> cursoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);
        setupViews();

        for(int i = 0; i < 5; i++){
            Curso curso = new Curso();
            curso.setNome("Titulo " + i);
            curso.setDescricao("Descrição " + i);
            cursoList.add(curso);
        }

        Toast.makeText(this,""+cursoList.size(),Toast.LENGTH_SHORT).show();

        CursosAdapter adapter = new CursosAdapter(cursoList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    private void setupViews() {
        recyclerView = findViewById(R.id.rv_cursos);
    }
}
