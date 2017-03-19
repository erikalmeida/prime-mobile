package com.si.servialdana.prime;

import android.content.Context;
import android.os.AsyncTask;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.si.servialdana.prime.sql.conexion.DBHelper;
import com.si.servialdana.prime.sql.modelo.TipoNotificacion;

import java.util.Arrays;
import java.util.List;

public class TipoNotificacionServicios extends AppCompatActivity{

    private List<TipoNotificacion> notificacionList;
    private DBHelper dbHelper;
    private RuntimeExceptionDao<TipoNotificacion, Integer> dao_tiponotificacion=null;

    public List<TipoNotificacion> getNotificacionList() {
        return notificacionList;
    }

    public void setNotificacionList(List<TipoNotificacion> notificacionList) {
        this.notificacionList = notificacionList;
    }
    @Override
    protected void onStart() {
        super.onStart();
        //new HttpRequestTask().execute();
    }

    public void guardarTipoNotificacion(Context mcontext){
        dbHelper = (DBHelper) OpenHelperManager.getHelper(mcontext, DBHelper.class);
        this.dao_tiponotificacion= dbHelper.getRuntimeExceptionTipoNotificacionDao();
        TipoNotificacion tipoNotificacion;
        tipoNotificacion = this.getNotificacionList().get(1);
        dao_tiponotificacion.create(tipoNotificacion);
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, TipoNotificacion[]> {

        TipoNotificacionServicios tns;

        @Override
        protected TipoNotificacion[] doInBackground(Void... params) {
            try {
                final String url = ""; //"https://bitpay.com/api/rates"
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<TipoNotificacion[]> responseEntity = restTemplate.getForEntity(url, TipoNotificacion[].class);
                TipoNotificacion[] tipoNotificaciones = responseEntity.getBody();
                /*MediaType contentType = responseEntity.getHeaders().getContentType();
                HttpStatus statusCode = responseEntity.getStatusCode();*/
                return tipoNotificaciones;
            } catch (Exception e) {
                Log.e("TipoNotificacionServ", e.getMessage(), e);
            }

            return null;
        }


        @Override
        protected void onPostExecute(TipoNotificacion[] tipoNotificacion) {
            List<TipoNotificacion> listaTipoNotificacion = Arrays.asList(tipoNotificacion);
            TipoNotificacionServicios tns = new TipoNotificacionServicios();
            tns.setNotificacionList(listaTipoNotificacion);
            tns.guardarTipoNotificacion(getApplicationContext());
        }

    }
}
