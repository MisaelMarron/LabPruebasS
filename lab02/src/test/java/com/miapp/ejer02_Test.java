package com.miapp;
import com.miapp.ejer02;  

import static org.hamcrest.MatcherAssert.*; 
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class ejer02_Test {

    // Casos válidos
    @Test
    public void testNumerosMixtos() {
        assertThat(ejer02.esPar(2), is(true));
        assertThat(ejer02.esPar(3), is(false));
        assertThat(ejer02.esPar(4), is(true));
    }

    @Test
    public void testSoloImpares() {
        assertThat(ejer02.esPar(1), is(false));
        assertThat(ejer02.esPar(5), is(false));
        assertThat(ejer02.esPar(9), is(false));
    }

    @Test
    public void testSoloPares() {
        assertThat(ejer02.esPar(2), is(true));
        assertThat(ejer02.esPar(6), is(true));
        assertThat(ejer02.esPar(8), is(true));
    }

    @Test
    public void testConCero() {
        assertThat(ejer02.esPar(0), is(true));
    }

    @Test
    public void testNumerosNegativos() {
        assertThat(ejer02.esPar(-2), is(true));
        assertThat(ejer02.esPar(-5), is(false));
        assertThat(ejer02.esPar(-7), is(false));
    }

    // Casos de entrada inválida

    @Test(expected = IllegalArgumentException.class)
    public void testCantidadCero() {
        validateCantidad(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCantidadNegativa() {
        validateCantidad(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLetraEnNumero() {
        simulateInput("5", "a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLetraEnCantidad() {
        parseCantidad("b");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNumeroVacio() {
        simulateInput("3", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCantidadVacia() {
        parseCantidad("");
    }

    // Métodos auxiliares para simular entradas no válidas

    private void validateCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Por favor, ingrese un numero mayor a cero.");
        }
    }

    private void parseCantidad(String cantidadStr) {
        try {
            int cantidad = Integer.parseInt(cantidadStr);
            validateCantidad(cantidad);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Entrada invalida. Ingrese un numero entero.");
        }
    }

    private void simulateInput(String cantidadStr, String numeroStr) {
        try {
            int cantidad = Integer.parseInt(cantidadStr);
            int numero = Integer.parseInt(numeroStr);
            ejer02.esPar(numero);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Entrada invalida. Ingrese un numero entero.");
        }
    }
}
