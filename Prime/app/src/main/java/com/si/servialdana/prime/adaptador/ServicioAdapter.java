package com.si.servialdana.prime.adaptador;


import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.si.servialdana.prime.R;
import com.si.servialdana.prime.sql.modelo.servicio;

import java.util.List;

/**
 * Created by ealmeida on 2/7/2017.
 */

public class ServicioAdapter extends RecyclerView.Adapter<ServicioAdapter.MyViewHolder>{

    private Context mContext;
    private List<servicio> servicioList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);

            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            //overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    public ServicioAdapter(Context mContext, List<servicio> servicioList) {
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
        servicio servicio = servicioList.get(position);
        holder.title.setText(servicio.getName());
        //holder.count.setText(servicio.getNumOfSongs() + " Días");

        // loading album cover using Glide library
        Glide.with(mContext).load(servicio.getThumbnail()).into(holder.thumbnail);


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
