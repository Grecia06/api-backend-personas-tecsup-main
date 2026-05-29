package com.usuario.ExamenFinalTecsup.persistencia.Implementacion;

import com.usuario.ExamenFinalTecsup.entidad.Persona;
import com.usuario.ExamenFinalTecsup.persistencia.IPersonaDAO;
import com.usuario.ExamenFinalTecsup.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonaImplementacion implements IPersonaDAO {

    @Autowired
    private PersonaRepositorio repositorio;

    @Override
    public List<Persona> ObtenerListado() {
        return (List<Persona>) repositorio.findAll();
    }

    @Override
    public Optional<Persona> ObtenerPersonaPorId(long id) {
        return repositorio.findById(id);
    }

    @Override
    public void GuardarPersona(Persona persona) {
        repositorio.save(persona);
    }

    @Override
    public void ActualizarPersona(long id, Persona persona) {
        persona.setId(id);
        repositorio.save(persona);
    }

    @Override
    public void EliminarPersonaPorId(long id) {
        repositorio.deleteById(id);
    }
}