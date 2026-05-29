package com.usuario.ExamenFinalTecsup.servicio.Implementacion;

import com.usuario.ExamenFinalTecsup.entidad.Persona;
import com.usuario.ExamenFinalTecsup.persistencia.IPersonaDAO;
import com.usuario.ExamenFinalTecsup.servicio.IPersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaImplementacionServicio implements IPersonaServicio {

    @Autowired
    private IPersonaDAO persistencia;

    @Override
    public List<Persona> ObtenerListado() {
        return persistencia.ObtenerListado();
    }

    @Override
    public Optional<Persona> ObtenerPersonaPorId(long id) {
        if (id == 0) {
            throw new IllegalArgumentException("El Id debe ser mayor de 0");
        }
        return persistencia.ObtenerPersonaPorId(id);
    }

    @Override
    public void GuardarPersona(Persona persona) {
        if (persona.getNombre() == null || persona.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre de la persona es obligatorio.");
        }
        if (persona.getApellido() == null || persona.getApellido().isBlank()) {
            throw new IllegalArgumentException("El apellido de la persona es obligatorio.");
        }
        if (persona.getDni() == null || persona.getDni().isBlank()) {
            throw new IllegalArgumentException("El DNI de la persona es obligatorio.");
        }
        if (persona.getEmail() == null || persona.getEmail().isBlank()) {
            throw new IllegalArgumentException("El email de la persona es obligatorio.");
        }
        persistencia.GuardarPersona(persona);
    }

    @Override
    public void ActualizarPersona(long id, Persona persona) {
        if (id == 0) {
            throw new IllegalArgumentException("El Id debe ser mayor de 0");
        }
        if (persona.getNombre() == null || persona.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre de la persona es obligatorio.");
        }
        if (persona.getApellido() == null || persona.getApellido().isBlank()) {
            throw new IllegalArgumentException("El apellido de la persona es obligatorio.");
        }
        if (persona.getDni() == null || persona.getDni().isBlank()) {
            throw new IllegalArgumentException("El DNI de la persona es obligatorio.");
        }
        if (persona.getEmail() == null || persona.getEmail().isBlank()) {
            throw new IllegalArgumentException("El email de la persona es obligatorio.");
        }
        persistencia.ActualizarPersona(id, persona);
    }

    @Override
    public void EliminarPersonaPorId(long id) {
        if (id == 0) {
            throw new IllegalArgumentException("El Id debe ser mayor de 0");
        }
        persistencia.EliminarPersonaPorId(id);
    }
}