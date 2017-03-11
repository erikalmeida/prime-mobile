package com.si.servialdana.prime;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
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

public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin;
    private EditText txtUsuario;
    private EditText txtContrasenna;
    private Usuario usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnLogin = (Button) findViewById(R.id.buttonLogin);
        txtUsuario = (EditText) findViewById(R.id.editTextUserLogin);
        txtContrasenna = (EditText) findViewById(R.id.editTextPasswordLogin);
        btnLogin.setOnClickListener(this);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonLogin:
                this.usuario = new Usuario(this.txtUsuario.getText().toString(), this.txtContrasenna.getText().toString());
                Toast.makeText(this, this.txtUsuario.getText(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private class LoginServicio extends AsyncTask<Void, Void, Usuario> {
        @Override
        protected Usuario doInBackground(Void... params) {
            try {
                final String url = "http://192.168.1.107:8080/servicios_crm/ServicioMovilPrime?solicitud=";
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
