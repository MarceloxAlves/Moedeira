package br.com.marcelo.moedeira.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.marcelo.moedeira.R;
import br.com.marcelo.moedeira.model.Curso;

/**
 * Created by jesus on 29/03/2018.
 */



public class CursosAdapter extends RecyclerView.Adapter<CursosAdapter.CursosViewHolder>{

    List<Curso> cursoList;
    Context context;

    public CursosAdapter(List<Curso> cursoList, Context context) {
        this.cursoList = cursoList;
        this.context = context;
    }

    @Override
    public CursosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(context);

        View linha = inflater.inflate(R.layout.layout_view_holder_curso, parent, false);

        return new CursosAdapter.CursosViewHolder(linha);
    }

    @Override
    public void onBindViewHolder(CursosViewHolder holder, int position) {
        Curso curso = cursoList.get(position);
        holder.descCurso.setText(curso.getDescricao());
        holder.tituloCurso.setText(curso.getNome());


    }

    @Override
    public int getItemCount() {
        return cursoList.size();
    }

    public class CursosViewHolder extends RecyclerView.ViewHolder{

        ImageView imageCurso;
        TextView tituloCurso, descCurso;
        public CursosViewHolder(View itemView) {
            super(itemView);
            imageCurso = itemView.findViewById(R.id.image_noticia_background);
            tituloCurso = itemView.findViewById(R.id.titulo_curso_text);
            descCurso = itemView.findViewById(R.id.descricao_curso_text);
        }
    }

    public void setNoticias(List<Curso> cursoList){this.cursoList = cursoList;}
}
