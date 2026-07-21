package com.Testing.clases;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {

    @Mock
    PasarelaDePago pasarela;

    @InjectMocks
    PedidoService svc;

    @Test
    void pagarconMontoValidoRetornaTrue() {

        when(pasarela.cobrar(100)).thenReturn(true);

        boolean resultado = svc.pagar(100);

        assertTrue(resultado);

        verify(pasarela).cobrar(100);
    }
}