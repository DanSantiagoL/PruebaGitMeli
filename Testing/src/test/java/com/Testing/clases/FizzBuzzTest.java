package com.Testing.clases;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";

    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    void multiploDe3DevuelveFizz() {
        assertEquals(FIZZ, fizzBuzz.fizzbuzz(3));
    }

    @Test
    void multiploDe5DevuelveBuzz() {
        assertEquals(BUZZ, fizzBuzz.fizzbuzz(5));
    }

    @Test
    void multiploDe3y5DevuelveFizzBuzz() {
        assertEquals(FIZZBUZZ, fizzBuzz.fizzbuzz(15));
    }

    @Test
    void noEsMultiplo_devuelveElNumero() {
        assertEquals("7", fizzBuzz.fizzbuzz(7));
    }
}