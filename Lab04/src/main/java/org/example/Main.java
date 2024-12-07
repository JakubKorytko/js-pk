package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ShapeDAO shapeDAO = new ShapeDAO();

        Color red = new Color(255, 0, 0, 255);
        Color blue = new Color(0, 0, 255, 255);
        Color yellow = new Color(255, 255, 0, 255);

        Triangle redTriangle =  new Triangle(7, 10,  5, red);
        Triangle yellowTriangle =  new Triangle(4, 8,  9, yellow);
        Rectangle blueRectangle = new Rectangle(5, 10, blue);
        Rectangle yellowRectangle = new Rectangle(10, 5, yellow);

        shapeDAO.saveShape(redTriangle);
        shapeDAO.saveShape(yellowTriangle);
        shapeDAO.saveShape(blueRectangle);
        shapeDAO.saveShape(yellowRectangle);

        Shape fetchedShape = shapeDAO.getShapeById(1L);

        if (fetchedShape != null) {
            System.out.println(fetchedShape);

            fetchedShape.color = new Color(50, 50, 50, 255);
            shapeDAO.updateShape(fetchedShape);

            shapeDAO.deleteShape(1L);
        }

        List<Shape> shapes = shapeDAO.getAllShapes();
        shapes.forEach(System.out::println);

        shapeDAO.close();

    }
}