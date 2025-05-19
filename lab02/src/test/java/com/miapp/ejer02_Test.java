package lab02.src.test.java.com.miapp;
import lab02.src.main.java.com.miapp.ejer02;  

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class ejer02_Test {
    @Test
    public void testEsPar() {

        //cambiar valores a tu gusto
        assertThat("2 deberia ser par", ejer02.esPar(2), is(true));
        assertThat("3 deberia ser impar", ejer02.esPar(3), is(false));
        assertThat("0 deberia ser par", ejer02.esPar(0), is(true));
        assertThat("-4 deberia ser par", ejer02.esPar(-4), is(true));
        assertThat("-7 deberia ser impar", ejer02.esPar(-7), is(false));
    }
}
