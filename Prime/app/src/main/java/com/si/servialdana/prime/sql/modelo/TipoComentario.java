package com.si.servialdana.prime.sql.modelo;

/**
 * Created by ealmeida on 2/26/2017.
 */

public class TipoComentario {
    private long id_tipo_comentario;
    private String descripcion;

    public TipoComentario(long id_tipo_comentario, String descripcion) {
        this.id_tipo_comentario = id_tipo_comentario;
        this.descripcion = descripcion;
    }

    public long getId_tipo_comentario() {
        return id_tipo_comentario;
    }

    public void setId_tipo_comentario(long id_tipo_comentario) {
        this.id_tipo_comentario = id_tipo_comentario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
