package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {
    /**
     * Permite crear un Cliente
     * @param cliente
     * @return el id generado
     */
    String crear(Cliente cliente);

    /**
     * Permite actualizar un Cliente
     * @param cliente
     */
    void actualizar(Cliente cliente);

    /**
     * Permite eliminar un Cliente
     * @param id
     */
    void eliminar(String id);

    /**
     * Permite validar si existe un cliente por Id
     * @param id
     * @return si existe o no
     */
    boolean existe(String id);

}
