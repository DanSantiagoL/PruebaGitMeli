package com.meli.workshop.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

// @RestControllerAdvice intercepta excepciones lanzadas en cualquier controller de la app.
// Centraliza el manejo de errores: sin esto, cada controller tendría que manejar sus propios errores
// y las respuestas serían inconsistentes (distintos formatos, distintos campos).
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Logger para registrar errores inesperados — fundamental en producción para diagnóstico
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Captura ProductoNotFoundException y devuelve 404.
    // Sin este handler, Spring devolvería un 500 genérico porque la excepción no estaría manejada.
    @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ProductoNotFoundException ex) {
        ErrorResponse body = new ErrorResponse(
                404,
                "Not Found",
                ex.getMessage(),
                LocalDateTime.now(),
                List.of() // Sin detalles extra — el mensaje ya es suficientemente descriptivo
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    // Captura ConflictException y devuelve 409.
    // 409 Conflict es el código correcto cuando el recurso ya existe o hay un conflicto de estado.
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse> handleConflict(ConflictException ex) {
        ErrorResponse body = new ErrorResponse(
                409,
                "Conflict",
                ex.getMessage(),
                LocalDateTime.now(),
                List.of()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    // Captura errores de validación de @Valid (ej. campos @NotBlank que llegan vacíos).
    // MethodArgumentNotValidException contiene todos los errores de validación en una lista,
    // por eso se extraen y se pasan en 'details' para que el cliente sepa exactamente qué corregir.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        // Extrae el mensaje de cada error de campo y los junta en una lista
        List<String> details = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
                .toList();

        ErrorResponse body = new ErrorResponse(
                400,
                "Bad Request",
                "Error de validación en los datos enviados",
                LocalDateTime.now(),
                details // Lista con todos los campos inválidos y sus mensajes
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    // Fallback de seguridad: captura cualquier excepción no manejada por los handlers anteriores.
    // Se loggea como ERROR porque es algo inesperado — un bug o condición no contemplada.
    // Nunca se expone el stack trace al cliente: podría revelar detalles internos de la app.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneral(Exception ex) {
        log.error("Error inesperado: {}", ex.getMessage(), ex); // Log completo con stack trace interno
        ErrorResponse body = new ErrorResponse(
                500,
                "Internal Server Error",
                "Ocurrió un error inesperado. Intente más tarde.",
                LocalDateTime.now(),
                List.of()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}