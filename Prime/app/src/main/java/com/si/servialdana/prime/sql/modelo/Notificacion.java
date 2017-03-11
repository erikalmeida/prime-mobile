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
    private int id;
    @DatabaseField
    private int idTipo;
    @DatabaseField
    private int idPromocion;
    @DatabaseField
    private int idPresupuesto;
    @DatabaseField
    private int idOrdenEntrega;
    @DatabaseField
    private int idEventualidad;
    @DatabaseField
    private String name;
    @DatabaseField
    private String descripcion;
    @DatabaseField
    private Date fechaCreacion;

    public Notificacion(int id, int idTipo, int idPromocion, int idPresupuesto, int idOrdenEntrega, int idEventualidad, String name, String descripcion, Date fechaCreacion) {
        this.id = id;
        this.idTipo = idTipo;
        this.idPromocion = idPromocion;
        this.idPresupuesto = idPresupuesto;
        this.idOrdenEntrega = idOrdenEntrega;
        this.idEventualidad = idEventualidad;
        this.name = name;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
    }


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public int getIdTipo() {return idTipo;}

    public void setIdTipo(int idTipo) {this.idTipo = idTipo;}

    public int getIdPromocion() {return idPromocion;}

    public void setIdPromocion(int idPromocion) {this.idPromocion = idPromocion;}

    public int getIdPresupuesto() {return idPresupuesto;}

    public void setIdPresupuesto(int idPresupuesto) {this.idPresupuesto = idPresupuesto;}

    public int getIdOrdenEntrega() {return idOrdenEntrega;}

    public void setIdOrdenEntrega(int idOrdenEntrega) {this.idOrdenEntrega = idOrdenEntrega;}

    public int getIdEventualidad() {return idEventualidad;}

    public void setIdEventualidad(int idEventualidad) {this.idEventualidad = idEventualidad;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public Date getFechaCreacion() {return fechaCreacion;}

    public void setFechaCreacion(Date fechaCreacion) {this.fechaCreacion = fechaCreacion;}
}
