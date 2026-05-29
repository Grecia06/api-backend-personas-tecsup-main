package com.usuario.ExamenFinalTecsup.controlador;

import com.usuario.ExamenFinalTecsup.entidad.Persona;
import com.usuario.ExamenFinalTecsup.servicio.IPersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personas")
public class PersonaControlador {

    @Autowired
    private IPersonaServicio servicio;

    @GetMapping
    public ResponseEntity<List<Persona>> ObtenerListado() {
        List<Persona> lista = servicio.ObtenerListado();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ObtenerPersonaPorId(@PathVariable long id) {
        try {
            Optional<Persona> persona = servicio.ObtenerPersonaPorId(id);
            if (persona.isPresent()) {
                return ResponseEntity.ok(persona.get());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontro una persona con el id: " + id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> GuardarPersona(@RequestBody Persona persona) {
        try {
            servicio.GuardarPersona(persona);
            return ResponseEntity.status(HttpStatus.CREATED).body("Persona registrada correctamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> ActualizarPersona(@PathVariable long id, @RequestBody Persona persona) {
        try {
            servicio.ActualizarPersona(id, persona);
            return ResponseEntity.ok("Persona actualizada correctamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> EliminarPersonaPorId(@PathVariable long id) {
        try {
            servicio.EliminarPersonaPorId(id);
            return ResponseEntity.ok("Persona eliminada correctamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}