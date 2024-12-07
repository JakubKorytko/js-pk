package org.app.shapes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class RectangleTest {

    Rectangle obj;

    @BeforeEach
    void setUp() {
        Color color = mock(Color.class);
        obj = new Rectangle(5, 5, color);
    }

    @Test
    void generateShape() {
        String shape = obj.generateShape();
        assertEquals(("* ".repeat(5) + "\n").repeat(5), shape);
    }

    @Test
    void getArea() {
        assertEquals(25.0, obj.getArea());
    }

    @Test
    void getPerimeter() {
        assertEquals(20.0, obj.getPerimeter());
    }
}