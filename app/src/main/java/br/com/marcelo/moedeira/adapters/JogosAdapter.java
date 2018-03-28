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
import br.com.marcelo.moedeira.model.Jogo;
import br.com.marcelo.moedeira.model.Noticia;

/**
 * Created by jesus on 28/03/2018.
 */

public class JogosAdapter extends RecyclerView.Adapter<JogosAdapter.JogosViewHolder> {


    private List<Jogo> listJogos;
    private Context context;

    public JogosAdapter(List<Jogo> listJogos, Context context) {
        this.listJogos = listJogos;
        this.context = context;
    }

    @Override
    public JogosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(context);

        View linha = inflater.inflate(R.layout.layout_view_holder_jogos, parent, false);

        return new JogosAdapter.JogosViewHolder(linha);
    }

    @Override
    public void onBindViewHolder(JogosViewHolder holder, int position) {

        Jogo jogo = listJogos.get(position);
        holder.mJogoTitulo.setText(jogo.getNome());
        holder.mJogoDescricao.setText(jogo.getDescricao());

    }

    @Override
    public int getItemCount() {
        return listJogos.size();
    }

    public class JogosViewHolder extends RecyclerView.ViewHolder{
        ImageView mJogoImage, mLikeJogo, mShareJogo, mDesLikeJogo;
        TextView mJogoTitulo,mJogoDescricao;
        public JogosViewHolder(View itemView) {
            super(itemView);
            mJogoImage = itemView.findViewById(R.id.jogo_icon);
            mJogoTitulo = itemView.findViewById(R.id.nome_jogo_text);
            mJogoDescricao = itemView.findViewById(R.id.jogo_descricao_text);
            mLikeJogo = itemView.findViewById(R.id.like_jogo);
            mDesLikeJogo = itemView.findViewById(R.id.deslike_jogo);
            mShareJogo = itemView.findViewById(R.id.share_jogo);
        }
    }

    public void setNoticias(List<Jogo> listJogos){this.listJogos = listJogos;}
}
