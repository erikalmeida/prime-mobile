package com.si.servialdana.prime.adaptador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.si.servialdana.prime.R;

import java.util.List;

public class RecyclerViewAdapterNotificaciones extends RecyclerView.Adapter<ViewHolderNotificaciones>  {

    private List<String> datos;
    private int posicion;

    public RecyclerViewAdapterNotificaciones(List<String> datos){
        this.datos = datos;
    }

    @Override
    public ViewHolderNotificaciones onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_notificaciones, parent, false);
        ViewHolderNotificaciones rvh = new ViewHolderNotificaciones(v);
        return rvh;

    }


    @Override
    public void onBindViewHolder(ViewHolderNotificaciones holder, int position) {
        posicion=position;
        holder.titulo.setText(datos.get(position));

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}
