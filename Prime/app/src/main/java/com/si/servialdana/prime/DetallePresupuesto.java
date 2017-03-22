package com.si.servialdana.prime;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

import com.si.servialdana.prime.sql.modelo.Presupuesto;
import com.si.servialdana.prime.sql.modelo.Sistema;
import com.si.servialdana.prime.utils.Constantes;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.Date;

public class DetallePresupuesto extends AppCompatActivity implements View.OnClickListener {

    private Presupuesto presupuesto;
    private Button btnAceptar;
    private Button btnRechazar;
    private int idpresupuesto;

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_presupuesto);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        idpresupuesto = extras.getInt("idpresupuesto");
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnRechazar = (Button) findViewById(R.id.btnRechazar);
        btnAceptar.setOnClickListener(this);
        btnRechazar.setOnClickListener(this);
        //new ServicioNotificacionPresupuesto().execute(Integer.toString(idpresuppuesto));
        //new ServicioNotificacionPresupuesto().execute();
    }


    @Override
    public void onClick(View v) {
        Presupuesto presu = new Presupuesto();
        switch (v.getId()) {
            case R.id.btnAceptar:
                new ServicioAceptarPresupuesto().execute();
                break;
            case R.id.btnRechazar:
                new ServicioRechazarPresupuesto().execute();
                break;
        }

        finish();

       /* Intent myIntent2 = new Intent(getApplicationContext(), DetallePresupuesto.class);
        v.getContext().finish(myIntent2);*/
    }

    public class ServicioNotificacionPresupuesto extends AsyncTask<String, Void, Presupuesto> {


        @Override
        protected Presupuesto doInBackground(String... params) {
            try {
                //Presupuesto presupuesto = new Presupuesto();
                //String id = params[0];
                String id = Integer.toString(idpresupuesto);
                final String url = "http://"+Constantes.IP+":"+Constantes.PUERTO_SERVICIO+"/prime/ControladorPeticion?solicitud=presupuestobuscar";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                String urlParams = url + "&idpresupuesto=" + id ;
                presupuesto = restTemplate.getForObject(urlParams, Presupuesto.class);
                Log.i("Correo:", Long.toString(presupuesto.getId_presupuesto()));
                return presupuesto;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Presupuesto presupuesto) {

           /* DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date hoy = presupuesto.getFecha_creacion();
            String reportDate = df.format(hoy);*/
            TextView txtFecha = (TextView) findViewById(R.id.textViewFechaPresupuesto);
            TextView txtMontoTotal = (TextView) findViewById(R.id.textViewMontoTotal);

            //txtFecha.setText(reportDate);
//            txtMontoTotal.setText(Float.toString(presupuesto.getMonto_total()));

        }
    }

    public class ServicioAceptarPresupuesto extends AsyncTask<Void, Void, Presupuesto> {

        Presupuesto presupuesto;

        @Override
        protected Presupuesto doInBackground(Void... params) {
            try {
                final String url = "http://"+Constantes.IP+":"+Constantes.PUERTO_SERVICIO+"/prime/ControladorPeticion?solicitud=presupuesto";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                String urlParams = url + "&idpresupuesto=" +  Integer.toString(idpresupuesto)+ "&estado=" + "Validada";
                presupuesto = restTemplate.postForObject(urlParams,this.presupuesto, Presupuesto.class);
                return presupuesto;
            } catch (Exception e) {
                Log.e("DetallePresupuesto", e.getMessage(), e);
            }
            return null;
        }
    }

    public class ServicioRechazarPresupuesto extends AsyncTask<Void, Void, Presupuesto> {

        Presupuesto presupuesto;

        @Override
        protected Presupuesto doInBackground(Void... params) {
            try {
                final String url = "http://"+Constantes.IP+":"+Constantes.PUERTO_SERVICIO+"/prime/ControladorPeticion?solicitud=presupuesto";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                String urlParams = url + "&idpresupuesto=" + Integer.toString(idpresupuesto) + "&estado=" + "Rechazada";
                presupuesto = restTemplate.postForObject(urlParams,this.presupuesto, Presupuesto.class);
                return presupuesto;
            } catch (Exception e) {
                Log.e("DetallePresupuesto", e.getMessage(), e);
            }
            return null;
        }
    }


}