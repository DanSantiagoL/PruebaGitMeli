package com.meli.workshop.exception;

// Excepción base para todos los errores de lógica de negocio.
// Extender RuntimeException la hace "unchecked" — no obliga a declararla con throws en cada método.
// Las excepciones específicas (ProductoNotFoundException, ConflictException) la extienden
// para poder tratarlas individualmente en el GlobalExceptionHandler.
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}