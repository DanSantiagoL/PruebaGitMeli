package com.meli.workshop.exception;

// Excepción específica para cuando se busca un producto que no existe.
// Extiende BusinessException para que el GlobalExceptionHandler la capture
// y devuelva automáticamente un 404 con el mensaje apropiado.
public class ProductoNotFoundException extends BusinessException {

    public ProductoNotFoundException(Long id) {
        // Mensaje claro que incluye el id buscado — facilita el debug para quien consume la API
        super("Producto con id " + id + " no encontrado");
    }
}