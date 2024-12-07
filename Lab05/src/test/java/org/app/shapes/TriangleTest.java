package org.app.shapes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TriangleTest {

    Triangle obj;
    Color color;

    @BeforeEach
    void setUp() {
        color = mock(Color.class);
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
    void constructors() {
        Triangle obj = new Triangle(3, 4, 5, color);
        Triangle obj2 = new Triangle(3, 5, 4);
        Triangle obj3 = new Triangle();

        assertEquals(color, obj.color);
        assertNull(obj2.color);
        assertEquals(3.0, obj.a);
        assertEquals(4.0, obj.b);
        assertEquals(0, obj3.a);
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