package com.si.servialdana.prime;


import android.app.Activity;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class BuzonSugerencias extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    //declare spinners
    Spinner spinnerTipo;
    Spinner spinnerMotivo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_buzon_sugerencias);
        // Spinner element
        spinnerTipo = (Spinner) findViewById(R.id.spinnerTipo);
        spinnerMotivo = (Spinner) findViewById(R.id.spinnerMotivo);



        // Spinner Drop down elements spinner tipo
        List<String> tipo = new ArrayList<String>();
        tipo.add("Queja");
        tipo.add("Sugerencia");
        tipo.add("Felicitaciones");

        List<String> motivo = new ArrayList<String>();
        motivo.add("Servicio");
        motivo.add("Instalaciones");
        motivo.add("Atención");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterTipo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipo);
        ArrayAdapter<String> dataAdapterMotivo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, motivo);

        // Drop down layout style - list view with radio button
        dataAdapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterMotivo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerTipo.setAdapter(dataAdapterTipo);
        spinnerMotivo.setAdapter(dataAdapterMotivo);

        // Spinner click listener
        spinnerTipo.setOnItemSelectedListener(this);
        spinnerMotivo.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item

        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
