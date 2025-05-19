package lab02.src.test.java.com.miapp;
import lab02.src.main.java.com.miapp.ejer03;  

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class ejer03_Test {
    @Test
    public void testDepositar() {
        assertThat(ejer03.depositar(1000.0, 500.0), is(closeTo(1500.0, 0.001)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositarMontoInvalido() {
        ejer03.depositar(1000.0, -50.0);
    }

    @Test
    public void testRetirar() {
        assertThat(ejer03.retirar(1000.0, 300.0), is(closeTo(700.0, 0.001)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRetirarMontoInvalido() {
        ejer03.retirar(1000.0, -100.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRetirarFondosInsuficientes() {
        ejer03.retirar(1000.0, 1500.0);
    }
}
