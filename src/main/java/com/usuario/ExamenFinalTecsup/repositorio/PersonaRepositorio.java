package com.usuario.ExamenFinalTecsup.repositorio;

import com.usuario.ExamenFinalTecsup.entidad.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepositorio extends CrudRepository<Persona, Long> {
    Optional<Persona> findByDni(String dni);
}