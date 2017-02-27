package com.si.servialdana.prime;

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
import java.sql.SQLException;
import android.widget.Toast;

public class SistemaServicio extends AppCompatActivity {

    private Sistema sistema;
    private DBHelper dbHelper;
    private RuntimeExceptionDao<Sistema, String> dao_sistema=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.guardarSistema();
    }

    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestTask().execute();
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

    public void guardarSistema(){
        dbHelper = (DBHelper) OpenHelperManager.getHelper(this, DBHelper.class);
        dao_sistema= dbHelper.getRuntimeExceptionSistemaDao();
        dao_sistema.create(new Sistema("1123","contenido"));
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, Sistema> {
        @Override
        protected Sistema doInBackground(Void... params) {
            try {
                final String url = "http://rest-service.guides.spring.io/greeting";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Sistema sistema = restTemplate.getForObject(url, Sistema.class);
                return sistema;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }


        @Override
        protected void onPostExecute(Sistema sistema) {
            TextView IdText = (TextView) findViewById(R.id.id_value);
            TextView ContentText = (TextView) findViewById(R.id.content_value);
            IdText.setText(sistema.getId());
            ContentText.setText(sistema.getContent());
        }

    }

}