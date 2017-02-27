package com.si.servialdana.prime.modelo;

/**
 * Created by ealmeida on 2/27/2017.
 */

public class Presupuesto {
    private long id_presupuesto;
    private float monto_total;

    public Presupuesto(long id_presupuesto, float monto_total) {
        this.id_presupuesto = id_presupuesto;
        this.monto_total = monto_total;
    }

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
}
