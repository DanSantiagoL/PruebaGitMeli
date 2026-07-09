package com.meli.workshop.exception;

// Excepción para conflictos de datos, por ejemplo: intentar crear un producto con nombre duplicado.
// Extiende BusinessException para ser capturada por el GlobalExceptionHandler → devuelve 409 Conflict.
public class ConflictException extends BusinessException {

    public ConflictException(String message) {
        super(message);
    }
}