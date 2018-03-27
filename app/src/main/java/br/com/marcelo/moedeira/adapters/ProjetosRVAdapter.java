package br.com.marcelo.moedeira.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.marcelo.moedeira.R;

public class ProjetosRVAdapter extends RecyclerView.Adapter<ProjetosRVAdapter.ViewHolder> {

    private Context context;
    private String img;
    private String titulo;
    private String descricao;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.projeto_cardview, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageViewProjeto;
        public TextView textViewTitulo;
        public TextView textViewDescricao;

        public ViewHolder(View itemView) {
            super(itemView);

            imageViewProjeto = itemView.findViewById(R.id.img_projeto);
            textViewTitulo = itemView.findViewById(R.id.text_titulo);
            textViewDescricao = itemView.findViewById(R.id.text_descricao);
        }
    }
}
