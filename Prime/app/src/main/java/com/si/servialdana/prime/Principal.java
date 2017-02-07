package com.si.servialdana.prime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.si.servialdana.prime.R;
import com.si.servialdana.prime.adaptador.RecyclerViewAdapterReclamos;
import java.util.ArrayList;
import java.util.List;

import android.support.design.widget.FloatingActionButton;


public class Principal extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView.LayoutManager manager;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamos);
        recyclerView = (RecyclerView) findViewById(R.id.listaReclamos);
        List<String> asuntos = new ArrayList<>();
        asuntos.add(0,"El motor no enciende");
        asuntos.add(1,"El auto esta derramando aceite");
        asuntos.add(2,"El motor suena muy feo");
        asuntos.add(3,"Los cauchos estan espichados");
        asuntos.add(4,"No estoy de acuerdo con el precio");
        asuntos.add(5,"Frenos no funcionan!!!");
        asuntos.add(6,"Derrame de aceite");
        asuntos.add(7,"Bateria dañada de nuevo");

        RecyclerViewAdapterReclamos adaptador=new RecyclerViewAdapterReclamos(asuntos);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptador);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButtonAgregarReclamo);
        fab.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.floatingActionButtonAgregarReclamo:
                Intent intent= new Intent(this,SolicitudReclamo.class);
                startActivity(intent);
                break;
        }
    }
}
