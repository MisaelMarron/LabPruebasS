package lab02.src.test.java.com.miapp;
import lab02.src.main.java.com.miapp.ejer01; 

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class ejer01_Test {
    @Test
    public void testCalcularArea() {
        assertThat(ejer01.calcularArea(5, 3), is(closeTo(15.0, 0.001)));
        assertThat(ejer01.calcularArea(2.5, 4.2), is(closeTo(10.5, 0.001)));
    }
}
