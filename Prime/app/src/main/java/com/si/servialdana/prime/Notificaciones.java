package com.si.servialdana.prime;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import com.si.servialdana.prime.adaptador.RecyclerViewAdapterNotificaciones;
import com.si.servialdana.prime.sql.modelo.Notificacion;
import com.si.servialdana.prime.utils.Constantes;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class Notificaciones extends AppCompatActivity {

    private RecyclerView.LayoutManager manager;
    private RecyclerView recyclerView;
    private List<Notificacion> notificacionList;

    public List<Notificacion> getNotificacionList(){ return notificacionList;}
    public void setNotificacionList(List<Notificacion> notificacionList) {this.notificacionList = notificacionList;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);
        /*recyclerView = (RecyclerView) findViewById(R.id.listaNotificaciones);


        RecyclerViewAdapterNotificaciones adaptador=new RecyclerViewAdapterNotificaciones(notificacionList);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptador);*/
        new ServicioNotificacion().execute();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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


    private class ServicioNotificacion extends AsyncTask<Void, Void, Notificacion[]> {

        HashMap<String, String> user;
        // User Session Manager Class
        UserSessionManager session;

        @Override
        protected Notificacion[] doInBackground(Void... params) {
            try {
                session = new UserSessionManager(getApplicationContext());
                user = session.getUserDetails();
                String id = user.get(UserSessionManager.KEY_ID);
                final String url = "http://"+ Constantes.IP+":"+ Constantes.PUERTO_SERVICIO+"/prime/ControladorPeticion?solicitud=notificaciones"; //"https://bitpay.com/api/rates"
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                String urlParams = url + "&idusuario=" + id ;
                ResponseEntity<Notificacion[]> responseEntity = restTemplate.getForEntity(urlParams, Notificacion[].class);
                Notificacion[] notificaciones = responseEntity.getBody();
                /*MediaType contentType = responseEntity.getHeaders().getContentType();
                HttpStatus statusCode = responseEntity.getStatusCode();*/
                return notificaciones;
            } catch (Exception e) {
                Log.e("ServicioNotificacion", e.getMessage(), e);
            }

            return null;
        }


        @Override
        protected void onPostExecute(Notificacion[] notificaciones) {
            List<Notificacion> listaNotificaciones = Arrays.asList(notificaciones);
            Notificaciones n = new Notificaciones();
            // n.setNotificacionList(listaNotificaciones);
            recyclerView = (RecyclerView) findViewById(R.id.listaNotificaciones);
            RecyclerViewAdapterNotificaciones adaptador=new RecyclerViewAdapterNotificaciones(listaNotificaciones);
            manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(adaptador);
        }

    }



}
