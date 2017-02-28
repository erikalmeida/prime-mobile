package com.si.servialdana.prime.sql.modelo;

/**
 * Created by ealmeida on 2/26/2017.
 */

public class MotivoComentario {
    private long id_motivo_comentario;
    private String descripcion;

    public MotivoComentario(long id_motivo_comentario, String descripcion) {
        this.id_motivo_comentario = id_motivo_comentario;
        descripcion = descripcion;
    }

    public long getId_motivo_comentario() {
        return id_motivo_comentario;
    }

    public void setId_motivo_comentario(long id_motivo_comentario) {
        this.id_motivo_comentario = id_motivo_comentario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        descripcion = descripcion;
    }
}
