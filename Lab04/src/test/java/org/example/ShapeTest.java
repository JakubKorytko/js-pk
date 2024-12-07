package org.example;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShapeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;


    private class DerivedClass extends Shape {
        DerivedClass(Color color) {
            super(color);
        }

        @Override
        public double getArea() {
            return 7.0;
        }

        @Override
        public double getPerimeter() {
            return 14.0;
        }
    }

    private DerivedClass derivedClass;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @BeforeEach
    void setUp() {
        Color red = mock(Color.class);

        red.blue = 0;
        red.green = 0;
        red.red = 255;
        red.alpha = 255;

        derivedClass = new DerivedClass(red);
    }

    @Test
    void getColorDescription() {
        assertEquals("Red: 255, Green: 0, Blue: 0, Alpha: 255",
                derivedClass.getColorDescription());
    }

    @Test
    void generateShape() {
        String shape = derivedClass.generateShape();
        assertEquals("Rendering is not implemented yet", shape);
    }

    @Test
    void print() {
        derivedClass.print();
        assertEquals("org.example.ShapeTest$DerivedClass"
                + System.lineSeparator(), outContent.toString());
    }

    @Test
    void getArea() {
        assertEquals(7.0, derivedClass.getArea());
    }

    @Test
    void getPerimeter() {
        assertEquals(14.0, derivedClass.getPerimeter());
    }
}