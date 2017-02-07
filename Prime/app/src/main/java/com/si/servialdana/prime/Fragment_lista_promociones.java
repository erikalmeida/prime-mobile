package com.si.servialdana.prime;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.si.servialdana.prime.adaptador.RecyclerViewAdapterListaPromociones;
import java.util.ArrayList;
import java.util.List;

public class Fragment_lista_promociones extends AppCompatActivity {

    private RecyclerView.LayoutManager manager;
    private RecyclerView recyclerView;

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lista_promociones, container, false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_lista_promociones);
        recyclerView = (RecyclerView) findViewById(R.id.listaPromociones);
        List<String> titulos = new ArrayList<>();
        titulos.add(0,"Promocion por expirar");
        titulos.add(1,"Solicitud de reclamo");
        titulos.add(2,"Estatus de servicio");
        titulos.add(3,"Mantenimiento preventivo");
        titulos.add(4,"Promocion por expirar");
        titulos.add(5,"Solicitud de reclamo");
        titulos.add(6,"Estatus de servicio");
        titulos.add(7,"Cita pendiente");

        RecyclerViewAdapterListaPromociones adaptador=new RecyclerViewAdapterListaPromociones(titulos);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptador);
        return rootView;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_lista_promociones);
        recyclerView = (RecyclerView) findViewById(R.id.listaPromociones);
        List<String> titulos = new ArrayList<>();
        titulos.add(0,"Cambio de Aceite 2x1");
        titulos.add(1,"Cambio Correa del tiempo 50% de Dscto");
        titulos.add(2,"Alineacion al 30% de Dscto");
        titulos.add(3,"Cambio de Catalizador -20%");
        titulos.add(4,"Lunes de Mantenimiento Preventivo 2x1");
        titulos.add(5,"Balanceo al 50% de Dscto");
        titulos.add(6,"Limpieza de Motor 20% de Dscto");
        titulos.add(7,"Revision del AA 20% de Dscto");

        RecyclerViewAdapterListaPromociones adaptador=new RecyclerViewAdapterListaPromociones(titulos);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptador);

    }
}
