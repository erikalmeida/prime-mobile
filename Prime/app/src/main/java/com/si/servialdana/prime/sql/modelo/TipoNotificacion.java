package com.si.servialdana.prime.sql.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by ealmeida on 11/03/2017.
 */
@DatabaseTable(tableName = "tb_tiponotificacion")
public class TipoNotificacion {

    @DatabaseField (id = true)
    private int id;
    @DatabaseField
    private String descripcion;
    @DatabaseField
    private String icono;

    public TipoNotificacion(int id, String descripcion, String icono) {
        this.id = id;
        this.descripcion = descripcion;
        this.icono = icono;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public String getIcono() {return icono;}

    public void setIcono(String icono) {this.icono = icono;}
}
