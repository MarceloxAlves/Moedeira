package br.com.marcelo.moedeira.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import br.com.marcelo.moedeira.infra.TDate;
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

        View linha = inflater.inflate(R.layout.layout_view_holder_noticia_show, parent, false);

        return new NoticiasViewHolder(linha) ;
    }

    @Override
    public void onBindViewHolder(NoticiasViewHolder holder, int position) {
        Noticia noticia = listNoticias.get(position);
        String img  =  APIService.BASE_URL + noticia.getImagem();
            img.replace("\\","");
        Picasso.with(context).load(img).into(holder.mNoticiaImage);

        String descricao = noticia.getResumo().length() > 120 ?  noticia.getResumo().substring(0,120) : noticia.getResumo();

        holder.mDesc.setText(descricao);
        holder.mTitulo.setText(noticia.getTitulo());
        TDate tDate = new TDate(noticia.getDateInc());
        holder.mData.setText(tDate.getDataFormatWeb());
        holder.mShareNoticia.setOnClickListener(v->{
            compartilharNoticia(noticia);
        });

    }



    @Override
    public int getItemCount() {
        return listNoticias.size();
    }

    public class NoticiasViewHolder extends RecyclerView.ViewHolder{
        ImageView mNoticiaImage, mShareNoticia;
        TextView mTitulo, mDesc,mData;


        public NoticiasViewHolder(View itemView) {
            super(itemView);
            mNoticiaImage = itemView.findViewById(R.id.image_noticia_background);
            mTitulo = itemView.findViewById(R.id.titulo_noticia);
            mDesc = itemView.findViewById(R.id.desc_noticia);
            mShareNoticia = itemView.findViewById(R.id.share_noticia);
            mData = itemView.findViewById(R.id.data_topo);
        }
    }

    public void setNoticias(List<Noticia> listNoticias){this.listNoticias = listNoticias;}

    private void compartilharNoticia(Noticia noticia) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        //sendIntent.putExtra(Intent.EXTRA_TEXT, APIService.BASE_URL+"?p=noticia-detalhe&q="+noticia.getId());
        sendIntent.putExtra(Intent.EXTRA_TEXT, APIService.BASE_URL + noticia.getImagem());
        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }
}