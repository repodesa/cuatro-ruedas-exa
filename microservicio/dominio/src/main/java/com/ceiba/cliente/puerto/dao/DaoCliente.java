package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;

import java.util.List;

public interface DaoCliente {
    /**
     * Pemite listar todos los registros de los clientes.
     * @return
     */
    List<DtoCliente> Listar ();

    /**
     * Permite buscar un cliente de acuerdo al Id.
     * @param id
     * @return
     */
    DtoCliente listarPorId (String id);
}
