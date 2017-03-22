package com.si.servialdana.prime;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.si.servialdana.prime.adaptador.PromocionAdapter;
import com.si.servialdana.prime.sql.modelo.Promocion;

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

public class CatalogoPromociones extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PromocionAdapter adapter;
    private List<Promocion> promocionList;

    private DBHelper dbHelper;
    private RuntimeExceptionDao<Promocion, Integer> dao_promociones=null;

    public void setPromocionList(List<Promocion> promocionList){
        this.promocionList = promocionList;
    }

    public List<Promocion> getPromocionList(){
        return this.promocionList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_promociones);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initCollapsingToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        promocionList = new ArrayList<>();
        adapter = new PromocionAdapter(this, promocionList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        //Promociones que vienen de la BD.
        prepareAlbums();

        try {
            Glide.with(this).load(R.drawable.cover).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //new ServicioPromociones().execute();
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
                R.drawable.service2,
                R.drawable.service1,
                R.drawable.serviciofrenos,
                R.drawable.serviciocambiopastillas,
                R.drawable.serviciocambioaceite};

        Promocion a = new Promocion(1,"2x1 alineacion", covers[0]);
        promocionList.add(a);

        a = new Promocion(2,"50% cambio aceite", covers[1]);
        promocionList.add(a);

        a = new Promocion(3," frenos dia del padre", covers[2]);
        promocionList.add(a);

        a = new Promocion(4,"Born to Die", covers[3]);
        promocionList.add(a);



        adapter.notifyDataSetChanged();
    }

    public void guardarPromociones(Context mcontext){
        dbHelper = (DBHelper) OpenHelperManager.getHelper(mcontext, DBHelper.class);
        this.dao_promociones= dbHelper.getRuntimeExceptionPromocionDao();
        Promocion Promocion;
        Promocion = this.getPromocionList().get(1);
        dao_promociones.create(Promocion);
    }

    public List<Promocion> consultarPromociones(){
        dbHelper = (DBHelper) OpenHelperManager.getHelper(this, DBHelper.class);
        this.dao_promociones= dbHelper.getRuntimeExceptionPromocionDao();
        this.promocionList= dao_promociones.queryForAll();
        return this.promocionList;
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

    private class ServicioPromociones extends AsyncTask<Void, Void, Promocion[]> {
        @Override
        protected Promocion[] doInBackground(Void... params) {
            try {
                final String url = ""; //"https://bitpay.com/api/rates"
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<Promocion[]> responseEntity = restTemplate.getForEntity(url, Promocion[].class);
                Promocion[] promociones = responseEntity.getBody();
                /*MediaType contentType = responseEntity.getHeaders().getContentType();
                HttpStatus statusCode = responseEntity.getStatusCode();*/
                return promociones;
            } catch (Exception e) {
                Log.e("ServicioPromocion", e.getMessage(), e);
            }

            return null;
        }


        @Override
        protected void onPostExecute(Promocion[] promociones) {
            List<Promocion> listaPromocion = Arrays.asList(promociones);
            CatalogoPromociones cp = new CatalogoPromociones();
            cp.setPromocionList(listaPromocion);
            cp.guardarPromociones(getApplicationContext());
        }

    }
}
