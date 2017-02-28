package com.si.servialdana.prime.excepciones;

public class UsuarioSQLExcepcion extends Exception {

    public UsuarioSQLExcepcion(String detailMessage) {
        super(detailMessage);
    }

    public UsuarioSQLExcepcion(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
