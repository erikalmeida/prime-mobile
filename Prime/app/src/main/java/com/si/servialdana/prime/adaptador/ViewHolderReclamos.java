package com.si.servialdana.prime.adaptador;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.si.servialdana.prime.R;

public class ViewHolderReclamos extends RecyclerView.ViewHolder{

    CardView cv;
    TextView asunto;
    TextView fecha;
    TextView tipo;
    TextView estatus;

    ViewHolderReclamos(View itemView){
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cvReclamos);
        asunto = (TextView) itemView.findViewById(R.id.textViewAsuntoTexto);
        fecha = (TextView) itemView.findViewById(R.id.textViewFechaTexto);
        tipo = (TextView) itemView.findViewById(R.id.textViewTipoTexto);

    }


}
