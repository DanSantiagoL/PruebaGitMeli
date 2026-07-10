package com.Testing.clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaludadorTest {
    @Test
    void saludaConNombre(){
    Saludador saludador = new Saludador();

    String respuesta = saludador.saludar("Ana");

    assertEquals("Hola, Ana!", respuesta);
    }

}