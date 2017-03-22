package com.si.servialdana.prime.adaptador;

import android.content.Intent;
import android.os.Bundle;
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
import com.si.servialdana.prime.sql.modelo.Notificacion;

public class ViewHolderNotificaciones extends RecyclerView.ViewHolder {

    CardView cv;
    TextView titulo;
    TextView descripcion;
    TextView fecha;
    ImageView icono;
    int tipo;
    int idpromocion;
    int idpresupuesto;
    int idordenentrega;
    int ideventualidad;


    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getIdpromocion() {return idpromocion;}

    public void setIdpromocion(int idpromocion) {this.idpromocion = idpromocion;}

    public int getIdpresupuesto() {return idpresupuesto;}

    public void setIdpresupuesto(int idpresupuesto) {this.idpresupuesto = idpresupuesto;}

    public int getIdordenentrega() {return idordenentrega;}

    public void setIdordenentrega(int idordenentrega) {this.idordenentrega = idordenentrega;}

    public int getIdeventualidad() {return ideventualidad;}

    public void setIdeventualidad(int ideventualidad) {
        this.ideventualidad = ideventualidad;
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
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP );
                Bundle extras = new Bundle();
                extras.putInt("idpromocion", idpromocion);

                extras.putInt("idordenentrega", idordenentrega);
                extras.putInt("ideventualidad", ideventualidad);
                extras.putInt("idpresupuesto", idpresupuesto);
                intent.putExtras(extras);
                v.getContext().startActivity(intent);
            }
        });
        titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), metodoonclick());
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Bundle extras = new Bundle();
                extras.putInt("idpromocion", idpromocion);
                extras.putInt("idordenentrega", idordenentrega);
                extras.putInt("ideventualidad", ideventualidad);
                extras.putInt("idpresupuesto", idpresupuesto);
                intent.putExtras(extras);
                v.getContext().startActivity(intent);
            }
        });
        descripcion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(), metodoonclick());
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Bundle extras = new Bundle();
                extras.putInt("idpromocion", idpromocion);
                extras.putInt("idordenentrega", idordenentrega);
                extras.putInt("ideventualidad", ideventualidad);
                extras.putInt("idpresupuesto", idpresupuesto);
                intent.putExtras(extras);
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
