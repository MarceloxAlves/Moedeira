package br.com.marcelo.moedeira.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.marcelo.moedeira.R;
import br.com.marcelo.moedeira.infra.APIService;
import br.com.marcelo.moedeira.model.Projeto;

public class ProjetosAdapter extends RecyclerView.Adapter<ProjetosAdapter.ViewHolder> {

    private Context context;
    private List<Projeto> projetos;

    public ProjetosAdapter(List<Projeto> projetos, Context context) {
        this.context = context;
        this.projetos = projetos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_view_holder_projeto, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Projeto projeto = projetos.get(position);
        Picasso.with(context).load(APIService.BASE_URL + projeto.getImagem()).into(holder.imageViewProjeto);
        holder.textViewTitulo.setText(projeto.getNome());
        holder.textViewDescricao.setText(projeto.getDescricao());

    }

    @Override
    public int getItemCount() {
        return projetos.size();
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
