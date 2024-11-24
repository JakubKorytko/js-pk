package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TriangleTest {

    Triangle obj;

    @BeforeEach
    void setUp() {
        Color color = mock(Color.class);
        obj = new Triangle(3, 4, 5, color);
    }

    @Test
    void generateShape() {
        String shape = obj.generateShape();
        assertEquals(
                "    *\n" +
                "   ***\n" +
                "  *****\n" +
                " *******\n" +
                "*********\n", shape);
    }

    @Test
    void getArea() {
        assertEquals(6.0, obj.getArea());
    }

    @Test
    void getPerimeter() {
        assertEquals(12.0, obj.getPerimeter());
    }
}