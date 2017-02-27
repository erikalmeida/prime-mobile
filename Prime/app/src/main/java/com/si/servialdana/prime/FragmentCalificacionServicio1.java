package com.si.servialdana.prime;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ealmeida on 2/26/2017.
 */

public class FragmentCalificacionServicio1 extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calificacion_servicio_1, container, false);
        return rootView;
    }
}
