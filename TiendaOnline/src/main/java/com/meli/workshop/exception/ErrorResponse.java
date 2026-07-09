package com.meli.workshop.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

// Record porque es un contenedor inmutable de datos — no necesita setters ni lógica.
// Representa el cuerpo estandarizado que devuelve la API en cualquier error.
// Todos los errores van a tener la misma forma: status, error, message, timestamp, details.
@JsonInclude(JsonInclude.Include.NON_EMPTY) // Omite 'details' del JSON si está vacío (ej. en 404/500)
public record ErrorResponse(
        int status,              // Código HTTP (404, 400, 409, 500...)
        String error,            // Nombre corto del error (ej. "Not Found")
        String message,          // Mensaje legible para el cliente
        LocalDateTime timestamp, // Momento exacto del error — útil para debug y logs
        List<String> details     // Lista de errores de validación; vacía en errores no-validación
) {}