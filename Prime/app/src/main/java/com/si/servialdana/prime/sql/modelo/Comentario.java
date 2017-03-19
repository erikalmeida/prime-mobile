package com.si.servialdana.prime.sql.modelo;

/**
 * Created by ealmeida on 2/26/2017.
 */

public class Comentario {
    private long id_comentario;
    private long id_tipo_comentario;
    private long id_motivo_comentario;
    private long id_cliente;
    private String comentario;

    public Comentario(long id_comentario,  long id_tipo_comentario, long id_motivo_comentario, long id_cliente, String comentario) {
        this.id_comentario = id_comentario;
        this.id_tipo_comentario = id_tipo_comentario;
        this.id_motivo_comentario = id_motivo_comentario;
        this.id_cliente = id_cliente;
        this.comentario = comentario;

    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public long getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(long id_comentario) {
        this.id_comentario = id_comentario;
    }

    public long getId_tipo_comentario() {
        return id_tipo_comentario;
    }

    public void setId_tipo_comentario(long id_tipo_comentario) {
        this.id_tipo_comentario = id_tipo_comentario;
    }

    public long getId_motivo_comentario() {
        return id_motivo_comentario;
    }

    public void setId_motivo_comentario(long id_motivo_comentario) {
        this.id_motivo_comentario = id_motivo_comentario;
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }
}
