package com.ceiba.dominio.excepcion;

public class ExcepcionFechaHora extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ExcepcionFechaHora(String message) {
        super(message);
    }
}
