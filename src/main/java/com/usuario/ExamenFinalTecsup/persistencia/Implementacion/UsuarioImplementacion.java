package com.usuario.ExamenFinalTecsup.persistencia.Implementacion;

import com.usuario.ExamenFinalTecsup.entidad.Usuario;
import com.usuario.ExamenFinalTecsup.persistencia.IUsuarioDAO;
import com.usuario.ExamenFinalTecsup.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsuarioImplementacion implements IUsuarioDAO {

    @Autowired
    private UsuarioRepositorio repositorio;

    @Override
    public List<Usuario> ObtenerListado() {
        return (List<Usuario>) repositorio.findAll();
    }

    @Override
    public Optional<Usuario> ObtenerUsuarioPorId(long id) {
        return repositorio.findById(id);
    }

    @Override
    public void GuardarUsuario(Usuario usuario) {
        repositorio.save(usuario);
    }

    @Override
    public void EliminarUsuarioPorId(long id) {
        repositorio.deleteById(id);
    }
}
