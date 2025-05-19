package com.miapp;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.*;

public class ejer03_Test {

    private ejer03 cajero;

    @Before
    public void setUp() {
        cajero = new ejer03();
    }

    @Test
    public void testConsultarSaldoInicial() {
        double saldo = cajero.consultarSaldo();
        assertThat(saldo, is(1000.0));
    }

    @Test
    public void testDepositoValido() {
        cajero.depositar(500);
        assertThat(cajero.consultarSaldo(), is(1500.0));
    }

    @Test
    public void testRetiroValidoMenorSaldo() {
        cajero.retirar(300);
        assertThat(cajero.consultarSaldo(), is(700.0));
    }

    @Test
    public void testRetirarTodoElSaldo() {
        cajero.retirar(1000);
        assertThat(cajero.consultarSaldo(), is(0.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRetiroMayorAlSaldo() {
        cajero.retirar(1500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositoCero() {
        cajero.depositar(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRetiroCero() {
        cajero.retirar(0);
    }

    @Test
    public void testDepositoDecimal() {
        cajero.depositar(10.5);
        assertThat(cajero.consultarSaldo(), is(1010.5));
    }

    @Test
    public void testRetiroDecimal() {
        cajero.retirar(99.9);
        assertThat(cajero.consultarSaldo(), is(900.1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositoNegativo() {
        cajero.depositar(-200);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRetiroNegativo() {
        cajero.retirar(-300);
    }

    // Los siguientes casos requieren simulación de entrada o una capa de UI:
    // 12. Salir del programa → no aplicable directamente
    // 13-15. Opción inválida/decimal/letra → necesitan test de entrada por consola
    // 16-20. Entradas no numéricas o vacías en monto → requieren mock de Scanner o interfaz
}

