package com.si.servialdana.prime.modelo;

import java.util.Date;

/**
 * Created by ealmeida on 2/25/2017.
 */

public class Promocion {
    private String name;
    private int thumbnail;
    private char id_promocion;
    private String url_image;
    private String descripcion;
    private float tarifa;
    private Date fecha_creacion;
    private int duracion;


    public Promocion() {
    }

    public Promocion(String name, int thumbnail, char id_promocion, String url_image, String descripcion, float tarifa, Date fecha_creacion, int duracion) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.id_promocion = id_promocion;
        this.url_image = url_image;
        this.descripcion = descripcion;
        this.tarifa = tarifa;
        this.fecha_creacion = fecha_creacion;
        this.duracion = duracion;
    }

    public Promocion(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public char getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(char id_promocion) {
        this.id_promocion = id_promocion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
