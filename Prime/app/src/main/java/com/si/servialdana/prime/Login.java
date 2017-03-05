package com.si.servialdana.prime;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.AsyncTask;
import android.app.ProgressDialog;
import android.util.Base64;
import android.util.Base64.*;
import com.si.servialdana.prime.sql.modelo.Usuario;

import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

    /*@Override
    protected void onStart() {
        super.onStart();
        new LoginServicio().execute();
    }*/

    private class LoginServicio extends AsyncTask<Void, Void, Usuario> {
        @Override
        protected Usuario doInBackground(Void... params) {
            try {
                final String url = "http://rest-service.guides.spring.io/greeting";
                Usuario usuario = new Usuario("oscareduardo937","12345");
                Usuario respuesta;
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                respuesta = restTemplate.postForObject(url,usuario, Usuario.class);
                if(respuesta!=null){
                    //Codigo para llevar al menu de un usuario
                }
                else{
                    //Codigo para llevar al menu de un no usuario
                }
            } catch (Exception e) {
                Log.e("Login", e.getMessage(), e);
            }

            return null;
        }


        @Override
        protected void onPostExecute(Usuario usuario) {
            // Algun codigo para manejar la interfaz
        }

    }
}
