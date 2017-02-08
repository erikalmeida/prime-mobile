package com.si.servialdana.prime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.si.servialdana.prime.adaptador.RecyclerViewAdapterHistorialCitas;
import java.util.ArrayList;
import java.util.List;

public class HistorialCitas extends AppCompatActivity{
    private RecyclerView.LayoutManager manager;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_citas);
        recyclerView = (RecyclerView) findViewById(R.id.listaHistorialCitas);
        List<String> descricpion = new ArrayList<>();
        descricpion.add(0,"Cambio de Aceite, Limpieza de Inyectores");
        descricpion.add(1,"Reemplazo de Bobina, Alineacion y Balanceo");
        descricpion.add(2,"Cambio de correa del tiempo, Reemplazo de Caja");
        descricpion.add(3,"Mantenimiento preventivo");
        descricpion.add(4,"Limpieza de inyectores, Cambio de aceite, Reemplazo de Bujias");
        descricpion.add(5,"Alineacion y Balanceo");
        descricpion.add(6,"Reemplazo de Bobina,Reemplazo de Caja, Alineacion y Balanceo");
        descricpion.add(7,"Cambio de Aceite");

        RecyclerViewAdapterHistorialCitas adaptador=new RecyclerViewAdapterHistorialCitas(descricpion);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptador);

    }
}
