package com.si.servialdana.prime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import android.support.design.widget.FloatingActionButton;


public class Principal extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView.LayoutManager manager;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButtonAgregarReclamo);
        fab.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.floatingActionButtonAgregarReclamo:
                break;
        }
    }
}
