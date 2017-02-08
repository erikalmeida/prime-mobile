package com.si.servialdana.prime.adaptador;

import android.widget.TextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.si.servialdana.prime.R;

public class ViewHolderHistorialCitas extends RecyclerView.ViewHolder{
    CardView cv;
    TextView descripcion;
    TextView hora;
    TextView fecha;
    TextView detalle;

    ViewHolderHistorialCitas(View itemView){
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cvHistorialCitas);
        descripcion = (TextView) itemView.findViewById(R.id.textViewDescripcion);
        fecha = (TextView) itemView.findViewById(R.id.textViewFecha);
        hora = (TextView) itemView.findViewById(R.id.textViewHora);
        detalle = (TextView) itemView.findViewById(R.id.textViewDetalle);


    }
}
