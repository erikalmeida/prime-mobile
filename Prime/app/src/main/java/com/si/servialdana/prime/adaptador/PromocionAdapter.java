package com.si.servialdana.prime.adaptador;

/**
 * Created by ealmeida on 2/25/2017.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.si.servialdana.prime.R;
import com.si.servialdana.prime.sql.modelo.promocion;

import java.util.List;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class PromocionAdapter extends RecyclerView.Adapter<PromocionAdapter.MyViewHolder> {

    private Context mContext;
    private List<promocion> promocionList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }


    public PromocionAdapter(Context mContext, List<promocion> promocionList) {
        this.mContext = mContext;
        this.promocionList = promocionList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.catalogo_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        promocion promocion = promocionList.get(position);
        holder.title.setText(promocion.getName());


        // loading album cover using Glide library
        Glide.with(mContext).load(promocion.getThumbnail()).into(holder.thumbnail);


    }

    /**
     * Showing popup menu when tapping on 3 dots
     */


    /**
     * Click listener for popup menu items
     */


    @Override
    public int getItemCount() {
        return promocionList.size();
    }
}
