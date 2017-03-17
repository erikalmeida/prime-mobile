package com.si.servialdana.prime.adaptador;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.si.servialdana.prime.CalificacionServicio;
import com.si.servialdana.prime.DetalleNotificacion;
import com.si.servialdana.prime.DetallePresupuesto;
import com.si.servialdana.prime.DetallePromocion;
import com.si.servialdana.prime.R;

public class ViewHolderNotificaciones extends RecyclerView.ViewHolder {

    CardView cv;
    TextView titulo;
    TextView descripcion;
    TextView fecha;
    ImageView icono;
    int tipo;

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public ViewHolderNotificaciones(View itemView) {

        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cvNotificaciones);
        titulo = (TextView) itemView.findViewById(R.id.textViewTituloNotificacion);
        descripcion = (TextView) itemView.findViewById(R.id.textViewDescripcionNotificacion);
        icono = (ImageView) itemView.findViewById(R.id.imageViewTipoNotificacion);
        fecha = (TextView) itemView.findViewById(R.id.textViewFechaNotificacion);


        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), metodoonclick());
                v.getContext().startActivity(intent);
            }
        });
        titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), metodoonclick());
                v.getContext().startActivity(intent);
            }
        });
        descripcion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(), metodoonclick());
                v.getContext().startActivity(intent);
            }
        });
    }

    public Class<?> metodoonclick() {

        Class<?> c = null;

        switch (tipo) {
            case 1: c = DetallePromocion.class;
                    break;
            case 2: c = DetallePresupuesto.class;
                    break;
            case 3: c = DetalleNotificacion.class;
                break;
            case 4: c = DetalleNotificacion.class;
                break;
            case 5: c = CalificacionServicio.class;
                break;

        }
        return c;
    }
}
