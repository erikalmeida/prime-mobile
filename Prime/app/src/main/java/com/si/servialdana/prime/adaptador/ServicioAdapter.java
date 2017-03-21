package com.si.servialdana.prime.adaptador;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.si.servialdana.prime.DetalleServicio;
import com.si.servialdana.prime.R;
import com.si.servialdana.prime.sql.modelo.Servicio;

import java.util.List;

/**
 * Created by ealmeida on 2/7/2017.
 */

public class ServicioAdapter extends RecyclerView.Adapter<ServicioAdapter.MyViewHolder>{

    private Context mContext;
    private List<Servicio> servicioList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;
        public Servicio Servicio;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetalleServicio.class);
                    v.getContext().startActivity(intent);
                }
            });
            thumbnail.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(v.getContext(), DetalleServicio.class);
                    v.getContext().startActivity(intent);
                }
            });
            title.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(v.getContext(), DetalleServicio.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }


    public ServicioAdapter(Context mContext, List<Servicio> servicioList) {
        this.mContext = mContext;
        this.servicioList = servicioList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.catalogo_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Servicio Servicio = servicioList.get(position);
        holder.title.setText(Servicio.getName());


        // loading album cover using Glide library
        Glide.with(mContext).load(Servicio.getThumbnail()).into(holder.thumbnail);


    }

    /**
     * Showing popup menu when tapping on 3 dots
     */

    /**
     * Click listener for popup menu items
     */



    @Override
    public int getItemCount() {
        return servicioList.size();
    }
}
