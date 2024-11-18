package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Task 1 - 3

        Color red = new Color(255, 0, 0, 255);
        Color blue = new Color(0, 0, 255, 255);
        Color yellow = new Color(255, 255, 0, 255);

        Triangle redTriangle =  new Triangle(5, 10,  5, red);
        Triangle yellowTriangle =  new Triangle(4, 8,  9, yellow);

        ShapeDescriber.describe(redTriangle);
        ShapeDescriber.describe(yellowTriangle);

        Rectangle blueRectangle = new Rectangle(5, 10, blue);
        Rectangle yellowRectangle = new Rectangle(10, 5, yellow);

        ShapeDescriber.describe(blueRectangle);
        ShapeDescriber.describe(yellowRectangle);

        System.out.println();

        // Task 4

        List<Shape> shapes = List.of(new Shape[]{redTriangle, yellowTriangle, blueRectangle, yellowRectangle});
        ShapeRenderer.render(shapes);
    }
}