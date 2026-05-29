package com.usuario.ExamenFinalTecsup.servicio;

import com.usuario.ExamenFinalTecsup.entidad.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioServicio {
    List<Usuario> ObtenerListado();
    Optional<Usuario> ObtenerUsuarioPorId(long id);
    void GuardarUsuario(Usuario usuario);
    void  EliminarUsuarioPorId(long id);
}
