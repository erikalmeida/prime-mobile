package com.si.servialdana.prime;

import android.content.Context;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import android.os.AsyncTask;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import android.util.Log;

import android.widget.TextView;
import com.si.servialdana.prime.sql.modelo.Sistema;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.si.servialdana.prime.sql.conexion.DBHelper;

import com.si.servialdana.prime.Fragment_quienes_somos_ubicanos;

public class SistemaServicio extends AppCompatActivity {

    private Sistema sistema;
    private DBHelper dbHelper;
    private RuntimeExceptionDao<Sistema, Integer> dao_sistema=null;

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onStart() {
        super.onStart();
        //new HttpRequestTask().execute();
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

    public void guardarSistema(Context mcontext){
        dbHelper = (DBHelper) OpenHelperManager.getHelper(mcontext, DBHelper.class);
        dao_sistema= dbHelper.getRuntimeExceptionSistemaDao();
        //dao_sistema.createIfNotExists(this.getSistema());
        dao_sistema.create(this.getSistema());
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, Sistema> {

        SistemaServicio ss;

        @Override
        protected Sistema doInBackground(Void... params) {
            try {
                Sistema sistema = new Sistema();
                final String url = "http://192.168.1.113:8080/prime/ControladorPeticion?solicitud=sistema"; //"https://d3f8c86f.ngrok.io/servicios_crm/ServicioMovilPrime?solicitud=sistema";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                sistema = restTemplate.getForObject(url, Sistema.class);
                Log.i("Correo:", sistema.getCorreo());
                return sistema;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }


        @Override
        protected void onPostExecute(Sistema sistema) {
            TextView idTextUbicanos = (TextView) findViewById(R.id.textViewUbicanosDireccion);
            TextView idTextCelular = (TextView) findViewById(R.id.textViewCelular);
            TextView idTextCorreo = (TextView) findViewById(R.id.textViewCorreoEmpresa);
            idTextUbicanos.setText(sistema.getDireccion());
            idTextCelular.setText(sistema.getCelular());
            idTextCorreo.setText(sistema.getCorreo());
            ss = new SistemaServicio();
            ss.setSistema(sistema);
            ss.guardarSistema(getApplicationContext());
        }

    }


}