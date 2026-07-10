package com.Testing.clases;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    void multiploDe3DevuelveFizz() {
        assertEquals("Fizz", fizzBuzz.fizzbuzz(3));
    }

    @Test
    void multiploDe5DevuelveBuzz() {
        assertEquals("Buzz", fizzBuzz.fizzbuzz(5));
    }

    @Test
    void multiploDe3y5DevuelveFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.fizzbuzz(15));
    }

    @Test
    void noEsMultiplo_devuelveElNumero() {
        assertEquals("7", fizzBuzz.fizzbuzz(7));
    }
}