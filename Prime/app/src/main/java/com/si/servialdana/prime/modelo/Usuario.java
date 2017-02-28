package com.si.servialdana.prime.modelo;

/**
 * Created by ealmeida on 2/26/2017.
 */

public class Usuario {
    private long id_usuario;
    private String correo;
    private String contrasenna;
    private String url_imagen;

    public Usuario(long id_usuario, String correo, String url_imagen, String contrasenna) {
        this.id_usuario = id_usuario;
        this.correo = correo;
        this.url_imagen = url_imagen;
        this.contrasenna = contrasenna;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
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

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }
}
