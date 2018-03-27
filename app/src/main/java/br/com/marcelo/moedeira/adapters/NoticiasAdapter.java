package br.com.marcelo.moedeira.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.marcelo.moedeira.R;
import br.com.marcelo.moedeira.model.Noticia;

/**
 * Created by jesus on 27/03/2018.
 */

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.NoticiasViewHolder>  {

    private List<Noticia> listNoticias;
    private Context context;

    public NoticiasAdapter(List<Noticia> listNoticias, Context context) {
        this.listNoticias = listNoticias;
        this.context = context;
    }

    @Override
    public NoticiasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(context);

        View linha = inflater.inflate(R.layout.layout_view_holder_noticia, parent, false);

        return new NoticiasViewHolder(linha) ;
    }

    @Override
    public void onBindViewHolder(NoticiasViewHolder holder, int position) {
        Noticia noticia = listNoticias.get(position);

        holder.mResumo.setText(noticia.getResumo());
        holder.mTituto.setText(noticia.getTitulo());

    }

    @Override
    public int getItemCount() {
        return listNoticias.size();
    }

    public class NoticiasViewHolder extends RecyclerView.ViewHolder{
        ImageView mNoticiaImage;
        TextView mTituto, mResumo;
        public NoticiasViewHolder(View itemView) {
            super(itemView);
            mNoticiaImage = itemView.findViewById(R.id.noticia_icon);
            mTituto = itemView.findViewById(R.id.titulo_text);
            mResumo = itemView.findViewById(R.id.resumo_text);
        }
    }

    public void setNoticias(List<Noticia> listNoticias){this.listNoticias = listNoticias;}
}
