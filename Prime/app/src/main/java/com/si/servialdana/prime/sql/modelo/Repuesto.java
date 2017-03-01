package com.si.servialdana.prime.sql.modelo;

/**
 * Created by ealmeida on 2/27/2017.
 */

public class Repuesto {
    private long id_repuesto;
    private String nombre;
    private float precio_unitario;

    public Repuesto(long id_repuesto, String nombre, float precio_unitario) {
        this.id_repuesto = id_repuesto;
        this.nombre = nombre;
        this.precio_unitario = precio_unitario;
    }

    public long getId_repuesto() {
        return id_repuesto;
    }

    public void setId_repuesto(long id_repuesto) {
        this.id_repuesto = id_repuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
}
