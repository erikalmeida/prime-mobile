package com.si.servialdana.prime;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.os.AsyncTask;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import android.util.Log;

import android.widget.TextView;
import com.si.servialdana.prime.sql.modelo.Sistema;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.si.servialdana.prime.sql.conexion.DBHelper;
import com.si.servialdana.prime.utils.Constantes;

public class QuienesSomos extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

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
        setContentView(R.layout.activity_quienes_somos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }


    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestTask().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quienes_somos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.



        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go Home
                Intent intent = new Intent(this, Home.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    /**
     * A placeholder fragment containing a simple view.
     */

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Fragment_quienes_somos_contactanos tab1 = new Fragment_quienes_somos_contactanos();
                    return tab1;
                case 1:
                    Fragment_quienes_somos_ubicanos tab2 = new Fragment_quienes_somos_ubicanos();
                    return tab2;
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Contactanos";
                case 1:
                    return "Ubicanos";
            }
            return null;
        }

    } //Class Sections Pager Adapter

    public void guardarSistema(Context mcontext){
        dbHelper = (DBHelper) OpenHelperManager.getHelper(mcontext, DBHelper.class);
        dao_sistema= dbHelper.getRuntimeExceptionSistemaDao();
        //dao_sistema.createIfNotExists(this.getSistema());
        dao_sistema.createIfNotExists(this.getSistema());
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, Sistema> {

        QuienesSomos qs;

        @Override
        protected Sistema doInBackground(Void... params) {
            try {
                //Sistema sistema = new Sistema();
                final String url = "http://"+ Constantes.IP+":"+ Constantes.PUERTO_SERVICIO+"/prime/ControladorPeticion?solicitud=sistema"; //"https://d3f8c86f.ngrok.io/servicios_crm/ServicioMovilPrime?solicitud=sistema";
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
             qs = new QuienesSomos();
            qs.setSistema(sistema);
            qs.guardarSistema(getApplicationContext());
        }

    }
}
