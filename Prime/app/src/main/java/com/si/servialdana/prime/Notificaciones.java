package com.si.servialdana.prime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.si.servialdana.prime.adaptador.RecyclerViewAdapterNotificaciones;
import com.si.servialdana.prime.adaptador.RecyclerViewAdapterReclamos;
import java.util.ArrayList;
import java.util.List;

public class Notificaciones extends AppCompatActivity {

    private RecyclerView.LayoutManager manager;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);
        recyclerView = (RecyclerView) findViewById(R.id.listaNotificaciones);
        List<String> titulos = new ArrayList<>();
        titulos.add(0,"Promocion por expirar");
        titulos.add(1,"Solicitud de reclamo");
        titulos.add(2,"Estatus de servicio");
        titulos.add(3,"Mantenimiento preventivo");
        titulos.add(4,"Promocion por expirar");
        titulos.add(5,"Solicitud de reclamo");
        titulos.add(6,"Estatus de servicio");
        titulos.add(7,"Cita pendiente");

        RecyclerViewAdapterNotificaciones adaptador=new RecyclerViewAdapterNotificaciones(titulos);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptador);

    }
}
