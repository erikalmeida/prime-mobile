package com.si.servialdana.prime.sql.modelo;

/**
 * Created by ealmeida on 2/26/2017.
 */

public class TipoCalificacionServicio {
    private long id_tipo_calificacion;
    private String comentario;
    private int calificacion;

    public TipoCalificacionServicio(long id_tipo_calificacion, String comentario, int calificacion) {
        this.id_tipo_calificacion = id_tipo_calificacion;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public long getId_tipo_calificacion() {
        return id_tipo_calificacion;
    }

    public void setId_tipo_calificacion(long id_tipo_calificacion) {
        this.id_tipo_calificacion = id_tipo_calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
