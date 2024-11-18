package org.example;

import com.diogonunes.jcolor.Attribute;

import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.TEXT_COLOR;

public class ShapeRenderer {

    public static void render(Shape shape) {
        Attribute textColor = TEXT_COLOR(shape.color.red(), shape.color.green(), shape.color.blue());
        System.out.println(colorize(shape.generateShape(), textColor));
    }

    public static void render(List<Shape> shapes) {
        for (Shape shape : shapes) {
            ShapeRenderer.render(shape);
            System.out.println();
        }
    }
}
