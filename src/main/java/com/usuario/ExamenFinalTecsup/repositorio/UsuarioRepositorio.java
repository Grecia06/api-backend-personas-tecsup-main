package com.usuario.ExamenFinalTecsup.repositorio;

import com.usuario.ExamenFinalTecsup.entidad.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario,Long> {

    Optional<Usuario> findByEmail(String email);
}
