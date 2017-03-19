package com.si.servialdana.prime.sql.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by ealmeida on 11/03/2017.
 */
@DatabaseTable(tableName = "tb_notificacion")
public class Notificacion {

    @DatabaseField(id = true)
    private int idnotificacion;
    @DatabaseField
    private int idtiponotificacion;
    @DatabaseField
    private int idpromocion;
    @DatabaseField
    private int idpresupuesto;
    @DatabaseField
    private int idordenentrega;
    @DatabaseField
    private int ideventualidad;
    @DatabaseField
    private String nombre;
    @DatabaseField
    private String descripcion;
    @DatabaseField
    private String fechacreacion;

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @DatabaseField
    private String estatus;

    public Notificacion(){

    }

    public Notificacion(int idnotificacion, int idtiponotificacion, int idpromocion, int idpresupuesto, int idordenentrega, int ideventualidad, String nombre, String descripcion, String fechacreacion, String estatus) {
        this.idnotificacion = idnotificacion;
        this.idtiponotificacion = idtiponotificacion;
        this.idpromocion = idpromocion;
        this.idpresupuesto = idpresupuesto;
        this.idordenentrega = idordenentrega;
        this.ideventualidad = ideventualidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechacreacion = fechacreacion;
        this.estatus= estatus;
    }


    public int getIdnotificacion() {return idnotificacion;}

    public void setIdnotificacion(int idnotificacion) {this.idnotificacion = idnotificacion;}

    public int getIdtiponotificacion() {return idtiponotificacion;}

    public void setIdtiponotificacion(int idtiponotificacion) {this.idtiponotificacion = idtiponotificacion;}

    public int getIdpromocion() {return idpromocion;}

    public void setIdpromocion(int idpromocion) {this.idpromocion = idpromocion;}

    public int getIdpresupuesto() {return idpresupuesto;}

    public void setIdpresupuesto(int idpresupuesto) {this.idpresupuesto = idpresupuesto;}

    public int getIdordenentrega() {return idordenentrega;}

    public void setIdordenentrega(int idordenentrega) {this.idordenentrega = idordenentrega;}

    public int getIdeventualidad() {return ideventualidad;}

    public void setIdeventualidad(int ideventualidad) {this.ideventualidad = ideventualidad;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public String getFechacreacion() {return fechacreacion;}

    public void setFechacreacion(String fechacreacion) {this.fechacreacion = fechacreacion;}
}
