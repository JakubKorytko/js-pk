package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    Color c;

    @Test
    public void properties() {
        assertThrows(IllegalArgumentException.class, () -> {
            c = new Color(256, 256, 256, 256);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            c = new Color(-5, -5, -5, -5);
        });

        c = new Color(255, 255, 255, 255);

        assertEquals(255, c.red());
        assertEquals(255, c.green());
        assertEquals(255, c.blue());
        assertEquals(255, c.alpha());
    }

    @Test
    public void optionalConstructors() {
        c = new Color(255, 255, 255);

        assertEquals(255, c.red());
        assertEquals(255, c.green());
        assertEquals(255, c.blue());
        assertEquals(0, c.alpha());

        c = new Color(255, 255);

        assertEquals(255, c.red());
        assertEquals(255, c.green());
        assertEquals(0, c.blue());
        assertEquals(0, c.alpha());

        c = new Color(255);

        assertEquals(255, c.red());
        assertEquals(0, c.green());
        assertEquals(0, c.blue());
        assertEquals(0, c.alpha());

        c = new Color();

        assertEquals(0, c.red());
        assertEquals(0, c.green());
        assertEquals(0, c.blue());
        assertEquals(0, c.alpha());
    }
}