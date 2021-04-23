package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.fabrica.FabricaUsuario;

@Component
public class ManejadorCrearUsuario implements ManejadorComandoRespuesta<ComandoUsuario, ComandoRespuesta<Long>> {

    private final FabricaUsuario fabricaUsuario;
    private final ServicioCrearUsuario servicioCrearUsuario;

    public ManejadorCrearUsuario(FabricaUsuario fabricaUsuario, ServicioCrearUsuario servicioCrearUsuario) {
        this.fabricaUsuario = fabricaUsuario;
        this.servicioCrearUsuario = servicioCrearUsuario;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoUsuario comando) {
        Usuario usuario = this.fabricaUsuario.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearUsuario.ejecutar(usuario));
    }
}