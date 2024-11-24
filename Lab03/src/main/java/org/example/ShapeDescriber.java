package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShapeDescriber {
    static Logger logger = LoggerFactory.getLogger("ShapeDescriber");

    public static void describe(Shape shape) {
        String area = String.valueOf(shape.getArea());
        String perimeter = String.valueOf(shape.getPerimeter());

        String type = "Typ figury: " + shape.getClass().getName();
        String color = shape.getColorDescription();
        String areaString = "Pole figury: " + area;
        String perimeterString = "Obwód figury: " + perimeter;

        logger.info(color);
        logger.info(type);
        logger.info(areaString);
        logger.info(perimeterString);
    }
}