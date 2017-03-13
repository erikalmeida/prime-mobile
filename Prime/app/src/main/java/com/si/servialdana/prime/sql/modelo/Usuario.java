package com.si.servialdana.prime.sql.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tb_usuario")
public class Usuario {

    @DatabaseField(id = true)
    private Long id;

    @DatabaseField
    private String correo;

    @DatabaseField
    private String contrasenna;


    public Usuario() {
    }

    public Usuario(String correo, String contrasenna){
        this.correo = correo;
        this.contrasenna = contrasenna;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }


}
