package com.ceiba.dominio.excepcion;

public class ExcepcionRegistroNoExiste extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionRegistroNoExiste(String message) {
        super(message);
    }
}
