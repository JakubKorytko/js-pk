package org.example;

import com.diogonunes.jcolor.Attribute;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.TEXT_COLOR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShapeRendererTest {

    List<Shape> shapes;
    Attribute redText = TEXT_COLOR(255, 0, 0);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private Color mockRed() {
        Color red = mock(Color.class);

        red.blue = 0;
        red.green = 0;
        red.red = 255;
        red.alpha = 255;

        return red;
    }

    private Shape mockShape() {
        Shape shape = mock(Shape.class);

        when(shape.generateShape()).thenReturn("***");

        shape.color = mockRed();

        return shape;
    }

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
        shapes = List.of(new Shape[]{mockShape(), mockShape(), mockShape()});
    }

    @Test
    void render() {
        ShapeRenderer.render(shapes.getFirst());

        assertEquals(colorize("***", redText) + System.lineSeparator(), outContent.toString());

        outContent.reset();

        ShapeRenderer.render(shapes);

        assertEquals((colorize("***", redText) + System.lineSeparator().repeat(2)).repeat(3), outContent.toString());
    }
}