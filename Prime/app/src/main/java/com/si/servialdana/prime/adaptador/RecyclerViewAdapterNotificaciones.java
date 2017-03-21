package com.si.servialdana.prime.adaptador;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.si.servialdana.prime.R;
import com.si.servialdana.prime.TipoNotificacionServicios;
import com.si.servialdana.prime.sql.modelo.Notificacion;
import com.si.servialdana.prime.sql.modelo.TipoNotificacion;

import java.util.List;

public class RecyclerViewAdapterNotificaciones extends RecyclerView.Adapter<ViewHolderNotificaciones>  {

    private Context mContext;
    private List<Notificacion> notificacionList;
    private int posicion;

    /*public RecyclerViewAdapterNotificaciones(List<Notificacion> listaNotificaciones) {

    }*/

    public RecyclerViewAdapterNotificaciones(List<Notificacion> notificacionList) {
        this.notificacionList = notificacionList;
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

        Notificacion noti =notificacionList.get(posicion);
        holder.titulo.setText(noti.getNombre());
        holder.descripcion.setText(noti.getDescripcion());
        holder.fecha.setText(noti.getFechacreacion());
        holder.setTipo(noti.getIdtiponotificacion());
        int tipo = noti.getIdtiponotificacion();

        switch (tipo)
        {
            case 1: holder.icono.setImageResource(R.drawable.ic_noti_promo);
                    break;
            case 2: holder.icono.setImageResource(R.drawable.ic_noti_presupuesto);
                    break;
            case 3: holder.icono.setImageResource(R.drawable.ic_noti_eventualidad);
                    break;
            case 4: holder.icono.setImageResource(R.drawable.ic_noti_entrega);
                    break;
            case 5: holder.icono.setImageResource(R.drawable.ic_noti_califica);
                    break;
        }

    }

    @Override
    public int getItemCount() {
        return notificacionList.size();
    }
}
