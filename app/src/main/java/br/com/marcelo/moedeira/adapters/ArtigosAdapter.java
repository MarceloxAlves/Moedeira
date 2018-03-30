package br.com.marcelo.moedeira.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.marcelo.moedeira.R;
import br.com.marcelo.moedeira.model.Artigo;

/**
 * Created by vinic on 29/03/2018.
 */

public class ArtigosAdapter extends RecyclerView.Adapter<ArtigosAdapter.ViewHolder> {

    private Context context;
    private List<Artigo> artigos;

    public ArtigosAdapter(Context context, List<Artigo> artigos) {
        this.context = context;
        this.artigos = artigos;
    }

    @Override
    public ArtigosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_view_holder_artigo, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ArtigosAdapter.ViewHolder holder, int position) {

        final Artigo artigo = artigos.get(position);

        holder.textViewTitulo.setText(artigo.getTitulo());
        holder.textViewResumo.setText(artigo.getResumo());
        holder.textViewAutor.setText(artigo.getAutor());

    }

    @Override
    public int getItemCount() {
        return artigos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewTitulo;
        public TextView textViewResumo;
        public TextView textViewAutor;
        public TextView textViewData;


        public ViewHolder(View itemView) {
            super(itemView);

            textViewTitulo = itemView.findViewById(R.id.text_titulo);
            textViewResumo = itemView.findViewById(R.id.text_resumo);
            textViewAutor = itemView.findViewById(R.id.text_autor);
            textViewData = itemView.findViewById(R.id.text_data);


        }
    }
}
