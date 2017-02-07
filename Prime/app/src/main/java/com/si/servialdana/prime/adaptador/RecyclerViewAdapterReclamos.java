package com.si.servialdana.prime.adaptador;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.si.servialdana.prime.R;


import java.util.List;

public class RecyclerViewAdapterReclamos extends RecyclerView.Adapter<ViewHolderReclamos> {

    private List<String> datos;
    private int posicion;

    public RecyclerViewAdapterReclamos(List<String> datos){
        this.datos = datos;
    }

    @Override
    public ViewHolderReclamos onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_reclamos, parent, false);
        ViewHolderReclamos rvh = new ViewHolderReclamos(v);
      return rvh;
    }

    @Override
    public void onBindViewHolder(ViewHolderReclamos holder, int position) {
        posicion=position;
        holder.asunto.setText(datos.get(position));

    }


    @Override
    public int getItemCount() {
        return datos.size();
    }


}
