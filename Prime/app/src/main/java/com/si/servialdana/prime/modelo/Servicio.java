package com.si.servialdana.prime.modelo;

import java.util.Date;
/**
 * Created by ealmeida on 2/14/2017.
 */

public class Servicio {

    private String name;
    private int numOfSongs;
    private int thumbnail;
    private long id_servicio;
    private String url_image;
    private String descripcion;
    private long tarifa;
    private Date fecha_creacion;

    public Servicio() {
    }

    public Servicio(String name, int numOfSongs, int thumbnail, long id_servicio, String url_image, String descripcion, Date fecha_creacion, long tarifa) {
        this.name = name;
        this.numOfSongs = numOfSongs;
        this.thumbnail = thumbnail;
        this.id_servicio = id_servicio;
        this.url_image = url_image;
        this.descripcion = descripcion;
        this.fecha_creacion = fecha_creacion;
        this.tarifa = tarifa;
    }

    public Servicio(String name, int thumbnail) {
        this.name = name;
        this.numOfSongs = numOfSongs;
        this.thumbnail = thumbnail;
    }

    public long getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(long id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getTarifa() {
        return tarifa;
    }

    public void setTarifa(long tarifa) {
        this.tarifa = tarifa;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

}

