package com.Testing.clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaludadorTest {

    private static final String NOMBRE = "Ana";
    private static final String SALUDO_ESPERADO = "Hola, Ana!";
    @Test
    void saludaConNombre(){
    Saludador saludador = new Saludador();

    String respuesta = saludador.saludar(NOMBRE);

    assertEquals(SALUDO_ESPERADO, respuesta);
    }

}