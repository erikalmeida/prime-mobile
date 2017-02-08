package com.si.servialdana.prime.adaptador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.si.servialdana.prime.R;
import java.util.List;

public class RecyclerViewAdapterHistorialCitas extends RecyclerView.Adapter<ViewHolderHistorialCitas> {
    private List<String> datos;
    private int posicion;

    public RecyclerViewAdapterHistorialCitas(List<String> datos){
        this.datos = datos;
    }

    @Override
    public ViewHolderHistorialCitas onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_historial_citas, parent, false);
        ViewHolderHistorialCitas rvh = new ViewHolderHistorialCitas(v);
        return rvh;

    }


    @Override
    public void onBindViewHolder(ViewHolderHistorialCitas holder, int position) {
        posicion=position;
        holder.descripcion.setText(datos.get(position));

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}
