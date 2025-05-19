package lab02.src.test.java.com.miapp;
import lab02.src.main.java.com.miapp.ejer03;  

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ejer03_Test {

    @Test
    public void testDepositar() {
        assertThat("Depositar 500 a una cuenta con 1000 debe dar 1500",
                   ejer03.depositar(1000.0, 500.0), is(closeTo(1500.0, 0.001)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositarMontoInvalido() {
        // Intentar depositar un monto negativo debe lanzar excepción
        ejer03.depositar(1000.0, -50.0);
    }

    @Test
    public void testRetirar() {
        assertThat("Retirar 300 de una cuenta con 1000 debe dejar 700",
                   ejer03.retirar(1000.0, 300.0), is(closeTo(700.0, 0.001)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRetirarMontoInvalido() {
        // Retirar un monto negativo debe lanzar excepción
        ejer03.retirar(1000.0, -100.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRetirarFondosInsuficientes() {
        // Retirar más de lo que hay en la cuenta debe lanzar excepción
        ejer03.retirar(1000.0, 1500.0);
    }
}

