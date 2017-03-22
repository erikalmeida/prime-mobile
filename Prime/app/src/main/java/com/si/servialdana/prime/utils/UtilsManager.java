package com.si.servialdana.prime.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.si.servialdana.prime.R;

import java.io.InputStream;

/**
 * Created by ealmeida on 18/03/2017.
 */

public class UtilsManager {



    public String urlImagen(String imagen){
        return new StringBuilder().append("http://").append(Constantes.IP).append(":").append(Constantes.PUERTO_SERVICIO).append("/").append(imagen).toString().replace(" ","");
    }
}

class CargarImageView extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;
    boolean resultImage;

    public CargarImageView(ImageView bmImage) {
        this.bmImage = bmImage;
        resultImage = true;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            resultImage = false;
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        if (resultImage) {
            bmImage.setImageBitmap(result);
        } else {
            bmImage.setImageResource(R.drawable.album1);
        }

    }
}
