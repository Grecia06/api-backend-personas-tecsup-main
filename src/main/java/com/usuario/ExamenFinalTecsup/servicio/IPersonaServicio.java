package com.usuario.ExamenFinalTecsup.servicio;

import com.usuario.ExamenFinalTecsup.entidad.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaServicio {
    List<Persona> ObtenerListado();
    Optional<Persona> ObtenerPersonaPorId(long id);
    void GuardarPersona(Persona persona);
    void ActualizarPersona(long id, Persona persona);
    void EliminarPersonaPorId(long id);
}