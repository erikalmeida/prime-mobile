package com.si.servialdana.prime.sql.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "tb_sistema")
public class Sistema {

    @DatabaseField(id = true)
    private int id;

    @DatabaseField
    private String celular;

    @DatabaseField
    private String correo;

    @DatabaseField
    private String direccion;

    @DatabaseField
    private String mapa;


    public Sistema(){

    }

    public Sistema(int id, String celular, String correo, String direccion, String mapa){
        this.id = id;
        this.direccion = direccion;
        this.celular = celular;
        this.correo = correo;
        this.mapa = mapa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }
}
