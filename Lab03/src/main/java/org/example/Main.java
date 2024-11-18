package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Color red = new Color(255, 0, 0, 255);
        Color blue = new Color(0, 0, 255, 255);
        Color yellow = new Color(255, 255, 0, 255);

        Triangle redTriangle =  new Triangle(5, 10,  5, red);
        Triangle yellowTriangle =  new Triangle(4, 8,  9, yellow);

        ShapeDescriber.describe(redTriangle);
        ShapeDescriber.describe(yellowTriangle);

        Rectangle blueRectangle = new Rectangle(10, 15, blue);
        Rectangle yellowRectangle = new Rectangle(5, 10, yellow);

        ShapeDescriber.describe(blueRectangle);
        ShapeDescriber.describe(yellowRectangle);
    }
}