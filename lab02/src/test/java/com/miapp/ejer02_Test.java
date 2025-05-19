package lab02.src.test.java.com.miapp;
import lab02.src.main.java.com.miapp.ejer02;  

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class ejer02_Test {
    @Test
    public void testEsPar() {
        assertThat(ejer02.esPar(2), is(true));
        assertThat(ejer02.esPar(3), is(false));
        assertThat(ejer02.esPar(0), is(true));
        assertThat(ejer02.esPar(-4), is(true));
        assertThat(ejer02.esPar(-7), is(false));
    }
}
