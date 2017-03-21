package com.si.servialdana.prime.sql.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tb_servicio")
public class Servicio {

    @DatabaseField(id = true)
    private int id;

    @DatabaseField
    private String name;

    @DatabaseField
    private int thumbnail;

    @DatabaseField
    private String urlImagen;

    public Servicio() {
    }

    public Servicio(int id, String name, int thumbnail, String urlImagen) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.urlImagen = urlImagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImagen() {return urlImagen;}

    public void setUrlImagen(String urlImagen) {this.urlImagen = urlImagen;}

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

}
