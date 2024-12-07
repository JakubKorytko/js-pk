package org.app.shapes;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

public class ShapeDescriberTest {

    @Test
    public void describe() {

        ShapeDescriber.logger = mock(Logger.class);
        Shape mockedShape = mock(Shape.class);

        when(mockedShape.getArea()).thenReturn(4.0);
        when(mockedShape.getPerimeter()).thenReturn(3.0);
        when(mockedShape.getColorDescription()).thenReturn("Red: 255, Green: 0, Blue: 0, Alpha: 255");

        ShapeDescriber.describe(mockedShape);

        verify(ShapeDescriber.logger).info("Red: 255, Green: 0, Blue: 0, Alpha: 255");
        verify(ShapeDescriber.logger).info(argThat(argument -> argument.startsWith("Typ figury: org.app.")));
        verify(ShapeDescriber.logger).info("Pole figury: 4.0");
        verify(ShapeDescriber.logger).info("Obwód figury: 3.0");
    }
}