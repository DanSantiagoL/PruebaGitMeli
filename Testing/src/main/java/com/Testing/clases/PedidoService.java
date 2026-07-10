package com.Testing.clases;

public class PedidoService {

    private PasareladePago pasarela;

    public PedidoService(PasareladePago pasarela) {
        this.pasarela = pasarela;
    }

    public boolean pagar(double monto) {
        return pasarela.cobrar(monto);
    }
}
