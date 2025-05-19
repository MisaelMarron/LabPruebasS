package com.miapp;

import com.miapp.ejer01;
import static org.hamcrest.MatcherAssert.*; 
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class ejer01_Test {

    @Test
    public void testAreaConEnteros() {
        double resultado = ejer01.calcularArea(5, 10);
        assertThat(resultado, is(50.0));
    }

    @Test
    public void testAreaConDecimales() {
        double resultado = ejer01.calcularArea(3.2, 2.5);
        assertThat(resultado, is(8.0));
    }

    @Test
    public void testAreaConEnteroYDecimal() {
        double resultado = ejer01.calcularArea(7, 2.5);
        assertThat(resultado, is(17.5));
    }

    @Test
    public void testAreaConBaseCero() {
        double resultado = ejer01.calcularArea(0, 1.5);
        assertThat(resultado, is(0.0));
    }

    @Test
    public void testAreaConAlturaCero() {
        double resultado = ejer01.calcularArea(6, 0);
        assertThat(resultado, is(0.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBaseNegativa() {
        ejer01.calcularArea(-5, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAlturaNegativa() {
        ejer01.calcularArea(4, -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAmbosNegativos() {
        ejer01.calcularArea(-7, -5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEntradaLetraEnBase() {
        simulateInput("a", "7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEntradaLetraEnAltura() {
        simulateInput("5", "b");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEntradaVacia() {
        simulateInput("", "");
    }

    // Método de simulación para pruebas de entradas no numéricas
    private void simulateInput(String baseStr, String alturaStr) {
        try {
            double base = Double.parseDouble(baseStr);
            double altura = Double.parseDouble(alturaStr);
            ejer01.calcularArea(base, altura);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Entrada no válida.");
        }
    }
}



