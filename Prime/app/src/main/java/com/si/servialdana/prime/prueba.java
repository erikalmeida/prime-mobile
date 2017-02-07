package com.si.servialdana.prime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.si.servialdana.prime.R;
import com.si.servialdana.prime.adaptador.RecyclerViewAdapterReclamos;
import java.util.ArrayList;
import java.util.List;

public class prueba extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios_curso);
        Button button = (Button) findViewById(R.id.buttonCalificar);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonCalificar:
                Intent intent= new Intent(this,CalificacionServicio.class);
                startActivity(intent);
                break;
        }
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
}
