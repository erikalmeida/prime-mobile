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
        LoginServicio ls = new LoginServicio();
        switch (v.getId()) {
            case R.id.buttonLogin:
                new LoginServicio().execute();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private class LoginServicio extends AsyncTask<Void, Void, Usuario> {

        Usuario usuario;

        @Override
        protected void onPreExecute() {
            EditText username = (EditText) findViewById(R.id.editTextUserLogin);
            EditText contrasenna = (EditText) findViewById(R.id.editTextPasswordLogin);
            usuario = new Usuario(username.getText().toString(), contrasenna.getText().toString());
        }

        @Override
        protected Usuario doInBackground(Void... params) {
            try {
                final String url = "http://812d8684.ngrok.io/servicios_crm/ServicioMovilPrime?solicitud=login";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                usuario = restTemplate.postForObject(url,this.usuario, Usuario.class);
                if(usuario!=null){
                    Log.i("Usuario", usuario.getCorreo());
                }
                else{
                    Log.i("Error", "Credenciales incorrectas");
                }
            } catch (Exception e) {
                Log.e("Login", e.getMessage(), e);
            }

            return usuario;
        }


        @Override
        protected void onPostExecute(Usuario usuario) {

        }

    }
}
