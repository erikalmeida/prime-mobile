package com.si.servialdana.prime;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.si.servialdana.prime.sql.modelo.Calificacion;
import com.si.servialdana.prime.utils.Constantes;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import static com.si.servialdana.prime.R.id.ratingBar;
import static com.si.servialdana.prime.R.id.ratingBarServicio;

public class CalificacionServicio extends AppCompatActivity implements View.OnClickListener{

    Calificacion calificacion = new Calificacion();
    private Button btnEnviarCalificacion;
    RatingBar ratingBarServicio;
    RatingBar ratingBarInstalacion;
    RatingBar ratingBarAtencion;
    EditText txtComentario;

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


    }

    @Override
    public void onClick(View v) {
        this.setCalificacion(new Calificacion());
        switch (v.getId()) {
            case R.id.btnEnviarCalificacion:
                new ServicioEnviarCalificacion().execute();
                break;

        }
    }

    private class ServicioEnviarCalificacion extends AsyncTask<Void, Void, Calificacion> {

        Calificacion calificacion;
        CalificacionServicio cs;

        @Override
        protected void onPreExecute() {
            cs = new CalificacionServicio();

            RatingBar ratingbarservicio = (RatingBar) findViewById(R.id.ratingBarServicio);
            RatingBar ratingbarinstalacion = (RatingBar) findViewById(R.id.ratingBarInstalaciones);
            RatingBar ratingbaratencion = (RatingBar) findViewById(R.id.ratingBarAtencion);
            EditText comentario = (EditText) findViewById(R.id.editTextComentarioCalificacion);

            calificacion = new Calificacion(ratingbarservicio.getNumStars(), ratingbarinstalacion.getNumStars(), ratingbaratencion.getNumStars(), comentario.getText().toString());
        }

        @Override
        protected Calificacion doInBackground(Void... params) {
            try {
                final String url = "https://"+ Constantes.IP+"/"+Constantes.PUERTO_SERVICIO+"prime/ControladorPeticion?solicitud=presupuesto";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                String urlParams = url + "&calificacionServicio=" + calificacion.getCalificacionServicio() +
                                         "&calificacionInstalacion=" +calificacion.getCalificacionInstalacion()+
                                         "&calificacionAtencion="+calificacion.getCalificacionAtencion()+
                                         "&comentario="+calificacion.getComentario();
                calificacion = restTemplate.postForObject(urlParams,this.calificacion, Calificacion.class);
                return calificacion;
            } catch (Exception e) {
                Log.e("CalificacionServicio", e.getMessage(), e);
            }
            return null;
        }
    }

}
