package com.si.servialdana.prime.modelo;

/**
 * Created by ealmeida on 2/26/2017.
 */

public class CalificacionServicio {
    private long id_calificacion_servicio;
    private long id_tipo_calificacion;

    public CalificacionServicio(long id_calificacion_servicio, long id_tipo_calificacion) {
        this.id_calificacion_servicio = id_calificacion_servicio;
        this.id_tipo_calificacion = id_tipo_calificacion;
    }

    public long getId_calificacion_servicio() {
        return id_calificacion_servicio;
    }

    public void setId_calificacion_servicio(long id_calificacion_servicio) {
        this.id_calificacion_servicio = id_calificacion_servicio;
    }

    public long getId_tipo_calificacion() {
        return id_tipo_calificacion;
    }

    public void setId_tipo_calificacion(long id_tipo_calificacion) {
        this.id_tipo_calificacion = id_tipo_calificacion;
    }
}
