package com.si.servialdana.prime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.os.AsyncTask;
import android.widget.Button;

import com.si.servialdana.prime.sql.modelo.Presupuesto;
import com.si.servialdana.prime.utils.Constantes;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class DetallePresupuesto extends AppCompatActivity implements View.OnClickListener {

    private Presupuesto presupuesto;
    private Button btnAceptar;
    private Button btnRechazar;

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
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnRechazar = (Button) findViewById(R.id.btnRechazar);
        btnAceptar.setOnClickListener(this);
        btnRechazar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        this.setPresupuesto(new Presupuesto());
        switch (v.getId()) {
            case R.id.btnAceptar:
                this.presupuesto.setEstado("Validada");
                new ServicioAceptarPresupuesto().execute();
                break;
            case R.id.btnRechazar:
                this.presupuesto.setEstado("Rechazada");
                new ServicioAceptarPresupuesto().execute();
                break;
        }
    }

    /*private class ServicioNotificacionPresupuesto extends AsyncTask<Void, Void, Presupuesto> {

    }*/

    private class ServicioAceptarPresupuesto extends AsyncTask<Void, Void, Presupuesto> {

        Presupuesto presupuesto;
        DetallePresupuesto dp;

        @Override
        protected void onPreExecute() {
            dp = new DetallePresupuesto();
            presupuesto = dp.getPresupuesto();
        }

        @Override
        protected Presupuesto doInBackground(Void... params) {
            try {
                final String url = "http://"+ Constantes.IP+":"+ Constantes.PUERTO_SERVICIO+"/prime/ControladorPeticion?solicitud=presupuesto";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                String urlParams = url + "&idpresupuesto=" + "21" + "&estado=" + "Validado";
                presupuesto = restTemplate.postForObject(urlParams,this.presupuesto, Presupuesto.class);
                return presupuesto;
            } catch (Exception e) {
                Log.e("DetallePresupuesto", e.getMessage(), e);
            }
            return null;
        }
    }


}