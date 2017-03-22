package com.si.servialdana.prime;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import com.si.servialdana.prime.sql.modelo.Calificacion;
import com.si.servialdana.prime.utils.Constantes;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class CalificacionServicio extends AppCompatActivity implements View.OnClickListener{

    Calificacion calificacion = new Calificacion();
    private Button btnEnviarCalificacion;
    RatingBar ratingBarServicio;
    RatingBar ratingBarInstalacion;
    RatingBar ratingBarAtencion;
    EditText txtComentario;
    int idordenentrega;

    public Calificacion getCalificacion() {return calificacion;}

    public void setCalificacion(Calificacion calificacion) {this.calificacion = calificacion;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificacion);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnEnviarCalificacion = (Button) findViewById(R.id.btnEnviarCalificacion);
        ratingBarServicio = (RatingBar) findViewById(R.id.ratingBarServicio);
        ratingBarInstalacion = (RatingBar) findViewById(R.id.ratingBarInstalaciones);
        ratingBarAtencion = (RatingBar) findViewById(R.id.ratingBarAtencion);
        txtComentario = (EditText) findViewById(R.id.editTextComentarioCalificacion);
        btnEnviarCalificacion.setOnClickListener(this);
        Intent intent= getIntent();
        idordenentrega= intent.getIntExtra("idordenentrega",1);
    }

    @Override
    public void onClick(View v) {
        this.setCalificacion(new Calificacion());
        switch (v.getId()) {
            case R.id.btnEnviarCalificacion:
                new ServicioEnviarCalificacion().execute();
                break;

        }
        finish();
    }

    private class ServicioEnviarCalificacion extends AsyncTask<String, Void, Calificacion> {

        Calificacion calificacion;
        CalificacionServicio cs;

        @Override
        protected void onPreExecute() {
            cs = new CalificacionServicio();

            RatingBar ratingbarservicio = (RatingBar) findViewById(R.id.ratingBarServicio);
            RatingBar ratingbarinstalacion = (RatingBar) findViewById(R.id.ratingBarInstalaciones);
            RatingBar ratingbaratencion = (RatingBar) findViewById(R.id.ratingBarAtencion);
            EditText comentario = (EditText) findViewById(R.id.editTextComentarioCalificacion);
            int a = Math.round(ratingbarservicio.getRating());
            int b = Math.round(ratingbarinstalacion.getRating());
            int c = Math.round(ratingbaratencion.getRating());
            calificacion = new Calificacion(a, b, c, comentario.getText().toString(),idordenentrega);
        }

        @Override
        protected Calificacion doInBackground(String... params) {
            try {
                //String idordenentrega = params[0];
                final String url = "http://"+ Constantes.IP+":"+Constantes.PUERTO_SERVICIO+"/prime/ControladorPeticion?solicitud=calificacion";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                String urlParams = url + "&calificacionServicio=" + Integer.toString(calificacion.getCalificacionServicio()) +
                        "&calificacionInstalacion=" +Integer.toString(calificacion.getCalificacionInstalacion())+
                        "&calificacionAtencion="+Integer.toString(calificacion.getCalificacionAtencion())+
                        "&comentario="+calificacion.getComentario()+
                        "&idordenentrega="+ "1";//Long.toString(idordenentrega);
                //System.out.print(urlParams+"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                calificacion = restTemplate.postForObject(urlParams,this.calificacion, Calificacion.class);
                return calificacion;
            } catch (Exception e) {
                Log.e("CalificacionServicio", e.getMessage(), e);
            }
            return null;
        }
    }

}
