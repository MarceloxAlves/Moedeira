package br.com.marcelo.moedeira.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jesus on 29/03/2018.
 */

//TODO::Cursos Adpter

public class CursosAdapter extends RecyclerView.Adapter<CursosAdapter.CursosViewHolder>{


    @Override
    public CursosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CursosViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CursosViewHolder extends RecyclerView.ViewHolder{

        public CursosViewHolder(View itemView) {
            super(itemView);
        }
    }
}
