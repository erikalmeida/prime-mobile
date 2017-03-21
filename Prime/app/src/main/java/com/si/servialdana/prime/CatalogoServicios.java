package com.si.servialdana.prime;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.si.servialdana.prime.sql.modelo.Servicio;
import com.si.servialdana.prime.adaptador.ServicioAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.util.Log;
import android.os.AsyncTask;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.si.servialdana.prime.sql.conexion.DBHelper;

import android.content.Context;

public class CatalogoServicios extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ServicioAdapter adapter;
    private List<Servicio> servicioList;

    private DBHelper dbHelper;
    private RuntimeExceptionDao<Servicio, Integer> dao_servicios=null;

    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_servicios);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        servicioList = new ArrayList<>();
        adapter = new ServicioAdapter(this, servicioList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        try {
            Glide.with(this).load(R.drawable.carrito).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     @Override
    protected void onStart() {
        super.onStart();
        //new ServicioCatalogo().execute();
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.serviciocambioaceite,
                R.drawable.serviciocambiopastillas,
                R.drawable.serviciofrenos,
                R.drawable.service1,
                R.drawable.service2,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

        Servicio a = new Servicio(1,"Cambio de Aceite", covers[0], "");
        servicioList.add(a);

        a = new Servicio(2,"Cambio de pastillas", covers[1], "");
        servicioList.add(a);

        a = new Servicio(3,"Frenos", covers[2], "");
        servicioList.add(a);

        a = new Servicio(4,"Polea", covers[3], "");
        servicioList.add(a);

        a = new Servicio(5,"Servicio 1", covers[4], "");
        servicioList.add(a);

        a = new Servicio(6,"Servicio 2", covers[5], "");
        servicioList.add(a);

        a = new Servicio(7,"Servicio 3", covers[6], "");
        servicioList.add(a);

        a = new Servicio(8,"Servicio 4", covers[7], "");
        servicioList.add(a);

        a = new Servicio(9,"Servicio 5", covers[8], "");
        servicioList.add(a);

        a = new Servicio(10,"Servicio 6", covers[9], "");
        servicioList.add(a);

        adapter.notifyDataSetChanged();
    }

    public void guardarServicios(Context mcontext){
        dbHelper = (DBHelper) OpenHelperManager.getHelper(mcontext, DBHelper.class);
        this.dao_servicios= dbHelper.getRuntimeExceptionServicioDao();
        Servicio servi;

        for (int i=0; i<servicioList.size(); i++){

            servi = this.getServicioList().get(i);
            dao_servicios.create(servi);
        }

    }

    public List<Servicio> consultarServicios(){
        dbHelper = (DBHelper) OpenHelperManager.getHelper(this, DBHelper.class);
        this.dao_servicios= dbHelper.getRuntimeExceptionServicioDao();
        this.servicioList= dao_servicios.queryForAll();
        return this.servicioList;
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

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    private class ServicioCatalogo extends AsyncTask<Void, Void, Servicio[]> {
        @Override
        protected Servicio[] doInBackground(Void... params) {
            try {
                final String url = ""; //"https://bitpay.com/api/rates"
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<Servicio[]> responseEntity = restTemplate.getForEntity(url, Servicio[].class);
                Servicio[] servicios = responseEntity.getBody();
                /*MediaType contentType = responseEntity.getHeaders().getContentType();
                HttpStatus statusCode = responseEntity.getStatusCode();*/
                return servicios;
            } catch (Exception e) {
                Log.e("ServicioServicios", e.getMessage(), e);
            }

            return null;
        }


        @Override
        protected void onPostExecute(Servicio[] servicios) {
            List<Servicio> listaServicios = Arrays.asList(servicios);
            CatalogoServicios cp = new CatalogoServicios();
            cp.setServicioList(listaServicios);
            cp.guardarServicios(getApplicationContext());
        }

    }
}

