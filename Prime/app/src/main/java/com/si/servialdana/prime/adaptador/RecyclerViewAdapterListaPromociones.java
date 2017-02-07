package com.si.servialdana.prime.adaptador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.si.servialdana.prime.R;

import java.util.List;

public class RecyclerViewAdapterListaPromociones extends RecyclerView.Adapter<ViewHolderListaPromociones>  {

    private List<String> datos;
    private int posicion;

    public RecyclerViewAdapterListaPromociones(List<String> datos){
        this.datos = datos;
    }

    @Override
    public ViewHolderListaPromociones onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_promocion, parent, false);
        ViewHolderListaPromociones rvh = new ViewHolderListaPromociones(v);
        return rvh;

    }


    @Override
    public void onBindViewHolder(ViewHolderListaPromociones holder, int position) {
        posicion=position;
        holder.titulo.setText(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}
