package com.Testing.clases;

public class PedidoService {

    private PasarelaDePago pasarela;

    public PedidoService(PasarelaDePago pasarela) {
        this.pasarela = pasarela;
    }

    public boolean pagar(double monto) {
        return pasarela.cobrar(monto);
    }
}
