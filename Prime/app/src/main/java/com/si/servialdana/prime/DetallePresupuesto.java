package com.si.servialdana.prime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetallePresupuesto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_presupuesto);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
