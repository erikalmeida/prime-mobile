package com.si.servialdana.prime.sql.modelo;

import java.util.Date;

/**
 * Created by ealmeida on 2/27/2017.
 */

public class Presupuesto {
    private long id_presupuesto;
    private float monto_total;
    private Date fecha_creacion;
    private String estado;

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Presupuesto(long id_presupuesto, float monto_total, String estado) {
        this.id_presupuesto = id_presupuesto;
        this.monto_total = monto_total;
        this.estado = estado;
    }

    public Presupuesto() {}

    public long getId_presupuesto() {
        return id_presupuesto;
    }

    public void setId_presupuesto(long id_presupuesto) {
        this.id_presupuesto = id_presupuesto;
    }

    public float getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(float monto_total) {
        this.monto_total = monto_total;
    }

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}
}
