package com.si.servialdana.prime.sql.modelo;

import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by ealmeida on 2/26/2017.
 */

public class Calificacion {
    //private long id_calificacion;
    private int calificacionServicio;
    private int calificacionInstalacion;
    private int calificacionAtencion;
    private String comentario;


    public Calificacion() {
    }

    public Calificacion(int calificacionServicio, int calificacionInstalacion, int calificacionAtencion, String comentario) {
        this.calificacionServicio = calificacionServicio;
        this.calificacionInstalacion = calificacionInstalacion;
        this.calificacionAtencion = calificacionAtencion;
        this.comentario = comentario;
    }

   /* public long getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(long id_calificacion) {
        this.id_calificacion = id_calificacion;
    }*/

    public int getCalificacionServicio() {
        return calificacionServicio;
    }

    public void setCalificacionServicio(int calificacionServicio) {
        this.calificacionServicio = calificacionServicio;
    }

    public int getCalificacionInstalacion() {
        return calificacionInstalacion;
    }

    public void setCalificacionInstalacion(int calificacionInstalacion) {
        this.calificacionInstalacion = calificacionInstalacion;
    }

    public int getCalificacionAtencion() {
        return calificacionAtencion;
    }

    public void setCalificacionAtencion(int calificacionAtencion) {
        this.calificacionAtencion = calificacionAtencion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
