package com.si.servialdana.prime.adaptador;


import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.si.servialdana.prime.R;

public class ViewHolderListaPromociones extends RecyclerView.ViewHolder {

    CardView cv;
    TextView titulo;
    TextView contenido;
    ImageView tipo;
    ImageView tipo2;
    ImageView tipo3;

    ViewHolderListaPromociones(View itemView){
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cvPromocion);
        titulo = (TextView) itemView.findViewById(R.id.textView4);
        contenido = (TextView) itemView.findViewById(R.id.textView6);
        tipo = (ImageView) itemView.findViewById(R.id.imageView5);
        tipo = (ImageView) itemView.findViewById(R.id.imageView4);
        tipo = (ImageView) itemView.findViewById(R.id.imageView9);


    }
}