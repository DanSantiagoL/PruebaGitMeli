package com.mercadolibre.ejercicios.tdd;

public class PiedraPapelTijera {

    public int jugar(String jugador1, String jugador2) {
        if (jugador1.equals(jugador2)) {
            return 0;
        }
        if (gana(jugador1, jugador2)) {
            return 1;
        }
        return 2;
    }

    private boolean gana(String atacante, String defensor) {
        return (atacante.equals("piedra") && defensor.equals("tijera"))
                || (atacante.equals("tijera") && defensor.equals("papel"))
                || (atacante.equals("papel")  && defensor.equals("piedra"));
    }
}