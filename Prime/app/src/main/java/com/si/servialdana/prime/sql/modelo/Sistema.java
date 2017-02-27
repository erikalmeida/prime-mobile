package com.si.servialdana.prime.sql.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "tb_sistema")
public class Sistema {

    /*@DatabaseField(id = true)
    private long id;

    @DatabaseField
    private String nroTelefono;

    @DatabaseField
    private String email;

    @DatabaseField
    private String direccion;*/

    @DatabaseField (id = true)
    private String id;

    @DatabaseField
    private String content;

    public Sistema(){

    }

    public Sistema(String id, String content){
        this.id = id;
        this.content = content;
    }

    /*public String getNroTelefono() {
        return this.nroTelefono;
    }

    public void setNroTelefono(String nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public String getEmail() { return this.email;}

    public void setEmail(String email){this.email = email;}

    public String getDireccion(){return this.direccion;}

    public void setDireccion(String direccion){this.direccion = direccion;}*/

    public String getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public void setId(String id){this.id=id;}

    public void setContent(String content){this.content=content;}
}
